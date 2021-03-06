/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tkvnmsz.tudastar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.article.ArticleService;
import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.login.UserService;
import tkvnmsz.tudastar.session.SessionData;

@Controller
public class WelcomeController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	//CSAK VÉKONY AZ AJTÓ :/
	@Autowired
	private SessionData sessionData;
	
	
	@GetMapping("/")
	public String welcome(Model model) {
		int mostLanguagesId = articleService.translatedToTheMostLanguages();
		Article mostLanguages = articleService.getById(mostLanguagesId);
		model.addAttribute("mostLanguages", mostLanguages);
		
		int worstAuthor = articleService.worstAuthor();
		User worstUser = userService.getById(worstAuthor);
		model.addAttribute("worstUser", worstUser);
		
		List<Article> mostTimesCorrectedArticle = articleService.mostTimesCorrectedArticle();
		model.addAttribute("mostCorrected", mostTimesCorrectedArticle);
		
		Map<Integer, Article> listAllArticles = articleService.listAllArticles();
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		int seed = df.format(date).hashCode();
		int articleOfTheDayId = new Random(seed).nextInt(listAllArticles.size());
		Article articleOfTheDay = listAllArticles.values().stream().skip(articleOfTheDayId).findFirst().get();
		model.addAttribute("articleOfTheDay", articleOfTheDay);
		
		return Pages.MAIN_PAGE;
	}
	
	/*
	@RequestMapping("/test/{id}")
	public String test(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		return "test";
	}*/
}
