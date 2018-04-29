package tkvnmsz.tudastar.login;

import java.util.HashMap;
import java.util.Map;

public class User {
	public static final User UNKNOWN_USER = new User(-1, "unknown");

	private int userId;
	private String username;
	private boolean loggedIn;
	private boolean admin;
	private Map<Integer, Integer> lectoringLevelInCategory = new HashMap<>();
	private String institution;
	private String scientificDegree;

	public User(int userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
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

	public Map<Integer, Integer> getLectoringLevelInCategory() {
		return lectoringLevelInCategory;
	}

	public void setLectoringLevelInCategory(Map<Integer, Integer> lectoringLevelInCategory) {
		this.lectoringLevelInCategory = lectoringLevelInCategory;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getScientificDegree() {
		return scientificDegree;
	}

	public void setScientificDegree(String scientificDegree) {
		this.scientificDegree = scientificDegree;
	}

}
