package tkvnmsz.tudastar.category;

import java.util.List;
import java.util.Map;

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
		Map<Integer, Category> listCategories = categoryService.listCategories();
		categoryService.fillUpNumberOfArticles(listCategories);
		model.addAttribute("categories", listCategories);
		
		return Pages.CATEGORIES;
	}
	
	@GetMapping("/category/{id}")
	public String test(@PathVariable int id, Model model) {
		Category category = categoryService.GetCategoryById(id);
		model.addAttribute("category", category);
		
		List<Article> articlesInCategory = articleService.listPublishedArticlesInCategory(id);
		model.addAttribute("articles", articlesInCategory);
		
		Map<Integer, Category> listSubCategories = categoryService.listSubCategories(id);
		categoryService.fillUpNumberOfArticles(listSubCategories);
		model.addAttribute("subcategories", listSubCategories);
		
		return Pages.CATEGORIES_LISTED;
	}
}
