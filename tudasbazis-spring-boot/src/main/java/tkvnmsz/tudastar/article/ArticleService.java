package tkvnmsz.tudastar.article;

import java.util.List;

public interface ArticleService {
	/**
	 * Post new article
	 * @param article
	 * @return the id of the newly created article
	 */
	int post(ArticlePostData articlePostData);
	
	/**
	 * Get a specific article
	 * @param articleId
	 * @return article
	 */
	Article getById(int articleId);
	
	/**
	 * Get the most times modified article
	 * @return id of returned article
	 */
	int mostTimesModifiedArticle();
	
	/**
	 * get the most times corrected article
	 * @return id of returned article
	 */
	int mostTimesCorrectedArticle();
	
	/**
	 * get the number of articles in a category
	 * @param categoryId
	 * @return number of articles in the category
	 */
	int numberOfArticlesInCategory(int categoryId);
	
	/**
	 * List articles written in the category
	 * @param categoryId
	 * @return list of articles
	 */
	List<Article> articlesInCategory(int categoryId);
}
