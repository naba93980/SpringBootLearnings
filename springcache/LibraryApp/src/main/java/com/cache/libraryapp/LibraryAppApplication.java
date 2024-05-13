package com.cache.libraryapp;

import java.time.Duration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

@SpringBootApplication
@EnableCaching
public class LibraryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAppApplication.class, args);
	}

	@Bean
	public RedisCacheManagerBuilderCustomizer myRedisCacheManagerBuilderCustomizer() {
		return (builder) -> builder
				.withCacheConfiguration("books", RedisCacheConfiguration
						.defaultCacheConfig().entryTtl(Duration.ofSeconds(10))
						.prefixCacheNameWith("library-app"));
	}
}
