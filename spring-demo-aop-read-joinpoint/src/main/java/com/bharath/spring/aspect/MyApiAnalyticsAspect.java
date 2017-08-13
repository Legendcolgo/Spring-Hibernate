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
@Order(3)
public class MyApiAnalyticsAspect {
    @Before("com.bharath.spring.aspect.PointcutExpressions.avoidSetterAndGetter()")
    public void performAPIAnalytics() {
        System.out.println(getClass() + " : Performing API Analytics @Before advice on addAccount ");
    }
}
