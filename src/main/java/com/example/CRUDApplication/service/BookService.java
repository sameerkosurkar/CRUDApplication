package com.example.CRUDApplication.service;

import com.example.CRUDApplication.model.Book;
import com.example.CRUDApplication.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;
    public ResponseEntity<List<Book>> getAllBooks(){
        try{
            List<Book> bookList = bookRepo.findAll();
            if (bookList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Book>> getAllBooksByAuthor(String author) {
        try{
            List<Book> bookList = bookRepo.findAllByAuthor(author);
            if (bookList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Book> getBookById(Long id){
        Optional<Book> bookData = bookRepo.findById(id);
        if (bookData.isPresent()){
            return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<Book> addBook(Book book){
        Book bookObj = bookRepo.save(book);
        return new ResponseEntity<>(bookObj, HttpStatus.OK);
    }
    public ResponseEntity<Book> updateBookById(Long id, Book newBookData){
        Optional<Book> oldBookData = bookRepo.findById(id);
        if (oldBookData.isPresent()){
            Book updatedBookData = oldBookData.get();
            updatedBookData.setTitle(newBookData.getTitle());
            updatedBookData.setAuthor(newBookData.getAuthor());

            Book bookObj = bookRepo.save(updatedBookData);
            return new ResponseEntity<>(bookObj, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<HttpStatus> deleteBookById(Long id){
        Optional<Book> oldBookData = bookRepo.findById(id);
        if (oldBookData.isPresent()) {
            bookRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
