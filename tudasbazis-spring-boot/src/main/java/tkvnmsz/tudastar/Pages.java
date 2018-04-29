package tkvnmsz.tudastar;

public class Pages {
	public static final String MAIN_PAGE = "index";

	public static final String LOGIN_FORM = "/login/loginForm";
	public static final String LOGIN_SUCCESSFUL = "redirect:/";
	public static final String LOGIN_FAILED = LOGIN_FORM;

	public static final String LOGOUT = "redirect:/";

	public static final String SIGNUP_FORM = "/login/signupForm";

	public static final String SIGNUP_SUCCESSFUL = "redirect:/";
	public static final String SIGNUP_FAILED = SIGNUP_FORM;

	public static final String PROFILE = "/profile/profile";

	public static final String CATEGORIES = "/categories/categories";
	public static final String CATEGORIES_LISTED = "/categories/listed";

	public static final String ARTICLE_POSTFORM = "/article/postForm";
	public static final String ARTICLE_POST_SUCCESSFUL = "redirect:/article/read/";
	public static final String ARTICLE_POST_FAILED = ARTICLE_POSTFORM;
	public static final String ARTICLE_READ = "/article/read";
	public static final String ARTICLE_READ_FAILED = "redirect:/";

	public static final String REVIEW = "/profile/notReviewed";
	public static final String REVIEW_ACCEPTED = "redirect:/review";
	public static final String REVIEW_DECLINED = "redirect:/review";

	public static final String ASSIGN_LECTOR = "/profile/notAssigned";
	public static final String ASSIGN_LECTOR_SUCCESSFUL = "redirect:/assign";

	public static final String NOTREVIEWABLE = "/profile/notReviewable";

	public static final String LAZY_USERS = "/profile/lazyUsers";

	public static final String SETTINGS = "/profile/settings";
	public static final String SETTINGS_SUCCESSFUL = "redirect:/profile";
	public static final String SETTINGS_FAILED = SETTINGS;

	public static final String REPORT = "report/reportForm";
	public static final String REPORT_SUCCESS = "report/thanks";
	public static final String REPORT_FAILED = "redirect:/";

	public static final String REPORTS = "report/reports";
	
	public static final String SIMILAR = "/article/similar";
}
