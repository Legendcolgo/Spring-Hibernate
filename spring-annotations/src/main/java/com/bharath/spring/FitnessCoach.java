package com.bharath.spring;

/**
 * Created by bharathrajakumar on 6/5/17.
 */

public class FitnessCoach implements Coach {
    private FortuneService fortuneService;

    public FitnessCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    public String getDailyWorkout() {
        return "Work out 100 reps for push-ups";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
