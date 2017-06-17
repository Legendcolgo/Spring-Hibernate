package com.bharath.spring;

/**
 * Created by bharathrajakumar on 6/1/17.
 */
public class SadFortuneService implements FortuneService {
    public String getFortune() {
        return "Today is yet another bad day for you !!!";
    }
}
