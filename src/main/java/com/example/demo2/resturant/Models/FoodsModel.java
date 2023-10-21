package com.example.demo2.resturant.Models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "foodName")
public class FoodsModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer foodId;
    private String  foodName;
    private Integer foodPrice;
    private String  foodIngredients;
    private String  foodImage;
    private  Integer FoodCount;
    private  Integer DiscountPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    CategoryModel categoryModel;
    @OneToMany(mappedBy = "foods",cascade = CascadeType.ALL)
    @JsonIgnore
    List<OrdersModel> ordersModels;

    public Integer getFoodId() {
        return foodId;
    }
    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }
    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    public Integer getFoodPrice() {
        return foodPrice;
    }
    public void setFoodPrice(Integer foodPrice) {
        this.foodPrice = foodPrice;
    }
    public String getFoodIngredients() {
        return foodIngredients;
    }
    public void setFoodIngredients(String foodIngredients) {
        this.foodIngredients = foodIngredients;
    }


    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public Integer getFoodCount() {
        return FoodCount;
    }
    public void setFoodCount(Integer foodCount) {
        FoodCount = foodCount;
    }
    public Integer getDiscountPrice() {
        return DiscountPrice;
    }
    public void setDiscountPrice(Integer discountPrice) {
        DiscountPrice = discountPrice;
    }
    public CategoryModel getCategoryModel() {
        return categoryModel;
    }
    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }
    public List<OrdersModel> getOrdersModels() {
        return ordersModels;
    }
    public void setOrdersModels(List<OrdersModel> ordersModels) {
        this.ordersModels = ordersModels;
    }
}
