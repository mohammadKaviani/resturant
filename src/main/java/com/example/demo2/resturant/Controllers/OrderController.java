package com.example.demo2.resturant.Controllers;

import com.example.demo2.resturant.Dto.FactorDetailsReport;
import com.example.demo2.resturant.Dto.OrderCurrentDto;
import com.example.demo2.resturant.Models.OrdersModel;
import com.example.demo2.resturant.Services.OrderService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class OrderController {

    OrderService orderService;

    public OrderController(OrderService orderService)
    {this.orderService = orderService; }
    @PostMapping(value = "/order-add")
    public String addOrder(@RequestBody List<OrdersModel> ordersModel)
    {return orderService.addOrder(ordersModel);}
    @GetMapping(value = "/get-orders/{id}")
    public List<OrdersModel> getAll(@PathVariable Integer id)
    { return orderService.getAllOrders(id);}
    @GetMapping(value = "/show-current-orders/{personId}/{dateNow}")
    public  List<OrderCurrentDto> showCurrentOrders(@PathVariable Integer personId,@PathVariable String dateNow)
    {return orderService.showCurrentOrders(personId,dateNow); }
    @DeleteMapping(value = "/delete-order/{id}")
    public String deleteOrder(@PathVariable Integer id)
    {return orderService.deleteOrder(id);}



}
