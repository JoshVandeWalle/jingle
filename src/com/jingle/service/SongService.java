package com.jingle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jingle.business.SongBusinessInterface;
import com.jingle.model.Song;
import com.jingle.util.RestDto;

/**
 * The Song service manages API behavior for songs
 * @author Josh Van de Walle
 *
 */
@RestController()
@RequestMapping("/api")
public class SongService {
	// business service used to enforce business rules and business logic
	SongBusinessInterface songBusinessService;

	// setter injection happens here
	@Autowired
	public void setSongBusinessService(SongBusinessInterface songBusinessService) {
		this.songBusinessService = songBusinessService;
	}

	// get all songs method
	@GetMapping("/retrieveAll")
	public RestDto<Song> handleRetrieveAll() {
		// use try catch to handle exceptions
		try {
			// pass control to business layer to retrieve all songs
			List<Song> songs = songBusinessService.getAllSongs();

			if (songs.size() > 0)
				// If all goes right, send the songs
				return new RestDto<Song>(200, "OK", songs);
			else
				// no songs found
				return new RestDto<Song>(404, "Songs not found", songs);
		}

		// handle exceptions here
		catch (Exception e) {
			return new RestDto<Song>(500, "Internal error", null);
		}
	}
}
