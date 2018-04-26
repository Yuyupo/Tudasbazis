package tkvnmsz.tudastar.login;

public class User {
	public static final User UNKNOWN_USER = new User(-1, "unknown");

	private int userId;
	private String username;
	private boolean loggedIn;
	private boolean admin;
	private boolean lector;

	public User(int userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}

	public User(User user) {
		super();
		username = user.username;
		loggedIn = user.loggedIn;
		admin = user.admin;
		lector = user.lector;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isLector() {
		return lector;
	}

	public void setLector(boolean lector) {
		this.lector = lector;
	}

}
