package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.login.LoginData;
import tkvnmsz.tudastar.login.RegisterData;
import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.login.UserService;

@Service
public class UserServiceDummy implements UserService {
	
	private List<User> users;
	
	public UserServiceDummy() {
		populateUsers();
	}
	
	private void populateUsers() {
		users = new ArrayList<>();
		User user;
		
		user = new User("Idarav");
		user.setAdmin(true);
		users.add(user);
		
		user = new User("Loop");
		user.setLector(true);
		users.add(user);
		
		user = new User("Yuyupo");
		users.add(user);
	}
	
	@Override
	public User login(LoginData loginData) {
		if( loginData.getPassword().equals("pass") ) {
			User user = users.stream().filter(u -> u.getUsername().equalsIgnoreCase(loginData.getUsername())).findFirst().orElse(null);
			if( user != null  ) {
				User loggedUser = new User(user);
				loggedUser.setLoggedIn(true);
				return loggedUser;
			}
		}
		
		return UnknownUser;
	}

	@Override
	public boolean register(RegisterData registerData) {
		return true;
	}
}
