package com.jingle.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	 * Takes in a user. 
	 * Inserts credentials and retrieves generated key. 
	 * If not created, return -1. 
	 * Inserts user using generated key. 
	 * If not created, return -2. 
	 * Return 1. 
	 * 
	 * @param user	user to create
	 * @return int	result
	 */
	public int create(User user) {
		// insert credentials
		String sql1 = "INSERT INTO credentials (username, password) VALUES (:username, :password)";

		BeanPropertySqlParameterSource params1 = new BeanPropertySqlParameterSource(user.getCredentials());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		int result1 = namedParameterJdbcTemplate.update(sql1, params1, keyHolder);

		if (result1 != 1) {
			return -1;
		}

		// insert user
		String sql2 = "INSERT INTO users (firstname, lastname, email, phone, credentials_id) VALUES (:firstName, :lastName, :email, :phone, :credentials_id)";

		user.setCredentials_id(keyHolder.getKey().intValue());
		BeanPropertySqlParameterSource params2 = new BeanPropertySqlParameterSource(user);

		int result2 = namedParameterJdbcTemplate.update(sql2, params2);

		if (result2 != 1) {
			return -2;
		}

		return 1;
	}

	/**
	 * not implemented
	 */
	public User read(User user) {
		return null;
	}

	/**
	 * Takes in a user with credentials. 
	 * Selects credentials id from credential username and password. 
	 * If not selected, return null. 
	 * Selects user using credentials id. 
	 * If not selected, return null. 
	 * Return selected user. 
	 * 
	 * @param user 	user to read
	 * @return User found user
	 */
	public User readByCredentials(User user) {
		String sql1 = "SELECT id FROM credentials WHERE username = :username AND password = :password LIMIT 1";

		BeanPropertySqlParameterSource params1 = new BeanPropertySqlParameterSource(user.getCredentials());

		SqlRowSet srs1 = namedParameterJdbcTemplate.queryForRowSet(sql1, params1);

		if (!srs1.last()) {
			return null;
		}

		String sql2 = "SELECT * FROM users WHERE credentials_id = :credentials_id LIMIT 1";

		user.setCredentials_id(srs1.getInt("id"));
		BeanPropertySqlParameterSource params2 = new BeanPropertySqlParameterSource(user);

		SqlRowSet srs2 = namedParameterJdbcTemplate.queryForRowSet(sql2, params2);

		if (!srs2.last()) {
			return null;
		}

		return new User(srs2.getInt("id"),srs2.getString("firstname"), srs2.getString("lastname"), srs2.getString("email"),
				srs2.getString("phone"), user.getCredentials());
	}

	/**
	 * not implemented
	 */
	public List<User> readAll() {
		return null;
	}

	/**
	 * not implemented
	 */
	public int update(User user) {
		return 0;
	}

	/**
	 * not implemented
	 */
	public int delete(User user) {
		return 0;
	}

}
