package tkvnmsz.tudastar.language;

import java.util.List;

public interface LanguageService {
	/**
	 * List all available languages
	 * @return
	 */
	List<Language> listLanguages();
	
	/**
	 * mivel térjünk vissza? topiccal kéne, de az nem az igazi. Nem dölt még el...
	 * @return
	 */
	List<Integer> articlesOrderedByTheNumberOfLanguages();
	
	/**
	 * szintén nem tudom mit adjunk vissza... :/ nem lehet azt a cikket, ami a legtöbb nyelven van, mert akkor milyen nyelven adod vissza... hülyeség
	 * @return
	 */
	int translatedToTheMostLanguages();
}
