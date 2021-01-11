package com.bot.bis.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Jobs {
	@Id //@GeneratedValue
	private Long id;

	private String object_type;
	private Long session_id;
	private Long parent_id;
	private String status;
	private String name;
	private String description;
	private String action;
	private String command;

	private Timestamp start_on;
	private Timestamp stop_at;
	private String result;
	private Timestamp updated_at;
	private String enable;
	
	@Transient
	private String job_type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getObject_type() {
		return object_type;
	}
	public void setObject_type(String object_type) {
		this.object_type = object_type;
	}
	public Long getSession_id() {
		return session_id;
	}
	public void setSession_id(Long session_id) {
		this.session_id = session_id;
	}
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
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
	public String getJob_type() {
		if("SQLLDR".equals(action))
			job_type = "è³‡æ?™æª¢? ¸??æ®µ";
		else if("BAD".equals(command))
			job_type = "?”¢??ŸBAD.taræª”æ??";
		else if("LOG".equals(command))
			job_type = "?”¢??ŸLOG.taræª”æ??";
		else if("PDF".equals(command))
			job_type = "?”¢??ŸPDF.taræª”æ??";
		else if("EXEC".equals(action) && "PKG".equals(command.substring(0,3)))
			job_type = "è³‡æ?™åŒ¯?•´??æ®µ";
		else if("EXEC".equals(action) && "USP".equals(command.substring(0,3)) && (command.length()<13||!"USP_CREATE_MA".equals(command.substring(0,13))))
			job_type = "ä¸»ç®¡æ©Ÿé?œå ±è¡¨é?è¼¯";
		else if("EXEC".equals(action) && "USP".equals(command.substring(0,3)) && (command.length()>=13&&"USP_CREATE_MA".equals(command.substring(0,13))))
			job_type = "ç®¡ç?†æ?§å ±è¡¨é?è¼¯";
		else if("CMD".equals(action) && "REPORT".equals(command))
			job_type = "?”¢??Ÿå…¨è¡Œå ±è¡?";//?”¢??Ÿä¸»ç®¡æ?Ÿé?œå ±è¡?
		else if("CMD".equals(action) && "MAREPORT".equals(command))
			job_type = "?”¢??Ÿå?†è?Œå ±è¡?";//?”¢??Ÿç®¡??†æ?§å ±è¡?
		else
			job_type = "";
		
		return job_type;
	}
	public void setJob_type(String job_type) {
		this.job_type = job_type;
	}
	
}
