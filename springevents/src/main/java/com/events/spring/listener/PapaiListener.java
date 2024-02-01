package com.events.spring.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.events.spring.event.BigBangEvent;
import com.events.spring.event.SmallBangEvent;

@Component
public class PapaiListener {

    @EventListener
    public void onListeningEvent(BigBangEvent event) {
        System.out.println("papai listened to event : " + event);
    }

    @EventListener
    public void onListeningEvent(SmallBangEvent event) {
        System.out.println("papai listened to event : " + event);
    }
}
