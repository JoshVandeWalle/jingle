package com.jingle.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jingle.model.Song;

/**
 * @author Henry Harvey The SongDataService modifies and retrieves data from the
 *         songs database
 */

public class SongDataService implements DataAccessInterface<Song> {

	/**
	 * @see DataAccessInterface create
	 */
	public int create(Song song) {
		int result = 0;
		Database db = new Database();
		Connection conn = null;

		String sql = "INSERT INTO songs (title, artist, album, year, length, genre, users_id) VALUES (?,?,?,?,?,?,?)";

		try {
			conn = db.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, song.getTitle());
			stmt.setString(2, song.getArtist());
			stmt.setString(3, song.getAlbum());
			stmt.setString(4, song.getYear());
			stmt.setString(5, song.getLength());
			stmt.setString(6, song.getGenre());
			stmt.setInt(7, song.getUsers_id());

			if (stmt.executeUpdate() != 1) {
				result = -1;
				throw new SQLException("Creating song failed.");
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
		return result;
	}

	/**
	 * not implemented
	 */
	public Song read(Song song) {
		return null;
	}

	/**
	 * not implemented
	 */
	public List<Song> readByTitle(Song song) {
		return null;
	}

	public List<Song> readAll() {
		List<Song> result = new ArrayList<Song>();
		Database db = new Database();
		Connection conn = null;

		String sql = "SELECT * FROM songs";

		try {
			conn = db.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				result.add(new Song(rs.getInt("id"), rs.getString("title"), rs.getString("artist"),
						rs.getString("album"), rs.getString("year"), rs.getString("length"), rs.getString("genre"),
						rs.getInt("users_id")));
			}
			rs.close();
		} catch (SQLException e) {
			throw new DatabaseException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new DatabaseException(e);
				}
			}
		}
		return result;
	}

	/**
	 * not implemented
	 */
	public int update(Song song) {
		return 0;
	}

	/**
	 * not implemented
	 */
	public int delete(Song song) {
		return 0;
	}

}
