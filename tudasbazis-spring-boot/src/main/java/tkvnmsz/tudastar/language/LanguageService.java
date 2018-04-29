package tkvnmsz.tudastar.language;

import java.util.List;

public interface LanguageService {
	/**
	 * List all available languages
	 * @return list of languages
	 */
	List<Language> listLanguages();
}
