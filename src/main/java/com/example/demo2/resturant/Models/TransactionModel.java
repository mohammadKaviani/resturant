package com.example.demo2.resturant.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.security.Timestamp;
import java.util.List;

@Entity
public class TransactionModel {


    @Id
    Integer TransactionId;
    String CodeBank;
    Timestamp PayDate;
    Integer Price;
    Integer FactorId;
    Boolean IdPay;



    public Integer getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(Integer transactionId) {
        TransactionId = transactionId;
    }

    public String getCodeBank() {
        return CodeBank;
    }

    public void setCodeBank(String codeBank) {
        CodeBank = codeBank;
    }


    public Timestamp getPayDate() {
        return PayDate;
    }

    public void setPayDate(Timestamp payDate) {
        PayDate = payDate;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public Integer getFactorId() {
        return FactorId;
    }

    public void setFactorId(Integer factorId) {
        FactorId = factorId;
    }

    public Boolean getIdPay() {
        return IdPay;
    }

    public void setIdPay(Boolean idPay) {
        IdPay = idPay;
    }
}
