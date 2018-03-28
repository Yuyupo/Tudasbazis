package tkvnmsz.tudastar.article;

import java.util.List;

public interface ReviewService {
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
	 * @return id's of not reviewed articles
	 */
	List<Integer> notReviewedArticles();
	
	/**
	 * Get the articles, that can not be reviewed, because there is no proper lector
	 * @return list of id's of not revieable articles
	 */
	List<Integer> notReviewableArticles();
	
	/**
	 * list lectors that could review article
	 * @param articleId
	 * @return list of id's of lectors
	 */
	List<Integer> offerLectors(int articleId);
}
