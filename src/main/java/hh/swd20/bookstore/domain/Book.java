package hh.swd20.bookstore.domain;

public class Book {
	
	private String title;
	private String author;
	private int year;
	private int isbn;
	private int price;
	
	
	public Book() {
		this.title = null;
		this.author = null;
		this.year = 0;
		this.isbn = 0;
		this.price = 0;
	}
	
	public Book(String title, String author, int year, int isbn, int price) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book information: title: " + title + ", author: " + author + ", publishing year: " + year + ", isbn: " + isbn + ", price: " + price + " €.";
	}
	

}
