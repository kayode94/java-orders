package com.modelingorders.demo.services;

import com.modelingorders.demo.models.Order;
import com.modelingorders.demo.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Transactional
@Service(value = "ordersService")
public class OrdersServiceImpl implements OrdersService
{
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public List<Order> findOrdersWithAdvanceAmount() {
        return ordersRepository.findAllByadvanceamtGreaterThan(0.00);
    }

    @Override
    public Order findOrdersById(long ordernum)
    {
        return ordersRepository.findById(ordernum).orElseThrow(() -> new EntityNotFoundException("Order " + ordernum + " Not Found"));
    }
}
