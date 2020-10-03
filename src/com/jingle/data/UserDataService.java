package com.jingle.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jingle.model.Credentials;
import com.jingle.model.User;

public class UserDataService implements DataServiceInterface<User> {

	// return value for methods that do not return a User
	int result = 0;

	/**
	 * @see DataServiceInterface create
	 */
	public int create(User user) {
		/*Database db = new Database();
		Connection conn = null;

		// insert credentials
		String sql = "INSERT INTO credentials" + "(username, password)" + "VALUES (?,?)";

		// insert user
		String sql2 = "INSERT INTO users" + "(firstname, lastname, email, phone, credentials_ID)"
				+ "VALUES (?,?,?,?,?)";

		try {
			conn = db.getConnection();
			System.out.println("Connection Success!");
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, user.getCredentials().getUsername());
			stmt.setString(2, user.getCredentials().getPassword());

			int first = stmt.executeUpdate();

			if (first != 1) {
				result = -1;
				throw new SQLException("Creating user failed. One row not added for credentials.");
			}

			// get credentials row ID
			int credId;
			try (ResultSet rs = stmt.getGeneratedKeys()) {
				if (rs.next()) {
					credId = rs.getInt(1);
				} else {
					throw new SQLException("Creating user failed, no ID obtained.");
				}
			}

			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1, user.getFirstName());
			stmt2.setString(2, user.getLastName());
			stmt2.setString(3, user.getEmail());
			stmt2.setString(4, user.getPhone());
			stmt2.setInt(5, credId);
			int second = stmt2.executeUpdate();

			if (second != 1) {
				result = -2;
				throw new SQLException("Creating user failed. One row not added for user.");
			}
		} catch (java.sql.SQLException e) {
			throw new DatabaseException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (java.sql.SQLException e) {
					throw new DatabaseException(e);
				}
			}
		}
		return result;*/
		return 0;
	}
	
	/**
	 * not implemented
	 */
	public User read(User user) {
		return null;
	}

	
	/**
	 * Takes in a user
	 * Connects to the database
	 * Creates and executes a sql statement
	 * Sets a user equal to the result set
	 * Returns the user
	 * 
	 * @param user	user to find
	 * @return user	user that is found
	 */
	public User readByCredentials(User user) {
		/*Database db = new Database();
		Connection conn = null;

		String sql = "SELECT id " + "FROM credentials " + "WHERE username = ? AND password = ? " + "LIMIT 1";

		String sql2 = "SELECT * " + "FROM users " + "WHERE credentials_ID = ? " + "LIMIT 1";

		try {
			conn = db.getConnection();
			System.out.println("Connection Success!");
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getCredentials().getUsername());
			stmt.setString(2, user.getCredentials().getPassword());

			int credId = -1;
			ResultSet rs = stmt.executeQuery();
			if (rs.last()) {
				credId = rs.getInt(1);
			}
			else {
				user = null;
				throw new SQLException("Reading user failed. Could not find credentials.");
			}

			PreparedStatement stmt2 = conn.prepareStatement(sql2);
			stmt2.setInt(1, credId);
			ResultSet rs2 = stmt2.executeQuery();
			if (rs2.last()) {
				user = new User(rs2.getInt("id"), rs2.getString("firstname"), rs2.getString("lastname"),
						rs2.getString("email"), rs2.getString("phone"),
						new Credentials(user.getCredentials().getUsername(), user.getCredentials().getPassword()));
			}
			else {
				user = null;
				throw new SQLException("Reading user failed. Could not find user information.");
			}
			rs.close();
		} catch (java.sql.SQLException e) {
			throw new DatabaseException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (java.sql.SQLException e) {
					throw new DatabaseException(e);
				}
			}
		}
		return user;*/
		return new User();
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
