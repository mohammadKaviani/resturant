package com.example.demo2.resturant.Controllers;

import com.example.demo2.resturant.Dto.CategoryAndFoods;
import com.example.demo2.resturant.Models.CategoryModel;
import com.example.demo2.resturant.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @RequestMapping(value = "/category-add",method = RequestMethod.POST)
    public CategoryModel addCategory(@RequestBody CategoryModel categoryModel){
        return categoryService.addCategory(categoryModel);
    }
    @GetMapping(value = "/get-categories")
    public List<CategoryModel> getCategpreis(){
        return categoryService.getAllCategoreis();
    }
    @GetMapping(value = "/get-category-foods/{id}")
    public List<CategoryAndFoods> getCategoryFoods(@PathVariable int id){
       return categoryService.getCategoryFoods(id);
    }
    @PostMapping(value = "/update-cagetory")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryModel categoryModel){
        return  categoryService.updateCategory(categoryModel);
    }
    @PostMapping(value = "/delete-cagetory/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Integer id){
        return  categoryService.deleteCategory(id);
    }
}
