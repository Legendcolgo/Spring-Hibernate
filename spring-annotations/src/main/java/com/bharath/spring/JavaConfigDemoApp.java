package com.bharath.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class JavaConfigDemoApp
{
    public static void main( String[] args )
    {
        //Step1: Load Spring configuration from the Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //Step2: Retrieve the bean from the spring container using the default bean-id
        Coach coachOne = context.getBean("tennisCoach", Coach.class);

        //Step3: Call methods on the bean
        System.out.println(coachOne.getDailyWorkout());

        System.out.println(coachOne.getDailyFortune());

        //Step4: Close the application context
        context.close();
    }
}
