package com.springboot.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springboot.basic.interfaces.IStaff;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        IStaff doc1 = context.getBean("doctor", Doctor.class);
        System.out.println(doc1);

        IStaff doc2 = context.getBean("doctor", Doctor.class);
        System.out.println(doc2);

        IStaff doc3 = context.getBean("doctor2", Doctor.class);
        System.out.println(doc3);

        IStaff doc4 = context.getBean("doctor2", Doctor.class);
        System.out.println(doc4);

    }
}
