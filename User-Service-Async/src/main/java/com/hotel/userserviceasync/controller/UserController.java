package com.hotel.userserviceasync.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.userserviceasync.entities.User;
import com.hotel.userserviceasync.service.UserServiceAsync;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/users")
@NoArgsConstructor
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private UserServiceAsync userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


    @GetMapping("/getUser")
    public CompletableFuture<ResponseEntity<User>> getUser(@RequestParam Long userId) {
        logger.info("{} in controller", Thread.currentThread().getName());
        return userService.getUser(userId)
                .thenApply(user -> {
                    logger.info("{} in controller response", Thread.currentThread().getName());
                    return ResponseEntity.status(HttpStatus.OK).body(user);
                });
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User users = userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam Long userId) {
        String users = userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
