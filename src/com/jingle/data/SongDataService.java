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
 * @author Henry Harvey
 * The SongDataService modifies and retrieves data from the songs database
 */

public class SongDataService implements DataServiceInterface<Song> {

	/**
	 * @see DataServiceInterface create
	 */
	public int create(Song song) {
		return 0;
	}
	
	/**
	 * not implemented
	 */
	public Song read(Song song) {
		return null;
	}

	public List<Song> readByTitle(Song song) {
		List<Song> result = new ArrayList<Song>();
		result.add(new Song(song.getTitle(), "", "2020", "00:10", ""));
		return result;
	}
	
	public List<Song> readAll() {
		List<Song> result = new ArrayList<Song>();
		result.add(new Song());
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
