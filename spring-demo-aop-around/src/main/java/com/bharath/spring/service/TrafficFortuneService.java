package com.bharath.spring.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by bharathrajakumar on 8/14/17.
 */
@Component
public class TrafficFortuneService {
    public String getFortune() {
        //Artificially delay the code exection

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Return a fortune
        return "Expect a heavy dose of bad luck today !!! ";
    }
}
