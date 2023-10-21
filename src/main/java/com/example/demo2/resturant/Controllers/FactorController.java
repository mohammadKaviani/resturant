package com.example.demo2.resturant.Controllers;

import com.example.demo2.resturant.Dto.FactorDetailsReport;
import com.example.demo2.resturant.Dto.FactorReport;
import com.example.demo2.resturant.Services.FactorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FactorController {


    FactorService factorService;
    @Autowired
    public FactorController(FactorService factorService) {
        this.factorService = factorService;
    }

    @GetMapping("/get-factors")
    public List<FactorReport> getFactors(){
        return factorService.getFactors();
    }

    @GetMapping("/get-factor-by-id/{factorId}")
    public List<FactorDetailsReport> getFactorById(@PathVariable Integer factorId){
        return factorService.getFactorById(factorId);
    }

    @GetMapping("/get-factor-by-date/{factorDate}")
    public List<FactorReport> getFactorById(@PathVariable String factorDate){
        return factorService.getFactorByDate(factorDate);
    }
    @GetMapping("/get-factor-by-person-id/{personId}")
    public List<FactorReport> getFactorByPersonId(@PathVariable Integer personId){
        return factorService.getFactorByPersonId(personId);
    }
    @DeleteMapping("/delete-factor/{codeFactor}")
    public String deleteFactorAndOrders(@PathVariable Integer codeFactor){
        return factorService.deleteFactorAndOrders(codeFactor);
    }
}
