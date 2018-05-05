package tkvnmsz.tudastar.keyword;

import java.util.List;
import java.util.Map;

public interface KeywordService {
	/*
	int addKeyword(String keyword);
	List<Keyword> getKeywordsLike(String keyword);
	List<Integer> similarArticles(List<Integer> keywordIDs);*/
	
	Map<Integer, Keyword> listKeywords();
}
