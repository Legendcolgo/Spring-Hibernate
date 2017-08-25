package com.bharath.spring;

import com.bharath.spring.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class AroundDemoApp
{
    public static void main( String[] args )
    {

        //Step1: Read Spring Config from Java Class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //Step2: Get the beans from the Spring Container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("Calling the main program");

        System.out.println("Calling fortune service to get my fortune");
        String fortune = trafficFortuneService.getFortune();

        System.out.println("Your fortune for the day is : " + fortune);

        //Step4: Close the context
        context.close();
    }
}
