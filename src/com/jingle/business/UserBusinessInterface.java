package com.jingle.business;

import java.util.List;

import com.jingle.model.User;

/**
 * @author Henry Harvey
 * The UserBusinessInterface establishes the required methods for UserBusinessService. 
 * It is used for Inversion of Control. 
 */

public interface UserBusinessInterface {

	public int registerUser(User user);

	public User loginUser(User user);

	public List<User> getAllUsers();

	public int editUser(User user);

	public int removeUser(User user);

}
