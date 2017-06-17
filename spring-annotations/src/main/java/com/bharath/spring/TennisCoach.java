package com.bharath.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by bharathrajakumar on 5/30/17.
 */
@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

//    @Value("${fortune.value}")
//    private String fortunes;

    //Field level Injection with Qualifiers for Dependency Injection
    @Autowired
    @Qualifier("readFromFileFortuneService")
    private FortuneService fortuneService;

    //Define a default constructor
    //This constructor needs to be commented out in case you are gonna use Constructor injection
    public TennisCoach() {
        System.out.println("Tennis coach says: You are inside my default constructor");
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("Tennis coach says : you are inside my post init method");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("Tennis coach says: you are inside my pre destroy method");
    }

    //Spring will call the dependency bean implementing the FortuneService Interface
    /*@Autowired
    public TennisCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }*/

    //Spring will call the dependency bean implementing the FortuneService Interface using the Setter injection
    /*@Autowired
    public void setFortuneService(FortuneService theFortuneService) {
        System.out.println("Tennis coach says: You are inside my setter method");
        fortuneService = theFortuneService;
    }*/

    //Inject dependencies by calling any method in your class
    /*@Autowired
    public void doSomeCrazyStuff(FortuneService theFortuneService) {
        System.out.println("Tennis coach says: You are inside my crazyStuff method");
        fortuneService = theFortuneService;
    }*/

    public String getDailyWorkout() {
        return "Practice your forehand volley";
    }

    public String getDailyFortune() {
//        System.out.println(fortunes);
        return fortuneService.getFortune();
    }
}
