package com.jingle.business;

import com.jingle.model.User;

public interface UserBusinessInterface {
	public int register(User user);
	public User login(User user);

}
