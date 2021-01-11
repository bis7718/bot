package com.bot.bis.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Action_Approves") 
public class ActionApproves implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id //@GeneratedValue
	private Long id;      
	
	private String action_type;
	private String params;      
	private String apply_user;  
	private String apply_name;  
	private Timestamp apply_at;    
	private String approve_user;
	private String approve_name;
	private Timestamp approve_at;  
	private String status;
	
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
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getApply_user() {
		return apply_user;
	}
	public void setApply_user(String apply_user) {
		this.apply_user = apply_user;
	}
	public String getApply_name() {
		return apply_name;
	}
	public void setApply_name(String apply_name) {
		this.apply_name = apply_name;
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
	
	public Timestamp getApply_at() {
		return apply_at;
	}
	public void setApply_at(Timestamp apply_at) {
		this.apply_at = apply_at;
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
	
	@Transient
	private String yyyy;
	
	@Transient
	private String mm;
	
	public String getYyyy() {
		String yyyy = null;
		if(this.apply_at != null && !"".equals(this.apply_at)) {
			String tmpDate[] = this.apply_at.toString().split("-");
			yyyy = tmpDate[0];
		}
		return yyyy;
	}
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}
	public String getMm() {
		String mm = null;
		if(this.apply_at != null && !"".equals(this.apply_at)) {
			String tmpDate[] = this.apply_at.toString().split("-");
			mm = tmpDate[1];
		}
		
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
}
