package hh.swd20.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository,
			UserRepository userrepository) {
		return (args) -> {

			Category category1 = new Category("Horror");
			Category category2 = new Category("Scifi");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			bookRepository.save(new Book("Test1", "Test1", 1990, 91939, 50.0, category1));
			bookRepository.save(new Book("Test2", "Test2", 1980, 23219, 45.0, category2));

			// Create users: admin/admin user/user
			User user1 = new User("vieras", "$2a$10$OyQcwGCi50UXxxWJFGQQxeV8zA12z8f2W.2pHCfZbgx0tGKscEsdC", "USER");
			User user2 = new User("max", "$2a$10$ITs0T5Q7bzzESYcaIFBaBeZRtVl1KDhaXzT5BAdvDEqk5JBC30sVm", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
		};

	}
}
