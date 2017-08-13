package com.bharath.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by bharathrajakumar on 8/7/17.
 */
@Aspect
public class PointcutExpressions {
    //This is a Point Cut Expression - to match any method with return type as void on a specific package
    //@Before("execution(* * com.bharath.spring.dao.*.*(..))")
    @Pointcut("execution(* com.bharath.spring.dao.*.*(..))")
    public void forDAOPackage() {}

    //Point Cut Expression for getter methods
    @Pointcut("execution(* com.bharath.spring.dao.*.get*(..))")
    public void forGetter() {}

    //Point Cut Expression for setter methods
    @Pointcut("execution(* com.bharath.spring.dao.*.set*(..))")
    public void forSetter() {}

    //Point Cut Expression for including the entire package except for setter and getter methods
    @Pointcut("forDAOPackage() && !(forGetter() || forSetter())")
    public void avoidSetterAndGetter() {}
}
