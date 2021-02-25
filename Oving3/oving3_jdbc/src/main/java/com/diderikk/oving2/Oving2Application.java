package com.diderikk.oving2;

import com.diderikk.oving2.model.Address;
import com.diderikk.oving2.model.Author;
import com.diderikk.oving2.model.Book;
import com.diderikk.oving2.repository.AddressRepository;
import com.diderikk.oving2.repository.AuthorRepository;
import com.diderikk.oving2.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Oving2Application {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Oving2Application.class, args);
	}

	@Bean
	CommandLineRunner setUpDB() {
		return args -> {
			Author author = new Author("Diderik Kramer","diderikk@stud.ntnu.no");
			Book book = new Book("Title2", 456);
			Address address = new Address("Vegamot", 1);

			authorRepository.save(author);
			addressRepository.save(address);
			bookRepository.save(book);

			// authorRepository.update(1, author);
			// bookRepository.update(1, book);
			// addressRepository.update(1, address);

			// authorRepository.deleteById(2);
			// addressRepository.deleteById(2);
			// bookRepository.deleteById(2);

			// Author author1 = authorRepository.findAll().get(0);
			// System.out.println(author1);
			// System.out.println();
			// System.out.println(bookRepository.findAll().get(0));
			// System.out.println();
			// System.out.println(addressRepository.findAll().get(0));
		};

	}

	// @Bean
	// CommandLineRunner createDB() {
	// 	return args -> {
	// 		// System.out.println("Creating Table...");
	// 		// jdbcTemplate.execute("CREATE TABLE author(author_id INT NOT NULL AUTO_INCREMENT," +
	// 		// "author_name VARCHAR(35), author_email VARCHAR(40), CONSTRAINT pk PRIMARY KEY(author_id))");
	// 		// jdbcTemplate.execute("CREATE TABLE book(book_id INT NOT NULL AUTO_INCREMENT," +
	// 		// "book_title VARCHAR(35), book_pageamount INT NOT NULL, CONSTRAINT pk PRIMARY KEY(book_id))");
	// 		// jdbcTemplate.execute("CREATE TABLE address(address_id INT NOT NULL AUTO_INCREMENT," +
	// 		// "address_gatename VARCHAR(35), address_gatenumber INT NOT NULL,"+
	// 		// "CONSTRAINT pk PRIMARY KEY(address_id))");
	// 	};

	// }

}
