package com.bharath.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by bharathrajakumar on 6/1/17.
 */

public class SwimCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    private FortuneService fortuneService;

    public SwimCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    public String getDailyWorkout() {
        return "Practice on your back strokes";
    }

    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
