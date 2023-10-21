package com.example.demo2.resturant.Repository;

import com.example.demo2.resturant.Models.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationTable extends JpaRepository<ReservationModel,Integer> {
}
