package com.bharath.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bharathrajakumar on 6/5/17.
 */
@Configuration
@ComponentScan("com.bharath.spring")
public class FitnessConfig {
    //Define bean for the Fortune Service
    @Bean
    public FortuneService singleFortuneService() {
        return new SingleFortuneService();
    }

    //Define bean for the coach
    @Bean
    public Coach fitnessCoach() {
        return new FitnessCoach(singleFortuneService());
    }
}
