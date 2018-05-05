package tkvnmsz.tudastar.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tkvnmsz.tudastar.login.LoginData;
import tkvnmsz.tudastar.login.SignupData;
import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.login.UserService;
import tkvnmsz.tudastar.service.database.ListDataFetcher;
import tkvnmsz.tudastar.service.database.OracleDatabase;
import tkvnmsz.tudastar.service.database.Parser;
import tkvnmsz.tudastar.service.database.SimpleDataFetcher;

@Service
public class UserServiceDummy implements UserService {

	@Override
	public User login(LoginData loginData) {
		SimpleDataFetcher<UserIdAndPassword> passFetcher = new SimpleDataFetcher<>(resultSet -> {
			UserIdAndPassword userIdAndPassword = new UserIdAndPassword();
			userIdAndPassword.password = resultSet.getString(1);
			userIdAndPassword.id = resultSet.getInt(2);
			return userIdAndPassword;
		});
		OracleDatabase.request("SELECT PASSWORD, ID FROM W_USER WHERE USERNAME = ?",
				stmt -> stmt.setString(1, loginData.getUsername()), passFetcher);
		UserIdAndPassword data = passFetcher.getData();
		if (data != null) {
			String password = data.password;
			int id = data.id;

			if (loginData.getPassword().equals(password)) {
				User loggedUser = ReadDataFromDatabase(id);
				return loggedUser;
			}
		}

		return User.UNKNOWN_USER;
	}

	private class UserIdAndPassword {
		public String password;
		public int id;
	}

	@Override
	public boolean signup(SignupData registerData) {
		SimpleDataFetcher<User> userFetcher = new SimpleDataFetcher<>(Parser::User);
		OracleDatabase.request("SELECT * FROM W_USER WHERE USERNAME = ?",
				stmt -> stmt.setString(1, registerData.getUsername()), userFetcher);
		boolean exist = userFetcher.getData() != null;

		if (!exist) {
			SimpleDataFetcher<Integer> idFetcher = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
			OracleDatabase.request("SELECT MAX(ID) FROM W_USER", idFetcher);
			Integer data = idFetcher.getData();

			OracleDatabase.execute(
					"Insert into H675212.W_USER (ID,USERNAME,PASSWORD,ADMIN,INSTITUTION,DEGREE) values (?,?,?,?,?,?)",
					stmt -> {
						int index = 0;
						stmt.setInt(++index, data + 1);
						stmt.setString(++index, registerData.getUsername());
						stmt.setString(++index, registerData.getPassword());
						stmt.setInt(++index, 0);
						stmt.setString(++index, "");
						stmt.setString(++index, "");

					});
		}

		return !exist;
	}

	@Override
	public User getById(int id) {
		SimpleDataFetcher<User> userFetcher = new SimpleDataFetcher<>(Parser::User);
		OracleDatabase.request("SELECT * FROM W_USER WHERE ID = ?", stmt -> stmt.setInt(1, id), userFetcher);
		return userFetcher.getData();
	}

	@Override
	public Map<Integer, User>  listUsers() {
		ListDataFetcher<User> userFetcher = new ListDataFetcher<>(Parser::User);
		OracleDatabase.request("SELECT * FROM W_USER", userFetcher);
				
		List<User> data = userFetcher.getData();
		data.forEach(u->fillLectoringCategories(u));
		return data.stream().collect(Collectors.toMap(User::getUserId, u-> u));
	}

	@Override
	public List<Integer> listLectorsOfCategory(int categoryId) {

		ListDataFetcher<Integer> userFetcher = new ListDataFetcher<>(resultset -> resultset.getInt(1));
		OracleDatabase.request(
				"SELECT USER_ID FROM W_LECTORATE_CATEGORY WHERE CATEGORY_ID = ? ORDER BY LANGUAGE_LEVEL DESC",
				stmt -> stmt.setInt(1, categoryId), userFetcher);
		return userFetcher.getData();

	}

	@Override
	public boolean isReviewableCategory(int categoryId) {

		boolean result = listLectorsOfCategory(categoryId).isEmpty();
		System.out.println("reviewable cat: " +categoryId + " res: " + result);
		return !result;

	}

	@Override
	public void unsetLectoring(int userId, int categoryId) {

		OracleDatabase.execute("DELETE FROM W_LECTORATE_CATEGORY WHERE USER_ID = ? AND CATEGORY_ID = ?", stmt -> {

			stmt.setInt(1, userId);
			stmt.setInt(2, categoryId);

		});

	}

	@Override
	public void setLectoring(int userId, int categoryId, int level) {

		// Insert into H675212.W_LECTORATE_CATEGORY
		// (ID,USER_ID,CATEGORY_ID,LANGUAGE_LEVEL) values ('1','1','1','2');

		SimpleDataFetcher<Integer> idFetcher = new SimpleDataFetcher<>(resultSet -> resultSet.getInt(1));
		OracleDatabase.request("SELECT MAX(ID) FROM W_LECTORATE_CATEGORY", idFetcher);
		Integer data = idFetcher.getData();

		unsetLectoring(userId, categoryId);

		OracleDatabase.execute(
				"Insert into H675212.W_LECTORATE_CATEGORY (ID,USER_ID,CATEGORY_ID,LANGUAGE_LEVEL) values (?,?,?,?)",
				stmt -> {
					int index = 0;
					stmt.setInt(++index, data + 1);
					stmt.setInt(++index, userId);
					stmt.setInt(++index, categoryId);
					stmt.setInt(++index, level);
				});
	}

	@Override
	public void setInstitution(int userId, String institution) {

		OracleDatabase.execute("UPDATE H675212.W_USER SET INSTITUTION = ? WHERE ID = ?", stmt -> {
			int index = 0;
			stmt.setString(++index, institution);
			stmt.setInt(++index, userId);

		});

	}

	@Override
	public void setScientificDegree(int userId, String scientificDegree) {
		OracleDatabase.execute("UPDATE H675212.W_USER SET DEGREE = ? WHERE ID = ?", stmt -> {
			int index = 0;
			stmt.setString(++index, scientificDegree);
			stmt.setInt(++index, userId);

		});
	}

	@Override
	public User ReadDataFromDatabase(int userId) {
		User user = getById(userId);
		user.setLoggedIn(true);

		
		fillLectoringCategories(user);
		

		return user;
	}

	private void fillLectoringCategories(User user) {
		ListDataFetcher<LectoringInCategory> lectoringFetcher = new ListDataFetcher<>(resultSet -> {
			LectoringInCategory lectoring = new LectoringInCategory();
			lectoring.categoryId = resultSet.getInt(1);
			lectoring.level = resultSet.getInt(2);
			return lectoring;
		});
		OracleDatabase.request("SELECT CATEGORY_ID, LANGUAGE_LEVEL FROM W_LECTORATE_CATEGORY WHERE USER_ID = ?",
				stmt -> stmt.setInt(1, user.getUserId()), lectoringFetcher);
		List<LectoringInCategory> lectoringList = lectoringFetcher.getData();
		if (lectoringList != null) {
			for (LectoringInCategory lectoringInCategory : lectoringList) {
				user.getLectoringLevelInCategory().put(lectoringInCategory.categoryId, lectoringInCategory.level);
			}
		}
	}

	private class LectoringInCategory {
		public int categoryId;
		public int level;
	}
}
