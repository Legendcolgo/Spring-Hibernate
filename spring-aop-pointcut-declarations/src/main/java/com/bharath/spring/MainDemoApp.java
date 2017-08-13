package com.bharath.spring;

import com.bharath.spring.dao.AccountDAO;
import com.bharath.spring.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class MainDemoApp
{
    public static void main( String[] args )
    {

        //Step1: Read Spring Config from Java Class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //Step2: Get the beans from the Spring Container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //Step3: Call bean methods
        Account account = new Account();
        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        membershipDAO.addAccount();
        membershipDAO.goToSleep();

//        System.out.println("Calling the add account method again for addAccountDAO!!!");
//        accountDAO.addAccount(account);

        //Step4: Close the context
        context.close();
    }
}
