package com.modelingorders.demo.controllers;

import com.modelingorders.demo.models.Customer;
import com.modelingorders.demo.services.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController
{
    @Autowired
    private CustomersService cusomtersService;

    //http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> customerList = cusomtersService.findAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    //http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{custcode}", produces = "application/json")
    public ResponseEntity<?> listCustomerById(@PathVariable long custcode)
    {
        Customer c = cusomtersService.findCustomerById(custcode);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //http://localhost:2019/customer/namelike/{name}
    @GetMapping(value = "/namelike/{custname}", produces = "application/json")
    public ResponseEntity<?> listCustomerByNameLike(@PathVariable String custname)
    {
        List<Customer> customerList = cusomtersService.findCustomerByName(custname);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}
