package com.multicode.payments.service;

import com.multicode.payments.data.*;
import com.multicode.payments.domain.*;
import com.multicode.payments.exception.BadRequestException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CCUtilsServiceImpl implements CCUtilsService {

    @Autowired
    private CreditCardTransactionRepository ccTransactionRepository;

    public List<CreditCardTransaction> getAllTransactions() {
        return ccTransactionRepository.findAll();
    }

    public CreditCardTransaction getById(int id) {
        Optional<CreditCardTransaction> ccTrans = ccTransactionRepository.findById(id);
        if (ccTrans.isPresent()) {
            return ccTrans.get();
        }
        else {
            return null;
        }
    }

    public List<CreditCardTransaction> getAllForAnOrder(String orderId) {
        return ccTransactionRepository.findAllByOrderId(orderId);
    }

    public List<CreditCardTransaction> getAllForACountry(String country) {
        return ccTransactionRepository.findAllByCountry(country);
    }

    public CreditCardTransaction saveTransaction(CreditCardTransaction ccTransaction) {
        return ccTransactionRepository.save(ccTransaction);
    }

    @Override
    public CreditCardTransaction updateTransaction(Integer id, Map<String,Object>  updatedTransaction) {
        System.out.println(id);
        Optional<CreditCardTransaction> transactionOptional = ccTransactionRepository.findById(id);
        if (!transactionOptional.isPresent()) {
            throw new BadRequestException("No item found with id " + id);
        }
        CreditCardTransaction transaction = transactionOptional.get();
        if (updatedTransaction.get("amount") != null) {
            transaction.setAmount(Double.parseDouble(updatedTransaction.get("amount").toString()));
        }
        if (updatedTransaction.get("country") != null) {
            transaction.setCountry(updatedTransaction.get("country").toString());
        }
        if (updatedTransaction.get("currency") != null) {
            transaction.setCurrency(updatedTransaction.get("currency").toString());
        }
        if (updatedTransaction.get("orderId") != null) {
            transaction.setOrderId(updatedTransaction.get("orderId").toString());
        }
        if (updatedTransaction.get("type") != null) {
            transaction.setType(updatedTransaction.get("type").toString());
        }
        if (updatedTransaction.get("taxCode") != null) {
            transaction.setTaxCode(Integer.parseInt(updatedTransaction.get("taxCode").toString()));
        }
        if (updatedTransaction.get("taxRate") != null) {
            transaction.setTaxRate(Double.parseDouble(updatedTransaction.get("taxRate").toString()));
        }

        ccTransactionRepository.save(transaction);

        return transaction;
    }

    @Override
    public List<String> getAllCountries() {
        return ccTransactionRepository.findAll().stream().map(it -> it.getCountry()).distinct().collect(Collectors.toList());
    }
}
