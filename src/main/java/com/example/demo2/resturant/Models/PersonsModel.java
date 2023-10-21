package com.example.demo2.resturant.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "firstName")
public class PersonsModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    String firstName;
    String lastName;
    String phoneNumbers;
    String address;
    String personType;

    @OneToMany(mappedBy = "personsModel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    List<OrdersModel> ordersModels;

    @OneToMany(mappedBy = "personsModel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    List<ReservationModel> reservationModels;

    @OneToMany(mappedBy = "personsModel", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    List<FactorModel> factorModels;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public List<OrdersModel> getOrdersModels() {
        return ordersModels;
    }

    public void setOrdersModels(List<OrdersModel> ordersModels) {
        this.ordersModels = ordersModels;
    }

    public List<ReservationModel> getReservationModels() {
        return reservationModels;
    }

    public void setReservationModels(List<ReservationModel> reservationModels) {
        this.reservationModels = reservationModels;
    }

    public List<FactorModel> getFactorModels() {
        return factorModels;
    }

    public void setFactorModels(List<FactorModel> factorModels) {
        this.factorModels = factorModels;
    }
}