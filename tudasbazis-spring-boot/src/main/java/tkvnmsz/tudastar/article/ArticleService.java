package tkvnmsz.tudastar.article;

public interface ArticleService {
	/**
	 * Post new article
	 * @param article
	 * @return
	 */
	int post(ArticlePostData articlePostData);
	
	/**
	 * Accept article to publish
	 * @param articleId
	 */
	void accept(int articleId);
	
	/**
	 * Get a specific article
	 * @param articleId
	 * @return
	 */
	Article getById(int articleId);
	
	/**
	 * Get the most times modified article
	 * @return
	 */
	int mostTimesModifiedArticle();
	
	/**
	 * get the most times corrected article
	 * @return
	 */
	int mostTimesCorrectedArticle();
}
