package tkvnmsz.tudastar.service;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.article.ArticlePostData;
import tkvnmsz.tudastar.article.ArticleService;

@Service
public class ArticleServiceDummy implements ArticleService {

	@Override
	public int post(ArticlePostData articlePostData) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void accept(int articleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article getById(int articleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int mostTimesModifiedArticle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int mostTimesCorrectedArticle() {
		// TODO Auto-generated method stub
		return 0;
	}

}
