package com.mx.mylibrary.service;

import com.mx.mylibrary.dao.BookDao;
import com.mx.mylibrary.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
@Service("bookService")
public class BookService {

    @Autowired
    @Qualifier("bookDao")
    private BookDao bookDao;

    public List<Book> listAll() {
        return bookDao.listAll();
    }

    @Transactional
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Transactional
    public Book update(Book book) {
        return bookDao.update(book);
    }

    @Transactional
    public boolean delete(int id) {
        return bookDao.delete(id);
    }
}
