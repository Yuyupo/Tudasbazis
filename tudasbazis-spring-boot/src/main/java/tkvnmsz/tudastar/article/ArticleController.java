package tkvnmsz.tudastar.article;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tkvnmsz.tudastar.category.Category;
import tkvnmsz.tudastar.category.CategoryService;
import tkvnmsz.tudastar.session.SessionData;

@RequestMapping("/article")
@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SessionData sessionData;

	@GetMapping("/post")
	public String postForm(Model model) {
		List<Category> categories = categoryService.listCategories();
		model.addAttribute("categories", categories);
		
		return "article/postform";
	}

	@PostMapping("/post")
	public String postSubmit(@ModelAttribute ArticlePostData articlePostData, @RequestParam Map<String, String> queryParameters) {

		String kindParameter = queryParameters.get("kind");
		ChangeKind kind = ChangeKind.CREATE;
		if( kindParameter != null ) {
			if( kindParameter.equals("m")) {
				kind = ChangeKind.MODIFY;
			}else {
				kind = ChangeKind.CORRECTION;
			}
		}
		articlePostData.setChangeKind(kind);

		

		int articleId = articleService.post(articlePostData);

		if (articleId != -1) {
			return "redirect:read/" + articleId;
		} else {
			return "article/postForm";
		}
	}
	
	@GetMapping("/read/{articleId}")
	public String read(@PathVariable Integer articleId, Model model) {
		if( articleId != null ) {
			Article article = articleService.getById(articleId);
			model.addAttribute("article", article);
		}
		return "article/read";
	}
	
	@GetMapping("/review/accept/{articleId}")
	public String reviewAccept(@PathVariable Integer articleId, Model model) {
		if( articleId != null ) {
			reviewService.accept(articleId);
		}
		return "redirect:read/" + articleId;
	}
	
	@GetMapping("/review/decline/{articleId}")
	public String reviewDecline(@PathVariable Integer articleId, Model model) {
		if( articleId != null ) {
			reviewService.decline(articleId);
		}
		return "redirect:read/" + articleId;
	}
	
}
