package tkvnmsz.tudastar.login;

public interface UserService {
	static final User UnknownUser = new User("unknown");  
	
	User login(LoginData loginData);
	boolean register(RegisterData registerData);

}