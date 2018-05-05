package tkvnmsz.tudastar.article;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.batch.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tkvnmsz.tudastar.Pages;
import tkvnmsz.tudastar.category.Category;
import tkvnmsz.tudastar.category.CategoryService;
import tkvnmsz.tudastar.keyword.Keyword;
import tkvnmsz.tudastar.keyword.KeywordService;
import tkvnmsz.tudastar.language.Language;
import tkvnmsz.tudastar.language.LanguageService;
import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.login.UserService;
import tkvnmsz.tudastar.report.ReportService;
import tkvnmsz.tudastar.session.SessionData;

@RequestMapping("/article")
@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private KeywordService keywordService;
	@Autowired
	private LanguageService languageService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private UserService userService;

	@Autowired
	private SessionData sessionData;

	@GetMapping("/post")
	public String postForm(Model model, @RequestParam Map<String, String> queryParameters) {
		if( queryParameters.containsKey("article") ) {
			int articleId = Integer.parseInt(queryParameters.get("article"));
			Article article = articleService.getById(articleId);
			model.addAttribute("article", article);
		}
		
		Map<Integer, Keyword> listKeywords = keywordService.listKeywords();
		model.addAttribute("keywords", listKeywords);

		Map<Integer, Category> listCategories = categoryService.listCategories();
		model.addAttribute("categories", listCategories);

		Map<Integer, Language> listLanguages = languageService.listLanguages();
		model.addAttribute("languages", listLanguages);

		List<Article> listPublishedArticlesIdTitle = articleService.listPublishedArticlesIdTitle();
		model.addAttribute("articles", listPublishedArticlesIdTitle);

		return Pages.ARTICLE_POSTFORM;
	}

	@PostMapping("/post")
	public String postSubmit(@ModelAttribute ArticlePostData articlePostData,
			@RequestParam Map<String, String> queryParameters) {

		String kindParameter = queryParameters.get("kind");
		ChangeKind kind = ChangeKind.CREATE;
		if (kindParameter != null) {
			if (kindParameter.equals("modify")) {
				kind = ChangeKind.MODIFY;
			} else {
				kind = ChangeKind.CORRECTION;
				int originalArticleId = Integer.parseInt(queryParameters.get("article"));
				articlePostData.setOriginalArticle(originalArticleId);
				int reportId = Integer.parseInt(queryParameters.get("report"));
				reportService.deleteReport(reportId); 
			}
		}
		articlePostData.setChangeKind(kind);
		
		int articleId = articleService.post(articlePostData);

		if (articleId != -1) {
			return Pages.ARTICLE_POST_SUCCESSFUL + articleId;
		} else {
			return Pages.ARTICLE_POSTFORM;
		}
	}

	@GetMapping("/read/{articleId}")
	public String read(@PathVariable Integer articleId, Model model) {

		if (articleId == null) {
			return Pages.ARTICLE_READ_FAILED;
		}

		Map<Integer, Keyword> listKeywords = keywordService.listKeywords();
		model.addAttribute("keywords", listKeywords);

		Article article = articleService.getById(articleId);
		model.addAttribute("article", article);

		Map<Integer, User> listUsers = userService.listUsers();
		model.addAttribute("users", listUsers);

		Map<Integer, Category> listCategories = categoryService.listCategories();
		model.addAttribute("categories", listCategories);

		Map<Integer, Language> listLanguages = languageService.listLanguages();
		model.addAttribute("languages", listLanguages);

		List<Article> listTranslationsOf = articleService.listTranslationsOf(articleId);
		model.addAttribute("translations", listTranslationsOf);

		return Pages.ARTICLE_READ;
	}

	@GetMapping("/review/accept/{articleId}")
	public String reviewAccept(@PathVariable Integer articleId, Model model) {
		if (articleId != null) {
			articleService.accept(articleId);
		}

		return Pages.REVIEW_ACCEPTED;
	}

	@GetMapping("/review/decline/{articleId}")
	public String reviewDecline(@PathVariable Integer articleId, Model model) {
		if (articleId != null) {
			articleService.decline(articleId);
		}

		return Pages.REVIEW_DECLINED;
	}
	
	@GetMapping("/similar/{keywordId}")
	public String showSimilars(@PathVariable int keywordId, Model model) {
		List<Article> listArticlesByKeywords = articleService.listArticlesByKeywords(keywordId);
		model.addAttribute("articles", listArticlesByKeywords);
		
		return Pages.SIMILAR;
	}

}
