package hh.swd20.bookstore;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;
//import hh.swd20.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired
	private BookRepository repository;
	
	@Test //testataan 'search' kirjoittajan mukaan
	public void findByAuthorShouldReturnBook() {
		List<Book> books = repository.findByAuthor("Johanna Sinisalo");
		log.error(books.toString());
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Not Before Sundown");
	}
	
	@Test //testataan delete
	public void deleteBook() {
		List<Book> books = (List<Book>) repository.findAll();
		Long id = new Long(4);
		repository.deleteById(id);
		assertThat(repository.findById(id)).isNotIn(books);
	}
	
	@Test //testataan create book
	public void createNewBook() {//category null mutta StudentRepositoryTest kuitenkin importattu Department??
		Book book = new Book("Author", "Book", 1880, "234522343-10", 50.00 , null);
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}

}
