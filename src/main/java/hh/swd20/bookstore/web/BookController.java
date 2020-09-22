package hh.swd20.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hh.swd20.bookstore.domain.Book;

@Controller
public class BookController {

	@GetMapping("/booklist")
	public String getBooks() {
		return "booklist";
	}
}
