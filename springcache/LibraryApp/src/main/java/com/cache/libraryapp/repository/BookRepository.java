package com.cache.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.cache.libraryapp.entities.Book;

@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book, String> {
    
    @Transactional
    @Modifying
    @Query("update Book set name = :name where id = :id")
    int updateBook(String id, String name);

    // @Query("update Book set name = :name where id = :id")
    // int updateBook(@Param("id") String id, @Param("name") String name);
}
