package com.bharath.spring.hibernate.controller;

import com.bharath.spring.hibernate.entity.Customer;
import com.bharath.spring.hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by bharathrajakumar on 7/15/17.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    //Inject Customer Service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        //Get list of customers from the service
        List<Customer> customerList = customerService.getCustomers();

        System.out.println(customerList);

        //Add the list of customers to the model and return the view
        model.addAttribute("customers", customerList);

        return "list-customers";
    }
}
