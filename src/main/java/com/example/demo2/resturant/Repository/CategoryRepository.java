package com.example.demo2.resturant.Repository;

import com.example.demo2.resturant.Dto.CategoryAndFoods;
import com.example.demo2.resturant.Models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryModel,Integer> {

    //    @Query("select u from OrdersModel u where u.personsModel.Id= :PersonID ")
//    List<OrdersModel> findPersonsOrders(@Param("PersonID") Integer PersonID);

    //    ( categoryId,  categoryName,  foodId,  foodName,  foodPrice,  discountPrice,  foodImage,  foodIngredient)
    @Query("SELECT new com.example.demo2.resturant.Dto.CategoryAndFoods(u.CategoryId,  u.CategoryName,  r.foodId,r.foodName, r.foodPrice,r.DiscountPrice ,r.foodImage,r.foodIngredients) FROM CategoryModel u join u.foodsModels r where u.CategoryId=:id")
    List<CategoryAndFoods> findCategoryAndFoods(@Param("id") Integer id);
}
