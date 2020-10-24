package com.jingle.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.jingle.data.DataAccessInterface;
import com.jingle.data.UserDataService;
import com.jingle.model.User;

/**
 * @author Henry Harvey
 * The UserBusinessService handles the business logic of the application involving users
 */

public class UserBusinessService implements UserBusinessInterface {

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
	 * Returns the ds readByCredentials method with user as parameter
	 * 
	 * @param user	user to login
	 * @return User	user that logged in
	 */
	public User login(User user) {
		UserDataService ds = new UserDataService();
		return ds.readByCredentials(user);
	}

}
