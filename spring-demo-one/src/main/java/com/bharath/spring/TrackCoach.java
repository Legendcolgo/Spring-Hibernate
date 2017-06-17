package com.bharath.spring;

/**
 * Created by bharathrajakumar on 5/27/17.
 */
public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() {

    }

    //Init method for this bean
    public void doMyStartupStuff() {
        System.out.println("Trackcoach says : you are inside my bean init method");
    }

    //Destroy method for this bean
    public void doMyCleanupStuff() {
        System.out.println("Trackcoach says: you are inside my bean destroy method");
    }

    public TrackCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    public String getDailyWorkout() {
        return "Run for 30 minutes around the track";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune() + " dont count too much on it ;)";
    }
}
