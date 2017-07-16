package com.bharath.spring.hibernate.dao;

import com.bharath.spring.hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

        //Create a hibernate query and sort it by last name. Use the bean's property name rather than the table column name
        Query<Customer> listCustomerQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        //Execute the query and get the result set
        List<Customer> customerList = listCustomerQuery.getResultList();

        //Return the result set
        return customerList;
    }

    public void saveCustomer(Customer customer) {

        //Get a hibernate session from the session factory
        Session currentSession = sessionFactory.getCurrentSession();
        
        //Save or Update - It will basically check if the primary key is null, if null it will treat it as a new cutomer
        //record else it will update the existing customer record for the given primary key
        currentSession.saveOrUpdate(customer);
    }

    public Customer getCustomer(int id) {

        //Get a hibernate session from the session factory
        Session currentSession = sessionFactory.getCurrentSession();

        //Get the customer record using the primary key from the database
        Customer customer = currentSession.get(Customer.class, id);

        return customer;
    }
}
