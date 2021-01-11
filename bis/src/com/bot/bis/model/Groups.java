package com.bot.bis.model;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SuppressWarnings(value={"unchecked"})
public class Groups {
	private String name;
	
	//@Column(name="`DESC`")//mysql
	@Column(name="\"DESC\"")//oracle
	private String desc;
	private Timestamp created_at;
	private Timestamp updated_at;
	private String sym;
	private Long created_by;
	
	@Transient //@Transient
	private List<Long> functionsIdList = Collections.EMPTY_LIST;
	
	@ManyToMany( cascade={CascadeType.ALL }, fetch=FetchType.EAGER )
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(
			name="group_functions",
			joinColumns = @JoinColumn(name="group_id", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name="function_id", referencedColumnName="id")
	)  
	//private List<Groups> functionsList = new ArrayList<Groups>();
	private List<Functions> functionsList = Collections.EMPTY_LIST;
	
	//@ManyToMany( cascade={CascadeType.ALL }, fetch=FetchType.EAGER )
	//@ManyToMany( cascade={CascadeType.ALL }, fetch=FetchType.EAGER, mappedBy="groupsList")
	//@ManyToMany( cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.EAGER, mappedBy="groupsList")
	@ManyToMany(fetch=FetchType.EAGER )
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(
			name="user_groups",
			joinColumns = @JoinColumn(name="group_id", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName="id")
	)  
	//@ManyToMany(targetEntity=Users.class) 
	private List<Users> usersList = Collections.EMPTY_LIST;
	
	@Id //@GeneratedValue
	private Long id;
	
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
	public Long getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}
	public List<Functions> getFunctionsList() {
		return functionsList;
	}
	public void setFunctionsList(List<Functions> functionsList) {
		this.functionsList = functionsList;
	}
	public List<Users> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}
	public List<Long> getFunctionsIdList() {
		return functionsIdList;
	}
	public void setFunctionsIdList(List<Long> functionsIdList) {
		this.functionsIdList = functionsIdList;
	}	
}
