package tkvnmsz.tudastar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.keyword.Keyword;
import tkvnmsz.tudastar.keyword.KeywordService;

@Service
public class KeywordServiceOracle implements KeywordService {

	@Override
	public int addKeyword(String keyword) {
		return 0;
	}

	@Override
	public List<Keyword> getKeywordsLike(String keyword) {
		return null;
	}

	@Override
	public List<Integer> similarArticles(List<Integer> keywordIDs) {
		return null;
	}
}
