package com.mx.mylibrary.dao.impl;

import com.mx.mylibrary.dao.BookDao;
import com.mx.mylibrary.entity.Book;
import com.mx.mylibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

    @Autowired
    @Qualifier("bookRepository")
    private BookRepository bookRepository;

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean delete(int id) {
        return bookRepository.findById(new Integer(id)).map(item -> {
            item.setStatus(false);
            bookRepository.save(item);
            return true;
        }).orElse(false);
    }
}
