package tkvnmsz.tudastar.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import tkvnmsz.tudastar.login.UserService;
import tkvnmsz.tudastar.session.SessionData;

@RequestMapping("/article")
@Controller
public class ArticleController {
	@Autowired
	private UserService userService; 
	@Autowired
	private ArticleService articleService; 
	
	@Autowired
	private SessionData sessionData;

	@GetMapping("/post")
	public String postForm(@ModelAttribute ArticlePostData articlePostData) {
		return "article/postForm";
	}
}
