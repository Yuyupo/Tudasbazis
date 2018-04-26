package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.article.ArticlePostData;
import tkvnmsz.tudastar.article.ArticleService;
import tkvnmsz.tudastar.article.ChangeKind;
import tkvnmsz.tudastar.category.Category;
import tkvnmsz.tudastar.category.CategoryService;

@Service
public class ArticleServiceDummy implements ArticleService {
	@Autowired
	CategoryService categoryService;
	
	List<Article> articles = new ArrayList<>();
	{
		Article article;
		List<Integer> keywords = new ArrayList<>();
		
		article = new Article();
		article.setTitle("Első cím");
		article.setContent("Első tartalom   a ds d a sd a f a fwfa  fa fs fs g sg s fs f sgs gs g s dg gnsog abgfi aof afosofaof o afais hfoahf ahfo afha owa ehf uhsgsgui aehoafousb fbaefiasf asefo flasflefp aslhf pashg shgip ef f b fpasufpi bsfb isf bai fbdfp bpdfb dbf pbfd sbf dfsdf  df sdfbdbfbf d f dfp sdf");
		article.setCategoryId(0);
		article.setChangeKind(ChangeKind.CREATE);
		article.setDate("2018-03-27");
		article.setId(articles.size());
		article.setReviewed(true);
		keywords.clear();
		keywords.add(0);
		article.setKeywordIDs(keywords);
		article.setLanguageId(0);
		article.setTopicId(0);
		articles.add(article);

		article = new Article();
		article.setTitle("Első cím (2. verzió)");
		article.setContent("Első tartalom (2. verzió) as  as dad asdasd as da f af awfawf awf  awfa wfawfawf afa fwafaf aw afw faw faw faf awf awf awf qwkf wq fkq onfowef owe owbe bsueg sbigb sboab bqouwbf szibfiabfwif iabfabis fab fisbif sifbisbfiseb fiesbf isuebfisebfai efbaiwf abeif abwifabifabfiab fabwifuab wif abiw baw bfabi wfiabwi faiwb fa bfabw bfaiwb fiabw fabw");
		article.setCategoryId(0);
		article.setChangeKind(ChangeKind.MODIFY);
		article.setDate("2018-03-28");
		article.setId(articles.size());
		article.setReviewed(false);
		keywords.clear();
		keywords.add(0);
		article.setKeywordIDs(keywords);
		article.setLanguageId(0);
		article.setTopicId(0);
		articles.add(article);
		
		article = new Article();
		article.setTitle("Első cím (3. verzió)");
		article.setContent("Első tartalom (3. verzió) as  as dad asdasd as da f af awfawf awf  awfa wfawfawf afa fwafaf aw afw faw faw faf awf awf awf qwkf wq fkq onfowef owe owbe bsueg sbigb sboab bqouwbf szibfiabfwif iabfabis fab fisbif sifbisbfiseb fiesbf isuebfisebfai efbaiwf abeif abwifabifabfiab fabwifuab wif abiw baw bfabi wfiabwi faiwb fa bfabw bfaiwb fiabw fabw");
		article.setCategoryId(0);
		article.setChangeKind(ChangeKind.MODIFY);
		article.setDate("2018-03-28");
		article.setId(articles.size());
		article.setReviewed(false);
		keywords.clear();
		keywords.add(0);
		article.setKeywordIDs(keywords);
		article.setLanguageId(0);
		article.setTopicId(0);
		articles.add(article);

		article = new Article();
		article.setTitle("Első cím (4. verzió)");
		article.setContent("Első tartalom (4. verzió) as  as dad asdasd as da f af awfawf awf  awfa wfawfawf afa fwafaf aw afw faw faw faf awf awf awf qwkf wq fkq onfowef owe owbe bsueg sbigb sboab bqouwbf szibfiabfwif iabfabis fab fisbif sifbisbfiseb fiesbf isuebfisebfai efbaiwf abeif abwifabifabfiab fabwifuab wif abiw baw bfabi wfiabwi faiwb fa bfabw bfaiwb fiabw fabw");
		article.setCategoryId(0);
		article.setChangeKind(ChangeKind.MODIFY);
		article.setDate("2018-03-28");
		article.setId(articles.size());
		article.setReviewed(false);
		keywords.clear();
		keywords.add(0);
		article.setKeywordIDs(keywords);
		article.setLanguageId(0);
		article.setTopicId(0);
		articles.add(article);
		
		article = new Article();
		article.setTitle("Második cím");
		article.setContent("Második tartalom");
		article.setCategoryId(articles.size());
		article.setChangeKind(ChangeKind.CREATE);
		article.setDate("2018-03-29");
		article.setId(2);
		article.setReviewed(true);
		keywords.clear();
		keywords.add(1);
		keywords.add(2);
		keywords.add(3);
		article.setKeywordIDs(keywords);
		article.setLanguageId(4);
		article.setTopicId(1);
		articles.add(article);
	}
	
	@Override
	public int post(ArticlePostData articlePostData) {
		Article article = new Article();
		article.setCategoryId(articlePostData.getCategoryId());
		article.setChangeKind(articlePostData.getChangeKind());
		article.setContent(articlePostData.getContent());
		article.setDate(new Date().toString());
		article.setId(articles.size());
		article.setLanguageId(article.getLanguageId());
		article.setReviewed(false);
		article.setTitle(articlePostData.getTitle());
		
		return 0;
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
	public int numberOfArticlesInCategory(int categoryId) {
		long count = countArticlesInCategories(categoryId);
		return (int)count;
	}
	
	private long countArticlesInCategories(int categoryId) {
		long count = articles.stream().filter(article -> article.getCategoryId() == categoryId).count();
		
		List<Category> categories = categoryService.listSubCategories(categoryId);
		for (Category category : categories) {
			count += countArticlesInCategories(category.getId());
		}
		
		return count;
	}

	@Override
	public List<Article> articlesInCategory(int categoryId) {
		List<Article> articlesInTheCategory = articles.stream().filter(article -> article.getCategoryId() == categoryId).collect(Collectors.toList());
		return articlesInTheCategory;
	}
	
	
}
