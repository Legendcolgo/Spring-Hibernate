package com.bharath.spring.hibernate.dao;

import com.bharath.spring.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bharathrajakumar on 7/15/17.
 */
//@Repository - This annotation tells Spring that this is a DAO Implementation
@Repository
public class CustomerDaoImpl implements CustomerDao {

    //Inject Session factory
    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomers() {

        //Get a hibernate session from the session factory
        Session currentSession = sessionFactory.getCurrentSession();

        //Create a hibernate query
        Query<Customer> listCustomerQuery = currentSession.createQuery("from Customer", Customer.class);

        //Execute the query and get the result set
        List<Customer> customerList = listCustomerQuery.getResultList();

        //Return the result set
        return customerList;
    }
}
