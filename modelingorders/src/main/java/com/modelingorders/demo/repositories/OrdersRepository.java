package com.modelingorders.demo.repositories;


import com.modelingorders.demo.models.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Order, Long>
{

    List<Order> findAllByadvanceamtGreaterThan(double amount);
}
