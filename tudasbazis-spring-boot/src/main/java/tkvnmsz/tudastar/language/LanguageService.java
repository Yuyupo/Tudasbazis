package tkvnmsz.tudastar.language;

import java.util.List;
import java.util.Map;

public interface LanguageService {
	/**
	 * List all available languages
	 * @return list of languages
	 */
	Map<Integer, Language> listLanguages();
}
