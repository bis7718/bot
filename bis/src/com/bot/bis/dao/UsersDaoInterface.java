package com.bot.bis.dao;

import java.util.Collection;
import java.util.List;

import com.bot.bis.model.Users;


public interface UsersDao {
	
	public List<Users> getAllUser();
	
	public Users getUser(String pAcct);
	
	public boolean isExists(Object pUsr);
	
	public Collection list(Object pUsr);
}
