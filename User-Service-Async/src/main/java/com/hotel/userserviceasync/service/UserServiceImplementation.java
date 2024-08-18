package com.hotel.userserviceasync.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.hotel.userserviceasync.entities.Hotel;
import com.hotel.userserviceasync.entities.Rating;
import com.hotel.userserviceasync.entities.User;
import com.hotel.userserviceasync.error.ResourceNotFoundException;
import com.hotel.userserviceasync.error.SomethingWentWrongException;
import com.hotel.userserviceasync.external.services.HotelService;
import com.hotel.userserviceasync.external.services.RatingService;
import com.hotel.userserviceasync.repositories.UserRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserServiceImplementation implements UserServiceAsync {

  private final UserRepository userRepository;
  private final HotelService hotelService;
  private final RatingService ratingService;
  private static final Logger logger = LoggerFactory.getLogger(UserServiceImplementation.class);

  @Override
  public User createUser(User user) {
    try {
      return userRepository.save(user);
    } catch (RuntimeException e) {
      throw new SomethingWentWrongException("Something went wrong, could not create");
    }
  }

  // @Override
  // @Async("taskExecutor")
  // public CompletableFuture<User> getUser(Long userId) {
  // System.out.println(Thread.currentThread().getName() + "in service");
  // return CompletableFuture.supplyAsync(() -> {
  // System.out.println(Thread.currentThread().getName()+ "insidwe new spawned");
  // try {
  // User user = userRepository.findById(userId)
  // .orElseThrow(() -> new ResourceNotFoundException("No such User found"));
  // List<Rating> ratings = ratingService.getRatingByUserId(user.getUserId());
  // ratings = ratings.stream().map(rating -> {
  // Hotel hotel = hotelService.getHotel(rating.getHotelId());
  // rating.setHotel(hotel);
  // return rating;
  // }).collect(Collectors.toList());
  // user.setRatings(ratings);
  // return user;
  // } catch (ResourceNotFoundException e) {
  // throw e;
  // } catch (RuntimeException e) {
  // throw new SomethingWentWrongException("Something went wrong, could not
  // fetch");
  // }
  // });
  // }

  @Override
  @Async("taskExecutor")
  public CompletableFuture<User> getUser(Long userId) {
    logger.info("{} in service", Thread.currentThread().getName());
    try {
      User user = userRepository.findById(userId)
          .orElseThrow(() -> new ResourceNotFoundException("No such User found"));
      List<Rating> ratings = ratingService.getRatingByUserId(user.getUserId());
      ratings = ratings.stream().map(rating -> {
        Hotel hotel = hotelService.getHotel(rating.getHotelId());
        rating.setHotel(hotel);
        return rating;
      }).collect(Collectors.toList());
      user.setRatings(ratings);
      return CompletableFuture.completedFuture(user);
    } catch (ResourceNotFoundException e) {
      throw e;
    } catch (RuntimeException e) {
      throw new SomethingWentWrongException("Something went wrong, could not fetch");
    }
  }

  @Override
  public List<User> getAllUsers() {
    try {
      return userRepository.findAll().stream().map(user -> {
        List<Rating> ratings = ratingService.getRatingByUserId(user.getUserId());
        ratings = ratings.stream().map(rating -> {
          Hotel hotel = hotelService.getHotel(rating.getHotelId());
          rating.setHotel(hotel);
          return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratings);
        return user;
      }).collect(Collectors.toList());
    } catch (RuntimeException e) {
      throw new ResourceNotFoundException("Something went wrong, could not fetch");
    }
  }

  @Override
  public User updateUser(User user) {
    User existingUser = userRepository.findById(user.getUserId())
        .orElseThrow(() -> new ResourceNotFoundException("No such User found"));
    try {
      BeanUtils.copyProperties(user, existingUser);
      return userRepository.save(existingUser);
    } catch (RuntimeException e) {
      throw new SomethingWentWrongException("Something went wrong, could not update");
    }
  }

  @Override
  public String deleteUser(Long userId) {
    try {
      userRepository.deleteById(userId);
      return "Deletion successful";
    } catch (RuntimeException e) {
      throw new SomethingWentWrongException("Something went wrong, could not delete");
    }
  }

}
