package com.jingle.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.jingle.model.Credentials;

/**
 * @author Henry Harvey 
 * The CredentialsDataService modifies and retrieves data from the credentials database
 */

public class CredentialsDataService implements CredentialsDataInterface {

	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	 * Take in a credentials. 
	 * Insert credentials and retrieves generated key. 
	 * If not created, return -1. 
	 * Return generated key. 
	 * 
	 * @param credentials	credentials to create
	 * @return int			generated key
	 */
	public int create(Credentials credentials) {
		String sql = "INSERT INTO credentials (username, password) VALUES (:username, :password)";

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(credentials);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		int result = namedParameterJdbcTemplate.update(sql, params, keyHolder);

		if (result != 1) {
			return -1;
		}

		return keyHolder.getKey().intValue();
	}

	/**
	 * Take in a credentials. 
	 * Select credentials using credentials id. 
	 * If not selected, return null. 
	 * Return selected credentials. 
	 * 
	 * @param credentials 	credentials to read
	 * @return Credentials 	found credentials
	 */
	public Credentials read(Credentials credentials) {
		String sql = "SELECT * FROM credentials WHERE id = :id LIMIT 1";

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(credentials);

		SqlRowSet srs = namedParameterJdbcTemplate.queryForRowSet(sql, params);

		if (!srs.last()) {
			return null;
		}

		return new Credentials(srs.getInt("id"), srs.getString("username"), srs.getString("password"));
	}

	/**
	 * Take in a credentials. 
	 * Select credentials using credentials username and password. 
	 * If not selected, return null. 
	 * Return selected credentials. 
	 * 
	 * @param credentials 	credentials to read
	 * @return Credentials 	found credentials
	 */
	public Credentials readByUsernamePassword(Credentials credentials) {
		String sql = "SELECT * FROM credentials WHERE username = :username AND password = :password LIMIT 1";

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(credentials);

		SqlRowSet srs = namedParameterJdbcTemplate.queryForRowSet(sql, params);

		if (!srs.last()) {
			return null;
		}

		return new Credentials(srs.getInt("id"), srs.getString("username"), srs.getString("password"));
	}

	/**
	 * Select all credentials. 
	 * Loops through results. 
	 * Add each credentials to list. 
	 * Return list. 
	 * 
	 * @return List<Credentials> 	list of all credentials
	 */
	public List<Credentials> readAll() {
		String sql = "SECELCT * FROM credentials";

		SqlRowSet srs = namedParameterJdbcTemplate.queryForRowSet(sql, EmptySqlParameterSource.INSTANCE);

		List<Credentials> result = new ArrayList<Credentials>();

		while (srs.next()) {
			Credentials credentials = new Credentials(srs.getInt("id"), srs.getString("username"),
					srs.getString("password"));
			result.add(credentials);
		}

		return result;

	}

	/**
	 * Take in a credentials. 
	 * Update credentials. 
	 * Return number of rows affected. 
	 * 
	 * @param credentials	credentials to update
	 * @return int			result
	 */
	public int update(Credentials credentials) {
		String sql = "UPDATE credentials SET username = :username, password = :password WHERE id = :id LIMIT 1";

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(credentials);

		return namedParameterJdbcTemplate.update(sql, params);
	}

	/**
	 * Take in a credentials. 
	 * Delete credentials. 
	 * Return number of rows affected. 
	 * 
	 * @param credentials	credentials to delete
	 * @return int			result
	 */
	public int delete(Credentials credentials) {
		String sql = "DELETE FROM credentials WHERE id = :id LIMIT 1";

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(credentials);

		return namedParameterJdbcTemplate.update(sql, params);
	}

}
