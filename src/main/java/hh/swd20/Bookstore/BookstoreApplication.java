package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category category1 = new Category("Horror");
			Category category2 = new Category("Scifi");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			bookRepository.save(new Book("The Holy Bible", "Jesus", 1990, 91939, 50.0, category1));
			bookRepository.save(new Book("Atlas of the world", "Mike Hunt", 1980, 23219, 45.0, category2));
		};

	}
}
