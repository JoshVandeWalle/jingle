package com.jingle.data;

import java.util.List;

import com.jingle.model.User;

/**
 * @author Henry Harvey
 * The UserDataInterface establishes the required methods for UserDataService. 
 * It is used for Inversion of Control. 
 */

public interface UserDataInterface {

	public int create(User user);

	public User read(User user);

	public User readByCredentials(User user);

	public List<User> readAll();

	public int update(User user);

	public int delete(User user);
}
