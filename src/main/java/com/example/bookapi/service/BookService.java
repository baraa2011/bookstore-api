package com.example.bookapi.service;

import com.example.bookapi.model.Book;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @PostConstruct
    public void init() {
        // Initialize with some sample data
        books.add(new Book(counter.incrementAndGet(), "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(counter.incrementAndGet(), "To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book(counter.incrementAndGet(), "1984", "George Orwell"));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
