package com.hotel.userserviceasync;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@SpringBootApplication
@EnableFeignClients
@EnableAsync
public class UserServiceAsyncApplication implements AsyncConfigurer{

	@Bean(name = "taskExecutor")
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(25);
		executor.setThreadNamePrefix("MyExecutor-");
		executor.initialize();
		return executor;
	}

	@Override
    public Executor getAsyncExecutor() {
        return taskExecutor();
    }

	public static void main(String[] args) {
		SpringApplication.run(UserServiceAsyncApplication.class, args);
	}

}
