package com.example.demo2.resturant.Repository;


import com.example.demo2.resturant.Models.PersonsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonsModel,Integer> {
}
