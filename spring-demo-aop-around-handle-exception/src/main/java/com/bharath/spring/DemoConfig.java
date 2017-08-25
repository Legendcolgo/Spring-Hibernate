package com.bharath.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by bharathrajakumar on 7/29/17.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.bharath.spring")
public class DemoConfig {

}
