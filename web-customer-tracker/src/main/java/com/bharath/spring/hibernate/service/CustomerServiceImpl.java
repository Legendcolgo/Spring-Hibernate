package com.bharath.spring.hibernate.service;

import com.bharath.spring.hibernate.dao.CustomerDao;
import com.bharath.spring.hibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bharathrajakumar on 7/16/17.
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    //Inject Customer DAO
    @Autowired
    private CustomerDao customerDao;

    //@Transactional - This annotation tells Spring to begin and end the transaction after calling this piece of code block
    @Transactional
    public List<Customer> getCustomers() {
        //Delegate the call to dao
        return customerDao.getCustomers();
    }

    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Transactional
    public Customer getCustomer(int id) {
        return customerDao.getCustomer(id);
    }
}
