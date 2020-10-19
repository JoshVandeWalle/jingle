package com.jingle.business;

import java.util.List;

import com.jingle.data.SongDataService;
import com.jingle.model.Song;

/**
 * @author Henry Harvey
 * The SongBusinessService handles the business logic of the application involving songs
 */

public class SongBusinessService implements SongBusinessInterface {

	/**
	 * @see SongBusinessInterface addSong
	 */
	public int addSong(Song song) {
		SongDataService ds = new SongDataService();
		return ds.create(song);
	}

	/**
	 * @see SongBusinessInterface searchSongsByTitle
	 */
	public List<Song> searchSongsByTitle(Song song) {
		SongDataService ds = new SongDataService();
		return ds.readByTitle(song);
	}

	/**
	 * @see SongBusinessInterface getAllSongs
	 */
	public List<Song> getAllSongs() {
		SongDataService ds = new SongDataService();
		return ds.readAll();
	}

	/**
	 * @see SongBusinessInterface editSong
	 */
	public int editSong(Song song) {
		SongDataService ds = new SongDataService();
		return ds.update(song);
	}

	/**
	 * @see SongBusinessInterface removeSong
	 */
	public int removeSong(Song song) {
		SongDataService ds = new SongDataService();
		return ds.delete(song);
	}

}
