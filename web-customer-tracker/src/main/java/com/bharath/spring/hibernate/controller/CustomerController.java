package com.bharath.spring.hibernate.controller;

import com.bharath.spring.hibernate.dao.CustomerDao;
import com.bharath.spring.hibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by bharathrajakumar on 7/15/17.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    //Inject Customer DAO
    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        //Get list of customers from the DAO
        List<Customer> customerList = customerDao.getCustomers();

        System.out.println(customerList);

        //Add the list of customers to the model and return the view
        model.addAttribute("customers", customerList);

        return "list-customers";
    }
}
