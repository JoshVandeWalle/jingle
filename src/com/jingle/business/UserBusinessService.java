package com.jingle.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jingle.data.CredentialsDataInterface;
import com.jingle.data.UserDataInterface;
import com.jingle.model.Credentials;
import com.jingle.model.User;

/**
 * @author Henry Harvey 
 * The UserBusinessService handles the business logic of the application involving users
 */

@Service
public class UserBusinessService implements UserBusinessInterface {

	UserDataInterface userDataService;

	CredentialsDataInterface credentialsDataService;

	@Autowired
	public void setUserDataService(UserDataInterface userDataService) {
		this.userDataService = userDataService;
	}

	@Autowired
	public void setCredentialsDataService(CredentialsDataInterface credentialsDataService) {
		this.credentialsDataService = credentialsDataService;
	}

	/**
	 * Take in a user. 
	 * Create credentials for user with credentialsDataService. 
	 * If not created, return -1.  
	 * Return the userDataService create method using user. 
	 * 
	 * @param user	user to register
	 * @return int	result
	 */
	public int registerUser(User user) {
		int credentials_id = credentialsDataService.create(user.getCredentials());

		if (credentials_id < 0) {
			return -1;
		}

		user.setCredentials_id(credentials_id);

		return userDataService.create(user);
	}

	/**
	 * Take in a user. 
	 * Select credentials for user with credentialsDataService. 
	 * If not selected, return null. 
	 * Set user's credentials. 
	 * Return the userDataService readByCredentialsId method using user. 
	 * 
	 * @param user	user to login
	 * @return int	result
	 */
	public User loginUser(User user) {

		Credentials credentials = credentialsDataService.readByUsernamePassword(user.getCredentials());

		if (credentials == null) {
			return null;
		}

		user.setCredentials(credentials);
		user.setCredentials_id(credentials.getId());

		return userDataService.readByCredentialsId(user);
	}
	
	/**
	 * Take in a user. 
	 * Set user equal to the userDataService read method using user.
	 * Set user's credentials  equal to the credentialsDataService read method using the user's credentials_id.
	 * 
	 * @param user	user to get
	 * @return User	result
	 */
	public User getUser(User user) {
		user = userDataService.read(user);
		user.setCredentials(credentialsDataService.read(new Credentials(user.getCredentials_id(), "", "")));
		
		return user;
	}

	/**
	 * Select all users with userDataService readAll. 
	 * For each user, set its credentials with credentialsDataService read. 
	 * Return all users. 
	 * 
	 * @return List	list of all users
	 */
	public List<User> getAllUsers() {

		List<User> users = userDataService.readAll();

		for (User user : users) {
			user.setCredentials(credentialsDataService.read(new Credentials(user.getCredentials_id(), "", "")));
		}

		return users;
	}

	/**
	 * Take in a user. 
	 * Update credentials for user with credentialsDataService. 
	 * If not updated, return 0. 
	 * Return the userDataService update method using user. 
	 * 
	 * @param user	user to update
	 * @return int	result
	 */
	public int editUser(User user) {

		if (credentialsDataService.update(user.getCredentials()) != 1 && userDataService.update(user) != 1) {
			return 0;
		}

		return 1;
	}

	/**
	 * Take in a user. 
	 * Delete credentials for user with credentialsDataService. 
	 * If not deleted, return 0. 
	 * Return the userDataService delete method using user. 
	 * 
	 * @param user	user to update
	 * @return int	result
	 */
	public int removeUser(User user) {

		if (credentialsDataService.delete(user.getCredentials()) != 1) {
			return 0;
		}

		return userDataService.delete(user);
	}

}
