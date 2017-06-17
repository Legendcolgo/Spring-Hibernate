package com.bharath.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class AnnotationDemoApp
{
    public static void main( String[] args )
    {
        //Step1: Load Spring configuration file
        ApplicationContext context = new FileSystemXmlApplicationContext("src/bean.xml");

        //Step2: Retrieve the bean from the spring container using the default bean-id
        Coach coachOne = context.getBean("tennisCoach", Coach.class);

        //Step3: Call methods on the bean
        System.out.println(coachOne.getDailyWorkout());

        System.out.println(coachOne.getDailyFortune());

        //Step4: Close the application context
        ((FileSystemXmlApplicationContext)context).close();
    }
}
