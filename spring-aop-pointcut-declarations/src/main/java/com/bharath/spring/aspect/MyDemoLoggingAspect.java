package com.bharath.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by bharathrajakumar on 7/29/17.
 */

@Aspect
@Component
public class MyDemoLoggingAspect {
    //This is where we add all of our advices
    //Advices are basically methods that get called before/after/around

    //This is a Point Cut Expression - to match any method with return type as void on a specific package
    //@Before("execution(* * com.bharath.spring.dao.*.*(..))")
    @Pointcut("execution(* com.bharath.spring.dao.*.*(..))")
    private void forDAOPackage() {}

    @Before("forDAOPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println(getClass() + " : Executing @Before advice on addAccount ");
    }

    @Before("forDAOPackage()")
    public void performAPIAnalytics() {
        System.out.println(getClass() + " : Performing API Analytics @Before advice on addAccount ");
    }
}
