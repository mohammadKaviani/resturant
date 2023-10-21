package com.example.demo2.resturant.Repository;

import com.example.demo2.resturant.Models.RestaurantTables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<RestaurantTables,Integer> {

}
