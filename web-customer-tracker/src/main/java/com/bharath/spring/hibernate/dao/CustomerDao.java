package com.bharath.spring.hibernate.dao;

import com.bharath.spring.hibernate.entity.Customer;

import java.util.List;

/**
 * Created by bharathrajakumar on 7/15/17.
 */
public interface CustomerDao {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
