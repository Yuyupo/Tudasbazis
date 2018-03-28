package tkvnmsz.tudastar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.article.ReviewService;

@Service
public class ReviewServiceDummy implements ReviewService {

	@Override
	public void accept(int articleId) {
		
	}

	@Override
	public void decline(int articleId) {
		
	}

	@Override
	public List<Integer> notReviewedArticles() {
		return null;
	}

	@Override
	public List<Integer> notReviewableArticles() {
		return null;
	}

	@Override
	public List<Integer> offerLectors(int articleId) {
		return null;
	}

}
