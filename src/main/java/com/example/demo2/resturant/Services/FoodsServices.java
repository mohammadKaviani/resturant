package com.example.demo2.resturant.Services;

import com.example.demo2.resturant.Models.CategoryModel;
import com.example.demo2.resturant.Models.FileUploadUtil;
import com.example.demo2.resturant.Models.FoodsModel;
import com.example.demo2.resturant.Dto.FoodInterFaceReport;
import com.example.demo2.resturant.Dto.FoodsReportWholePackage;
import com.example.demo2.resturant.Models.ImageData;
import com.example.demo2.resturant.Repository.FoodsModelRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FoodsServices {

    FoodsModelRepository foodsModelRepository;

    public FoodsServices(FoodsModelRepository foodsModelRepository) {
        this.foodsModelRepository = foodsModelRepository;
    }

    public String addFood(FoodsModel foodsModel, @RequestParam("image") MultipartFile multipartFile, @RequestParam("category") Integer category) throws IOException {


        FoodsModel foodsModel1 = new FoodsModel();
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());


        foodsModel1.setFoodName(foodsModel.getFoodName());
        foodsModel1.setFoodPrice(foodsModel.getFoodPrice());
        foodsModel1.setFoodCount(foodsModel.getFoodCount());
        foodsModel1.setDiscountPrice(foodsModel.getDiscountPrice());
        foodsModel1.setFoodIngredients(foodsModel.getFoodIngredients());
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryId(category);
        foodsModel1.setCategoryModel(categoryModel);
        Integer int_random = ThreadLocalRandom.current().nextInt();
        foodsModel1.setFoodImage(int_random.toString() + "_" + fileName);
        FoodsModel savedFoods = foodsModelRepository.save(foodsModel1);
        String uploadDir = "foods-photos/";

        FileUploadUtil.saveFile(uploadDir, int_random.toString() + "_" + fileName, multipartFile);

        return "Okey Shod";
    }

    public List<Object[]> getListFoods() {
        return foodsModelRepository.findAllFoods();
    }

    public List<FoodInterFaceReport> getListFoodsByInterFace() {
        return foodsModelRepository.findAllFoodInterFace();
    }

    public List<FoodsReportWholePackage> getAllPackage() {
        return foodsModelRepository.findAllByPackageName();
    }

    public ResponseEntity<String> updateFoods(FoodsModel foodsModel, @RequestParam("image") MultipartFile multipartFile, @RequestParam("category") Integer category) throws IOException {


        FoodsModel foodsModel1 = new FoodsModel();
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        foodsModel1 = foodsModelRepository.findById(foodsModel.getFoodId().intValue()).get();
        foodsModel1.setFoodName(foodsModel.getFoodName());
        foodsModel1.setFoodPrice(foodsModel.getFoodPrice());
        foodsModel1.setDiscountPrice(foodsModel.getDiscountPrice());
        foodsModel1.setFoodIngredients(foodsModel.getFoodIngredients());

        if (multipartFile != null) {

            Path path = FileSystems.getDefault().getPath("foods-photos/" + foodsModel1.getFoodImage());
            try {
                Files.delete(path);
            } catch (NoSuchFileException x) {
                System.err.format("%s: no such" + " file or directory%n", path);
            } catch (IOException x) {
                System.err.println(x);
            }


            Integer int_random = ThreadLocalRandom.current().nextInt();
            foodsModel1.setFoodImage(int_random.toString() + "_" + fileName);
            String uploadDir = "foods-photos/";
            FileUploadUtil.saveFile(uploadDir, int_random.toString() + "_" + fileName, multipartFile);
        }

        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setCategoryId(category);
        foodsModel1.setCategoryModel(categoryModel);
        foodsModelRepository.save(foodsModel1);
        return new ResponseEntity<>("Food Model Updated...", HttpStatus.OK);


    }

    public ResponseEntity<String> deleteFood(Integer id) {

        FoodsModel foodsModel = new FoodsModel();

        if(foodsModelRepository.findById(id).isPresent()) {
            foodsModel =foodsModelRepository.findById(id).get();
            Path path = FileSystems.getDefault().getPath("foods-photos/" + foodsModel.getFoodImage());
            try {
                Files.delete(path);
            } catch (NoSuchFileException x) {
                System.err.format("%s: no such" + " file or directory%n", path);
            } catch (IOException x) {
                System.err.println(x);
            }

            foodsModelRepository.deleteById(id);
            return new ResponseEntity<>("One Record was Deleted....", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("  Record was not Found ....", HttpStatus.OK);
        }

    }
}
