package com.bot.bis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "File_Down_Lists") 
public class FileDownLists {
	@Id //@GeneratedValue
	private Long id;   
	
	private String file_names;
	private String enable;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFile_names() {
		return file_names;
	}
	public void setFile_names(String file_names) {
		this.file_names = file_names;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}  
	
	
}
