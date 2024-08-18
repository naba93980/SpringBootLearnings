package com.hotel.userserviceasync.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.userserviceasync.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
