package tkvnmsz.tudastar.keyword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tkvnmsz.tudastar.article.ArticleService;
import tkvnmsz.tudastar.login.UserService;
import tkvnmsz.tudastar.session.SessionData;

@Controller
@RequestMapping("/keyword")
public class KeywordController {

	@Autowired
	private UserService userService; 
	@Autowired
	private KeywordService keywordService; 
	
	@Autowired
	private SessionData sessionData;
	
	
	@GetMapping("/add")
	public String addKeyword() {
		return null;
		
	}
}
