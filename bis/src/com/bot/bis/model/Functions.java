package com.bot.bis.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Functions implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	@Column(name="\"DESC\"")//oracle
	//@Column(name="`DESC`")//mysql
	private String desc;
	private Timestamp created_at;
	private Timestamp updated_at;
	private String sym;
	private String url;
	
	@Id //@GeneratedValue
	private Long id;
	
//	@ManyToMany(mappedBy = "functions")
//	private List<Groups> groups = Collections.EMPTY_LIST;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	public String getSym() {
		return sym;
	}
	public void setSym(String sym) {
		this.sym = sym;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}

