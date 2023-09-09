package com.multicode.payments.domain;

import jakarta.persistence.*;
import java.time.*;

@Entity
@Table(name = "cctransactions")
public class CreditCardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double amount;
    private String country;
    private String currency;
    private LocalDate date;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "tax_code")
    private Integer taxCode;

    @Column(name = "tax_rate")
    private Double taxRate;
    private String type;

    public CreditCardTransaction () {}

    public CreditCardTransaction(String rawData) {
        //(4823, -180.00, 'USA', 'USD', '2021-03-22 00:00:00', 'MANUAL', 0, 0, 'Refund')
        String[] fields = rawData.split(",");
        this.id = Integer.parseInt(fields[0].replace("(","").trim());
        this.amount = Double.parseDouble(fields[1].trim());
        this.country = fields[2].replaceAll("'", "").trim().toLowerCase();
        this.currency = fields[3].replaceAll("'", "").trim().toLowerCase();
        this.date = LocalDate.parse(fields[4].replaceAll("'", "").trim().split(" ")[0]);
        this.orderId = fields[5].replaceAll("'", "").trim();
        this.taxCode = Integer.parseInt(fields[6].replace("(","").trim());
        this.taxRate = Double.parseDouble(fields[7].trim());
        this.type = fields[8].replaceAll("'", "").replace(")", "").trim();
    }

    public CreditCardTransaction(CreditCardTransactionDTO dto) {
        this.id = null;
        this.amount = dto.getAmount();
        this.country = dto.getCountry();
        this.currency = dto.getCurrency();
        this.date = LocalDate.now();
        this.orderId = dto.getOrderId();
        this.taxCode = dto.getTaxCode();
        this.taxRate = dto.getTaxRate();
        this.type = dto.getType();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
        return "ccTransaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", country='" + country + '\'' +
                ", currency='" + currency + '\'' +
                ", date=" + date +
                ", orderId='" + orderId + '\'' +
                ", taxCode=" + taxCode +
                ", taxRate=" + taxRate +
                ", type='" + type + '\'' +
                '}';
    }
}
