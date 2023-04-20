package com.project.graphQL.controller;

import com.project.graphQL.entity.Book;
import com.project.graphQL.model.BookInput;
import com.project.graphQL.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @QueryMapping("getBook")
    public Book getBookById(@Argument int bookId){
        return bookService.getBook(bookId);
    }

    @QueryMapping("allBooks")
    public List<Book> getBooks(){
        return bookService.getBooks();
    }


    @MutationMapping("addBook")
    public Book create(@Argument BookInput book){
        Book book1 = Book.builder().title(book.getTitle())
                .price(book.getPrice())
                .desc(book.getDesc())
                .pages(book.getPages())
                .author(book.getAuthor()).build();
        return bookService.create(book1);
    }
}
