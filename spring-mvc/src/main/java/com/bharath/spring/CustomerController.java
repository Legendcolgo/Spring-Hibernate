package com.bharath.spring;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by bharathrajakumar on 6/17/17.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    //@Initbinder - This will be used for pre-processing the web requests
    //In this case we are going to be trimming the white spaces before the data gets into
    //the model object
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        //Trim the white spaces and if any field is having only white spaces, it will be trimmed to null.
        //This is done by enabling it to - true

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        //This will be applied only for the "String" class not for any other data types
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @RequestMapping("/processForm")
    //@Valid - Performs validations on the customer object
    //BindingResult - Stores the result of the validation
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

        System.out.println("Binding Result : " + bindingResult);

        if(bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            System.out.println("Customer First Name : " + customer.getFirstName() + ", Last Name : " + customer.getLastName());
            return "customer-confirmation";
        }

    }
}
