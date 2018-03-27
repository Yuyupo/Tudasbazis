package tkvnmsz.tudastar.login;

public interface UserService {
	/**
	 * Login the user with the given datas
	 * @param loginData
	 * @return
	 */
	User login(LoginData loginData);
	
	/**
	 * Register user
	 * @param registerData
	 * @return
	 */
	boolean register(RegisterData registerData);

}