package tkvnmsz.tudastar.service;

import java.util.List;

import tkvnmsz.tudastar.login.LoginData;
import tkvnmsz.tudastar.login.SignupData;
import tkvnmsz.tudastar.login.User;
import tkvnmsz.tudastar.login.UserService;

public class UserServiceOracle implements UserService{

	@Override
	public User login(LoginData loginData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User ReadDataFromDatabase(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean signup(SignupData registerData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getById(int id) {
		//SELECT * FROM W_USER WHERE ID = 1
		return null;
	}

	@Override
	public List<User> listUsers() {
		//SELECT * FROM W_USER
		return null;
	}

	@Override
	public List<Integer> listLectorsOfCategory(int categoryId) {
		//SELECT * FROM W_LECTORATE_CATEGORY WHERE CATEGORY_ID = 1 ORDER BY LANGUAGE_LEVEL
		return null;
	}

	@Override
	public boolean isReviewableCategory(int categoryId) {
		
		return listLectorsOfCategory(categoryId).isEmpty()?false:true;
	}

	@Override
	public void unsetLectoring(int userId, int categoryId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLectoring(int userId, int categoryId, int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setInstitution(int userId, String institution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScientificDegree(int userId, String scientificDegree) {
		// TODO Auto-generated method stub
		
	}

}
