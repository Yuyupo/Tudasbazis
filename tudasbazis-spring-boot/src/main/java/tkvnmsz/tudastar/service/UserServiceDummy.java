package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.login.LoginData;
import tkvnmsz.tudastar.login.SignupData;
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
		
		user = new User(users.size(), "Idarav");
		user.setAdmin(true);
		users.add(user);
		
		user = new User(users.size(), "Loop");
		user.setLector(true);
		users.add(user);
		
		user = new User(users.size(), "Yuyupo");
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
		
		return User.UNKNOWN_USER;
	}

	@Override
	public boolean signup(SignupData registerData) {
		User user = new User(users.size(), registerData.getUsername());
		users.add(user);
		
		return true;
	}
}
