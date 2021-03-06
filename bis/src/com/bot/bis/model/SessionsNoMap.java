package com.bot.bis.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "Sessions")
public class SessionsNoMap implements Serializable{
	@Id @GeneratedValue
	private Long id;
	private String description;
	private Timestamp datadate;
	private String status;
	private Timestamp start_on;
	private Timestamp stop_at;
	private Timestamp updated_at;
	private String fix_ver;
	private Date created_at;
	private String disabled;
	private String sh_pid;
	private String bossa_pid;
	private String error_stop;
	private String users;
	private String approve_user;
	
	private String remark;
	
	@Transient
	private String datadate_s;
	@Transient
	private String start_on_s;
	@Transient
	private String stop_at_s;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getFix_ver() {
		return fix_ver;
	}
	public void setFix_ver(String fix_ver) {
		this.fix_ver = fix_ver;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getSh_pid() {
		return sh_pid;
	}
	public void setSh_pid(String sh_pid) {
		this.sh_pid = sh_pid;
	}
	public String getBossa_pid() {
		return bossa_pid;
	}
	public void setBossa_pid(String bossa_pid) {
		this.bossa_pid = bossa_pid;
	}
	public String getError_stop() {
		return error_stop;
	}
	public void setError_stop(String error_stop) {
		this.error_stop = error_stop;
	}
	public String getUsers() {
		return users;
	}
	public void setUsers(String users) {
		this.users = users;
	}
	public String getApprove_user() {
		return approve_user;
	}
	public void setApprove_user(String approve_user) {
		this.approve_user = approve_user;
	}
	
	public Timestamp getDatadate() {
		return datadate;
	}
	public void setDatadate(Timestamp datadate) {
		this.datadate = datadate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getStart_on() {
		return start_on;
	}
	public void setStart_on(Timestamp start_on) {
		this.start_on = start_on;
	}
	public Timestamp getStop_at() {
		return stop_at;
	}
	public void setStop_at(Timestamp stop_at) {
		this.stop_at = stop_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String getYyyy() {
		String yyyy = null;
		if(getDatadate() != null && !"".equals(getDatadate())) {
			//String tmpDate[] = getDatadate().split("-");//mysql
			//String tmpDate[] = getDatadate().split("/");//oracle
			String[] tmpDate = new String[2];
			
			if(getDatadate().toString().indexOf("-") > 0)
				tmpDate = getDatadate().toString().split("-");//mysql
			else if(getDatadate().toString().indexOf("/") > 0)
				tmpDate = getDatadate().toString().split("/");//oracle
			
			yyyy = tmpDate[0];
		}
		return yyyy;
	}
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}
	public String getMm() {
		String mm = null;
		if(getDatadate() != null && !"".equals(getDatadate())) {
			//String tmpDate[] = getDatadate().split("-");//mysql
			//String tmpDate[] = getDatadate().split("/");//oracle
			String[] tmpDate = new String[2];
			if(getDatadate().toString().indexOf("-") > 0)
				tmpDate = getDatadate().toString().split("-");//mysql
			else if(getDatadate().toString().indexOf("/") > 0)
				tmpDate = getDatadate().toString().split("/");//oracle
			
			if(tmpDate[1] != null) {
				mm = String.format("%02d", Integer.parseInt(tmpDate[1].split(" ")[0]));
				//mm = tmpDate[1];
			}
				
		}
		
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	
	public String getDd() {
		String dd = null;
		if(getDatadate() != null && !"".equals(getDatadate())) {
			//String tmpDate[] = getDatadate().split("-");
			//dd = tmpDate[2];
			String[] tmpDate = new String[2];
			if(getDatadate().toString().indexOf("-") > 0)
				tmpDate = getDatadate().toString().split("-");//mysql
			else if(getDatadate().toString().indexOf("/") > 0)
				tmpDate = getDatadate().toString().split("/");//oracle
			
			if(tmpDate[2] != null) {
				dd = String.format("%02d", Integer.parseInt(tmpDate[2].split(" ")[0]));
				//mm = tmpDate[1];
			}
		}
		
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}
	
	public String getRemark() {
		if(remark != null)
			return remark;
		else
			return "";
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	
}
