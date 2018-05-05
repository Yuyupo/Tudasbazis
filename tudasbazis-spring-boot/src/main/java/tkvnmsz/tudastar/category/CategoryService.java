package tkvnmsz.tudastar.category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
	
	/**
	 * Get Category by id
	 * @param id
	 * @return category
	 */
	Category GetCategoryById(int id);
	
	
	
	/**
	 * List available categories
	 * @return list of categories
	 */
	Map<Integer, Category> listCategories();
	
	/**
	 * Fill up the number of articles in categories
	 * @param listCategories
	 */
	void fillUpNumberOfArticles(Map<Integer, Category> listCategories);
	
	/**
	 * List direct subcategories of the category related to the given categoryId
	 * @param categoryId
	 * @return
	 */
	Map<Integer, Category> listSubCategories(int categoryId);
}
