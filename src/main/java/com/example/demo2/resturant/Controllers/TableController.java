package com.example.demo2.resturant.Controllers;

import com.example.demo2.resturant.Models.RestaurantTables;
import com.example.demo2.resturant.Services.TableInfoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TableController {

    public TableInfoService tableInfoService;

    public TableController(TableInfoService tableInfoService) {
        this.tableInfoService = tableInfoService;
    }


    @PostMapping(value = "/table-add")
    public RestaurantTables addTable(@RequestBody RestaurantTables  restaurantTables){
        return  tableInfoService.addTable(restaurantTables);
    }

    @GetMapping(value = "/get-list-table")
    public List<RestaurantTables> getAllTable()
    {
        return tableInfoService.getAllTable();
    }

    @PutMapping(value = "/update-table")
    public String updateTable(@RequestBody RestaurantTables restaurantTables){
        restaurantTables.getTableId();
        return tableInfoService.updateTable(restaurantTables);
    }
    @DeleteMapping(value = "/delete-table/{id}")
    public ResponseEntity<String> deletTable(@PathVariable Integer id){
        return tableInfoService.deleteTable(id);
    }


}
