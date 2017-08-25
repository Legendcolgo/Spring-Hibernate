package com.bharath.spring.dao;

import com.bharath.spring.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bharathrajakumar on 7/29/17.
 */
@Component
public class AccountDAO {
    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + " : in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : Doing my db work - Adding an account");
    }

    public boolean doWork() {
        System.out.println(getClass() + " : Doing some real work ");
        return false;
    }

    public List<Account> findAccounts(boolean tripWire) {
        //Simulating exception for sake of throwing it... Duh !!!
        if(tripWire) {
            throw new RuntimeException("LOLException");
        }

        List<Account> accountList = new ArrayList<Account>();

        Account account1 = new Account("Barry", "Silver");
        Account account2 = new Account("Dave", "Diamond");
        Account account3 = new Account("Karina", "Gold");
        Account account4 = new Account("Dorathy", "Platinum");

        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);
        accountList.add(account4);

        return accountList;
    }
}
