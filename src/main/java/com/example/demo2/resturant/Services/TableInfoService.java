package com.example.demo2.resturant.Services;


import com.example.demo2.resturant.Models.RestaurantTables;
import com.example.demo2.resturant.Repository.ReservationTable;
import com.example.demo2.resturant.Repository.TableRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class TableInfoService {

    public TableRepository tableRepository;

    public TableInfoService(TableRepository tableRepository) {

        this.tableRepository = tableRepository;
    }

    public RestaurantTables addTable(RestaurantTables restaurantTables) {
        return tableRepository.save(restaurantTables);
    }

    public List<RestaurantTables> getAllTable() {

        return tableRepository.findAll(Sort.by(Sort.Direction.DESC, "tableStatus"));

    }

    public String updateTable(RestaurantTables restaurantTables) {
        RestaurantTables restaurantTables1 = new RestaurantTables();
        if (tableRepository.findById(restaurantTables.getTableId()).isPresent()) {
            restaurantTables1.setTableId(restaurantTables.getTableId());
            restaurantTables1.setTitleTable(restaurantTables.getTitleTable());
            restaurantTables1.setCapacity(restaurantTables.getCapacity());
            restaurantTables1.setTableStatus(restaurantTables.getTableStatus());
            tableRepository.save(restaurantTables1);
            return "Record Was Updated Successfully";
        } else {
            return "Record Is Not Exist";
        }


    }

    public ResponseEntity<String> deleteTable(Integer id) {
        tableRepository.deleteById(id);
        return new ResponseEntity<>("SuccessFully....", HttpStatus.OK);
    }

}
