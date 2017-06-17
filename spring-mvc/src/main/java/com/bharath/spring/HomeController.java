package com.bharath.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bharathrajakumar on 6/5/17.
 */
//Step1 : Create a controller class
@Controller
public class HomeController {

    //Step2: Create a controller method
    //Step3: Add a request mapping to this method
    @RequestMapping("/")
    public String showPage() {

        //Step4: Return the view
        return "main-menu";
    }
}
