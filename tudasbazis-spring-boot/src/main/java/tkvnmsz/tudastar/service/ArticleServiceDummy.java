package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.Date;
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
import tkvnmsz.tudastar.session.SessionData;

@Service
public class ArticleServiceDummy implements ArticleService {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	private SessionData sessionData;

	List<Article> articles = new ArrayList<>();
	List<Integer> topics = new ArrayList<>();
	Map<Integer, Integer> assignedLectors = new HashMap<>();

	public ArticleServiceDummy() {
		populate();
	}

	private void populate() {
		Article article;
		List<Integer> keywords;

		article = new Article();
		article.setTitle("Első cím");
		article.setContent(
				"Első tartalom   a ds d a sd a f a fwfa  fa fs fs g sg s fs f sgs gs g s dg gnsog abgfi aof afosofaof o afais hfoahf ahfo afha owa ehf uhsgsgui aehoafousb fbaefiasf asefo flasflefp aslhf pashg shgip ef f b fpasufpi bsfb isf bai fbdfp bpdfb dbf pbfd sbf dfsdf  df sdfbdbfbf d f dfp sdf");
		article.setCategoryId(0);
		article.setChangeKind(ChangeKind.CREATE);
		article.setDate("2018-03-27");
		article.setId(articles.size());
		article.setReviewed(true);
		keywords = new ArrayList<>();
		keywords.add(0);
		article.setKeywordIDs(keywords);
		article.setLanguageId(0);
		article.setTopicId(0);
		articles.add(article);
		topics.add(0);

		article = new Article();
		article.setTitle("Első cím (2. verzió)");
		article.setContent(
				"Első tartalom (2. verzió) as  as dad asdasd as da f af awfawf awf  awfa wfawfawf afa fwafaf aw afw faw faw faf awf awf awf qwkf wq fkq onfowef owe owbe bsueg sbigb sboab bqouwbf szibfiabfwif iabfabis fab fisbif sifbisbfiseb fiesbf isuebfisebfai efbaiwf abeif abwifabifabfiab fabwifuab wif abiw baw bfabi wfiabwi faiwb fa bfabw bfaiwb fiabw fabw");
		article.setCategoryId(0);
		article.setChangeKind(ChangeKind.MODIFY);
		article.setDate("2018-03-28");
		article.setId(articles.size());
		article.setReviewed(true);
		keywords = new ArrayList<>();
		keywords.add(0);
		keywords.add(1);
		keywords.add(2);
		article.setKeywordIDs(keywords);
		article.setLanguageId(1);
		article.setTopicId(0);
		articles.add(article);

		article = new Article();
		article.setTitle("Első cím (3. verzió)");
		article.setContent(
				"Első tartalom (3. verzió) as  as dad asdasd as da f af awfawf awf  awfa wfawfawf afa fwafaf aw afw faw faw faf awf awf awf qwkf wq fkq onfowef owe owbe bsueg sbigb sboab bqouwbf szibfiabfwif iabfabis fab fisbif sifbisbfiseb fiesbf isuebfisebfai efbaiwf abeif abwifabifabfiab fabwifuab wif abiw baw bfabi wfiabwi faiwb fa bfabw bfaiwb fiabw fabw");
		article.setCategoryId(0);
		article.setChangeKind(ChangeKind.MODIFY);
		article.setDate("2018-03-28");
		article.setId(articles.size());
		article.setReviewed(true);
		keywords = new ArrayList<>();
		keywords.add(1);
		keywords.add(2);
		keywords.add(3);
		article.setKeywordIDs(keywords);
		article.setLanguageId(2);
		article.setTopicId(0);
		articles.add(article);

		article = new Article();
		article.setTitle("Első cím (4. verzió)");
		article.setContent(
				"Első tartalom (4. verzió) as  as dad asdasd as da f af awfawf awf  awfa wfawfawf afa fwafaf aw afw faw faw faf awf awf awf qwkf wq fkq onfowef owe owbe bsueg sbigb sboab bqouwbf szibfiabfwif iabfabis fab fisbif sifbisbfiseb fiesbf isuebfisebfai efbaiwf abeif abwifabifabfiab fabwifuab wif abiw baw bfabi wfiabwi faiwb fa bfabw bfaiwb fiabw fabw");
		article.setCategoryId(0);
		article.setChangeKind(ChangeKind.MODIFY);
		article.setDate("2018-03-28");
		article.setId(articles.size());
		article.setReviewed(false);
		keywords = new ArrayList<>();
		keywords.add(3);
		article.setKeywordIDs(keywords);
		article.setLanguageId(3);
		article.setTopicId(0);
		articles.add(article);

		article = new Article();
		article.setTitle("Második cím");
		article.setContent("Második tartalom");
		article.setCategoryId(5);
		article.setChangeKind(ChangeKind.CREATE);
		article.setDate("2018-03-29");
		article.setId(articles.size());
		article.setReviewed(true);
		keywords = new ArrayList<>();
		keywords.add(1);
		keywords.add(2);
		keywords.add(3);
		article.setKeywordIDs(keywords);
		article.setLanguageId(2);
		article.setTopicId(1);
		articles.add(article);
		topics.add(1);

		article = new Article();
		article.setTitle("Harmadik cím");
		article.setContent("Harmadik tartalom");
		article.setCategoryId(3);
		article.setChangeKind(ChangeKind.CREATE);
		article.setDate("2018-03-29");
		article.setId(articles.size());
		article.setReviewed(false);
		article.setWriterId(-1);
		keywords = new ArrayList<>();
		keywords.add(1);
		keywords.add(2);
		keywords.add(3);
		article.setKeywordIDs(keywords);
		article.setLanguageId(2);
		article.setTopicId(2);
		articles.add(article);
		topics.add(2);
	}

	@Override
	public int post(ArticlePostData articlePostData) {
		Article article = new Article();
		article.setCategoryId(articlePostData.getCategoryId());
		article.setChangeKind(articlePostData.getChangeKind());
		article.setContent(articlePostData.getContent());
		article.setDate(new Date().toString());
		article.setId(articles.size());
		article.setLanguageId(articlePostData.getLanguageId());
		article.setReviewed(false);
		article.setTitle(articlePostData.getTitle());
		article.setKeywordIDs(articlePostData.getKeywordIds());

		int topicId;

		if (articlePostData.getParentArticleId() == -1) {
			topicId = topics.size();
			topics.add(topicId);
		} else {
			Article parentArticle = getById(articlePostData.getParentArticleId());
			topicId = parentArticle.getTopicId();
		}

		article.setWriterId(sessionData.getUser().getUserId());
		article.setTopicId(topicId);

		articles.add(article);

		return articles.size() - 1;
	}

	@Override
	public Article getById(int articleId) {
		return articles.get(articleId);
	}

	@Override
	public int mostTimesModifiedArticle() {
		return 0;
	}

	@Override
	public int mostTimesCorrectedArticle() {
		return 0;
	}

	@Override
	public int numberOfPublishedArticlesInCategory(int categoryId) {
		long count = countPublishedArticlesInCategories(categoryId);
		return (int) count;
	}

	private long countPublishedArticlesInCategories(int categoryId) {
		long count = articles.stream().filter(article -> article.getCategoryId() == categoryId && article.isReviewed())
				.count();

		List<Category> categories = categoryService.listSubCategories(categoryId);
		for (Category category : categories) {
			count += countPublishedArticlesInCategories(category.getId());
		}

		return count;
	}

	@Override
	public List<Article> listPublishedArticlesInCategory(int categoryId) {
		List<Article> articlesInTheCategory = articles.stream()
				.filter(article -> article.getCategoryId() == categoryId && article.isReviewed())
				.collect(Collectors.toList());
		return articlesInTheCategory;
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
		return articles.stream().filter(a -> a.isReviewed()).collect(Collectors.toList());
	}

	@Override
	public List<Article> listTranslationsOf(int articleId) {
		Article article = getById(articleId);
		int topicId = article.getTopicId();

		List<Article> translations = articles.stream().filter(
				a -> a.getTopicId() == topicId && a.isReviewed() && a.getLanguageId() != article.getLanguageId())
				.collect(Collectors.toList());

		// ITT JÖNNE AZ, HOGY CSAK A LEGFRISSEBB DÁTUMÚT NÉZZÜK

		return translations;
	}

	@Override
	public void accept(int articleId) {
		getById(articleId).setReviewed(true);
		assignedLectors.remove(articleId);
	}

	@Override
	public void decline(int articleId) {
		articles.remove(articleId);
		assignedLectors.remove(articleId);
	}

	@Override
	public List<Article> assignedArticlesToReview(int userId) {
		List<Article> notReviewed = articles.stream().filter(a -> !a.isReviewed()
				&& assignedLectors.containsKey(a.getId()) && assignedLectors.get(a.getId()) == userId)
				.collect(Collectors.toList());
		return notReviewed;
	}

	@Override
	public List<Article> notReviewableArticles() {
		List<Article> notReviewables = articles.stream().filter(
				a -> !a.isReviewed() && a.getWriterId() == -1 && !userService.isReviewableCategory(a.getCategoryId()))
				.collect(Collectors.toList());
		return notReviewables;
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
		List<Article> notAssigned = articles.stream().filter(a -> !a.isReviewed()
				&& !assignedLectors.containsKey(a.getId()) && userService.isReviewableCategory(a.getCategoryId()))
				.collect(Collectors.toList());
		return notAssigned;
	}

	@Override
	public void assignArticle(int articleId, int lectorId) {
		assignedLectors.put(articleId, lectorId);
	}

	@Override
	public List<User> listLazyUsers() {
		List<User> lazyUsers = userService.listUsers().stream().filter( u ->
		!articles.stream().anyMatch(a -> a.getWriterId() == u.getUserId())).collect(Collectors.toList());
		return lazyUsers;
	}

	@Override
	public List<Article> listAllArticlesIdTitle() {
		return articles;
	}

	@Override
	public List<Article> listArticlesByKeywords(int keywordId) {
		return articles.stream().filter(a->a.isReviewed() && a.getKeywordIDs().contains(keywordId)).collect(Collectors.toList());
	}

}
