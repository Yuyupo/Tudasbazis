package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.article.ArticleService;
import tkvnmsz.tudastar.category.Category;
import tkvnmsz.tudastar.category.CategoryService;

@Service
public class CategoryServiceDummy implements CategoryService {
	@Autowired
	ArticleService articleService;

	private List<Category> categories = new ArrayList<>();
	{
		Category ur, galaxis, csillagrendszer, naprendszer, fold, mars, feketelyuk, esemenyhorizont;
		categories.add(ur = new Category(categories.size(), "Űr", -1));
		categories.add(galaxis = new Category(categories.size(), "Galaxis", ur.getId()));
		categories.add(csillagrendszer = new Category(categories.size(), "Csillagrendszer", galaxis.getId()));
		categories.add(naprendszer = new Category(categories.size(), "Naprendszer", csillagrendszer.getId()));
		categories.add(fold = new Category(categories.size(), "Föld", naprendszer.getId()));
		categories.add(mars = new Category(categories.size(), "Mars", naprendszer.getId()));

		categories.add(feketelyuk = new Category(6, "Feketelyuk", galaxis.getId()));
		categories.add(esemenyhorizont = new Category(7, "Eseményhorizont", feketelyuk.getId()));
	}

	@Override
	public List<Category> listCategories() {
		return categories;
	}

	@Override
	public List<Category> listSubCategories(int categoryId) {
		return categories.stream().filter(category -> category.getParentId() == categoryId)
				.collect(Collectors.toList());
	}

	@Override
	public List<Integer> articlesInCategories(int categoryId) {
		return null;
	}

	@Override
	public void fillUpNumberOfArticles(List<Category> categories) {
		for (Category category : categories) {
			category.setNumberOfArticles(articleService.numberOfPublishedArticlesInCategory(category.getId()));
		}
	}

	@Override
	public Category GetCategoryById(int id) {
		Category foundCategory = categories.stream().filter(category -> category.getId() == id).findFirst().orElse(null);
		return foundCategory;
	}
}
