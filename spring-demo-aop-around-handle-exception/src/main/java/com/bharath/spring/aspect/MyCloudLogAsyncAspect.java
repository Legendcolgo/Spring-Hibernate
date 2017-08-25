package com.bharath.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by bharathrajakumar on 8/7/17.
 */
@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("com.bharath.spring.aspect.PointcutExpressions.avoidSetterAndGetter()")
    public void logToCloudAsync() {
        System.out.println(getClass() + " : Logging to cloud in async fashion ");
    }
}
