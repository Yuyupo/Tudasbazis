package tkvnmsz.tudastar.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.login.UserService;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionData {
	private User user = UserService.UnknownUser;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void unsetUser() {
		user = UserService.UnknownUser;
	}
}
