package com.jingle.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.jingle.model.User;

/**
 * @author Henry Harvey 
 * The UserDataService modifies and retrieves data from the users and credentials databases
 */

public class UserDataService implements UserDataInterface {

	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	 * Take in a user. 
	 * Insert user. 
	 * Return number of rows affected.
	 * 
	 * @param user	user to create
	 * @return int	rows affected
	 */
	public int create(User user) {
		String sql = "INSERT INTO users (firstname, lastname, email, phone, credentials_id) VALUES (:firstName, :lastName, :email, :phone, :credentials_id)";

		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
	}

	/**
	 * Take in a user. 
	 * Select user using user id. 
	 * If not selected, return null. 
	 * Return selected user. 
	 * 
	 * @param user 	user to read
	 * @return User found user
	 */
	public User read(User user) {
		String sql = "SELECT * FROM users WHERE id = :id LIMIT 1";

		SqlRowSet srs = namedParameterJdbcTemplate.queryForRowSet(sql, new BeanPropertySqlParameterSource(user));

		if (!srs.last()) {
			return null;
		}

		return new User(srs.getInt("id"), srs.getString("firstname"), srs.getString("lastname"), srs.getString("email"), srs.getString("phone"), srs.getInt("credentials_id"));
	}

	/**
	 * Take in a user. 
	 * Select user using credentials id. 
	 * If not selected, return null. 
	 * Return selected user. 
	 * 
	 * @param user 	user to read
	 * @return User found user
	 */
	public User readByCredentialsId(User user) {
		String sql = "SELECT * FROM users WHERE credentials_id = :credentials_id LIMIT 1";

		SqlRowSet srs = namedParameterJdbcTemplate.queryForRowSet(sql, new BeanPropertySqlParameterSource(user));

		if (!srs.last()) {
			return null;
		}

		return new User(srs.getInt("id"), srs.getString("firstname"), srs.getString("lastname"), srs.getString("email"), srs.getString("phone"), user.getCredentials());
	}

	/**
	 * Select all users. 
	 * Loop through results. 
	 * Add each user to list. 
	 * Return list. 
	 * 
	 * @return List 	list of all users
	 */
	public List<User> readAll() {
		String sql = "SECELCT * FROM users";

		SqlRowSet srs = namedParameterJdbcTemplate.queryForRowSet(sql, EmptySqlParameterSource.INSTANCE);

		List<User> result = new ArrayList<User>();

		while (srs.next()) {
			User user = new User(srs.getInt("id"), srs.getString("firstname"), srs.getString("lastname"), srs.getString("email"), srs.getString("phone"), srs.getInt("credentials_id"));
			result.add(user);
		}

		return result;
	}

	/**
	 * Take in a user. 
	 * Update user. 
	 * Return number of rows affected. 
	 * 
	 * @param user	user to update
	 * @return int	rows affected
	 */
	public int update(User user) {
		String sql = "UPDATE users SET firstname = :firstName, lastname = :lastName, email = :email, phone = :phone WHERE id = :id LIMIT 1";

		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
	}

	/**
	 * Take in a user. 
	 * Delete user. 
	 * Return number of rows affected. 
	 * 
	 * @param user	user to delete
	 * @return int	rows affected
	 */
	public int delete(User user) {
		String sql = "DELETE FROM users WHERE id = :id LIMIT 1";

		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
	}

}
