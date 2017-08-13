package com.bharath.spring;

import com.bharath.spring.dao.AccountDAO;
import com.bharath.spring.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class AfterReturningDemoApp
{
    public static void main( String[] args )
    {

        //Step1: Read Spring Config from Java Class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //Step2: Get the beans from the Spring Container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        //Call method to find the accounts
        List<Account> accountList = accountDAO.findAccounts();

        //Display the accounts
        System.out.println("Main Program : ");
        System.out.println(accountList);

        //Step4: Close the context
        context.close();
    }
}
