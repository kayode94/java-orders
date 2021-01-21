package com.modelingorders.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordernum;

    private double orderamt;
    private double advanceamt;
    private String orderdescription;

    //Many orders to many types of payment relationship
    @ManyToMany
    @JoinTable(name = "orderspayments",
            joinColumns = @JoinColumn(name ="ordernum"),
            inverseJoinColumns = @JoinColumn(name = "paymentid"))
    Set<Payment>payments = new HashSet<>();

    //Many orders to one customer relationship
    @ManyToOne
    @JoinColumn(name="custcode", nullable = false)
    private Customer customer;

    public Order()
    {
        //default constructor
    }

    public Order(double orderamt, double advanceamt, Customer customer, String orderdescription) {
        this.orderamt = orderamt;
        this.advanceamt = advanceamt;
        this.orderdescription = orderdescription;
        this.customer = customer;
    }

    public long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(long ordernum) {
        this.ordernum = ordernum;
    }

    public double getOrderamt() {
        return orderamt;
    }

    public void setOrderamt(double orderamt) {
        this.orderamt = orderamt;
    }

    public double getAdvanceamt() {
        return advanceamt;
    }

    public void setAdvanceamt(double advanceamt) {
        this.advanceamt = advanceamt;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
