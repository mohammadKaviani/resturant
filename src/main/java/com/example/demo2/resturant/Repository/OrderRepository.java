package com.example.demo2.resturant.Repository;

import com.example.demo2.resturant.Dto.FactorDetailsReport;
import com.example.demo2.resturant.Dto.FoodsReportWholePackage;
import com.example.demo2.resturant.Dto.OrderCurrentDto;
import com.example.demo2.resturant.Models.OrdersModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrdersModel,Integer> {

  @Query("select u from OrdersModel u where u.personsModel.Id= :PersonID ")
List<OrdersModel> findPersonsOrders(@Param("PersonID") Integer PersonID);


  @Query("SELECT new  com.example.demo2.resturant.Dto.OrderCurrentDto(u.Id,r.firstName,r.lastName,u.DateOrder,b.foodName,u.Count,u.Payment) " +
          "FROM OrdersModel u JOIN u.personsModel r JOIN u.foods b where r.Id=:PeronID and u.DateOrder=:dateNow ")
  List<OrderCurrentDto>findAllCurrentOrders(@Param("PeronID")Integer PeronID, @Param("dateNow")String dateNow );

  @Query("delete from OrdersModel t where t.factorModel.factorId = :factorId")
  void deleteAllByIdFactor(@Param("factorId") Integer factorId);

}
