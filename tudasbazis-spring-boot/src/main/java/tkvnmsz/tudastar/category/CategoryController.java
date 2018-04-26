package tkvnmsz.tudastar.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tkvnmsz.tudastar.Pages;
import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.article.ArticleService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ArticleService articleService;
	
	@GetMapping("/categories")
	public String showCategories(Model model) {
		List<Category> categories = categoryService.listCategories();
		categoryService.fillUpNumberOfArticles(categories);
		model.addAttribute("categories", categories);
		
		return Pages.CATEGORIES;
	}
	
	@GetMapping("/category/{id}")
	public String test(@PathVariable int id, Model model) {
		Category category = categoryService.GetCategoryById(id);
		model.addAttribute("category", category);
		
		List<Article> articlesInCategory = articleService.articlesInCategory(id);
		model.addAttribute("articles", articlesInCategory);
		
		List<Category> subCategories = categoryService.listSubCategories(id);
		model.addAttribute("subcategories", subCategories);
		
		return Pages.CATEGORIES_LISTED;
	}
}
