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
	 * Takes in a song. 
	 * Inserts song. 
	 * Return number of rows added. 
	 * 
	 * @param user	song to create
	 * @return int	result
	 */
	public int create(Song song) {
		String sql = "INSERT INTO songs (title, artist, album, year, length, genre, users_id) VALUES (:title, :artist, :album, :year, :length, :genre, :users_id)";

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(song);

		return namedParameterJdbcTemplate.update(sql, params);
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

	/**
	 * Selects all songs. 
	 * Loops through results. 
	 * Adds each song to list. 
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
