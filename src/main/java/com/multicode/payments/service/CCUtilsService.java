package com.multicode.payments.service;

import com.multicode.payments.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

public interface CCUtilsService {

    List<CreditCardTransaction> getAllTransactions();
    CreditCardTransaction getById(int id);
    List<CreditCardTransaction> getAllForAnOrder(String orderId);
    List<CreditCardTransaction> getAllForACountry(String country);

    CreditCardTransaction saveTransaction(CreditCardTransaction ccTransaction);

    CreditCardTransaction updateTransaction(Integer id, Map<String,Object>  updatedTransaction);

    List<String> getAllCountries();
}
