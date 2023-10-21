package com.example.demo2.resturant.Dto;


public class FoodsReportWholePackage {


    private final Integer foodId;
    private final String foodName;
    private final Integer foodPrice;
    private final Integer discountPrice;
    private final String foodImage;
    private final String foodIngredient;

    private final String  categoryName;
//    private final  CategoryModel categoryModel;

    public FoodsReportWholePackage(Integer foodId, String foodName, Integer foodPrice, Integer discountPrice, String foodImage, String foodIngredient, String categoryName) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.discountPrice = discountPrice;
        this.foodImage = foodImage;
        this.foodIngredient = foodIngredient;
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }
//    public CategoryModel getCategoryModel() {
//        return categoryModel;
//    }
}
