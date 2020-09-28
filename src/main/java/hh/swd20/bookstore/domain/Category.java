package hh.swd20.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category" )//Category OneToMany Book
	private List<Book> books;
	
	public Category() {
		this.categoryid = 0;
		this.name = null;
	}

	public Category(long categoryid, String name) {
		this.categoryid = categoryid;
		this.name = name;
	}

	public Category(String name) {
		this.name = name;
	}

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		//No list attribute to the toString-method, otherwise it will cause an infinite loop
		return "Category [id=" + categoryid + ", name=" + name + "]";
	}

	
}
