package tkvnmsz.tudastar.article;

import java.util.List;

import tkvnmsz.tudastar.login.User;

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
	int numberOfPublishedArticlesInCategory(int categoryId);
	
	/**
	 * List articles written in the category
	 * @param categoryId
	 * @return list of articles
	 */
	List<Article> listPublishedArticlesInCategory(int categoryId);
	

	/**
	 * mivel térjünk vissza? topiccal kéne, de az nem az igazi. Nem dölt még el...
	 * @return
	 */
	List<Integer> articlesOrderedByTheNumberOfLanguages();
	
	/**
	 * szintén nem tudom mit adjunk vissza... :/ nem lehet azt a cikket, ami a legtöbb nyelven van, mert akkor milyen nyelven adod vissza... hülyeség
	 * @return
	 */
	int translatedToTheMostLanguages();
	
	/**
	 * list only the id and title of articles
	 * @return list of articles (only id and title fed)
	 */
	List<Article> listPublishedArticlesIdTitle();
	
	/**
	 * list only the id and title of articles
	 * @return list of articles (only id and title fed)
	 */
	List<Article> listAllArticlesIdTitle();
	
	/**
	 * list articles that are the translations of the give article
	 * each language once
	 * @param artileId
	 * @return list of translations
	 */
	List<Article> listTranslationsOf(int articleId);
	
	/**
	 * Accept article to publish
	 * @param articleId
	 */
	void accept(int articleId);

	/**
	 * Decline article
	 * @param articleId
	 */
	void decline(int articleId);
	
	/**
	 * Get the articles, that are not reviewed yet
	 * @param userId TODO
	 * @return not reviewed articles
	 */
	List<Article> assignedArticlesToReview(int userId);
	
	/**
	 * Get the articles, that are not assigned to anyone yet
	 * @return not assigned articles
	 */
	List<Article> notAssignedArticles();
	
	/**
	 * Get the articles, that can not be reviewed, because there is no proper lector
	 * @return list of id's of not revieable articles
	 */
	List<Article> notReviewableArticles();
	
	/**
	 * list lectors that could review article
	 * @param articleId
	 * @return list of id's of lectors
	 */
	List<Integer> offerLectors(int articleId);
	
	/**
	 * Assign an article to a lector
	 * @param articleId
	 * @param lectorId
	 */
	void assignArticle(int articleId, int lectorId);
	
	/**
	 * List users that haven't posted any articles yet
	 * @return list of users
	 */
	List<User> listLazyUsers();
	
	/**
	 * List articles with given keyword
	 * @param keywordIds
	 * @return
	 */
	List<Article> listArticlesByKeywords(int keywordId);
}
