package com.bharath.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by bharathrajakumar on 6/1/17.
 */

@Configuration
@PropertySource(value={"file:src/sport.properties"})
@ComponentScan("com.bharath.spring")
public class SportConfig {
    //Define bean for SadFortuneService. Here "sadFortuneService" is the bean id
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    //Define bean for Swim coach and inject dependency. Here "swimCoach" is the bean id
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }
}
