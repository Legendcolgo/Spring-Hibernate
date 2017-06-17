package com.bharath.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by bharathrajakumar on 5/27/17.
 */
public class SetterDemoApp {
    public static void main(String[] args) {
        //Load the spring configuration file
        ApplicationContext context = new FileSystemXmlApplicationContext("src/bean.xml");

        //Get the beans from the spring container
        CricketCoach cricketCoach = context.getBean("myCricketCoach", CricketCoach.class);

        //Call the methods on the beans
        System.out.println(cricketCoach.getDailyWorkout());

        System.out.println(cricketCoach.getDailyFortune());

        //Call new methods to get the literal values
        System.out.println(cricketCoach.getEmailAddress());

        System.out.println(cricketCoach.getTeam());

        //Close the context
        ((FileSystemXmlApplicationContext)context).close();
    }
}
