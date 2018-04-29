package tkvnmsz.tudastar.profile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tkvnmsz.tudastar.Pages;
import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.article.ArticleService;
import tkvnmsz.tudastar.category.Category;
import tkvnmsz.tudastar.category.CategoryService;
import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.login.UserService;
import tkvnmsz.tudastar.session.SessionData;

@Controller
public class ProfileController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	UserService userService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	private SessionData sessionData;

	@GetMapping("/profile")
	public String showProfile(Model model) {
		List<Category> categories = categoryService.listCategories();
		model.addAttribute("categories", categories);
		
		return Pages.PROFILE;
	}

	@GetMapping("/review")
	public String showReview(Model model) {
		List<Article> notReviewedArticles = articleService.assignedArticlesToReview(sessionData.getUser().getUserId());
		model.addAttribute("articles", notReviewedArticles);

		return Pages.REVIEW;
	}

	@GetMapping("/assign")
	public String showAssign(Model model) {
		List<Article> notReviewedArticles = articleService.notAssignedArticles();
		model.addAttribute("articles", notReviewedArticles);
		
		Map<Integer, List<Integer>> lectors = new HashMap<>();
		for (Article article : notReviewedArticles) {
			List<Integer> offeredLectors = articleService.offerLectors(article.getId());
			lectors.put(article.getId(), offeredLectors);
		}
		model.addAttribute("lectors", lectors);
		
		List<User> listUsers = userService.listUsers();
		model.addAttribute("users", listUsers);
		
		
		return Pages.ASSIGN_LECTOR;
	}

	@GetMapping("/assignTo")
	public String showAssignTo(@RequestParam Map<String, String> queryParameters, Model model) {
		int articleId = Integer.parseInt(queryParameters.get("articleId"));
		int lectureId = Integer.parseInt(queryParameters.get("lectorId"));
		
		articleService.assignArticle(articleId, lectureId);
		
		return Pages.ASSIGN_LECTOR_SUCCESSFUL;
	}
	
	@GetMapping("/notreviewable")
	public String showNotReviewable(Model model) {
		List<Article> notReviewedArticles = articleService.notReviewableArticles();
		model.addAttribute("articles", notReviewedArticles);

		return Pages.NOTREVIEWABLE;
	}
	
	@GetMapping("/lazyusers")
	public String showLazyUsers(Model model) {
		List<User> lazyUsers = articleService.listLazyUsers();
		model.addAttribute("users", lazyUsers);

		return Pages.LAZY_USERS;
	}
	
	@GetMapping("/settings")
	public String showSettings(Model model) {
		List<Category> categories = categoryService.listCategories();
		model.addAttribute("categories", categories);
		
		return Pages.SETTINGS;
	}
	
	@PostMapping("/settings")
	public Object settingsSubmit(@RequestParam Map<String, String> queryParameters, Model model) {
		
		for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
			if( entry.getKey().equals("institution") ) {
				userService.setInstitution(sessionData.getUser().getUserId(), entry.getValue());
			}else if( entry.getKey().equals("scientificDegree") ) {
				userService.setScientificDegree(sessionData.getUser().getUserId(), entry.getValue());
			}else if( entry.getKey().startsWith("category-") ) {
				int categoryId = Integer.parseInt(entry.getKey().substring("category-".length()));
				int level = Integer.parseInt(entry.getValue());
				
				if( level == 0 ) {
					userService.unsetLectoring(sessionData.getUser().getUserId(), categoryId);
				}else {
					userService.setLectoring(sessionData.getUser().getUserId(), categoryId, level);
				}
			}
		}
		
		sessionData.setUser(userService.ReadDataFromDatabase(sessionData.getUser().getUserId()));
		
		return Pages.SETTINGS_SUCCESSFUL;
	}
}
