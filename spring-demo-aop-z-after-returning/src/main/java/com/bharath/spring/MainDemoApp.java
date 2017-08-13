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
        account.setName("bharath");
        account.setLevel("gold");

        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String serviceCode = accountDAO.getServiceCode();

        membershipDAO.addAccount();
        membershipDAO.goToSleep();


        //Step4: Close the context
        context.close();
    }
}
