package com.jingle.business;

import com.jingle.data.UserDataService;
import com.jingle.model.User;

/**
 * @author Henry Harvey
 * The UserBusinessService handles the business logic of the application involving users
 */

public class UserBusinessService {

	/**
	 * Takes in a user
	 * Creates a UserDataService
	 * Returns the ds create method with user as parameter
	 * 
	 * @param user	user to register
	 * @return int	int result
	 */
	public int register(User user) {
		UserDataService ds = new UserDataService();
		return ds.create(user);
	}

	/**
	 * Takes in a user
	 * Creates a UserDataService
	 * Sets a new user equal to the ds readByCredentials method with user as parameter
	 * If new user is not equal to null, return 0
	 * Else, return -1
	 * 
	 * @param user	user to register
	 * @return int	int result
	 */
	public int login(User user) {
		UserDataService ds = new UserDataService();
		User foundUser = ds.readByCredentials(user);
		if (foundUser != null) {
			return 0;
		} else {
			return -1;
		}
	}

}
