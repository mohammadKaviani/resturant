package com.example.demo2.resturant.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "titleTable")
public class RestaurantTables {

     @Id
     @GeneratedValue(strategy= GenerationType.AUTO)
     Integer TableId;
     String TitleTable;
     String Capacity;
     Boolean tableStatus;

     @OneToMany(mappedBy = "restaurantTables")
  @JsonIgnore
     List<ReservationModel>reservationModels;


    public Boolean getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Boolean tableStatus) {
        this.tableStatus = tableStatus;
    }

    public List<ReservationModel> getReservationModels() {
        return reservationModels;
    }

    public void setReservationModels(List<ReservationModel> reservationModels) {
        this.reservationModels = reservationModels;
    }

    public Integer getTableId() {
        return TableId;
    }

    public void setTableId(Integer tableId) {
        TableId = tableId;
    }

    public String getTitleTable() {
        return TitleTable;
    }

    public void setTitleTable(String titleTable) {
        TitleTable = titleTable;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }
}
