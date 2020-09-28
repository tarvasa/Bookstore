package hh.swd20.bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hh.swd20.bookstore.domain.Category;
import hh.swd20.bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("/categorylist") // categorylist-endpointin tekemä GET-pyyntö, palauttaa categorylist-nimisen näkymän(view)
	public String getCategories(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}
	
	@GetMapping("/create")
	public String createCategory(Model model) {
		model.addAttribute("category", new Category());
		return "newcategory";
	}
	
	@PostMapping("/savecategory")
	public String saveCategory(Category category) {
		crepository.save(category);
		return "redirect:categorylist";		
	}
	
}
