package tkvnmsz.tudastar;

public class Pages {
	public static final String MAIN_PAGE = "index";
	
	public static final String LOGIN_FORM = "login/loginForm";
	public static final String LOGIN_SUCCESSFUL = "redirect:/";
	public static final String LOGIN_FAILED = LOGIN_FORM;
	
	public static final String LOGOUT = MAIN_PAGE;
	
	public static final String SIGNUP_FORM = "login/signupForm";
	
	public static final String SIGNUP_SUCCESSFUL = "redirect:/";
	public static final String SIGNUP_FAILED = SIGNUP_FORM;
	
	public static final String PROFILE = "profile/profile";
	
	public static final String CATEGORIES = "/categories/categories";
	public static final String CATEGORIES_LISTED = "/categories/listed";

	public static final String ARTICLE_POSTFORM = "/article/postForm";
	public static final String ARTICLE_POST_SUCCESSFUL = "redirect:read/";
	public static final String ARTICLE_POST_FAILED = ARTICLE_POSTFORM;
	public static final String ARTICLE_READ = "/article/read";

	public static final String REVIEW = "/review";
	public static final String REVIEW_ACCEPTED = "redirect:/review";
	public static final String REVIEW_DECLINED = "redirect:/review";
}
