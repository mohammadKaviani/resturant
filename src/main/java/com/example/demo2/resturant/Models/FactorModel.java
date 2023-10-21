package com.example.demo2.resturant.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.security.Timestamp;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "factorId")
public class FactorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer factorId;
    @JsonIgnore
    @OneToMany(mappedBy = "factorModel"  ,cascade = CascadeType.ALL,orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<OrdersModel> ordersModels;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    PersonsModel personsModel;
    String DeliverPersonName;
    boolean deliveryState;
    String dateFactor;

    String timeFactor;
    Integer Discount;
    Integer Sum;


    public String getDateFactor() {
        return dateFactor;
    }

    public void setDateFactor(String dateFactor) {
        this.dateFactor = dateFactor;
    }

    public String getTimeFactor() {
        return timeFactor;
    }

    public void setTimeFactor(String timeFactor) {
        this.timeFactor = timeFactor;
    }

    public List<OrdersModel> getOrdersModels() {
        return ordersModels;
    }

    public void setOrdersModels(List<OrdersModel> ordersModels) {
        this.ordersModels = ordersModels;
    }

    public boolean isDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(boolean deliveryState) {
        this.deliveryState = deliveryState;
    }

    public Integer getSum() {
        return Sum;
    }

    public void setSum(Integer sum) {
        Sum = sum;
    }

    public Integer getFactorId() {
        return factorId;
    }

    public void setFactorId(Integer factorId) {
        factorId = factorId;
    }


    public Integer getDiscount() {
        return Discount;
    }

    public void setDiscount(Integer discount) {
        Discount = discount;
    }

    public PersonsModel getPersonsModel() {
        return personsModel;
    }

    public void setPersonsModel(PersonsModel personsModel) {
        this.personsModel = personsModel;
    }


    public String getDeliverPersonName() {
        return DeliverPersonName;
    }

    public void setDeliverPersonName(String deliverPersonName) {
        DeliverPersonName = deliverPersonName;
    }
}
