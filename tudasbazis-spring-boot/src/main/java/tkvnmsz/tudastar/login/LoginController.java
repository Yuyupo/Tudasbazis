package tkvnmsz.tudastar.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tkvnmsz.tudastar.service.UserServiceDummy;
import tkvnmsz.tudastar.session.SessionData;

@Controller
public class LoginController {
	@Autowired
	private UserServiceDummy userService; 
	
	@Autowired
	private SessionData sessionData;
	
	@GetMapping("/login")
	public String loginForm() {
		return "login/loginForm";
	}

	@PostMapping(value = "/login")
	public String loginSubmit(@ModelAttribute LoginData loginData) {
		User user = userService.login(loginData);
		
		if( user.isLoggedIn() ) {
			sessionData.setUser(user);
		}

		return "login/loginResult";
	}
	

	@GetMapping("/logout")
	public String logout() {
		sessionData.unsetUser();
		return "login/logout";
	}
	
	@GetMapping("/status")
	@ResponseBody
	public User status() {
		return sessionData.getUser();
	}
	
	
	@GetMapping("/session")
	public String session() {
		return "session";
	}
}
