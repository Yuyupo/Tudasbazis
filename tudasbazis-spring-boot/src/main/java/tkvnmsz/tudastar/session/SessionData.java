package tkvnmsz.tudastar.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.WebApplicationContext;

import tkvnmsz.tudastar.login.User;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@ControllerAdvice
public class SessionData {
	private User user = User.UNKNOWN_USER;
	
	@ModelAttribute
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void unsetUser() {
		user = User.UNKNOWN_USER;
	}
}
