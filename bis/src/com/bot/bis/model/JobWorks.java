package com.bot.bis.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Job_Works") 
public class JobWorks {
	
	@Id
	private String job_action;//@Column(name = "job_action")
	private String job_name;
	private Timestamp created_at;
	
	public String getJob_action() {
		return job_action;
	}
	public void setJob_action(String job_action) {
		this.job_action = job_action;
	}
	public String getJob_name() {
		return job_name;
	}
	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	
	
}
