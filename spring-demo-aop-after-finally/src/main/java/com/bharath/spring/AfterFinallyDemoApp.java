package com.bharath.spring;

import com.bharath.spring.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class AfterFinallyDemoApp
{
    public static void main( String[] args )
    {

        //Step1: Read Spring Config from Java Class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //Step2: Get the beans from the Spring Container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        List<Account> accountList = null;

        try {
            //Adding a boolean flag to throw exception on purpose
            boolean tripWire = false;

            //Call method to find the accounts
            accountList = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("Caught the exception : " + e);
        }

        //Display the accounts
        System.out.println("Main Program : ");
        System.out.println(accountList);

        //Step4: Close the context
        context.close();
    }
}
