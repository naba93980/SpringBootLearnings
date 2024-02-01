package com.events.spring.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.events.spring.event.BigBangEvent;
import com.events.spring.event.SmallBangEvent;

@Component
public class ZeeCafePublisher {

    ApplicationEventPublisher publisher;

    public ZeeCafePublisher() {
    }

    @Autowired
    public ZeeCafePublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void streamBangTheory(String episodeNo){
        System.out.println("zee cafe : starting BBT " + episodeNo );
        System.out.println("zee cafe : starting SBT " + episodeNo );
        publisher.publishEvent(new BigBangEvent(this, episodeNo));
        publisher.publishEvent(new SmallBangEvent(episodeNo));
    }
}
