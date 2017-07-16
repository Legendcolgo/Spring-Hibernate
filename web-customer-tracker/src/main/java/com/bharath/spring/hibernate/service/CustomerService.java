package com.bharath.spring.hibernate.service;

import com.bharath.spring.hibernate.entity.Customer;

import java.util.List;

/**
 * Created by bharathrajakumar on 7/16/17.
 */
public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);
}
