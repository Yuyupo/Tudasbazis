package tkvnmsz.tudastar.login;

public interface UserService {
	/**
	 * Login the user with the given datas
	 * @param loginData
	 * @return the user, that logged in
	 */
	User login(LoginData loginData);
	
	/**
	 * Register user
	 * @param registerData
	 * @return
	 */
	boolean signup(SignupData registerData);

}