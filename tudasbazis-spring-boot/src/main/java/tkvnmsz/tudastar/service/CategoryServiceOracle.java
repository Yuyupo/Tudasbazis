package tkvnmsz.tudastar.service;

import java.util.List;

import tkvnmsz.tudastar.category.Category;
import tkvnmsz.tudastar.category.CategoryService;

public class CategoryServiceOracle implements CategoryService{

	@Override
	public Category GetCategoryById(int id) {
		//SELECT * FROM W_ARTICLE_CATEGORY WHERE id = 1;
		return null;
	}

	@Override
	public List<Category> listCategories() {
		//SELECT * FROM W_ARTICLE_CATEGORY
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fillUpNumberOfArticles(List<Category> categories) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> listSubCategories(int categoryId) {
		//SELECT * FROM W_ARTICLE_CATEGORY WHERE PARENTCATEGORY_ID = 1
		return null;
	}



}
