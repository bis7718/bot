package com.bot.bis.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bot.bis.service.LoginService;

@Controller
@RequestMapping(value = "/login")
public class LoginController{
	
	final Logger logger = LogManager.getLogger(this);
			
	private LoginService loginService;
		
	@Autowired(required=true)
	@Qualifier(value="loginServiceImpl")
	public void setLoginService(LoginService pLoginService){
		this.loginService = pLoginService;
	}
		
	@RequestMapping(value = "/loginbypwd", method = RequestMethod.POST)
	public String redirectToLogin(HttpServletRequest pRequest,Model pModel) {
		String vUserName = pRequest.getParameter("username");
		String vPassword = pRequest.getParameter("password");
		logger.info("username :" + vUserName);
		logger.info("password :" + vPassword);
		String vResult = loginService.check(vUserName, vPassword, pRequest);
		logger.info("vResult :" + vResult);
		pModel.addAttribute("message",vResult);
		
		return "welcome";
	}
	
	@RequestMapping(value = "/sso", method = RequestMethod.GET)
	public String checkSso(Model model) {
		return "404";
	}
}
