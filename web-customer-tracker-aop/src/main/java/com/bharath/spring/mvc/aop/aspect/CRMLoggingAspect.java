package com.bharath.spring.mvc.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * Created by bharathrajakumar on 8/24/17.
 */
@Aspect
@Component
public class CRMLoggingAspect {
    //Setup Logger
    private static Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

    //Setup pointcut declaration for controller
    @Pointcut("execution(* com.bharath.spring.mvc.aop.controller.*.*(..))")
    private void forControllerPackage() {}

    //Setup pointcut declaration for service
    @Pointcut("execution(* com.bharath.spring.mvc.aop.service.*.*(..))")
    private void forServicePackage() {}

    //Setup pointcut declaration for dao
    @Pointcut("execution(* com.bharath.spring.mvc.aop.dao.*.*(..))")
    private void forDaoPackage() {}

    //Pointcut expression for the complete application flow
    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    //Add before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        //Log the method we are calling
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("@Before - Calling method : " + methodName);

        //Log the arguments passed to the called method
        Object[] methodArguments = joinPoint.getArgs();
        logger.info("@Before - Parameters passed to the method : " + Arrays.toString(methodArguments));
    }

    //Add afterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        //Log the method we are returning from
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("@AfterReturning - from method : " + methodName);

        //Log the returning data
        logger.info("@AfterReturning - returned data : " + result);
    }
}
