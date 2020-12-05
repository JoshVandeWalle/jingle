package com.jingle.data;

import java.util.List;

import com.jingle.model.Song;

/**
 * @author Henry Harvey
 * The SongDataInterface establishes the required methods for SongDataService. 
 * It is used for Inversion of Control. 
 */

public interface SongDataInterface {

	public int create(Song song);

	public Song read(Song song);

	public List<Song> readByUsersId(Song song);

	public List<Song> readAll();

	public int update(Song song);

	public int delete(Song song);
}
