package com.project.graphQL.service;

import com.project.graphQL.entity.Book;

import java.util.List;

public interface BookService {
    Book create(Book book);
    List<Book> getBooks();
    Book getBook(int bookId);
}
