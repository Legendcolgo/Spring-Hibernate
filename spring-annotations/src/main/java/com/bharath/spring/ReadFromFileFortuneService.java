package com.bharath.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by bharathrajakumar on 5/31/17.
 */
@Component
public class ReadFromFileFortuneService implements FortuneService {
    @Value("${fortune.value}")
    private String fortuneContent;

    private String[] fortunes;

    public ReadFromFileFortuneService() {

    }

    public String getFortune() {
        fortunes = fortuneContent.split(",");
        int index = new Random().nextInt(fortunes.length);
        return "Your random fortune from a file was picked and it is : " + fortunes[index];
    }
}
