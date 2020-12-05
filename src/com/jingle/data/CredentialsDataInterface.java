package com.jingle.data;

import java.util.List;

import com.jingle.model.Credentials;

/**
 * @author Henry Harvey
 * The CredentialsDataInterface establishes the required methods for CredentialsDataService. 
 * It is used for Inversion of Control. 
 */

public interface CredentialsDataInterface {

	public int create(Credentials credentials);

	public Credentials read(Credentials credentials);

	public Credentials readByUsernamePassword(Credentials credentials);

	public List<Credentials> readAll();

	public int update(Credentials credentials);

	public int delete(Credentials credentials);
}
