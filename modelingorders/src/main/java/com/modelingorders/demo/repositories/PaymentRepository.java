package com.modelingorders.demo.repositories;

import com.modelingorders.demo.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long>
{

}
