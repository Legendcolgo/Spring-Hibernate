package com.bharath.spring;

import java.util.Random;

/**
 * Created by bharathrajakumar on 5/27/17.
 */
public class HappyFortuneService implements FortuneService {
    private String[] fortunes = new String []{};

    public String getFortune() {
        int index = new Random().nextInt(fortunes.length);
        return fortunes[index];
    }
}
