package com.example.demo2.resturant.Dto;

public class FactorReport {

    private final  Integer factorId;
    private  final String dateFactor;
    private final String timeFactor;
    private final Integer sumPerice;
    private  final boolean deliveryState;
    private final String personFirstName;
    private final String personLastName;

    public Integer getFactorId() {
        return factorId;
    }

    public String getDateFactor() {
        return dateFactor;
    }

    public String getTimeFactor() {
        return timeFactor;
    }

    public Integer getSumPerice() {
        return sumPerice;
    }

    public boolean isDeliveryState() {
        return deliveryState;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public FactorReport(Integer factorId, String dateFactor, String timeFactor, Integer sumPerice, boolean deliveryState, String personFirstName, String personLastName) {
        this.factorId = factorId;
        this.dateFactor = dateFactor;
        this.timeFactor = timeFactor;
        this.sumPerice = sumPerice;
        this.deliveryState = deliveryState;
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
    }
}
