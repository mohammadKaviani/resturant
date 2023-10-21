package com.example.demo2.resturant.Services;

import com.example.demo2.resturant.Models.ReservationModel;
import com.example.demo2.resturant.Models.RestaurantTables;
import com.example.demo2.resturant.Repository.ReservationTable;
import com.example.demo2.resturant.Repository.TableRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResarvationTableService {

    public ReservationTable reservationTable;
    public TableRepository tableRepository;

    public ResarvationTableService(ReservationTable reservationTable, TableRepository tableRepository) {
        this.reservationTable = reservationTable;
        this.tableRepository = tableRepository;
    }

    public String addReserve(ReservationModel reservationModel) {
        RestaurantTables restaurantTables;
        restaurantTables = tableRepository.findById(reservationModel.getRestaurantTables().getTableId()).get();

        if (restaurantTables.getTableStatus() == false) {
            return "میز مورد نظر رزو می باشد";
        } else {
            restaurantTables.setTableStatus(false);
            tableRepository.save(restaurantTables);
            reservationTable.save(reservationModel);
            return "میز مورد نظر رزو شد";
        }
    }


    public ResponseEntity<String> deleteReserve(Integer id){
        reservationTable.deleteById(id);
        return  new ResponseEntity<>("رزو لغو شد....", HttpStatus.OK);



    }
}
