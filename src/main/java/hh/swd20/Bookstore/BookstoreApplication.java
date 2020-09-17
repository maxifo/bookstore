package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			// Your code...add some demo data to db
			Book book1 = new Book("Java for beginners", "Mikki Hiiri", 2005, 23231, 12.50);
			Book book2 = new Book("Advanced python programming", "Patrick Python", 2010, 23414, 15);
			bookRepository.save(book1); // tallennetaan tietokantaan 1. auto
			bookRepository.save(book2); // tallennetaan tietokantaan 2. auto

		};

	}
}
