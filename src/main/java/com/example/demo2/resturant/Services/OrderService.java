package com.example.demo2.resturant.Services;

import com.example.demo2.resturant.Dto.FactorDetailsReport;
import com.example.demo2.resturant.Dto.OrderCurrentDto;
import com.example.demo2.resturant.Models.FactorModel;
import com.example.demo2.resturant.Models.FoodsModel;
import com.example.demo2.resturant.Models.OrdersModel;
import com.example.demo2.resturant.Models.PersonsModel;
import com.example.demo2.resturant.Repository.FactorRepository;
import com.example.demo2.resturant.Repository.FoodsModelRepository;
import com.example.demo2.resturant.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class OrderService {


    OrderRepository orderRepository;
    FactorRepository factorRepository;
    FoodsModelRepository foodsModelRepository;

    public OrderService(OrderRepository orderRepository, FoodsModelRepository foodsModelRepository, FactorRepository factorRepository) {
        this.orderRepository = orderRepository;
        this.factorRepository = factorRepository;
        this.foodsModelRepository = foodsModelRepository;
    }

    public List<OrdersModel> getAllOrders(Integer id) {

        return orderRepository.findPersonsOrders(id);
    }

    public String addOrder(List<OrdersModel> ordersModel) {
        String foodCountInfo = "";
        FoodsModel foodsModel = new FoodsModel();
        FactorModel factorModel = new FactorModel();
        FactorModel factorModel1 = new FactorModel();

        Integer sumPrice = 0;
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter df2 = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDate dateNow = LocalDate.now();
        LocalDate yearNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();

        //create Empty Factor
        PersonsModel personsModel = new PersonsModel();
        personsModel.setId(ordersModel.get(0).getPersonsModel().getId().intValue());
        factorModel.setPersonsModel(personsModel);
        factorModel1 = factorRepository.save(factorModel);


        for (OrdersModel ordersModel1 : ordersModel) {
            foodsModel = foodsModelRepository.findById(ordersModel1.getFoods().getFoodId()).get();

            if (foodsModel.getFoodCount() <= 0) {
                foodCountInfo += foodsModel.getFoodName() + " has been finished... \n";
            } else if (foodsModel.getFoodCount() < ordersModel1.getCount()) {
                foodCountInfo += "The amount of " + foodsModel.getFoodName() + "  requested is not available... \n";
            } else {

                ordersModel1.setDateOrder(df.format(dateNow).toString());
                ordersModel1.setFactorModel(factorModel1);
                foodsModel.setFoodCount(foodsModel.getFoodCount() - ordersModel1.getCount());

                foodsModelRepository.save(foodsModel);
                orderRepository.save(ordersModel1);
            }
            sumPrice = sumPrice + foodsModel.getFoodPrice();
        }


        factorModel1.setPersonsModel(personsModel);
        factorModel1.setDateFactor(df.format(dateNow).toString());
        factorModel1.setTimeFactor(tf.format(timeNow).toString());
        factorModel1.setDeliveryState(false);
        factorModel1.setSum(sumPrice);
        factorModel1.setDeliverPersonName("1001");
        factorRepository.save(factorModel1);


        if (foodCountInfo.length() == 0)
            return "All Orders Saved Successfully....";
        else
            return foodCountInfo;
    }

    public List<OrderCurrentDto> showCurrentOrders(Integer personId, String dateNow) {
        return orderRepository.findAllCurrentOrders(personId, dateNow);
    }


    public String deleteOrder(Integer orderId) {


        OrdersModel ordersModel = new OrdersModel();
        FoodsModel foodsModel = new FoodsModel();

        ordersModel = orderRepository.findById(orderId).orElse(null);

        if (Objects.isNull(ordersModel)) {
            return "Order Was Not Found";
        } else {

            foodsModel = foodsModelRepository.findById(ordersModel.getFoods().getFoodId().intValue()).get();
            foodsModel.setFoodCount(foodsModel.getFoodCount() + ordersModel.getCount());
            foodsModelRepository.save(foodsModel);
            orderRepository.deleteById(orderId);
            return "Order Was Deleted Successfully";
        }


    }

}
