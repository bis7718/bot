package com.bot.bis.model;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Departments {
	
	private String code;
	private String name;
	private Timestamp created_at;
	private Timestamp updated_at;
	private String overseas_flag;
	
	@OneToOne ( cascade={CascadeType.ALL } )
	@JoinColumn(name="id")  
	private Users users;
	
	@SuppressWarnings("unchecked")
	@ManyToMany( cascade={CascadeType.ALL }, fetch=FetchType.EAGER )
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(
			name="file_departments",
			joinColumns = @JoinColumn(name="DEPARTMENT_ID", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name="UPLOAD_FILE_ID", referencedColumnName="id", nullable = true)
	)  
	private List<UploadFiles> uploadFilesList = Collections.EMPTY_LIST;
	
	@Id //@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public String getOverseas_flag() {
		return overseas_flag;
	}
	public void setOverseas_flag(String overseas_flag) {
		this.overseas_flag = overseas_flag;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public List<UploadFiles> getUploadFilesList() {
		return uploadFilesList;
	}
	public void setUploadFilesList(List<UploadFiles> uploadFilesList) {
		this.uploadFilesList = uploadFilesList;
	}
}

