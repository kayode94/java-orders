package com.modelingorders.demo.services;

import com.modelingorders.demo.models.Order;

import java.util.List;

public interface OrdersService
{
    List<Order> findOrdersWithAdvanceAmount();

    Order findOrdersById(long ordernum);
}
