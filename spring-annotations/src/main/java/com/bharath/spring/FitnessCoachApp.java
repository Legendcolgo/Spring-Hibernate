package com.bharath.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by bharathrajakumar on 6/5/17.
 */
public class FitnessCoachApp {
    public static void main(String args[]) {
        //Step1: Load spring configuration from the config class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FitnessConfig.class);

        //Step2: Get the beans from the spring container using the bean-id
        FitnessCoach coach = context.getBean("fitnessCoach", FitnessCoach.class);

        //Step3: Make use of the bean methods
        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        //Step4: Close the application context
        context.close();
    }
}
