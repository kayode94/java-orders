package com.modelingorders.demo.services;

import com.modelingorders.demo.models.Customer;

import java.util.List;

public interface CustomersService
{
    List<Customer> findAllCustomers();

    Customer findCustomerById(long custcode);

    List<Customer> findCustomerByName(String custname);
}
