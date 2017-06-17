package com.bharath.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bharathrajakumar on 6/14/17.
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    //Need a controller method to show the initial form

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //Need a controller method to process the form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //New controller  method to read form data and add it to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {

        //Read the request parameter from the html form
        String studentName = request.getParameter("studentName");

        //Convert the form data to uppercase
        studentName =studentName.toUpperCase();

        //Create a message
        String message = "Yo!!! " + studentName + ", What are you upto??";

        //Add this message to the model
        model.addAttribute("message", message);

        return "helloworld";
    }

    @RequestMapping("/processFormVersionThree")
    public String letsShoutDudeAgain(@RequestParam("studentName") String studentName, Model model) {

        //Convert the form data to uppercase
        studentName=studentName.toUpperCase();

        //Create a message
        String message = "Hey Yo dude !!! " + studentName + ", What are you upto??";

        //Add this message to the model
        model.addAttribute("message", message);

        return "helloworld";
    }
}

