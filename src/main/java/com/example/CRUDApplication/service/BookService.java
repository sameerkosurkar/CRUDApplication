package com.example.CRUDApplication.service;

import com.example.CRUDApplication.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public ResponseEntity<List<Book>> getAllBooks();

    public ResponseEntity<List<Book>> getAllBooksByAuthor(String author);
    public ResponseEntity<Book> getBookById(Long id);
    public ResponseEntity<Book> addBook(Book book);
    public ResponseEntity<Book> updateBookById(Long id, Book newBookData);
    public ResponseEntity<HttpStatus> deleteBookById(Long id);
}
