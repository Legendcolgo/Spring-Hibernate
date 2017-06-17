package com.bharath.spring;

/**
 * Created by bharathrajakumar on 5/27/17.
 */
public class BaseballCoach implements Coach{

    //Define private field for dependency
    private FortuneService fortuneService;

    public BaseballCoach() {

    }

    //Define  constructor for dependency injection
    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    public String getDailyWorkout() {
        return "Spend 30 minutes on the batting practice";
    }

    public String getDailyFortune() {
        //Use my fortuneService to get a fortune
        return fortuneService.getFortune();
    }
}
