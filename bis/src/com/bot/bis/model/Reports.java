package com.bot.bis.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reports {
	@Id @GeneratedValue
	private Long id;      
	
	private String name;
	private String description;
	private String rpt_file;
	private String type;
	private Timestamp created_at;
	private Timestamp updated_at;
	private String gen_mode;
	
	@ManyToOne( cascade={CascadeType.ALL }, fetch=FetchType.EAGER )
	@JoinColumn(name="category_id")  
	private ReportCategories reportCategories;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRpt_file() {
		return rpt_file;
	}
	public void setRpt_file(String rpt_file) {
		this.rpt_file = rpt_file;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGen_mode() {
		return gen_mode;
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
	public void setGen_mode(String gen_mode) {
		this.gen_mode = gen_mode;
	}
	public ReportCategories getReportCategories() {
		return reportCategories;
	}
	public void setReportCategories(ReportCategories reportCategories) {
		this.reportCategories = reportCategories;
	}
	
	
}
