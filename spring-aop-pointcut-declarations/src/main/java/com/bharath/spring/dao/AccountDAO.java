package com.bharath.spring.dao;

import com.bharath.spring.Account;
import org.springframework.stereotype.Component;

/**
 * Created by bharathrajakumar on 7/29/17.
 */
@Component
public class AccountDAO {
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : Doing my db work - Adding an account");
    }

    public boolean doWork() {
        System.out.println(getClass() + " : Doing some real work ");
        return false;
    }
}
