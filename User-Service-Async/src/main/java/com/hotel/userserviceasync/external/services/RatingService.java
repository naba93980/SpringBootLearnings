package com.hotel.userserviceasync.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.userserviceasync.entities.Rating;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "Rating-Service")
public interface RatingService {
    
    @GetMapping("/ratings/getRatingByUserId")
    @Retry(name = "ratingService", fallbackMethod = "getRatingByUserIdRetryFallback" )
    @CircuitBreaker(name = "ratingService")
    @RateLimiter(name = "ratingService")
    List<Rating> getRatingByUserId(@RequestParam Long userId);

    default List<Rating> getRatingByUserIdCBFallback(Long userId, Exception e) {
        return List.of(
            Rating.builder().ratingId("0").userId(userId).hotelId(0L).rating(0).feedback("no feedback fb").build(),
            Rating.builder().ratingId("0").userId(userId).hotelId(0L).rating(0).feedback("no feedback").build(),
            Rating.builder().ratingId("0").userId(userId).hotelId(0L).rating(0).feedback("no feedback").build()
            );
    }

    default List<Rating> getRatingByUserIdRetryFallback(Long userId, Exception e) {
        return List.of(
            Rating.builder().ratingId("0").userId(userId).hotelId(0L).rating(0).feedback("no feedback retry").build(),
            Rating.builder().ratingId("0").userId(userId).hotelId(0L).rating(0).feedback("no feedback").build(),
            Rating.builder().ratingId("0").userId(userId).hotelId(0L).rating(0).feedback("no feedback").build()
            );
    }
}
