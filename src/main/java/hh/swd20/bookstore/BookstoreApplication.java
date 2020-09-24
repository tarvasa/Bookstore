package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.BookRepository;
import hh.swd20.bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			Book book1 = new Book("Johanna Sinisalo", "Not Before Sundown", 2000, "1232323-21", 25.90);
			Book book2 = new Book("Andrzej Sapkowski", "Lady Of the Lake", 2017, "22122343-5", 30.00 );
			bookRepository.save(book1);
			bookRepository.save(book2);
		};
	}
	
}
