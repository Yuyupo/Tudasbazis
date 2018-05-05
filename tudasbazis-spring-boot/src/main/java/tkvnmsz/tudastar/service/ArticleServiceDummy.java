package tkvnmsz.tudastar.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.article.ArticlePostData;
import tkvnmsz.tudastar.article.ArticleService;
import tkvnmsz.tudastar.article.ChangeKind;
import tkvnmsz.tudastar.category.Category;
import tkvnmsz.tudastar.category.CategoryService;
import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.login.UserService;
import tkvnmsz.tudastar.service.database.ListDataFetcher;
import tkvnmsz.tudastar.service.database.OracleDatabase;
import tkvnmsz.tudastar.service.database.Parser;
import tkvnmsz.tudastar.service.database.SimpleDataFetcher;
import tkvnmsz.tudastar.session.SessionData;

@Service
public class ArticleServiceDummy implements ArticleService {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	private SessionData sessionData;

	@Override
	public int post(ArticlePostData articlePostData) {

		if (articlePostData.getChangeKind() == ChangeKind.CORRECTION) {

			Article parentArticle = getById(articlePostData.getParentArticleId());
			int topicId = parentArticle.getTopicId();
			int languageId = articlePostData.getLanguageId();

			// SELECT WHERE topic id = ... alnguageid = ....
			OracleDatabase.execute(
					"UPDATE H675212.W_ARTICLE SET TITLE = ? , CONTENT = ?,  MODIFCATIONCOUNTER = MODIFCATIONCOUNTER+1 WHERE ID = ?",
					stmt -> {
						int index = 0;
						stmt.setString(++index, articlePostData.getTitle());
						stmt.setString(++index, articlePostData.getContent());
						stmt.setInt(++index, articlePostData.getOriginalArticle());
					});

			OracleDatabase.execute("DELETE FROM W_KEYWORD_MARK WHERE ARTICLE_ID = ?",
					stmt -> stmt.setInt(1, articlePostData.getOriginalArticle()));

			List<Integer> keywordIds = articlePostData.getKeywordIds();

			SimpleDataFetcher<Integer> idFetcher2 = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
			OracleDatabase.request("SELECT MAX(ID) FROM W_KEYWORD_MARK", idFetcher2);
			int keywordId = idFetcher2.getData();
			if (keywordIds != null) {
				for (Integer integer : keywordIds) {

					int masikKeywordId = ++keywordId;

					OracleDatabase.execute(
							"Insert into H675212.W_KEYWORD_MARK (ID, ARTICLE_ID, KEYWORD_ID) values (?,?,?)", stmt -> {
								int index = 0;
								stmt.setInt(++index, masikKeywordId);
								stmt.setInt(++index, articlePostData.getOriginalArticle());
								stmt.setInt(++index, integer);

							});

				}
			}
			return articlePostData.getOriginalArticle();
		} else {

			int topicId;

			if (articlePostData.getParentArticleId() == -1) {
				SimpleDataFetcher<Integer> idFetcher = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
				OracleDatabase.request("SELECT MAX(ID) FROM W_TOPIC", idFetcher);
				topicId = idFetcher.getData() + 1;

				OracleDatabase.execute("Insert into H675212.W_TOPIC (ID) values (?)", stmt -> stmt.setInt(1, topicId));

			} else {
				Article parentArticle = getById(articlePostData.getParentArticleId());
				topicId = parentArticle.getTopicId();
			}

			SimpleDataFetcher<Integer> idFetcher = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
			OracleDatabase.request("SELECT MAX(ID) FROM W_ARTICLE", idFetcher);
			Integer articleNewId = idFetcher.getData();

			OracleDatabase.execute(
					"Insert into H675212.W_ARTICLE (ID,TITLE,CREATION_DATE,MODIFICATION_TYPE,CONTENT,AUTHOR_ID,TOPIC_ID,LANGUAGE_ID,APPROVED,VISITED,MODIFCATIONCOUNTER) values (?,?,?,?,?,?,?,?,?,?,?)",
					stmt -> {
						int index = 0;
						stmt.setInt(++index, articleNewId + 1);
						stmt.setString(++index, articlePostData.getTitle());
						stmt.setDate(++index, new Date(System.currentTimeMillis()));
						stmt.setInt(++index, 1); // Tökmindegy
						stmt.setString(++index, articlePostData.getContent());
						stmt.setInt(++index, sessionData.getUser().getUserId());
						stmt.setInt(++index, topicId); // Nem biztos
						stmt.setInt(++index, articlePostData.getLanguageId());
						stmt.setInt(++index, 0);
						stmt.setInt(++index, 0);
						stmt.setInt(++index, 0);
					});

			SimpleDataFetcher<Integer> maxIdCategoryFetcher = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
			OracleDatabase.request("SELECT MAX(ID) FROM W_DISCUSSED_CATEGORY", maxIdCategoryFetcher);
			Integer maxIdCategory = maxIdCategoryFetcher.getData();

			OracleDatabase.execute("DELETE FROM W_KEYWORD_MARK WHERE ARTICLE_ID = ?",
					stmt -> stmt.setInt(1, articleNewId + 1));

			OracleDatabase.execute(
					"Insert into H675212.W_DISCUSSED_CATEGORY (ID, ARTICLE_ID, CATEGORY_ID) values (?,?,?)", stmt -> {
						int index = 0;
						stmt.setInt(++index, maxIdCategory + 1);
						stmt.setInt(++index, articleNewId + 1);
						stmt.setInt(++index, articlePostData.getCategoryId());

					});

			List<Integer> keywordIds = articlePostData.getKeywordIds();

			SimpleDataFetcher<Integer> idFetcher2 = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
			OracleDatabase.request("SELECT MAX(ID) FROM W_KEYWORD_MARK", idFetcher2);
			int keywordId = idFetcher2.getData();

			for (Integer integer : keywordIds) {

				int masikKeywordId = ++keywordId;

				OracleDatabase.execute("Insert into H675212.W_KEYWORD_MARK (ID, ARTICLE_ID, KEYWORD_ID) values (?,?,?)",
						stmt -> {
							int index = 0;
							stmt.setInt(++index, masikKeywordId);
							stmt.setInt(++index, articleNewId + 1);
							stmt.setInt(++index, integer);

						});

			}

			return articleNewId + 1;
		}
	}

	@Override
	public Article getById(int articleId) {
		SimpleDataFetcher<Article> articleFetcher = new SimpleDataFetcher<>(Parser::Article);
		OracleDatabase.request("SELECT * FROM W_ARTICLE WHERE ID = ?", stmt -> stmt.setInt(1, articleId),
				articleFetcher);
		Article data = articleFetcher.getData();

		fillKeywords(data);
		fillCategory(data);

		return data;
	}

	@Override
	public int worstAuthor() {
		
		SimpleDataFetcher<Integer> categoryFetcher = new SimpleDataFetcher<>(resultset -> resultset.getInt(1));
		OracleDatabase.request("SELECT AUTHOR_ID FROM W_ARTICLE GROUP BY AUTHOR_ID ORDER BY SUM(MODIFCATIONCOUNTER)", categoryFetcher);
		return categoryFetcher.getData();

	}

	@Override
	public List<Article> mostTimesCorrectedArticle() {

		
		ListDataFetcher<Article> articleFetcher = new ListDataFetcher<>(Parser::Article);
		OracleDatabase.request("SELECT * FROM W_ARTICLE ORDER BY( MODIFCATIONCOUNTER) DESC", articleFetcher);
		return articleFetcher.getData().stream().limit(3).collect(Collectors.toList());

	}

	@Override
	public int numberOfPublishedArticlesInCategory(int categoryId) {

		SimpleDataFetcher<Integer> categoryFetcher = new SimpleDataFetcher<>(resultset -> resultset.getInt(1));
		OracleDatabase.request("SELECT COUNT(*) FROM W_DISCUSSED_CATEGORY WHERE CATEGORY_ID = ?",
				stmt -> stmt.setInt(1, categoryId), categoryFetcher);
		return categoryFetcher.getData();
	}

	private long countPublishedArticlesInCategories(int categoryId) {

		SimpleDataFetcher<Integer> categoryFetcher = new SimpleDataFetcher<>(resultset -> resultset.getInt(1));
		OracleDatabase.request(
				// SELECT * FROM W_DISCUSSED_CATEGORY LEFT OUTER JOIN W_ARTICLE ON W_ARTICLE.ID
				// = W_DISCUSSED_CATEGORY.CATEGORY_ID WHERE CATEGORY_ID = 1 AND APPROVED = 1
				"SELECT COUNT(*) FROM W_DISCUSSED_CATEGORY LEFT OUTER JOIN W_ARTICLE ON W_ARTICLE.ID = W_DISCUSSED_CATEGORY.CATEGORY_ID WHERE CATEGORY_ID = ? AND APPROVED = 1",
				stmt -> stmt.setInt(1, categoryId), categoryFetcher);
		return categoryFetcher.getData();
	}

	@Override
	public List<Article> listPublishedArticlesInCategory(int categoryId) {
		ListDataFetcher<Article> articleFetcher = new ListDataFetcher<>(Parser::Article);
		OracleDatabase.request(
				"SELECT W_ARTICLE.ID,W_ARTICLE.TITLE,W_ARTICLE.CREATION_DATE,W_ARTICLE.MODIFICATION_TYPE,W_ARTICLE.CONTENT,W_ARTICLE.AUTHOR_ID,W_ARTICLE.TOPIC_ID,W_ARTICLE.LANGUAGE_ID,W_ARTICLE.APPROVED,W_ARTICLE.VISITED,W_ARTICLE.MODIFCATIONCOUNTER,W_ARTICLE.LECTOR_ID FROM W_DISCUSSED_CATEGORY LEFT OUTER JOIN W_ARTICLE ON W_ARTICLE.ID = W_DISCUSSED_CATEGORY.ARTICLE_ID WHERE CATEGORY_ID = ? AND APPROVED = 1",
				stmt -> stmt.setInt(1, categoryId), articleFetcher);
		return articleFetcher.getData();
	}

	@Override
	public List<Article> articlesOrderedByTheNumberOfLanguages() {

		ListDataFetcher<Article> articleFetcher = new ListDataFetcher<>(Parser::Article);
		OracleDatabase.request(
				"SELECT * FROM W_ARTICLE kulso WHERE LANGUAGE_ID = ( SELECT MIN(belso.LANGUAGE_ID) FROM W_ARTICLE belso WHERE belso.TOPIC_ID = kulso.TOPIC_ID ) ORDER BY ( SELECT COUNT(*) FROM W_ARTICLE belso WHERE belso.TOPIC_ID = kulso.TOPIC_ID ) DESC  ",
				articleFetcher);
		return articleFetcher.getData();
	}

	@Override
	public int translatedToTheMostLanguages() {
		List<Article> articlesOrderedByTheNumberOfLanguages = articlesOrderedByTheNumberOfLanguages();
		
		return articlesOrderedByTheNumberOfLanguages.get(0).getId();
	}

	@Override
	public List<Article> listPublishedArticlesIdTitle() {
		ListDataFetcher<Article> articleFetcher = new ListDataFetcher<>(Parser::Article);
		OracleDatabase.request("SELECT * FROM W_ARTICLE WHERE APPROVED = 1", articleFetcher);
		return articleFetcher.getData();
	}

	@Override
	public List<Article> listTranslationsOf(int articleId) {
		ListDataFetcher<Article> articleFetcher = new ListDataFetcher<>(Parser::Article);
		OracleDatabase.request(
				"SELECT * FROM W_ARTICLE WHERE TOPIC_ID = (SELECT TOPIC_ID FROM W_ARTICLE WHERE ID = ?) AND ID <> ?",
				stmt -> {
					int index = 0;
					stmt.setInt(++index, articleId);
					stmt.setInt(++index, articleId);
				}, articleFetcher);
		return articleFetcher.getData();
	}

	@Override
	public void accept(int articleId) {

		OracleDatabase.execute("UPDATE H675212.W_ARTICLE SET APPROVED = 1 WHERE ID = ?",
				stmt -> stmt.setInt(1, articleId));
	}

	@Override
	public void decline(int articleId) {
		OracleDatabase.execute("DELETE FROM W_ARTICLE WHERE ID = ? ", stmt -> stmt.setInt(1, articleId));
	}

	@Override
	public List<Article> assignedArticlesToReview(int userId) {

		ListDataFetcher<Article> articleFetcher = new ListDataFetcher<>(Parser::Article);
		OracleDatabase.request("SELECT * FROM W_ARTICLE WHERE LECTOR_ID = ? AND APPROVED = 0",
				stmt -> stmt.setInt(1, userId), articleFetcher);
		return articleFetcher.getData();
	}

	@Override
	public List<Article> notReviewableArticles() {
		ListDataFetcher<Article> articleFetcher = new ListDataFetcher<>(Parser::Article);
		OracleDatabase.request("SELECT * FROM W_ARTICLE WHERE APPROVED = 0 AND LECTOR_ID IS NULL", articleFetcher);
		List<Article> articles = articleFetcher.getData();
		articles.forEach(a->fillCategory(a));
		
		List<Article> notReviewable = articles.stream()
				.filter(a -> !userService.isReviewableCategory(a.getCategoryId())).collect(Collectors.toList());
		return notReviewable;
	}

	@Override
	public List<Integer> offerLectors(int articleId) {
		Article article = getById(articleId);
		int categoryId = article.getCategoryId();

		List<Integer> listLectorsOfCategory = userService.listLectorsOfCategory(categoryId);

		if (article.getWriterId() != -1 && !listLectorsOfCategory.contains(article.getWriterId())) {
			listLectorsOfCategory.add(article.getWriterId()); // A SZERZŐ IS LEHET LEKTOR!
		}

		return listLectorsOfCategory;
	}

	@Override
	public List<Article> notAssignedArticles() {

		ListDataFetcher<Article> articleFetcher = new ListDataFetcher<>(Parser::Article);
		OracleDatabase.request("SELECT * FROM W_ARTICLE WHERE APPROVED = 0 AND LECTOR_ID IS NULL", articleFetcher);
		List<Article> articles = articleFetcher.getData();

		articles.forEach(a->fillCategory(a));
		
		List<Article> notAssigned = articles.stream().filter(a -> userService.isReviewableCategory(a.getCategoryId()))
				.collect(Collectors.toList());
		
		
		return notAssigned;
	}

	@Override
	public void assignArticle(int articleId, int lectorId) {
		OracleDatabase.execute("UPDATE H675212.W_ARTICLE SET LECTOR_ID = ? WHERE ID = ?", stmt -> {
			int index = 0;
			stmt.setInt(++index, lectorId);
			stmt.setInt(++index, articleId);

		});
	}

	@Override
	public List<User> listLazyUsers() {

		ListDataFetcher<User> userFetcher = new ListDataFetcher<>(Parser::User);
		OracleDatabase.request("SELECT * FROM W_USER WHERE ID NOT IN (SELECT AUTHOR_ID FROM W_ARTICLE) ", userFetcher);
		return userFetcher.getData();

	}

	@Override
	public Map<Integer, Article> listAllArticles() {
		ListDataFetcher<Article> articleFetcher = new ListDataFetcher<>(Parser::Article);
		OracleDatabase.request("SELECT * FROM W_ARTICLE", articleFetcher);
		return articleFetcher.getData().stream().collect(Collectors.toMap(Article::getId, u -> u));
	}

	@Override
	public List<Article> listArticlesByKeywords(int keywordId) {
		ListDataFetcher<Article> articleFetcher = new ListDataFetcher<>(Parser::Article);
		OracleDatabase.request(
				"SELECT * FROM W_ARTICLE WHERE ID IN (SELECT ARTICLE_ID FROM W_KEYWORD_MARK WHERE KEYWORD_ID = ?)",
				stmt -> stmt.setInt(1, keywordId), articleFetcher);
		return articleFetcher.getData();
	}

	private void fillKeywords(Article article) {

		List<Integer> keywordIDs = new ArrayList<>();

		ListDataFetcher<Integer> articleFetcher = new ListDataFetcher<>(resultSet -> resultSet.getInt(1));
		OracleDatabase.request("SELECT KEYWORD_ID FROM W_KEYWORD_MARK WHERE ARTICLE_ID = ?",
				stmt -> stmt.setInt(1, article.getId()), articleFetcher);
		if (articleFetcher.getData() != null) {
			keywordIDs.addAll(articleFetcher.getData());
		}
		article.setKeywordIDs(keywordIDs);
	}
	
	
	private void fillCategory(Article article) {

		SimpleDataFetcher<Integer> articleFetcher = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
		OracleDatabase.request("SELECT CATEGORY_ID FROM W_DISCUSSED_CATEGORY WHERE ARTICLE_ID = ?",
				stmt -> stmt.setInt(1, article.getId()), articleFetcher);
		if (articleFetcher.getData() != null) {
			article.setCategoryId(articleFetcher.getData());
		}
	}

}
