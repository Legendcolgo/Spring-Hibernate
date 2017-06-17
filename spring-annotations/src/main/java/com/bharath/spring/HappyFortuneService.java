package com.bharath.spring;

import org.springframework.stereotype.Component;

/**
 * Created by bharathrajakumar on 5/31/17.
 */
@Component
public class HappyFortuneService implements FortuneService {

    public String getFortune() {
        return "Today is not your lucky day!!! Deal with it !!!";
    }

}
