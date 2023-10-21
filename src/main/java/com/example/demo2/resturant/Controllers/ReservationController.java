package com.example.demo2.resturant.Controllers;


import com.example.demo2.resturant.Models.ReservationModel;
import com.example.demo2.resturant.Services.ResarvationTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationController {


    public ResarvationTableService resarvationTableService;
    @Autowired
    public ReservationController(ResarvationTableService resarvationTableService) {
        this.resarvationTableService = resarvationTableService;
    }
    @PostMapping(value = "/reserve-add")
    public String addReserve(@RequestBody ReservationModel reservationModel){
        return resarvationTableService.addReserve(reservationModel);
    }


    @DeleteMapping(value = "/delete-reserve/{id}")
    public ResponseEntity<String> deleteReserve(@PathVariable Integer id){
        return resarvationTableService.deleteReserve(id);
    }



}
