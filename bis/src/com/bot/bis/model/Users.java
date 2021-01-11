package com.bot.bis.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="USERS")
@SuppressWarnings(value={"unchecked", "serial"})
public class Users implements Serializable{
	
	//Log Factory
	//Logger logger = LogManager.getLogger(Users.class);
	
	private String code;
	private String name;
	private String is_valid;
	private Timestamp created_at;
	private Timestamp updated_at;
	private String companydomain;
	private String pass;
	
	@Id //@GeneratedValue 
	private Long id;
	
	@Transient
	private Long departmentsId;
	
	@Transient
	private String ip;
	
	@ManyToOne( cascade={CascadeType.ALL }, fetch=FetchType.EAGER )
	@JoinColumn(name="department_id")  
	private Departments departments;
	
	@Transient
	private List<Long> groupsIdList = Collections.EMPTY_LIST;

	@ManyToMany(fetch=FetchType.EAGER )
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(
			name="user_groups",
			joinColumns = @JoinColumn(name="user_id", referencedColumnName="id"),
					inverseJoinColumns = @JoinColumn(name="group_id", referencedColumnName="id")
	)  
	private List<Groups> groupsList = Collections.EMPTY_LIST;
	
	@Transient
	private List<Menus> menusList = Collections.EMPTY_LIST;
	
	@Transient
	private List<Functions> allFunctionsList = Collections.EMPTY_LIST;
	
	@Transient
	private List<Functions> currentFunctionsList = Collections.EMPTY_LIST;
	
	@Transient
	private Map<String,Functions> allFunctionsMap = Collections.EMPTY_MAP;
	
	@Transient
	private List<Functions> userFunctionsList = Collections.EMPTY_LIST;
	
	@Transient
	private Map<String,Functions> userFunctionsMap = Collections.EMPTY_MAP;
	
	@Transient
	private String menuSelect = null;
	
	@Transient
	private String functionSelect = null;
	
	@Transient
	private String methodInvoke = null;
	
	//getters & setters
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
	public String getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
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
	public String getCompanydomain() {
		return companydomain;
	}
	public void setCompanydomain(String companydomain) {
		this.companydomain = companydomain;
	}
	public Departments getDepartments() {
		return departments;
	}
	public void setDepartments(Departments departments) {
		this.departments = departments;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public List<Groups> getGroupsList() {
		return groupsList;
	}
	public void setGroupsList(List<Groups> groupsList) {
		this.groupsList = groupsList;	
	}
	public List<Menus> getMenusList() {
		return menusList;
	}
	public void setMenusList(List<Menus> menusList) {
		this.menusList = menusList;
	}
	
	public List<Functions> getAllFunctionsList() {
		return allFunctionsList;
	}
	public void setAllFunctionsList(List<Functions> allFunctionsList) {
		this.allFunctionsList = allFunctionsList;
	}

	public Map<String, Functions> getAllFunctionsMap() {
		return allFunctionsMap;
	}
	public void setAllFunctionsMap(Map<String, Functions> allFunctionsMap) {
		this.allFunctionsMap = allFunctionsMap;
	}	
	public String getMenuSelect() {
		return menuSelect;
	}
	public void setMenuSelect(String menuSelect) {
		this.menuSelect = menuSelect;
	}
	public String getFunctionSelect() {
		return functionSelect;
	}
	public void setFunctionSelect(String functionSelect) {
		this.functionSelect = functionSelect;
	}
	
	public String getMethodInvoke() {
		return methodInvoke;
	}
	public void setMethodInvoke(String methodInvoke) {
		this.methodInvoke = methodInvoke;
	}
	
	public List<Functions> getUserFunctionsList() {
		return userFunctionsList;
	}
	public void setUserFunctionsList(List<Functions> userFunctionsList) {
		this.userFunctionsList = userFunctionsList;
	}
	public List<Long> getGroupsIdList() {
		return groupsIdList;
	}
	public void setGroupsIdList(List<Long> groupsIdList) {
		this.groupsIdList = groupsIdList;
	}
	public Long getDepartmentsId() {
		return departmentsId;
	}
	public void setDepartmentsId(Long departmentsId) {
		this.departmentsId = departmentsId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	private String toOrderedString(String inputStr) {
		String result = "";
		
		int start = inputStr.indexOf("_") + 1;
		String orderStr = inputStr.substring(start, inputStr.length());
    	String orderTmp = orderStr;
    	
    	
    	while(orderTmp.length() > 0) {    		
			if (orderTmp.indexOf("_") > 0) {
				String first = orderTmp.substring(0, orderTmp.indexOf("_"));
				first = String.format("%02d", Integer.parseInt(first));

				result = result + first;

				orderTmp = orderTmp.substring(orderTmp.indexOf("_") + 1,orderTmp.length());
				
			} else {
				String first =  orderTmp;
				first = String.format("%02d", Integer.parseInt(first));
				orderTmp = "";
				result = result + first;				
			}
       	}
		
		return result;
	}
	
	
	public void createMenusList() {
		this.allFunctionsMap = new HashMap<String, Functions>();	//所有功能清單
		this.userFunctionsMap = new HashMap<String, Functions>();	//使用者有權使用功能清單
		
		//*** 將所有功能清單放入Map中
		if(allFunctionsList != null) {
			for(int i = 0; i < allFunctionsList.size(); i++) {
				Functions functionsTmp = allFunctionsList.get(i);
				this.allFunctionsMap.put(functionsTmp.getSym(), functionsTmp);
			}
		}
		
		//將使用者所屬群組裡的功能放入 userFunctionsList 中
		this.userFunctionsList = new ArrayList<Functions>();
		
		for(int i = 0; i < this.groupsList.size(); i++) {
			Groups tmpGroup = this.groupsList.get(i);
			this.userFunctionsList.addAll(tmpGroup.getFunctionsList());
		}

		//*** 使用者有權使用功能清單放入Map中
		if(this.userFunctionsList != null) {
			for(int i = 0; i < this.userFunctionsList.size(); i++) {
				Functions functionsTmp = this.userFunctionsList.get(i);
				this.userFunctionsMap.put(functionsTmp.getSym(), functionsTmp);
			}
		}
		
		
		/*
		 * 建立Menu
		 */
		Set<Menus> menuSet = new HashSet<Menus>();	//Menu集合
		Set<String> menuStrSet = new HashSet<String>();	//Menu字串集合
		
		this.menusList = new ArrayList<Menus>();
		
		//取出使用者擁有的每個功能，建立Menu
		for (int j = 0; j < this.userFunctionsList.size(); j++) {
			Functions fcn = (Functions) this.userFunctionsList.get(j);
			String fcnSym = fcn.getSym();
			
			//如果功能代號字串裡有 _, menu的代號就是功能代號字串開頭，到第一個出現 _ 以前的字串
			if (fcnSym.indexOf("_") > 0) {
				String menuStr = fcnSym.substring(0,
						fcnSym.indexOf("_"));
				
				//如果 menuStrSet 裡還沒有 menuStr，就把 menuStr 加入集合
				if (!menuStrSet.contains(menuStr) &&
						this.allFunctionsMap.get(menuStr) != null) {
					menuStrSet.add(menuStr);

					Functions menuFcn = (Functions) this.allFunctionsMap
							.get(menuStr);

					Menus menu = new Menus();
					menu.setOrder(Integer.parseInt(menuFcn.getId()
							.toString()));
					menu.setName(menuFcn.getName());
					menu.setSym(menuFcn.getSym());
					menu.setLink(menuFcn.getUrl());
					menuSet.add(menu);

				}
			}
		}
		
		if(menuSet.size() > 0) {
			menusList.addAll(menuSet);
			
			Collections.sort(menusList,new Comparator<Menus>(){
				@Override
				public int compare(Menus arg0, Menus arg1) {
			        return arg0.getOrder() - arg1.getOrder();
			    }
			});
		}
		
		//移除屬於 Menu 的部分
		Iterator<String> iter1 = menuStrSet.iterator(); //使用者所屬群組裡包含之功能
		while (iter1.hasNext()) { 
			String key = (String) iter1.next();
			this.userFunctionsMap.remove(key);
		}
		
		
		/*
		 * 建立 SubMenu
		 */
		for(int i = 0; i < menusList.size(); i++) {
			Menus menuTmp = menusList.get(i);
			List<Functions> listTmp = new ArrayList<Functions>();
						
			@SuppressWarnings("rawtypes")
			Iterator iter = this.userFunctionsMap.entrySet().iterator(); //使用者所屬群組裡包含之功能
			while (iter.hasNext()) { 
			    @SuppressWarnings("rawtypes")
				Map.Entry entry = (Map.Entry) iter.next(); 
			    String key = (String) entry.getKey(); 
			    Functions val = (Functions) entry.getValue();
			    
			    if(key.indexOf(menuTmp.getSym()) == 0 &&	//包含menu的字串
			    		val.getSym().indexOf("_") > 0) //有_才是function, 沒有則是menu
			    	listTmp.add(val);
			} 
			
			Collections.sort(listTmp,new Comparator<Functions>(){
				@Override
				public int compare(Functions arg0, Functions arg1) {
					String argStr0 = toOrderedString(arg0.getSym());
					String argStr1 = toOrderedString(arg1.getSym());
					
					argStr0 = String.format("%-8s", argStr0).replace(" ", "0");
					argStr1 = String.format("%-8s", argStr1).replace(" ", "0");
					
					int argInt0 = Integer.parseInt(argStr0);
					int argInt1 = Integer.parseInt(argStr1);
					
					return argInt0 - argInt1;
			    }
			});			
			menuTmp.setSubFunctionsList(listTmp);
		}
		
		/*
		 * 設定 Menu 連結
		 * 若使用者無預設 Menu 連結之權限，取使用者有權限的第一個連結
		 */
		for(int i = 0; i < menusList.size(); i++) {
			Menus menuTmp = menusList.get(i);
			List<Functions> subFunctionsList = menuTmp.getSubFunctionsList();
			String link = menuTmp.getLink();
			String firstLink = null; //第一個function的Link, 用來在沒有預設Link時用
			int count = 0;
			
			/*
			 * menu預設的link是否包含有權限功能的link,
			 * 若有表示預設link使用者有權使用
			 * 若無表示預設link使用者不可使用, 選擇使用者有權的第一個link設到menu中
			 */
			boolean containLink = false;
			
			/*
			 * menu是否有子功能link
			 * 若無, 則仍使用menu原有的link (rptview就是一例)
			 */
			
			for (int j = 0; j < subFunctionsList.size(); j++) {
				Functions subFunctions = (Functions) subFunctionsList.get(j);
				
				if (count == 0 && 
						subFunctions.getUrl() != null &&
			    		!"".equals(subFunctions.getUrl())) {
					firstLink = subFunctions.getUrl();
					count++;
				}

				if(link.equals(subFunctions.getUrl())) {
					containLink = true;
				}
			}
			
			if(!containLink && firstLink != null && !"".equals(firstLink)) {
				menuTmp.setLink(firstLink);
			}	
		}
	}

}
