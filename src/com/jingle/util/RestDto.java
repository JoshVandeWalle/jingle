package com.jingle.util;

import java.util.List;

public class RestDto<T> {
	private int code;
	private String message;
	private List<T> data;
	public RestDto(int code, String message, List<T> data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public RestDto() {
		super();
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public List<T> getData() {
		return data;
	}
	
	

}
