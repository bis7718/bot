package com.bot.bis.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "Audit_Logs") 
public class AuditLogs implements Serializable{
	@Id //@GeneratedValue
	private Long id;      
	
	private String ip;
	private String user_id;
	private String controller;
	private String action;
	private String params;
	private String status;
	private Timestamp updated_at;
	private String companydomain;
	private String sqlcommand;
	
	@Transient
	private String yyyy;
	
	@Transient
	private String mm;
	
	@Transient
	private String dd;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public String getCompanydomain() {
		return companydomain;
	}
	public void setCompanydomain(String companydomain) {
		this.companydomain = companydomain;
	}
	public String getSqlcommand() {
		return sqlcommand;
	}
	public void setSqlcommand(String sqlcommand) {
		this.sqlcommand = sqlcommand;
	}

	//
	public String getYyyy() {
		String yyyy = null;
		if(this.updated_at != null && !"".equals(this.updated_at)) {
			String tmpDate[] = this.updated_at.toString().split("-");
			yyyy = tmpDate[0];
		}
		return yyyy;
	}
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}
	public String getMm() {
		String mm = null;
		if(this.updated_at != null && !"".equals(this.updated_at)) {
			String tmpDate[] = this.updated_at.toString().split("-");
			mm = tmpDate[1];
		}
		
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}

	public String getDd() {
		String dd = null;
		if(this.updated_at != null && !"".equals(this.updated_at)) {
			String tmpDate[] = this.updated_at.toString().split("-");
			dd = tmpDate[2].split(" ")[0];
		}
		
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	
	
}
