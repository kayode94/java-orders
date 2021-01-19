package com.modelingorders.demo.repositories;


import com.modelingorders.demo.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomersRepository extends CrudRepository<Customer, Long>
{

}
