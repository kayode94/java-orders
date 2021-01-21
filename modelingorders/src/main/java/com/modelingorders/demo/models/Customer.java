package com.modelingorders.demo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long custcode;

    @Column(nullable = false)
    private String custname;

    private String workingarea;

    private String custcountry;

    private String grade;

    private double openingamt;

    private double receiveamt;

    private double paymentamt;

    private double outstandingamt;

    private String phone;

    //Many customers to one agent relationship
    //Remember to pass agent in the constructor
    @ManyToOne
    @JoinColumn(name = "agentcode", nullable = false)
    private Agent agent;

    //One customer to many orders relationship
    //you dont have to pass orders because it is a List
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();



    public Customer()
    {
        //default constructor
    }

    public Customer( String custname, String custcity, String workingarea, String custcountry, String grade, double openingamt, double receiveamt, double paymentamt, double outstandingamt, String phone, Agent agent)
    {
        this.custname = custname;
        this.workingarea = workingarea;
        this.custcountry = custcountry;
        this.grade = grade;
        this.openingamt = openingamt;
        this.receiveamt = receiveamt;
        this.paymentamt = paymentamt;
        this.outstandingamt = outstandingamt;
        this.phone = phone;
        this.agent = agent;
    }

    public long getCustcode() {
        return custcode;
    }

    public void setCustcode(long custcode) {
        this.custcode = custcode;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getWorkingare() {
        return workingarea;
    }

    public void setWorkingare(String workingare) {
        this.workingarea = workingare;
    }

    public String getCustcountry() {
        return custcountry;
    }

    public void setCustcountry(String custcountry) {
        this.custcountry = custcountry;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getOpeningamt() {
        return openingamt;
    }

    public void setOpeningamt(double openingamt) {
        this.openingamt = openingamt;
    }

    public double getReceiveamt() {
        return receiveamt;
    }

    public void setReceiveamt(double receiveamt) {
        this.receiveamt = receiveamt;
    }

    public double getPaymentamt() {
        return paymentamt;
    }

    public void setPaymentamt(double paymentamt) {
        this.paymentamt = paymentamt;
    }

    public double getOutstandingamt() {
        return outstandingamt;
    }

    public void setOutstandingamt(double outstandingamt) {
        this.outstandingamt = outstandingamt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<Order> getOrder() {
        return orders;
    }

    public void setOrder(List<Order> order) {
        this.orders = order;
    }
}
