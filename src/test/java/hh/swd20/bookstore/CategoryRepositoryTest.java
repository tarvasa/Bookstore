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

import hh.swd20.bookstore.domain.CategoryRepository;
import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	@Autowired
	private CategoryRepository repository;
	
	@Test //testataan 'search' kategorian mukaan
	public void findByAuthorShouldReturnBook() {
		List<Category> categories = repository.findByName("scifi");
		log.error(categories.toString());
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCategoryid()).isEqualTo(1);
	}
	@Test //testataan delete
	public void deleteCategory() {
		List<Category> categories = (List<Category>) repository.findAll();
		Long id = new Long(1);
		repository.deleteById(id);
		assertThat(repository.findById(id)).isNotIn(categories);
	}
	
	@Test //testataan create category
	public void createNewCategory() {
		Category category = new Category("horror");
		assertThat(category.getCategoryid()).isNotNull();
	}
}