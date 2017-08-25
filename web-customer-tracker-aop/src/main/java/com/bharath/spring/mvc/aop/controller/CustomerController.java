package com.bharath.spring.mvc.aop.controller;

import com.bharath.spring.mvc.aop.entity.Customer;
import com.bharath.spring.mvc.aop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by bharathrajakumar on 7/15/17.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static Logger logger = Logger.getLogger(CustomerController.class.getName());

    //Inject Customer Service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        //Get list of customers from the service
        List<Customer> customerList = customerService.getCustomers();

        logger.info(customerList.toString());

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

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId")int id, Model model) {
        //Get the customer from the database
        Customer customer = customerService.getCustomer(id);

        //Populate the model with the customer object
        model.addAttribute("customer", customer);

        //Send the model to the form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId")int id) {
        //Delete the cutomer id for the given primary key id
        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }
}
