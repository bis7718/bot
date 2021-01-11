package com.bot.bis.model;

public class BatchCriterion {
	private Long id;
	private String yyyy;
	private String mm;
	private String disabled;
	private String input;
	private String ftp;
	private String fix;
	
	private String isNoMap;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getYyyy() {
		return yyyy;
	}
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getFtp() {
		return ftp;
	}
	public void setFtp(String ftp) {
		this.ftp = ftp;
	}
	public String getFix() {
		return fix;
	}
	public void setFix(String fix) {
		this.fix = fix;
	}
	public String getIsNoMap() {
		return isNoMap;
	}
	public void setIsNoMap(String isNoMap) {
		this.isNoMap = isNoMap;
	}
	
}
