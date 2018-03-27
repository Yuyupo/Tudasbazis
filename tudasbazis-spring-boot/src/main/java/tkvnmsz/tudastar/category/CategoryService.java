package tkvnmsz.tudastar.category;

import java.util.List;

public interface CategoryService {
	/**
	 * List available categories
	 * @return
	 */
	List<Category> listCategories();
	
	/**
	 * list articles in a specific category
	 * @param categoryId
	 * @return
	 */
	List<Integer> articlesInCategories(int categoryId);
}
