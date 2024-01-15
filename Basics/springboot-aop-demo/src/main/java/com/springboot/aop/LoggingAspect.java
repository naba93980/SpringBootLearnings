package com.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
                                    // return type, package, class, method
    @Before("execution(* com.springboot.aop.*.*(..))")  // pointcut expression
    public void logger(JoinPoint jp){
        System.out.println(jp.getSignature());
        System.out.println("Logging......Logging......Logging");
    }

    @After("execution(* com.springboot.aop.*.*(..))")
    public void logger2(){
        System.out.println("Logging......Logging......Logging");
    }

}

// https://chat.openai.com/c/2aca22d4-7571-4906-b545-94844692e828