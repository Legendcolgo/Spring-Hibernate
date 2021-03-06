package com.bharath.spring.aspect;

import com.bharath.spring.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by bharathrajakumar on 7/29/17.
 */

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private static Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    //This is where we add all of our advices
    //Advices are basically methods that get called before/after/around
    @Before("com.bharath.spring.aspect.PointcutExpressions.avoidSetterAndGetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info(getClass() + " : Executing @Before advice on addAccount ");

        //Display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method signature : " + methodSignature);

        //Display method arguments
        Object[] arguments = joinPoint.getArgs();

        for(Object a : arguments) {
            logger.info("Method argument : " + a.toString());

            //Print Account object specific instance variables
            if(a instanceof Account) {
                Account account = (Account) a;

                logger.info("Account Name : " + account.getName());
                logger.info("Account Level : " + account.getLevel());
            }
        }
    }

    //Adding a new AfterReturning advice... YAY !!!
    @AfterReturning(pointcut = "com.bharath.spring.aspect.PointcutExpressions.forFindAccounts()", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        //Display the method we are advising on
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("Executing after advice on method : " + methodName);

        //Display the method's return value
        logger.info("Method result : " + result);

        //Performing post processing of the returned data by modifying the list

        //Convert the list of string to upper case
        convertAccountNamesToUpperCase(result);

    }

    //Adding a new AfterThrowing advice... YAY !!!
    @AfterThrowing(pointcut = "com.bharath.spring.aspect.PointcutExpressions.forFindAccounts()", throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        //Display the method we are advising on
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("Executing after throwing advice on method : " + methodName);

        //Log the exception
        logger.info("Exception being thrown : " + exception);
    }

    //Adding a new After advice... YAY !!!
    @After("com.bharath.spring.aspect.PointcutExpressions.forFindAccounts()")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        //Display the method we are advising on
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("Executing after finally advice on method : " + methodName);
    }

    //Adding a new Around advice... YAY !!!
    @Around("execution(* com.bharath.spring.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //Display the method we are advising on
        String methodName = proceedingJoinPoint.getSignature().toShortString();
        logger.info("Executing around advice on method : " + methodName);

        //Get the starting system time
        long startTime = System.currentTimeMillis();

        //Execute the target method
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());

            //Give a custom message
            result = "Someone is gonna come and save you... A girl is on her way !!!";

            //We can rethrow the exception by calling the following piece of code
            //throw e;
        }


        //Get the ending system time
        long endTime = System.currentTimeMillis();

        //Compute the time difference and display it
        logger.info("Total time taken for executing the fortune service(in Seconds) : " + (endTime - startTime)/1000.0);

        return result;
    }

    private void convertAccountNamesToUpperCase(List<Account> accountList) {
        for(Account account : accountList) {
            String tempAccountName = account.getName().toUpperCase();

            account.setName(tempAccountName);
        }
    }
}
