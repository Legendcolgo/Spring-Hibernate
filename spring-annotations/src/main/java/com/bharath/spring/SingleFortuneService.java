package com.bharath.spring;

import org.springframework.stereotype.Component;

/**
 * Created by bharathrajakumar on 6/5/17.
 */
@Component
public class SingleFortuneService implements FortuneService {
    public String getFortune() {
        return "This is your single fortune of the day : YOLO";
    }
}
