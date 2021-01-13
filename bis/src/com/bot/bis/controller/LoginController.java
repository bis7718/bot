package com.bot.bis.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bot.bis.model.Users;
import com.bot.bis.service.LoginService;
import com.bot.bis.utils.CommonConstants;
import com.bot.bis.utils.SessionConstants;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	final Logger logger = LogManager.getLogger(this);

	private LoginService loginService;

	@Autowired(required = true)
	@Qualifier(value = "loginServiceImpl")
	public void setLoginService(LoginService pLoginService) {
		this.loginService = pLoginService;
	}

	@RequestMapping(value = "/loginbypwd", method = RequestMethod.POST)
	public String redirectToLogin(HttpServletRequest pRequest, Model pModel) {
		String vUserName = pRequest.getParameter("username");
		String vPassword = pRequest.getParameter("password");
		String vResult = loginService.check(vUserName, vPassword, pRequest);
		switch (vResult) {
		case CommonConstants.SUCCESS:
			System.out.println("成功");
			pModel.addAttribute("message", "成功");
			return "welcome_m";
		case CommonConstants.FAILED_LOGIN:
			System.out.println("查無使用者");
			pModel.addAttribute("message", "查無使用者");
			return "login_m";
		case CommonConstants.FAILED_AUTHORIZATION:
			System.out.println("使用者未設定權限");
			pModel.addAttribute("message", "使用者未設定權限");
			return "login_m";
		default:
			System.out.println("未知的錯誤");
			pModel.addAttribute("message", "未知的錯誤");
			return "login_m";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String checkSso(Model model) {
		return "404";
	}
}
