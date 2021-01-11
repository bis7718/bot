package com.bot.bis.model;

import java.util.List;

public class Menus {
	private int order;
	private String link;
	private String name;
	private String sym;
	private List<Functions> subFunctionsList;
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSym() {
		return sym;
	}
	public void setSym(String sym) {
		this.sym = sym;
	}
	public List<Functions> getSubFunctionsList() {
		return subFunctionsList;
	}
	public void setSubFunctionsList(List<Functions> subFunctionsList) {
		this.subFunctionsList = subFunctionsList;
	}
}

