package tkvnmsz.tudastar.keyword;

import java.util.List;

public interface KeywordService {
	int addKeyword(String keyword);
	List<Keyword> getKeywordsLike(String keyword);
	List<Integer> similarArticles(List<Integer> keywordIDs);
}
