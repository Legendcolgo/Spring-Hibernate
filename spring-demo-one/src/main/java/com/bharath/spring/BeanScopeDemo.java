package com.bharath.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by bharathrajakumar on 5/28/17.
 */
public class BeanScopeDemo {
    public static void main(String args[]) {
        //Step1: Load Spring configuration file
        ApplicationContext context = new FileSystemXmlApplicationContext("src/beanScope.xml");

        //Step2: Retrieve the bean from the spring container
        Coach coachOne = context.getBean("myCoach", Coach.class);

        Coach coachTwo = context.getBean("myCoach", Coach.class);

        //Check if coachOne and coachTwo are the same bean
        boolean result = (coachOne == coachTwo);

        System.out.println("Pointing to the same object : " + result);

        System.out.println("Memory location of the firt bean : " + coachOne);

        System.out.println("Memory location of the second bean : " + coachTwo);

        //Step3: Close the context
        ((FileSystemXmlApplicationContext)context).close();
    }
}
