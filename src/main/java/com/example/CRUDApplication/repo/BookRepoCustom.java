package com.example.CRUDApplication.repo;

import com.example.CRUDApplication.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.List;

public interface BookRepoCustom {
//    List<Book> findAllByAuthor(String author);
//
    EntityManager em = null;

    default List<Book> findAllByAuthor(String authorName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);

        Root<Book> book = cq.from(Book.class);
        Predicate authorNamePredicate = cb.equal(book.get("author"), authorName);
        cq.where(authorNamePredicate);

        TypedQuery<Book> query = em.createQuery(cq);
        return query.getResultList();
    }
}
