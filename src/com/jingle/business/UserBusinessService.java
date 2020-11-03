package com.jingle.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jingle.data.UserDataInterface;
import com.jingle.model.User;

/**
 * @author Henry Harvey 
 * The UserBusinessService handles the business logic of the application involving users
 */

@Service
public class UserBusinessService implements UserBusinessInterface {

	UserDataInterface userDataService;

	@Autowired
	public void setUserDataService(UserDataInterface userDataService) {
		this.userDataService = userDataService;
	}

	/**
	 * Takes in a user. 
	 * Returns the userDataService create method with user as the parameter.
	 * 
	 * @param user	user to register
	 * @return int	result
	 */
	public int registerUser(User user) {
		return userDataService.create(user);
	}

	/**
	 * Takes in a user. 
	 * Returns the userDataService readByCredentials method with user as the parameter. 
	 * 
	 * @param user 	user to login
	 * @return User user that logged in
	 */
	public User loginUser(User user) {
		return userDataService.readByCredentials(user);
	}

	/**
	 * Returns the userDataService readAll method.
	 * 
	 * @return List<User>	list of all users
	 */
	public List<User> getAllUsers() {
		return userDataService.readAll();
	}

	/**
	 * Takes in a user. 
	 * Returns the userDataService update method with user as the parameter. 
	 * 
	 * @param user	user to edit
	 * @return int	result
	 */
	public int editUser(User user) {
		return userDataService.update(user);
	}

	/**
	 * Takes in a user. 
	 * Returns the userDataService delete method with user as the parameter. 
	 * 
	 * @param user	user to remove
	 * @return int	result
	 */
	public int removeUser(User user) {
		return userDataService.delete(user);
	}

}
