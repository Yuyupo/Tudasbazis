package tkvnmsz.tudastar.service;

import java.util.List;

import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.article.ArticlePostData;
import tkvnmsz.tudastar.article.ArticleService;
import tkvnmsz.tudastar.login.User;

public class ArticleServiceOracle implements ArticleService{

	@Override
	public int post(ArticlePostData articlePostData) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Article getById(int articleId) {
		// SELECT * FROM W_ARTICLE WHERE ID = 1
		return null;
	}

	@Override
	public int mostTimesModifiedArticle() {
		//SELECT ID FROM W_ARTICLE WHERE MODIFCATIONCOUNTER = (SELECT MAX(MODIFCATIONCOUNTER) FROM W_ARTICLE)
		return 0;
	}

	@Override
	public int mostTimesCorrectedArticle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int numberOfPublishedArticlesInCategory(int categoryId) {
		// SELECT COUNT(*) FROM W_DISCUSSED_CATEGORY WHERE CATEGORY_ID = 1
		return 0;
	}

	@Override
	public List<Article> listPublishedArticlesInCategory(int categoryId) {
		// SELECT ARTICLE_ID FROM W_DISCUSSED_CATEGORY WHERE CATEGORY_ID = 1
		//getById...
		return null;
	}

	@Override
	public List<Integer> articlesOrderedByTheNumberOfLanguages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int translatedToTheMostLanguages() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Article> listPublishedArticlesIdTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> listAllArticlesIdTitle() {
		//SELECT ID, TITLE FROM W_ARTICLE
		return null;
	}

	@Override
	public List<Article> listTranslationsOf(int articleId) {
		//SELECT * FROM W_ARTICLE WHERE TOPIC_ID = (SELECT TOPIC_ID FROM W_ARTICLE WHERE ID = 1)
		return null;
	}

	@Override
	public void accept(int articleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decline(int articleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Article> assignedArticlesToReview(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> notAssignedArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> notReviewableArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> offerLectors(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignArticle(int articleId, int lectorId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listLazyUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> listArticlesByKeywords(int keywordId) {
		// TODO Auto-generated method stub
		return null;
	}

}
