package com.events.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.events.spring.publisher.ZeeCafePublisher;

@Component
public class MyRunner implements CommandLineRunner{

    private ZeeCafePublisher publisher;
    
    public MyRunner() {
    }

    @Autowired
    public MyRunner(ZeeCafePublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void run(String... args) throws Exception {
      publisher.streamBangTheory("23");
    }
    
}
