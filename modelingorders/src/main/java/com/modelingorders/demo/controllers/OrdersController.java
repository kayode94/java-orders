package com.modelingorders.demo.controllers;

import com.modelingorders.demo.models.Order;
import com.modelingorders.demo.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController
{
    @Autowired
    private OrdersService ordersService;

    //http://localhost:2019/order/advanceamt
    @GetMapping(value = "/advanceamt", produces = "application/json")
    public ResponseEntity<?> findOrderWithAdvanceAmount()
    {
        List<Order> orderList = ordersService.findOrdersWithAdvanceAmount();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    ////http://localhost:2019/order/{ordernum}"
    @GetMapping(value = "/order/{ordernum}", produces = "application/json")
    public ResponseEntity<?> getOrderByNumber(@PathVariable long ordernum)
    {
        Order o = ordersService.findOrdersById(ordernum);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }
}
