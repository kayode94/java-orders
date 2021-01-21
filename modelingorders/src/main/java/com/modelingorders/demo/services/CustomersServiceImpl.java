package com.modelingorders.demo.services;

import com.modelingorders.demo.models.Customer;
import com.modelingorders.demo.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService
{
    @Autowired
    private CustomersRepository customersRepository;


    @Override
    public List<Customer> findAllCustomers()
    {
        List<Customer> myList = new ArrayList<>();
        customersRepository.findAll().iterator().forEachRemaining(myList::add);
        return myList;
    }

    @Override
    public Customer findCustomerById(long custcode) throws EntityNotFoundException
    {
        return customersRepository.findById(custcode).orElseThrow(()-> new EntityNotFoundException("Customer " + custcode + " Not found"));
    }

    @Override
    public List <Customer> findCustomerByName(String custname)
    {
        return customersRepository.findBycustnameContainingIgnoringCase(custname);
    }
}
