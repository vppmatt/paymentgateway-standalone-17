package com.multicode.payments.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;

public class CreditCardTransactionDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double amount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String country;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String currency;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String orderId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer taxCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double taxRate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;

    public CreditCardTransactionDTO () {}

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(Integer taxCode) {
        this.taxCode = taxCode;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CreditCardTransactionDTO{" +
                "amount=" + amount +
                ", country='" + country + '\'' +
                ", currency='" + currency + '\'' +
                ", orderId='" + orderId + '\'' +
                ", taxCode=" + taxCode +
                ", taxRate=" + taxRate +
                ", type='" + type + '\'' +
                '}';
    }
}
