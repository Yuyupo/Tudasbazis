package tkvnmsz.tudastar.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tkvnmsz.tudastar.Pages;
import tkvnmsz.tudastar.session.SessionData;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@Autowired
	private SessionData sessionData;

	@GetMapping("/login")
	public String loginForm() {
		return Pages.LOGIN_FORM;
	}

	@PostMapping(value = "/login")
	public String loginSubmit(@ModelAttribute LoginData loginData, Model model) {
		User user = userService.login(loginData);

		if (user.isLoggedIn()) {
			sessionData.setUser(user);
			
			return Pages.LOGIN_SUCCESSFUL;
		}else {
			model.addAttribute("message", "Wrong username or password.");
			return Pages.LOGIN_FAILED;
		}
	}

	@GetMapping("/logout")
	public String logout() {
		sessionData.unsetUser();
		return Pages.LOGOUT;
	}
	
	@GetMapping("/signup")
	public String signupForm() {
		return Pages.SIGNUP_FORM;
	}

	@PostMapping(value = "/signup")
	public String signupSubmit(@ModelAttribute SignupData signupData, Model model) {
		boolean success = userService.signup(signupData);
		
		if (success) {			
			return Pages.SIGNUP_SUCCESSFUL;
		}else {
			model.addAttribute("message", "Something went wrong. Sry. :(");
			return Pages.SIGNUP_FAILED;
		}
	}
	
	@GetMapping("/status")
	@ResponseBody
	public User status() {
		return sessionData.getUser();
	}
}
