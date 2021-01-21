package com.modelingorders.demo.repositories;


import com.modelingorders.demo.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomersRepository extends CrudRepository<Customer, Long>
{

    List<Customer> findBycustnameContainingIgnoringCase(String name);
}
