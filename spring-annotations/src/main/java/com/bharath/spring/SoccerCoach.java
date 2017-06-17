package com.bharath.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by bharathrajakumar on 5/30/17.
 */
@Component
public class SoccerCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    public String getDailyWorkout() {
        return "Practice on your dribbling skills";
    }

    public String getDailyFortune() {
        return "Soccer coach with email address - " + email + ", belonging to team - " + team + ", has a fortune : YOU SUCK !!!" ;
    }
}
