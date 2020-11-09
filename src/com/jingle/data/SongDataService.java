package com.jingle.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.jingle.model.Song;

/**
 * @author Henry Harvey 
 * The SongDataService modifies and retrieves data from the songs database
 */

public class SongDataService implements SongDataInterface {

	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	 * Take in a song. 
	 * Insert song. 
	 * Return number of rows added. 
	 * 
	 * @param song	song to create
	 * @return int	result
	 */
	public int create(Song song) {
		String sql = "INSERT INTO songs (title, artist, album, year, length, genre, users_id) VALUES (:title, :artist, :album, :year, :length, :genre, :users_id)";

		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(song));
	}

	/**
	 * Take in a song. 
	 * Select song using id. 
	 * If not selected, return null. 
	 * Return selected song. 
	 * 
	 * @param song 	song to read
	 * @return Song found song
	 */
	public Song read(Song song) {
		String sql = "SELECT * FROM songs WHERE id = :id LIMIT 1";

		SqlRowSet srs = namedParameterJdbcTemplate.queryForRowSet(sql, new BeanPropertySqlParameterSource(song));

		if (!srs.last()) {
			return null;
		}

		return new Song(srs.getInt("id"), srs.getString("title"), srs.getString("artist"), srs.getString("album"),
				srs.getString("year"), srs.getString("length"), srs.getString("genre"), srs.getInt("users_id"));
	}

	public List<Song> readByUsersId(Song song) {
		String sql = "SELECT * FROM songs WHERE users_id = :users_id";

		SqlRowSet srs = namedParameterJdbcTemplate.queryForRowSet(sql, new BeanPropertySqlParameterSource(song));

		List<Song> result = new ArrayList<Song>();

		while (srs.next()) {
			result.add(new Song(srs.getInt("id"), srs.getString("title"), srs.getString("artist"),
					srs.getString("album"), srs.getString("year"), srs.getString("length"), srs.getString("genre"),
					srs.getInt("users_id")));
		}
		
		return result;
	}

	/**
	 * not implemented
	 */
	public List<Song> readByTitle(Song song) {
		return null;
	}

	/**
	 * Select all songs. 
	 * Loop through results. 
	 * Add each song to list. 
	 * Return list. 
	 * 
	 * @return List<Song>	List of all songs
	 */
	public List<Song> readAll() {
		String sql = "SELECT * FROM songs";

		SqlRowSet srs = namedParameterJdbcTemplate.queryForRowSet(sql, EmptySqlParameterSource.INSTANCE);

		List<Song> result = new ArrayList<Song>();

		while (srs.next()) {
			result.add(new Song(srs.getInt("id"), srs.getString("title"), srs.getString("artist"),
					srs.getString("album"), srs.getString("year"), srs.getString("length"), srs.getString("genre"),
					srs.getInt("users_id")));
		}

		return result;
	}

	/**
	 * Take in a song. 
	 * Update song. 
	 * Return number of rows affected. 
	 * 
	 * @param song	song to update
	 * @return int	result
	 */
	public int update(Song song) {
		String sql = "UPDATE songs SET title = :title, artist = :artist, album = :album, year = :year, length = :length, genre = :genre WHERE id = :id LIMIT 1";

		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(song));
	}

	/**
	 * Take in a song. 
	 * Delete song. 
	 * Return number of rows affected. 
	 * 
	 * @param song	song to delete
	 * @return int	result
	 */
	public int delete(Song song) {
		String sql = "DELETE FROM songs WHERE id = :id LIMIT 1";

		return namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(song));
	}

}
