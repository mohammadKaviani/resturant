package com.example.demo2.resturant.Models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class ReservationModel {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer Id;
    @ManyToOne
    RestaurantTables restaurantTables;
    @ManyToOne(cascade = CascadeType.MERGE)
    PersonsModel personsModel;
    String date;
    String startAt;
    String endAt;






    public String getDate() { return date; }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }


    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public PersonsModel getPersonsModel() {
        return personsModel;
    }
    public void setPersonsModel(PersonsModel personsModel) {
        this.personsModel = personsModel;
    }
    public RestaurantTables getRestaurantTables() {
        return restaurantTables;
    }
    public void setRestaurantTables(RestaurantTables restaurantTables) {
        this.restaurantTables = restaurantTables;
    }
}
