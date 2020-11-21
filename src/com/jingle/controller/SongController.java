package com.jingle.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	 * initialize the Model and View container
	 * provide view name
	 * pass control to business layer to get all the songs in the database
	 * pass the list of songs to the view for display
	 * return the Model and View container so the framework can display the right view and data
	 * 
	 * @return ModelAndView the container with the correct view and data
	 */
	@GetMapping("/browse")
	public ModelAndView handleDisplayBrowseAllSongs() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("song_browseAll");
			mav.addObject("songs", songBusinessService.getAllSongs());
			mav.addObject("viewSong", new Song());
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * This method manages behavior related to displaying the user page.
	 * initialize the Model and View container
	 * provide view name
	 * provided the Song object to be created
	 * return the Model and View container so the framework can display the right view and data
	 * 
	 * @return ModelAndView the container with the correct view and data
	 */

	@GetMapping("/upload")
	public ModelAndView handleDisplayUploadForm() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("song_uploadForm");
			mav.addObject("song",
					new Song(-1, "", ((User) httpSession.getAttribute("sessionUser")).getCredentials().getUsername(),
							"", "", "", "", -1));
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * This method manages behavior related to adding a new song
	 * set song ID based on session user
	 * pass control to business layer to add song to database and catch result flag
	 * if the song wasn't added successfully
	 * 
	 * @param song the new song
	 * @return ModelAndView the container with the correct view and data
	 */
	@PostMapping("/handleUpload")
	public ModelAndView handleUploadSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		try {
			if (result.hasErrors()) {
				return this.handleDisplayUploadForm();
			}
			song.setUsers_id(((User) httpSession.getAttribute("sessionUser")).getId());
			if (songBusinessService.uploadSong(song) != 1) {
				ModelAndView mav = new ModelAndView();
				mav.setViewName("error");
				return mav;
			}
			return this.handleDisplayBrowseMyUploads();
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	@GetMapping("/uploads")
	public ModelAndView handleDisplayBrowseMyUploads() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("song_browseMyUploads");
			mav.addObject("songs", songBusinessService.getSongsByUsersId(
					new Song(-1, "", "", "", "", "", "", ((User) httpSession.getAttribute("sessionUser")).getId())));
			mav.addObject("viewSong", new Song());
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	@PostMapping("/song")
	public ModelAndView handleDisplaySong(@ModelAttribute("song") Song song) {
		try {
			ModelAndView mav = new ModelAndView();
			mav.addObject("song", song);
			if (((User) httpSession.getAttribute("sessionUser")).getId() == song.getUsers_id()) {
				mav.setViewName("song_viewMyUpload");
			} else {
				mav.setViewName("song_view");
			}
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	@PostMapping("/edit")
	public ModelAndView handleDisplayEditForm(@ModelAttribute("song") Song song) {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("song_editForm");
			mav.addObject("song", song);
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	@PostMapping("/handleEdit")
	public ModelAndView handleEditSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		try {
			if (result.hasErrors()) {
				return this.handleDisplayEditForm(song);
			}
			if (songBusinessService.editSong(song) != 1) {
				ModelAndView mav = new ModelAndView();
				mav.setViewName("error");
				return mav;
			}
			return this.handleDisplayBrowseMyUploads();
		}

		catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	@PostMapping("/delete")
	public ModelAndView handleDisplayDeleteForm(@ModelAttribute("song") Song song) {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("song_deleteForm");
			mav.addObject("song", song);
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	@PostMapping("/handleDelete")
	public ModelAndView handleDeleteSong(@ModelAttribute("song") Song song) {
		try {
			if (songBusinessService.removeSong(song) != 1) {
				ModelAndView mav = new ModelAndView();
				mav.setViewName("error");
				return mav;
			}
			return this.handleDisplayBrowseMyUploads();
		}

		catch (Exception e) {
			return new ModelAndView("error");
		}
	}

}
