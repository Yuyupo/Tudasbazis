package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.language.Language;
import tkvnmsz.tudastar.language.LanguageService;

@Service
public class LanguageServiceDummy implements LanguageService{
	private ArrayList<Language> languages = new ArrayList<>();
	
	public LanguageServiceDummy() {
		populateLanguages();
	}
	
	
	private void populateLanguages() {
		Language language;
		
		language = new Language();
		language.setId(languages.size());
		language.setName("English");
		languages.add(language);
		
		language = new Language();
		language.setId(languages.size());
		language.setName("Deutsch");
		languages.add(language);
		
		language = new Language();
		language.setId(languages.size());
		language.setName("Magyar");
		languages.add(language);
		
		language = new Language();
		language.setId(languages.size());
		language.setName("русский");
		languages.add(language);
		
		language = new Language();
		language.setId(languages.size());
		language.setName("日本");
		languages.add(language);
	}


	@Override
	public List<Language> listLanguages() {
		return languages;
	}

}
