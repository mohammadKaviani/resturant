package com.example.demo2.resturant.Dto;

public class OrderCurrentDto {





    private final Integer orderId;
    private final String firstNamePerson;
    private final String lastNamePerson;
    private final String dateOrder;
    private final String foodName;
    private final Integer count;
    private  final boolean payment;


    public OrderCurrentDto(Integer orderId, String firstNamePerson, String lastNamePerson, String dateOrder, String foodName, Integer count, boolean payment) {
        this.orderId = orderId;
        this.firstNamePerson = firstNamePerson;
        this.lastNamePerson = lastNamePerson;
        this.dateOrder = dateOrder;
        this.foodName = foodName;
        this.count = count;
        this.payment = payment;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public String getFirstNamePerson() {
        return firstNamePerson;
    }

    public String getLastNamePerson() {
        return lastNamePerson;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public String getFoodName() {
        return foodName;
    }

    public Integer getCount() {
        return count;
    }

    public boolean isPayment() {
        return payment;
    }
}
