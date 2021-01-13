package com.bot.bis.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.bot.bis.model.Users;

public interface LoginService {
	public String check(String pAcct, String pPwd, HttpServletRequest pHttpServletRequest);
	public List<Users> findAllUsers();
}
