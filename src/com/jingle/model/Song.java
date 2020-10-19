package com.jingle.model;

import javax.validation.constraints.Size;

/**
 * @author Henry Harvey
 * The Song model is the product object model of the application
 */

public class Song {
	private int id;

	@Size(min = 1, max = 60, message = "Title must be between 1 and 60 characters long.")
	private String title;

	private int artist_id;

	@Size(min = 1, max = 60, message = "Album must be between 1 and 60 characters long.")
	private String album;

	@Size(min = 4, max = 4, message = "Year must be 4 characters long.")
	private String year;

	@Size(min = 5, max = 5, message = "Length must be 5 characters long.")
	private String length;

	@Size(min = 1, max = 30, message = "Genre must be between 1 and 30 characters long.")
	private String genre;

	// Constructor with all fields
	public Song(int id, String title, int artist_id, String album, String year, String length, String genre) {
		this.id = id;
		this.title = title;
		this.artist_id = artist_id;
		this.album = album;
		this.year = year;
		this.length = length;
		this.genre = genre;
	}

	// Constructor with all fields except id's
	public Song(String title, String album, String year, String length, String genre) {
		this.id = -1;
		this.title = title;
		this.artist_id = -1;
		this.album = album;
		this.year = year;
		this.length = length;
		this.genre = genre;
	}

	// Default constructor
	public Song() {
		this.id = -1;
		this.title = "title";
		this.artist_id = -1;
		this.album = "album";
		this.year = "0000";
		this.length = "00:00";
		this.genre = "genre";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", title=" + title + ", artist_id=" + artist_id + ", album=" + album + ", year="
				+ year + ", length=" + length + ", genre=" + genre + "]";
	}

}
