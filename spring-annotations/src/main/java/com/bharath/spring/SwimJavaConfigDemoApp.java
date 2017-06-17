package com.bharath.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class SwimJavaConfigDemoApp
{
    public static void main( String[] args )
    {
        //Step1: Load Spring configuration from the Java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        //Step2: Retrieve the bean from the spring container using the default bean-id
        SwimCoach coachOne = context.getBean("swimCoach", SwimCoach.class);

        //Step3: Call methods on the bean
        System.out.println(coachOne.getDailyWorkout());

        System.out.println(coachOne.getDailyFortune());

        //Call methods specific to SwimCoach class
        System.out.println("Email address is : " + coachOne.getEmail() + ", Team is : " + coachOne.getTeam());

        //Step4: Close the application context
        context.close();
    }
}
