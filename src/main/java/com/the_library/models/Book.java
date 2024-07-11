package com.the_library.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class Book {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String tittle;
    
    private String author;

    public Book(Integer id, String tittle, String author) {
        this.id = id;
        this.tittle = tittle;
        this.author = author;
    }

    public Book() {
    }

    

}
