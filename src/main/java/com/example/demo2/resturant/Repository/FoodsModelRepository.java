package com.example.demo2.resturant.Repository;


import com.example.demo2.resturant.Models.FoodsModel;
import com.example.demo2.resturant.Dto.FoodInterFaceReport;
import com.example.demo2.resturant.Dto.FoodsReportWholePackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FoodsModelRepository extends JpaRepository<FoodsModel, Integer> {
//    @Query("select u from OrdersModel u where u.personsModel.Id= :PersonID ")
//    List<OrdersModel> findPersonsOrders(@Param("PersonID") Integer PersonID);

    @Query("SELECT u.foodName,u.foodPrice,u.foodIngredients,u.DiscountPrice" +
            " ,u.foodId,u.foodImage, u.categoryModel.CategoryName FROM  FoodsModel u")
    List<Object[]> findAllFoods();

    @Query("SELECT u FROM FoodsModel u")
    List<FoodInterFaceReport> findAllFoodInterFace();
    @Query("SELECT new  com.example.demo2.resturant.Dto.FoodsReportWholePackage(u.foodId,u.foodName," +
        "u.foodPrice,u.DiscountPrice,u.foodImage,u.foodIngredients,r.CategoryName) FROM FoodsModel u JOIN u.categoryModel r")
    List<FoodsReportWholePackage>findAllByPackageName();

//
//    Integer foodId;
//    private String  foodName;
//    private Integer foodPrice;
//    private String  foodIngredients;
//    private String  foodImage;
//    private  Integer FoodCount;
//    private  Integer DiscountPrice;


}
