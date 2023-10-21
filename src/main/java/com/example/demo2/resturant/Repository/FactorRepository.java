package com.example.demo2.resturant.Repository;

import com.example.demo2.resturant.Dto.CategoryAndFoods;
import com.example.demo2.resturant.Dto.FactorDetailsReport;
import com.example.demo2.resturant.Dto.FactorReport;
import com.example.demo2.resturant.Models.FactorModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FactorRepository extends JpaRepository <FactorModel,Integer> {



      @Query("SELECT new com.example.demo2.resturant.Dto.FactorReport(u.factorId,u.dateFactor,u.timeFactor,u.Sum,u.deliveryState,p.firstName,p.lastName) FROM FactorModel u join u.personsModel p")
      List<FactorReport> findFactors(Sort by);

      @Query("SELECT new com.example.demo2.resturant.Dto.FactorDetailsReport(fc.factorId ,p.firstName,p.lastName,fc.dateFactor,fc.timeFactor,fc.Sum,fc.deliveryState,f.foodName,u.Count) FROM OrdersModel u join u.personsModel  p join u.foods f join u.factorModel  fc   where fc.factorId=:factorId")
      List<FactorDetailsReport> findFactorById(@Param("factorId") Integer factorId);

      @Query("SELECT new com.example.demo2.resturant.Dto.FactorReport(u.factorId,u.dateFactor,u.timeFactor,u.Sum,u.deliveryState,p.firstName,p.lastName) FROM FactorModel u join u.personsModel p where u.dateFactor=:factorDate")
      List<FactorReport> findFactorByDate(@Param("factorDate") String factorDate);


      @Query("SELECT new com.example.demo2.resturant.Dto.FactorReport(u.factorId,u.dateFactor,u.timeFactor,u.Sum,u.deliveryState,p.firstName,p.lastName) FROM FactorModel u join u.personsModel p where p.Id=:personId")
      List<FactorReport> findFactorByPersonId(@Param("personId") Integer personId);

//      @Modifying
//      @Query("delete  from FactorModel u where u.dateFactor=:dateFactor")
//      void deleteByDate(@PathVariable("dateFactor") String dateFactor);
}
