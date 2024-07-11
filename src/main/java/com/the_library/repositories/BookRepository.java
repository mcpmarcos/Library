package com.the_library.repositories;



import org.springframework.data.jpa.repository.JpaRepository;


import com.the_library.models.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
    
    //Book findById(Integer id); 
    
}
