package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.keyword.Keyword;
import tkvnmsz.tudastar.keyword.KeywordService;

@Service
public class KeywordServiceDummy implements KeywordService {
	private List<Keyword> keywords = new ArrayList<>();
	
	public KeywordServiceDummy() {
		populateKeywords();
	}
	
	private void populateKeywords() {
		Keyword keyword;
		
		keyword = new Keyword();
		keyword.setId(keywords.size());
		keyword.setKeyword("game");
		keywords.add(keyword);
		
		keyword = new Keyword();
		keyword.setId(keywords.size());
		keyword.setKeyword("food");
		keywords.add(keyword);
		
		keyword = new Keyword();
		keyword.setId(keywords.size());
		keyword.setKeyword("people");
		keywords.add(keyword);
		
		keyword = new Keyword();
		keyword.setId(keywords.size());
		keyword.setKeyword("corn");
		keywords.add(keyword);
	}

	@Override
	public List<Keyword> listKeywords() {
		return keywords;
	}

}
