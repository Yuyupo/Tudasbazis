package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.keyword.Keyword;
import tkvnmsz.tudastar.keyword.KeywordService;
import tkvnmsz.tudastar.language.Language;
import tkvnmsz.tudastar.service.database.ListDataFetcher;
import tkvnmsz.tudastar.service.database.OracleDatabase;
import tkvnmsz.tudastar.service.database.Parser;

@Service
public class KeywordServiceDummy implements KeywordService {
	
	@Override
	public Map<Integer,Keyword> listKeywords() {
		ListDataFetcher<Keyword> languageFetcher = new ListDataFetcher<>(Parser::Keyword);
		OracleDatabase.request("SELECT * FROM W_KEYWORD",languageFetcher);
		return languageFetcher.getData().stream().collect(Collectors.toMap(Keyword::getId, u-> u));
	}

}
