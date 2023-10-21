package com.example.demo2.resturant.Dto;

import com.example.demo2.resturant.Models.CategoryModel;

public interface FoodInterFaceReport {

    Integer getFoodId();

    String getFoodName();

    Integer getFoodPrice();

    String getFoodIngredients();

    String getFoodImage();

    Integer getFoodCount();

    Integer getDiscountPrice();

    CategoryModel getCategoryModel();
}
