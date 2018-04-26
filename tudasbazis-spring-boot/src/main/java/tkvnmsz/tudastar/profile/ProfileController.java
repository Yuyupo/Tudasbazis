package tkvnmsz.tudastar.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tkvnmsz.tudastar.Pages;
import tkvnmsz.tudastar.session.SessionData;

@Controller
public class ProfileController {

	@Autowired
	private SessionData sessionData;
	
	@GetMapping("/profile")
	public String showProfile() {
		return Pages.PROFILE;
	}
}
