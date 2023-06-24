package com.example.CRUDApplication.controller;

import com.example.CRUDApplication.model.Book;
import com.example.CRUDApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@ResponseBody
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/getAllBooksByAuthor")
    public ResponseEntity<List<Book>> getAllBooksByAuthor(@RequestBody Book book) {
        return bookService.getAllBooksByAuthor(book.getAuthor());
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PostMapping("/updateBookById/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book newBookData){
        return bookService.updateBookById(id, newBookData);
    }

    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<HttpStatus> deleteBookById(@PathVariable Long id){
        return bookService.deleteBookById(id);
    }
}
