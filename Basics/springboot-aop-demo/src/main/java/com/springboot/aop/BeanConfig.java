package com.springboot.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.springboot.aop")
@EnableAspectJAutoProxy
public class BeanConfig {
    
}
