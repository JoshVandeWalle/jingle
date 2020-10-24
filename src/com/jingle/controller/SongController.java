package com.jingle.controller;

import java.util.ArrayList;
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

/**
 * 
 * @author Josh Van de Walle
 * 
 * the SongController manages behavior related to songs
 *
 */
@Controller
@RequestMapping("/song")
public class SongController {
	
	SongBusinessInterface songService;
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	public void setSongService(SongBusinessInterface songService)
	{
		this.songService = songService;
	}
	
	@GetMapping("/")
	public ModelAndView handleRetrieveAll()
	{
		try 
		{
			// initialize the Model and View container 
			ModelAndView mav = new ModelAndView();
			// provide view name
			mav.setViewName("songIndex");
			
			// pass control to business layer to get all the songs in the database
			List<Song> songList = songService.getAllSongs();
			
			// pass the list of songs to the view for display
			mav.addObject("list", songList);
			
			// return the Model and View container so the framework can display the right view and data
			return mav;
		}
		
		catch (Exception e)
		{
			return new ModelAndView("error");
		}
	}
	
	@PostMapping("/handleUpload")
	public ModelAndView handleUploadSong(@Valid @ModelAttribute("song") Song song)
	{
		try
		{
			System.out.println(httpSession.getAttribute("userId"));
			song.setUsers_id(Integer.parseInt(httpSession.getAttribute("userId").toString()));
			
			// pass control to business layer to add song to database and catch result flag
			int result = songService.addSong(song);
			
			// if the song wasn't added successfully
			if (result != 0)
			{
				ModelAndView mav = new ModelAndView();
				mav.setViewName("error");
				return mav;
			}
			
			return this.handleRetrieveAll();
		}
		
		catch (Exception e)
		{
			return new ModelAndView("error");
		}
	}
	
	@GetMapping("/handleDisplayUploadPage")
	public ModelAndView handleDisplayUploadPage()
	{
		try 
		{
			// initialize the Model and View container 
			ModelAndView mav = new ModelAndView();
			// provide view name
			mav.setViewName("songUpload");
			
			// provided the Song object to be created
			mav.addObject("song", new Song());
			
			// return the Model and View container so the framework can display the right view and data
			return mav;
		}
		
		catch (Exception e)
		{
			return new ModelAndView("error");
		}
	}
	
	
}
