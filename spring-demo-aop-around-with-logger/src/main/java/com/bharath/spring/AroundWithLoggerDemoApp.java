package com.bharath.spring;

import com.bharath.spring.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class AroundWithLoggerDemoApp
{
    private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
    public static void main( String[] args )
    {

        //Step1: Read Spring Config from Java Class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //Step2: Get the beans from the Spring Container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Calling the main program");

        logger.info("Calling fortune service to get my fortune");
        String fortune = trafficFortuneService.getFortune();

        logger.info("Your fortune for the day is : " + fortune);

        //Step4: Close the context
        context.close();
    }
}
