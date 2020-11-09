package com.jingle.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jingle.data.SongDataInterface;
import com.jingle.model.Song;

/**
 * @author Henry Harvey 
 * The SongBusinessService handles the business logic of the application involving songs
 */

@Service
public class SongBusinessService implements SongBusinessInterface {

	SongDataInterface songDataService;

	@Autowired
	public void setSongDataService(SongDataInterface songDataService) {
		this.songDataService = songDataService;
	}

	/**
	 * Takes in a song. 
	 * Returns the songDataService create method with song as the parameter. 
	 * 
	 * @param song	song to upload
	 * @return int	result
	 */
	public int uploadSong(Song song) {
		return songDataService.create(song);
	}

	/**
	 * Takes in a song. 
	 * Returns the songDataService readByUsersId method with song as the parameter. 
	 * 
	 * @param 	song		song with users_id to search
	 * @return 	List<Song>	list of results
	 */
	public List<Song> getSongsByUsersId(Song song) {
		return songDataService.readByUsersId(song);
	}

	/**
	 * Takes in a song. 
	 * Returns the songDataService readByTitle method with song as the parameter. 
	 * 
	 * @param 	song		song with title to search
	 * @return 	List<Song>	list of results
	 */
	public List<Song> getSongsByTitle(Song song) {
		return songDataService.readByTitle(song);
	}

	/**
	 * Returns the songDataService readAll method. 
	 * 
	 * @return List<Song>	list of all songs
	 */
	public List<Song> getAllSongs() {
		return songDataService.readAll();
	}

	/**
	 * Takes in a song. 
	 * Returns the songDataService update method with song as the parameter. 
	 * 
	 * @param 	song	song to edit
	 * @return 	int		result
	 */
	public int editSong(Song song) {
		return songDataService.update(song);
	}

	/**
	 * Takes in a song. 
	 * Returns the songDataService delete method with song as the parameter. 
	 * 
	 * @param 	song	song to delete
	 * @return 	int		result
	 */
	public int removeSong(Song song) {
		return songDataService.delete(song);
	}

}
