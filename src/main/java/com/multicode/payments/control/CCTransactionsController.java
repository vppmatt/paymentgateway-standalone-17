package com.multicode.payments.control;

import com.multicode.payments.domain.*;
import com.multicode.payments.exception.*;
import com.multicode.payments.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin
public class CCTransactionsController {

    @Autowired
    CCUtilsService service;

    @ResponseBody
    @GetMapping(produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Object mappingFunctionForGetAllAndSearch(
            @RequestParam(value ="order", required = false) String orderId,
            @RequestParam(value ="country", required = false) String country) {
        if(country != null) {
            return getForACountry(country);
        }
        else if (orderId != null) {
            return getForAnOrder(orderId);
        }
        else {
            return getAll();
        }
    }

    public List<CreditCardTransaction> getAll() {
        return service.getAllTransactions();
    }

    public List<CreditCardTransaction> getForAnOrder(String orderId) {
        return service.getAllForAnOrder(orderId);
    }

    public List<CreditCardTransaction> getForACountry(String country) {
        return service.getAllForACountry(country);
    }

    @ResponseBody
    @GetMapping(value="/{id}",  produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public CreditCardTransaction getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @ResponseBody
    @PostMapping(produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public CreditCardTransaction addTransaction(@RequestBody CreditCardTransactionDTO newTransaction) {

        try {
            return service.saveTransaction(new CreditCardTransaction(newTransaction));
        }
        catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @ResponseBody
    @PutMapping(value="/{id}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public CreditCardTransaction updateTransaction(@PathVariable Integer id, @RequestBody HashMap<String, Object> updatedTransaction) {

        try {
            return service.updateTransaction(id, updatedTransaction);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException(e.getMessage());
        }
    }
}
