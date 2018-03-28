package tkvnmsz.tudastar.article;

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
}
