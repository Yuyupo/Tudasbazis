package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.category.Category;
import tkvnmsz.tudastar.category.CategoryService;

@Service
public class CategoryServiceDummy implements CategoryService {
	private List<Category> categories = new ArrayList<>();
	{
		categories.add(new Category(0, "Űr", -1));
		categories.add(new Category(1, "Galaxis", 0));
		categories.add(new Category(2, "Csillagrendszer", 1));
		categories.add(new Category(3, "Naprendszer", 2));
		categories.add(new Category(4, "Föld", 3));
		categories.add(new Category(5, "Mars", 3));

		categories.add(new Category(6, "Feketelyuk", 1));
		categories.add(new Category(7, "Eseményhorizont", 6));
	}
	
	@Override
	public List<Category> listCategories() {
		return categories;
	}

	@Override
	public List<Category> listSubCategories(int categoryId) {
		return categories.stream().filter(category -> category.getParentId() == categoryId).collect(Collectors.toList());
	}

	@Override
	public List<Integer> articlesInCategories(int categoryId) {
		return null;
	}

}
