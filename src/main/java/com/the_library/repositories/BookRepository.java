package com.the_library.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.the_library.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    
    Optional<Book> findById(Integer id);
    
}
