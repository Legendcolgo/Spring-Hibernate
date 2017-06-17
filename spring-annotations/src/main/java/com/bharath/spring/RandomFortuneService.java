package com.bharath.spring;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by bharathrajakumar on 5/31/17.
 */
@Component
public class RandomFortuneService implements FortuneService {
    private String[] fortuneList = new String[]{"Today you are gonna get fucked up", "Meh... Yet another day", "Today is your day"};

    public String getFortune() {
        int index = new Random().nextInt(fortuneList.length);
        return "Random fortune : " + fortuneList[index];
    }
}
