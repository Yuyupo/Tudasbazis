package tkvnmsz.tudastar.category;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tkvnmsz.tudastar.Pages;

@Controller
public class CategoryController {
	
	@GetMapping("/categories")
	public String showCategories() {
		
		return Pages.CATEGORIES;
	}
	
	@GetMapping("/category/{id}")
	public String test(@PathVariable int id, Model model) {
		
		return Pages.CATEGORIES_LISTED;
	}
}
