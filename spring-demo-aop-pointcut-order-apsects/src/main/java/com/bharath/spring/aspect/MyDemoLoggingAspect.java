package com.bharath.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by bharathrajakumar on 7/29/17.
 */

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    //This is where we add all of our advices
    //Advices are basically methods that get called before/after/around
    @Before("com.bharath.spring.aspect.PointcutExpressions.avoidSetterAndGetter()")
    public void beforeAddAccountAdvice() {
        System.out.println(getClass() + " : Executing @Before advice on addAccount ");
    }
}
