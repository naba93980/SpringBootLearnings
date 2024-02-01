package com.events.spring.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.events.spring.event.BigBangEvent;

@Component
public class NabaListener implements ApplicationListener<BigBangEvent> {

    @Override
    public void onApplicationEvent(BigBangEvent event) {
       System.out.println("Naba listened to event : " + event);
    }
    
}
