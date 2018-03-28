package tkvnmsz.tudastar.category;

import java.util.List;

public interface CategoryService {
	/**
	 * List available categories
	 * @return list of categories
	 */
	List<Category> listCategories();
	
	/**
	 * List direct subcategories of the category related to the given categoryId
	 * @param categoryId
	 * @return
	 */
	List<Category> listSubCategories(int categoryId);
	
	/**
	 * list articles in a specific category
	 * @param categoryId
	 * @return list of articles
	 */
	List<Integer> articlesInCategories(int categoryId);
}
