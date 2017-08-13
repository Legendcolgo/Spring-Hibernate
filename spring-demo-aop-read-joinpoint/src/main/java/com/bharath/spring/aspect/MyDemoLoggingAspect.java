package com.bharath.spring.aspect;

import com.bharath.spring.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println(getClass() + " : Executing @Before advice on addAccount ");

        //Display method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method signature : " + methodSignature);

        //Display method arguments
        Object[] arguments = joinPoint.getArgs();

        for(Object a : arguments) {
            System.out.println("Method argument : " + a);

            //Print Account object specific instance variables
            if(a instanceof Account) {
                Account account = (Account) a;

                System.out.println("Account Name : " + account.getName());
                System.out.println("Account Level : " + account.getLevel());
            }
        }
    }
}
