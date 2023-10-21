package com.example.demo2.resturant.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.security.Timestamp;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "count", scope = OrdersModel.class)
public class OrdersModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer Id;

    @ManyToOne
    PersonsModel personsModel;
    @ManyToOne
    FoodsModel foods;
    Integer Count;
    String DateOrder;
    Boolean Payment;
    @ManyToOne(fetch = FetchType.EAGER)

    @JsonIgnore
    FactorModel factorModel ;




    public String getDateOrder() {
        return DateOrder;
    }

    public void setDateOrder(String dateOrder) {
        DateOrder = dateOrder;
    }

    public FactorModel getFactorModel() {
        return factorModel;
    }

    public void setFactorModel(FactorModel factorModel) {
        this.factorModel = factorModel;
    }
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }


    public Boolean getPayment() {
        return Payment;
    }

    public void setPayment(Boolean payment) {
        Payment = payment;
    }

    public PersonsModel getPersonsModel() {
        return personsModel;
    }

    public void setPersonsModel(PersonsModel personsModel) {
        this.personsModel = personsModel;
    }

    public FoodsModel getFoods() {
        return foods;
    }

    public void setFoods(FoodsModel foods) {
        this.foods = foods;
    }
}
