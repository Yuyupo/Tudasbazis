package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.article.ArticlePostData;
import tkvnmsz.tudastar.article.ArticleService;
import tkvnmsz.tudastar.article.ChangeKind;

@Service
public class ArticleServiceDummy implements ArticleService {
	List<Article> articles = new ArrayList<>();
	{
		Article article;
		List<Integer> keywords = new ArrayList<>();
		
		article = new Article();
		article.setTitle("Első cím");
		article.setContent("Első tartalom");
		article.setCategoryId(0);
		article.setChangeKind(ChangeKind.CREATE);
		article.setDate("2018-03-27");
		article.setId(0);
		article.setReviewed(true);
		keywords.clear();
		keywords.add(0);
		article.setKeywordIDs(keywords);
		article.setLanguageId(0);
		article.setTopicId(0);
		articles.add(article);

		article = new Article();
		article.setTitle("Első cím (2. verzió)");
		article.setContent("Első tartalom (2. verzió)");
		article.setCategoryId(0);
		article.setChangeKind(ChangeKind.MODIFY);
		article.setDate("2018-03-28");
		article.setId(1);
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
		article.setCategoryId(1);
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

}
