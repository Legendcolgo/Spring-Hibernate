package com.bharath.spring.hibernate.controller;

import com.bharath.spring.hibernate.entity.Customer;
import com.bharath.spring.hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        //Create a customer object and add it to the model
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }
}
