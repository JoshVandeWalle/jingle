package com.jingle.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jingle.business.SongBusinessInterface;
import com.jingle.model.Song;
import com.jingle.model.User;

/**
 * @author Josh Van de Walle
 *         the SongController manages behavior related to songs
 */

@Controller
@RequestMapping("/song")
public class SongController {

	@Autowired
	private HttpSession httpSession;

	SongBusinessInterface songBusinessService;

	@Autowired
	public void setSongBusinessService(SongBusinessInterface songBusinessService) {
		this.songBusinessService = songBusinessService;
	}

	/**
	 * this method manages behavior related to displaying all songs
	 * 
	 * @return ModelAndView the container with the correct view and data
	 */
	@GetMapping("/browse")
	public ModelAndView handleRetrieveAll() {
		try {
			// initialize the Model and View container
			ModelAndView mav = new ModelAndView();
			// provide view name
			mav.setViewName("songBrowse");

			// pass control to business layer to get all the songs in the database
			List<Song> songList = songBusinessService.getAllSongs();

			// pass the list of songs to the view for display
			mav.addObject("songs", songList);

			// return the Model and View container so the framework can display the right
			// view and data
			return mav;
		}

		catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * This method manages behavior related to displaying the user page.
	 * 
	 * @return ModelAndView the container with the correct view and data
	 */

	@GetMapping("/handleDisplayUploadPage")
	public ModelAndView handleDisplayUploadPage() {
		try {
			// initialize the Model and View container
			ModelAndView mav = new ModelAndView();
			// provide view name
			mav.setViewName("songUpload");

			// provided the Song object to be created
			Song song = new Song();
			song.setArtist(((User) httpSession.getAttribute("sessionUser")).getCredentials().getUsername());
			mav.addObject("song", song);

			// return the Model and View container so the framework can display the right
			// view and data
			return mav;
		}

		catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * This method manages behavior related to adding a new song
	 * 
	 * @param song the new song
	 * @return ModelAndView the container with the correct view and data
	 */
	@PostMapping("/handleUpload")
	public ModelAndView handleUploadSong(@Valid @ModelAttribute("song") Song song) {
		try {
			// set song ID based on session user
			song.setUsers_id(((User) httpSession.getAttribute("sessionUser")).getId());

			// check if the user provided an artist
			/*
			 * if (song.getArtist() == null || song.getArtist().equals("")) { // use the
			 * username as default song.setArtist(((User)
			 * httpSession.getAttribute("sessionUser")).getCredentials().getUsername()); }
			 */

			// pass control to business layer to add song to database and catch result flag
			int result = songBusinessService.uploadSong(song);

			// if the song wasn't added successfully
			if (result != 1) {
				ModelAndView mav = new ModelAndView();
				mav.setViewName("error");
				return mav;
			}

			return this.handleRetrieveAll();
		}

		catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	@GetMapping("/uploads")
	public ModelAndView handleDisplayUploadsPage() {
		return new ModelAndView("uploads", "songs", songBusinessService.getSongsByUsersId(
				new Song(-1, "", "", "", "", "", "", ((User) httpSession.getAttribute("sessionUser")).getId())));
	}

	@PostMapping("/song")
	public ModelAndView handleDisplaySong(@ModelAttribute("song") Song song) {
		if (((User) httpSession.getAttribute("sessionUser")).getId() == song.getUsers_id()) {
			return new ModelAndView("ownersSong", "song", song);
		} else {
			System.out.println(song);
			return new ModelAndView("song", "song", song);
		}
	}

}
