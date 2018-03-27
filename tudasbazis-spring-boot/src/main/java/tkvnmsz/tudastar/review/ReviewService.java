package tkvnmsz.tudastar.review;

import java.util.List;

public interface ReviewService {
	/**
	 * Get the articles, that are not reviewed yet
	 * @return
	 */
	List<Integer> notReviewedArticles();
	
	/**
	 * Get the articles, that can not be reviewed, because there is no proper lector
	 */
	List<Integer> notReviewableArticles();
	
	/**
	 * list lectors that could review article
	 * @param articleId
	 * @return
	 */
	List<Integer> offerLectors(int articleId);
}
