package com.bharath.spring.dao;

import org.springframework.stereotype.Component;

/**
 * Created by bharathrajakumar on 7/29/17.
 */
@Component
public class MembershipDAO {
    public boolean addAccount() {
        System.out.println(getClass() + " : Doing my db work - Adding a membership account");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + " : Going to sleep ");
    }
}
