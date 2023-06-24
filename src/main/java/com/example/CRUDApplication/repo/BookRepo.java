package com.example.CRUDApplication.repo;

import com.example.CRUDApplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepo extends JpaRepository<Book, Long>, BookRepoCustom{
//    List<Book> findAllByAuthor(String author);

//    @Query(value = "select * from Books where author = ?1", nativeQuery = true)
    List <Book> findAllByAuthor(String author);

}
