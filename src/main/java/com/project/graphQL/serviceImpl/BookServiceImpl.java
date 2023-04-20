package com.project.graphQL.serviceImpl;

import com.project.graphQL.entity.Book;
import com.project.graphQL.repository.BookRepository;
import com.project.graphQL.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(int bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new RuntimeException("No such Book present :("));
    }
}
