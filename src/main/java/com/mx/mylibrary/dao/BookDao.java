package com.mx.mylibrary.dao;

import com.mx.mylibrary.entity.Book;

import java.util.List;

public interface BookDao {

    List<Book> listAll();
    Book save(Book book);
    Book update(Book book);
    boolean delete(int id);
}
