package com.chiomalibarymanagementfe.chiomalibarymanagementfe.client;

import com.chiomalibarymanagementfe.chiomalibarymanagementfe.entity.Book;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

public class BookServiceClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "http://localhost:8080/api/book";

    public List<Book> getAllBooks() {
        Book[] books = restTemplate.getForObject(BASE_URL, Book[].class);
        return Arrays.asList(books);
    }

    public Book createBook(Book book) {
        return restTemplate.postForObject(BASE_URL, book, Book.class);
    }

    public void updateBook(int id, Book book) {
        restTemplate.put(BASE_URL + "/" + id, book);
    }

    public void deleteBook(int id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}

