package com.bharath.spring;

/**
 * Created by bharathrajakumar on 5/27/17.
 */
public class CricketCoach implements Coach {
    private FortuneService fortuneService;

    //TO inject literal values
    private String emailAddress;

    private String team;

    //Create a no-arg constructor
    public CricketCoach() {
        System.out.println("CricketCoach says : you are inside my no-args constructor");
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        System.out.println("CricketCoach says : my email address is " + this.emailAddress);
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
        System.out.println("CricketCoach says : my team is " + this.team);
    }

    //Setter method for dependency injection
    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("CricketCoach says : you are inside my setter method");
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout() {
        return "Practice on your batting";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
