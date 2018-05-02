package tkvnmsz.tudastar.service;

import java.util.List;

import tkvnmsz.tudastar.keyword.Keyword;
import tkvnmsz.tudastar.keyword.KeywordService;

public class KeywordServiceOracle implements KeywordService{

	@Override
	public List<Keyword> listKeywords() {
		//SELECT * FROM W_KEYWORD
		return null;
	}

}
