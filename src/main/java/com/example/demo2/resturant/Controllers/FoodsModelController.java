package com.example.demo2.resturant.Controllers;

import com.example.demo2.resturant.Models.FileUploadUtil;
import com.example.demo2.resturant.Models.FoodsModel;
import com.example.demo2.resturant.Dto.FoodInterFaceReport;
import com.example.demo2.resturant.Dto.FoodsReportWholePackage;
import com.example.demo2.resturant.Models.ImageData;
import com.example.demo2.resturant.Services.FoodsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class FoodsModelController {


    FoodsServices foodsServices;
    @Autowired
    public FoodsModelController(FoodsServices foodsServices) {
        this.foodsServices = foodsServices;
    }
    @GetMapping(value = "/get-all-foods")
    public List<Object[]> getListFoods() { return foodsServices.getListFoods();}
    @GetMapping(value = "/food-list-interface")
    public List<FoodInterFaceReport> getAllFoodsInterface() { return foodsServices.getListFoodsByInterFace(); }
    @GetMapping(value = "/food-list")
    public List<FoodsReportWholePackage> getAllPackage() { return foodsServices.getAllPackage(); }
    @PutMapping(value = "/update-foods")
    public ResponseEntity<String> updateFood(FoodsModel foodsModel, @RequestParam("image") MultipartFile multiPartFile, @RequestParam("category") Integer category) throws IOException {
        return foodsServices.updateFoods(foodsModel, multiPartFile, category);
    }
    @PostMapping(value = "/food-add")
    public String addFood(FoodsModel foodsModel, @RequestParam("image") MultipartFile multipartFile, @RequestParam("category") Integer category) throws IOException {
        return foodsServices.addFood(foodsModel, multipartFile, category);
    }
    @DeleteMapping("/delete-food/{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Integer id) {
        return foodsServices.deleteFood(id);
    }


}
