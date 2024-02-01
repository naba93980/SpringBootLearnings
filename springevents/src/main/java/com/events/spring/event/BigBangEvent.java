package com.events.spring.event;

import org.springframework.context.ApplicationEvent;


public class BigBangEvent extends ApplicationEvent {

    private String episodeNo;

    public BigBangEvent(Object source) {
        super(source);
    }

    public BigBangEvent(Object source, String episodeNo) {
        super(source);
        this.episodeNo=episodeNo;
    }

    public String episodeNo(){
        return episodeNo;
    }

    @Override
    public String toString() {
        return "BigBangEvent [episodeNo=" + episodeNo + "]";
    }
    
}
