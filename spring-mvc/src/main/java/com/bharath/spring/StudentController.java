package com.bharath.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bharathrajakumar on 6/14/17.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    //Create a method to show the form
    @RequestMapping("/showForm")
    public String showForm(Model model) {

        //Create a student object
        Student student = new Student();

        //Add this student object to the model
        model.addAttribute("student", student);

        //Add country options to the model
        model.addAttribute("theCountryOptions", countryOptions);

        return "student-form";
    }

    //Create a method to show the processed student model
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student){

        System.out.println("Student Details : ");
        System.out.println("First Name : " + student.getFirstName() + ", Last Name : " + student.getLastName());
        System.out.println("Country : " + student.getCountry());
        System.out.println("Favorite Language : " + student.getFavoriteLanguage());
        System.out.println("Favorite Operating System : " + student.getFavoriteOperatingSystems());
        return  "student-confirmation";
    }

}
