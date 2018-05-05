package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.article.ArticleService;
import tkvnmsz.tudastar.category.Category;
import tkvnmsz.tudastar.category.CategoryService;
import tkvnmsz.tudastar.language.Language;
import tkvnmsz.tudastar.service.database.ListDataFetcher;
import tkvnmsz.tudastar.service.database.OracleDatabase;
import tkvnmsz.tudastar.service.database.Parser;
import tkvnmsz.tudastar.service.database.SimpleDataFetcher;

@Service
public class CategoryServiceDummy implements CategoryService {
	@Autowired
	ArticleService articleService;

	
	@Override
	public Map<Integer,Category> listCategories() {
		ListDataFetcher<Category> categoryFetcher = new ListDataFetcher<>(Parser::Category);
		OracleDatabase.request("SELECT * FROM W_ARTICLE_CATEGORY WHERE ID <> -1",categoryFetcher);
		return categoryFetcher.getData().stream().collect(Collectors.toMap(Category::getId, u-> u));
	}

	@Override
	public Map<Integer,Category> listSubCategories(int categoryId) {

		ListDataFetcher<Category> categoryFetcher = new ListDataFetcher<>(Parser::Category);
		OracleDatabase.request("SELECT * FROM W_ARTICLE_CATEGORY WHERE PARENTCATEGORY_ID = ?", stmt -> stmt.setInt(1, categoryId),categoryFetcher);
		
		categoryFetcher.getData().forEach(System.out::println);
		
		return categoryFetcher.getData().stream().collect(Collectors.toMap(Category::getId, u-> u));
	}


	@Override
	public void fillUpNumberOfArticles(Map<Integer,Category> categories) {
		
		
		for (Map.Entry<Integer, Category> category : categories.entrySet()) {
			SimpleDataFetcher<Integer> categoryFetcher = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
			System.out.println("Category id: " + category.getKey());
			OracleDatabase.request("SELECT COUNT(*) FROM W_DISCUSSED_CATEGORY WHERE CATEGORY_ID = ?", stmt -> stmt.setInt(1, category.getKey()),categoryFetcher);
			category.getValue().setNumberOfArticles(categoryFetcher.getData());
			System.out.println("Category count: " + categoryFetcher.getData());
		}
	}

	@Override
	public Category GetCategoryById(int id) {
		
		SimpleDataFetcher<Category> categoryFetcher = new SimpleDataFetcher<>(Parser::Category);
		OracleDatabase.request("SELECT * FROM W_ARTICLE_CATEGORY WHERE id = ?", stmt -> stmt.setInt(1, id),categoryFetcher);
		Category data = categoryFetcher.getData();
		
		return data;
		
	}
}
