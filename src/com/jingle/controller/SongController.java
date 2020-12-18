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
import com.jingle.model.SessionData;
import com.jingle.model.Song;
import com.jingle.model.User;

/**
 * @author Josh Van de Walle
 * The SongController manages behavior related to songs
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
	 * Redirects to upload page.
	 * 
	 * @return ModelAndView	upload page + song mav
	 */
	@GetMapping("/upload")
	public ModelAndView handleDisplayUploadForm() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("song_uploadForm");
			mav.addObject("song", new Song(-1, "", ((SessionData) httpSession.getAttribute("sessionData")).getUsername(), "", "", "", "", -1));
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Handles upload and redirects to uploads.
	 * 
	 * @param song 			Song to be created
	 * @param result 		the validation result
	 * @return ModelAndView	uploads page + list of songs + song mav
	 */
	@PostMapping("/handleUpload")
	public ModelAndView handleUploadSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		try {
			if (result.hasErrors()) {
				return this.handleDisplayUploadForm();
			}
			song.setUsers_id(((SessionData) httpSession.getAttribute("sessionData")).getUsers_id());
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

	/**
	 * Redirects to uploads.
	 * 
	 * @return ModelAndView	uploads page + list of songs + song mav
	 */
	@GetMapping("/uploads")
	public ModelAndView handleDisplayBrowseMyUploads() {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("song_browseMyUploads");
			mav.addObject("songs", songBusinessService.getSongsByUsersId(new Song(-1, "", "", "", "", "", "", ((SessionData) httpSession.getAttribute("sessionData")).getUsers_id())));
			mav.addObject("viewSong", new Song());
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Redirects to browse page.
	 * 
	 * @return ModelAndView	browse page + list of songs + song mav
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
	 * Redirects to song page.
	 * 
	 * @param song 			Song to view
	 * @return ModelAndView	view song + song mav
	 */
	@GetMapping("/song")
	public ModelAndView handleDisplaySong(@ModelAttribute("song") Song song) {
		try {
			song = songBusinessService.getSong(song);
			ModelAndView mav = new ModelAndView();
			mav.addObject("song", song);
			mav.addObject("user", new User());
			mav.setViewName("song_view");
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Redirects to edit page.
	 * 
	 * @param song 			Song to edit
	 * @return ModelAndView	edit page + song mav
	 */
	@GetMapping("/edit")
	public ModelAndView handleDisplayEditForm(@ModelAttribute("song") Song song) {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("song_editForm");
			mav.addObject("song", songBusinessService.getSong(song));
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Handles edit and redirects to uploads.
	 * 
	 * @param song 			song to edit
	 * @param result 		the validation result
	 * @return ModelAndView	uploads page + list of songs + song mav
	 */
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

	/**
	 * Redirects to delete page.
	 * 
	 * @param song 			Song to delete
	 * @return ModelAndView	delete page + song mav
	 */
	@GetMapping("/delete")
	public ModelAndView handleDisplayDeleteForm(@ModelAttribute("song") Song song) {
		try {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("song_deleteForm");
			mav.addObject("song", songBusinessService.getSong(song));
			return mav;
		} catch (Exception e) {
			return new ModelAndView("error");
		}
	}

	/**
	 * Handles delete and redirects to uploads.
	 * 
	 * @param song 			song to delete
	 * @return ModelAndView	uploads page + list of songs + song mav
	 */
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
