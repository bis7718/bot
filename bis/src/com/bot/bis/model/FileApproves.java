package com.bot.bis.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "File_Approves") 
public class FileApproves implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1008115582251683677L;

	@Id //@GeneratedValue
	private Long id;      
	
	private String action_type; 
	private String files_name;  
	private String temp_name;     
	private String upload_user; 
	private String upload_name; 
	private Timestamp upload_at;   
	private String approve_user;
	private String approve_name;
	private Timestamp approve_at;  
	private String status;
	
	@ManyToOne( cascade={CascadeType.ALL }, fetch=FetchType.EAGER )
	@JoinColumn(name="file_id")  
	private UploadFiles uploadFiles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAction_type() {
		return action_type;
	}
	public void setAction_type(String action_type) {
		this.action_type = action_type;
	}
	public String getFiles_name() {
		return files_name;
	}
	public void setFiles_name(String files_name) {
		this.files_name = files_name;
	}
	public String getTemp_name() {
		return temp_name;
	}
	public void setTemp_name(String temp_name) {
		this.temp_name = temp_name;
	}
	public String getUpload_user() {
		return upload_user;
	}
	public void setUpload_user(String upload_user) {
		this.upload_user = upload_user;
	}
	public String getUpload_name() {
		return upload_name;
	}
	public void setUpload_name(String upload_name) {
		this.upload_name = upload_name;
	}
	public String getApprove_user() {
		return approve_user;
	}
	public void setApprove_user(String approve_user) {
		this.approve_user = approve_user;
	}
	public String getApprove_name() {
		return approve_name;
	}
	public void setApprove_name(String approve_name) {
		this.approve_name = approve_name;
	}
	
	
	
	public Timestamp getUpload_at() {
		return upload_at;
	}
	public void setUpload_at(Timestamp upload_at) {
		this.upload_at = upload_at;
	}
	public Timestamp getApprove_at() {
		return approve_at;
	}
	public void setApprove_at(Timestamp approve_at) {
		this.approve_at = approve_at;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UploadFiles getUploadFiles() {
		return uploadFiles;
	}
	public void setUploadFiles(UploadFiles uploadFiles) {
		this.uploadFiles = uploadFiles;
	} 
	
	@Transient
	private String yyyy;
	
	@Transient
	private String mm;
	
	public String getYyyy() {
		String yyyy = null;
		if(this.upload_at != null && !"".equals(this.upload_at)) {
			String tmpDate[] = this.upload_at.toString().split("-");
			yyyy = tmpDate[0];
		}
		return yyyy;
	}
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}
	public String getMm() {
		String mm = null;
		if(this.upload_at != null && !"".equals(this.upload_at)) {
			String tmpDate[] = this.upload_at.toString().split("-");
			mm = tmpDate[1];
		}
		
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
}
