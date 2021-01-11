package com.bot.bis.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "AP_BIS_AUDIT_LOG") 
public class BisApAuditLogs {
	@Id //@GeneratedValue
	private Long id;      
	
	private String user_id;
	private String source_id;
	private String destination_id;
	private String procedure_name;
	private String schema_name;
	private String table_name;
	private String action_type;
	private String sql_script;
	private String sql_status;
	private String sql_rows;
	private String sql_result;
	private String ss_seq;
	private Timestamp created_at;
	
	@Transient
	private String yyyy;
	
	@Transient
	private String mm;
	
	@Transient
	private String dd;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSource_id() {
		return source_id;
	}
	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}
	public String getDestination_id() {
		return destination_id;
	}
	public void setDestination_id(String destination_id) {
		this.destination_id = destination_id;
	}
	public String getProcedure_name() {
		return procedure_name;
	}
	public void setProcedure_name(String procedure_name) {
		this.procedure_name = procedure_name;
	}
	public String getSchema_name() {
		return schema_name;
	}
	public void setSchema_name(String schema_name) {
		this.schema_name = schema_name;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getAction_type() {
		return action_type;
	}
	public void setAction_type(String action_type) {
		this.action_type = action_type;
	}
	public String getSql_script() {
		return sql_script;
	}
	public void setSql_script(String sql_script) {
		this.sql_script = sql_script;
	}
	public String getSql_status() {
		return sql_status;
	}
	public void setSql_status(String sql_status) {
		this.sql_status = sql_status;
	}
	public String getSql_rows() {
		return sql_rows;
	}
	public void setSql_rows(String sql_rows) {
		this.sql_rows = sql_rows;
	}
	public String getSql_result() {
		return sql_result;
	}
	public void setSql_result(String sql_result) {
		this.sql_result = sql_result;
	}
	public String getSs_seq() {
		return ss_seq;
	}
	public void setSs_seq(String ss_seq) {
		this.ss_seq = ss_seq;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	
	//
	public String getYyyy() {
		String yyyy = null;
		if(this.created_at != null && !"".equals(this.created_at)) {
			String tmpDate[] = this.created_at.toString().split("-");
			yyyy = tmpDate[0];
		}
		return yyyy;
	}
	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}
	public String getMm() {
		String mm = null;
		if(this.created_at != null && !"".equals(this.created_at)) {
			String tmpDate[] = this.created_at.toString().split("-");
			mm = tmpDate[1];
		}
		
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}

	public String getDd() {
		String dd = null;
		if(this.created_at != null && !"".equals(this.created_at)) {
			String tmpDate[] = this.created_at.toString().split("-");
			dd = tmpDate[2].split(" ")[0];
		}
		
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
