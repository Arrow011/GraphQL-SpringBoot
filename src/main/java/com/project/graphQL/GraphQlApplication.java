package com.project.graphQL;

import com.project.graphQL.entity.Book;
import com.project.graphQL.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQlApplication implements CommandLineRunner {

	@Autowired
	BookService bookService;
	public static void main(String[] args) {
		SpringApplication.run(GraphQlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1 = Book.builder()
				.title("Rich Dad Poor Dad")
				.pages(500)
				.author("Robert Kiyosaki")
				.desc("Makes one know about the dynamics of getting rich!!")
				.price(300)
				.build();
		Book b2 = Book.builder()
				.title("The Autobiography of a Yogi")
				.pages(700)
				.author("Paramhansa Yogananada")
				.desc("About self realization...")
				.price(1000)
				.build();
		bookService.create(b1);
		bookService.create(b2);
	}
}
