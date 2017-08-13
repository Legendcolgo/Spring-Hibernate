package com.bharath.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by bharathrajakumar on 7/29/17.
 */

@Aspect
@Component
public class MyDemoLoggingAspect {
    //This is where we add all of our advices
    //Advices are basically methods that get called before/after/around

    //This is a Point Cut Expression - to match a specific class that has this method name
    //@Before("execution(public void com.bharath.spring.dao.AccountDAO.addAccount())")

    //This is a Point Cut Expression - to match specific method which begins with string "add"
    //@Before("execution(public void add*())")

    //This is a Point Cut Expression - to match specific method with return type as void
    //@Before("execution(void addAccount())")

    //This is a Point Cut Expression - to match specific method with return type as void and with any number of parameters
    //@Before("execution(public void addAccount(..))")

    //This is a Point Cut Expression - to match any method with return type as void on a specific package
    //@Before("execution(* * com.bharath.spring.dao.*.*(..))")

    //This is a Point Cut Expression - to match any method with return type as void on a specific package with a specific parameter
    //@Before("execution(* add*(com.bharath.spring.Account))")

    //This is a Point Cut Expression - to match any method with return type as void on a specific package with any number of params
    //@Before("execution(* add*(..))")

    //This is a Point Cut Expression - to match any class that has this method name
    //@Before("execution(public void addAccount())")

    @Before("execution(* com.bharath.spring.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println(getClass() + " : Executing @Before advice on addAccount ");
    }
}
