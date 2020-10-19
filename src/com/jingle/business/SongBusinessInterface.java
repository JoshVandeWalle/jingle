package com.jingle.business;

import java.util.List;

/**
 * @author Henry Harvey
 * The SongBusinessInterface establishes the required methods for the song business service
 * It is used for Inversion of Control
 */

import com.jingle.model.Song;

public interface SongBusinessInterface {

	/**
	 * Takes in a song. Creates a SongDataService. Returns the ds create method with
	 * song as parameter.
	 * 
	 * @param song song to add
	 * @return int int result
	 */
	public int addSong(Song song);

	/**
	 * Takes in a song. Creates a SongDataService. Returns the ds readByTitle method
	 * with song as parameter.
	 * 
	 * @param song song with title to search
	 * @return List<Song> list of results
	 */
	public List<Song> searchSongsByTitle(Song song);

	/**
	 * Creates a SongDataService. Returns the ds readAll method.
	 * 
	 * @return List<Song> list of results
	 */
	public List<Song> getAllSongs();

	/**
	 * Takes in a song. Creates a SongDataService. Returns the ds update method with
	 * song as parameter.
	 * 
	 * @param song song to edit
	 * @return int int result
	 */
	public int editSong(Song song);

	/**
	 * Takes in a song. Creates a SongDataService. Returns the ds delete method with
	 * song as parameter.
	 * 
	 * @param song song to delete
	 * @return int int result
	 */
	public int removeSong(Song song);

}
