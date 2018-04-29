package tkvnmsz.tudastar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		user.setInstitution("Szegedi tudomanyegyetemmmm");
		user.setScientificDegree("Dr.");
		users.add(user);

		user = new User(users.size(), "Loop");
		user.getLectoringLevelInCategory().put(0, 1);
		user.setInstitution("Világuralom KFT.");
		user.setScientificDegree("Nagyúr");
		users.add(user);

		user = new User(users.size(), "Yuyupo");
		user.setInstitution("VR ftw nyrt");
		user.getLectoringLevelInCategory().put(0, 2);
		user.setScientificDegree("Mágus");
		users.add(user);
	}

	@Override
	public User login(LoginData loginData) {
		if (loginData.getPassword().equals("pass")) {
			User user = users.stream().filter(u -> u.getUsername().equalsIgnoreCase(loginData.getUsername()))
					.findFirst().orElse(null);
			if (user != null) {
				User loggedUser = ReadDataFromDatabase(user.getUserId());
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

	@Override
	public User getById(int id) {
		return users.get(id);
	}

	@Override
	public List<User> listUsers() {
		return users;
	}

	@Override
	public List<Integer> listLectorsOfCategory(int categoryId) {
		List<Integer> lectors = users.stream().filter(u -> u.getLectoringLevelInCategory().containsKey(categoryId))
				.sorted((u1, u2) -> u2.getLectoringLevelInCategory().get(categoryId)
						- u1.getLectoringLevelInCategory().get(categoryId)).map(u -> u.getUserId()).collect(Collectors.toList());
		
		
		return lectors;
	}

	@Override
	public boolean isReviewableCategory(int categoryId) {
		boolean isThereAnyLector = users.stream().anyMatch(u -> u.getLectoringLevelInCategory().containsKey(categoryId));
		return isThereAnyLector;
	}

	@Override
	public void unsetLectoring(int userId, int categoryId) {
		User user = getById(userId);
		user.getLectoringLevelInCategory().remove(categoryId);
		
	}

	@Override
	public void setLectoring(int userId, int categoryId, int level) {
		User user = getById(userId);
		user.getLectoringLevelInCategory().put(categoryId, level);
	}

	@Override
	public void setInstitution(int userId, String institution) {
		User user = getById(userId);
		System.out.println("Set to: " + institution);
		user.setInstitution(institution);
	}

	@Override
	public void setScientificDegree(int userId, String scientificDegree) {
		User user = getById(userId);
		user.setScientificDegree(scientificDegree);
	}

	@Override
	public User ReadDataFromDatabase(int userId) {
		User user = getById(userId);
		
		User loggedUser = new User(user.getUserId(), user.getUsername());
		loggedUser.setAdmin(user.isAdmin());
		loggedUser.setLoggedIn(true);
		loggedUser.setLectoringLevelInCategory(user.getLectoringLevelInCategory());
		loggedUser.setInstitution(user.getInstitution());
		loggedUser.setScientificDegree(user.getScientificDegree());
		return loggedUser;
	}
}
