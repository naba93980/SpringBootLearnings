package com.hotel.userserviceasync.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.hotel.userserviceasync.entities.User;

public interface UserServiceAsync {
    
    User createUser(User user);

    CompletableFuture<User> getUser(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    String deleteUser(Long userId);
     
}
