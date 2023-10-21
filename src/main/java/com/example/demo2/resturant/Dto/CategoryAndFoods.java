package com.example.demo2.resturant.Dto;

public class CategoryAndFoods {

    public final Integer categoryId;
    public  final  String categoryName;
    private final Integer foodId;
    private final String foodName;
    private final Integer foodPrice;
    private final Integer discountPrice;
    private final String foodImage;
    private final String foodIngredient;

    public Integer getCateGoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public Integer getFoodPrice() {
        return foodPrice;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public String getFoodIngredient() {
        return foodIngredient;
    }

    public CategoryAndFoods(Integer categoryId, String categoryName, Integer foodId, String foodName, Integer foodPrice, Integer discountPrice, String foodImage, String foodIngredient) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.discountPrice = discountPrice;
        this.foodImage = foodImage;
        this.foodIngredient = foodIngredient;
    }
}
