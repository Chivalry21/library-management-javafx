package com.chiomalibarymanagementfe.chiomalibarymanagementfe.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
public class Book {


    private int id;

    private String title;
    private String author;
    private LocalDate publishedDate;
    private String isbn;

//    // --- Getters ---
//
//    public int getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public String getPublishedDate() {
//        return publishedDate;
//    }
//
//    public String getIsbn() {
//        return isbn;
//    }
//
//    // --- Setters ---
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public void setPublishedDate(String publishedDate) {
//        this.publishedDate = publishedDate;
//    }
//
//    public void setIsbn(String isbn) {
//        this.isbn = isbn;
//    }
}
