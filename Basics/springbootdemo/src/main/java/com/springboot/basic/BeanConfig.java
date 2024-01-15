package com.springboot.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.springboot.basic")
public class BeanConfig {
    
    @Bean(name = "doctor")
    @Scope(value = "prototype")
    public Doctor doctor(){
        return new Doctor();
    }

    @Bean(name = "doctor2")
    public Doctor doctor2(){
        return new Doctor();
    }
   
}
