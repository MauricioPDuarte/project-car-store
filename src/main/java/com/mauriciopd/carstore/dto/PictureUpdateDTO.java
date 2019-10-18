package com.mauriciopd.carstore.dto;

import java.io.Serializable;

public class PictureUpdateDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private boolean thumbnail;
	
	
	public PictureUpdateDTO() {
	}

	public PictureUpdateDTO(Integer id, boolean thumbnail) {
		super();
		this.id = id;
		this.thumbnail = thumbnail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(boolean thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	

	
}
