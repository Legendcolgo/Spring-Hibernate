package com.bharath.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by bharathrajakumar on 6/1/17.
 */
public class AnnotationBeanScopeDemoApp {
    public static void main( String[] args )
    {
        //Step1: Load Spring configuration file
        ApplicationContext context = new FileSystemXmlApplicationContext("src/bean.xml");

        //Step2: Retrieve the bean from the spring container using the default bean-id
        Coach coachOne = context.getBean("tennisCoach", Coach.class);

        Coach coachTwo = context.getBean("tennisCoach", Coach.class);

        boolean result = (coachOne == coachTwo);

        //Step3: Call methods on the bean

        System.out.println("Pointing to the same object : " + result);

        System.out.println("Memory location for coachOne : " + coachOne);

        System.out.println("Memory location for coachTwo  : " + coachTwo);

        //Step4: Close the application context
        ((FileSystemXmlApplicationContext)context).close();
    }
}
