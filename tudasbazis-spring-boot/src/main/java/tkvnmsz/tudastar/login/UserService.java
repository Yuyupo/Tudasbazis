package tkvnmsz.tudastar.login;

import java.util.List;
import java.util.Map;

public interface UserService {
	/**
	 * Login the user with the given datas
	 * @param loginData
	 * @return the user, that logged in
	 */
	User login(LoginData loginData);
	
	/**
	 * Reads data from database
	 * @param userId
	 * @return
	 */
	User ReadDataFromDatabase(int userId);
	
	/**
	 * Register user
	 * @param registerData
	 * @return
	 */
	boolean signup(SignupData registerData);
	
	/**
	 * get user by his id
	 * @param id
	 * @return user with hte given id
	 */
	User getById(int id);
	
	
	/**
	 * list all users
	 * @return list of users
	 */
	Map<Integer, User> listUsers();
	
	/**
	 * list all lectors of a category, orderd by the level
	 * @param categoryId
	 * @return list of lectors
	 */
	List<Integer> listLectorsOfCategory(int categoryId);
	
	/**
	 * Is a category reviewable -> is there any lector for that category
	 * @param categoryId
	 * @return is it reviewable
	 */
	boolean isReviewableCategory(int categoryId);
	
	/**
	 * Unsets a users lectoring of a category
	 * @param userId
	 * @param categoryId
	 */
	void unsetLectoring(int userId, int categoryId);
	
	/**
	 * Sets a users lectoring of a category to a level
	 * @param userId
	 * @param categoryId
	 * @param level
	 */
	void setLectoring(int userId, int categoryId, int level);
	
	/**
	 * Set instituion
	 * @param userId
	 * @param institution
	 */
	void setInstitution(int userId, String institution);
	
	/**
	 * Sets scientific degree
	 */
	void setScientificDegree(int userId, String scientificDegree);
}