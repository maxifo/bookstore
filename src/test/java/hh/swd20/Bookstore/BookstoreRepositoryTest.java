package hh.swd20.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

//@RunWith(SpringRunner.class)  //JUnit4
@ExtendWith(SpringExtension.class) // JUnit5 eli Jupiter
@DataJpaTest
public class BookstoreRepositoryTest {

	@Autowired
	private BookRepository repository;

	@Test
	public void findByTitle() {
		List<Book> books = repository.findByTitle("Test1");

		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Test1");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("Test1", "Test1", 1980, 23219, 45.0, null);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}