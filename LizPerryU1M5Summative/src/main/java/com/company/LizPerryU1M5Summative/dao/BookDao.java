package com.company.LizPerryU1M5Summative.dao;

import com.company.LizPerryU1M5Summative.model.Book;

import java.util.List;

public interface BookDao {

    Book addBook(Book book);

    Book getBook(int id);

    List<Book> getAllBooks();

    List<Book> getAllBooksByAuthor(int authorId);

    void updateBook(Book book);

    void deleteBook(int id);

}
