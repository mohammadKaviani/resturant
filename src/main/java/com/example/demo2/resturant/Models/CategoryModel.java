package com.example.demo2.resturant.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "categoryName")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer CategoryId;
    private String CategoryName;

    @OneToMany(mappedBy = "categoryModel",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private  List<FoodsModel>foodsModels;
    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public List<FoodsModel> getFoodsModels() {
        return foodsModels;
    }

    public void setFoodsModels(List<FoodsModel> foodsModels) {
        this.foodsModels = foodsModels;
    }
}
