package tkvnmsz.tudastar.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tkvnmsz.tudastar.Pages;
import tkvnmsz.tudastar.article.Article;
import tkvnmsz.tudastar.article.ArticleService;
import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.login.UserService;
import tkvnmsz.tudastar.session.SessionData;

@Controller
public class ReportController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private UserService userService;
	@Autowired
	private SessionData sessionData;
	
	@GetMapping("/report/{targetId}")
	public String reportFrom(@PathVariable int targetId, Model model) {
		Article article = articleService.getById(targetId);
		
		if( article == null ) {
			return Pages.REPORT_FAILED;
		}
		
		return Pages.REPORT;
	}
	
	@PostMapping("/report/{targetId}")
	public String reportSubmit(@ModelAttribute ReportPostData reportPostData, @PathVariable int targetId, Model model) {
		reportService.report(reportPostData, sessionData.getUser().getUserId());
		return Pages.REPORT_SUCCESS;
	}
	
	
	@GetMapping("/reports")
	public String showReports(Model model) { 
		List<Report> reports = reportService.listReports();
		model.addAttribute("reports", reports);
		
		Map<Integer, Article> listAllArticlesIdTitle = articleService.listAllArticlesIdTitle();
		model.addAttribute("articles", listAllArticlesIdTitle);
		
		
		Map<Integer, User> listUsers = userService.listUsers();
		model.addAttribute("users", listUsers);
		
		return Pages.REPORTS;
	}
}
