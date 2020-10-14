package hh.swd20.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("save couple book");
			Category category1 = new Category("scifi");
			Category category2 = new Category("fantasy");
			Category category3 = new Category("fiction");
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			
			Book book1 = new Book("Johanna Sinisalo", "Not Before Sundown", 2000, "1232323-21", 25.90, category2);
			Book book2 = new Book("Andrzej Sapkowski", "Lady Of the Lake", 2017, "22122343-5", 30.00 , category2);
			bookRepository.save(book1);
			bookRepository.save(book2);
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
			
			log.info("Fetch all categories");
			for (Category category : categoryRepository.findAll()) {

				log.info(category.toString());
			}
		};
		
	}
}
