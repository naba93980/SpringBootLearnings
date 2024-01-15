package com.springboot.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAspectMain
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        ShoppingCart cart = context.getBean(ShoppingCart.class);
        cart.checkout("abc");
        context.close();
    }
}
