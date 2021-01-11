package com.bot.bis.model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

public class FileInfo {
	private String fileName;
	private String fileSize;
	private Date fileUpatetime;
	private String filePath;
	private InputStream fileInputStream;
	private ArrayList<String> fileContent;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public Date getFileUpatetime() {
		return fileUpatetime;
	}
	public void setFileUpatetime(Date fileUpatetime) {
		this.fileUpatetime = fileUpatetime;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public InputStream getFileInputStream() {
		return fileInputStream;
	}
	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}
	public ArrayList<String> getFileContent() {
		return fileContent;
	}
	public void setFileContent(ArrayList<String> fileContent) {
		this.fileContent = fileContent;
	}	
	
}
