package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.language.Language;
import tkvnmsz.tudastar.language.LanguageService;
import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.service.database.ListDataFetcher;
import tkvnmsz.tudastar.service.database.OracleDatabase;
import tkvnmsz.tudastar.service.database.Parser;

@Service
public class LanguageServiceDummy implements LanguageService{
	
	@Override
	public Map<Integer,Language> listLanguages() {
		ListDataFetcher<Language> languageFetcher = new ListDataFetcher<>(Parser::Language);
		OracleDatabase.request("SELECT * FROM W_LANGUAGE",languageFetcher);
		return languageFetcher.getData().stream().collect(Collectors.toMap(Language::getId, u-> u));
	}

}
