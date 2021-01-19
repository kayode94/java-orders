package com.modelingorders.demo.repositories;


import com.modelingorders.demo.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Order, Long>
{

}
