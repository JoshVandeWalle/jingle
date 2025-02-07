package com.jingle.business;

import java.util.List;

/**
 * @author Henry Harvey
 * The SongBusinessInterface establishes the required methods for SongBusinessService. 
 * It is used for Inversion of Control. 
 */

import com.jingle.model.Song;

/**
 * @author Henry Harvey
 * The SongBusinessInterface establishes the required methods for SongBusinessService. 
 * It is used for Inversion of Control. 
 */

public interface SongBusinessInterface {

	public int uploadSong(Song song);

	public Song getSong(Song song);

	public List<Song> getSongsByUsersId(Song song);

	public List<Song> getAllSongs();

	public int editSong(Song song);

	public int removeSong(Song song);

}
