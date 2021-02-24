package com.bot.bis.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bot.bis.model.Users;
import com.bot.bis.serviceInter.LoginService;

@Controller
@RequestMapping({"/login"})
public class LoginController {
  final Logger logger = LogManager.getLogger(this);
  
  private LoginService loginService;
  
  private String message;
  
  @Autowired(required = true)
  @Qualifier("loginServiceImpl")
  public void setLoginService(LoginService pLoginService) {
    this.loginService = pLoginService;
  }
  
  @RequestMapping(value = {"/loginbypwd"}, method = {RequestMethod.GET})
  public String redirectToLogin(HttpServletRequest pRequest, Model pModel) {
    pModel.addAttribute("message", this.message);
    if (this.message != "") {
      pModel.addAttribute("message", this.message);
      this.message = "";
    } 
    return "loginpage";
  }
  
  @RequestMapping(value = {"/check"}, method = {RequestMethod.POST})
  public void checkAcct(HttpServletRequest pRequest, HttpServletResponse pResponse, Model pModel) throws Exception {
    String pAcct = pRequest.getParameter("username");
    String pPwd = pRequest.getParameter("password");
    String pResult = this.loginService.check(pAcct, pPwd, pRequest);
    this.logger.error("pResult: " + pResult);
    Map<String, Users> vSession = this.loginService.getSession();
    Users pUser = vSession.get("user");
    if (pResult == "S") {
      pRequest.getSession().setAttribute("user", pUser);
      this.logger.error("name: " + pUser.getName());
      pResponse.sendRedirect("welcome");
    } else {
      String str;
      switch ((str = pResult).hashCode()) {
        case 2235:
          if (str.equals("FA")) {
            this.message = "使用者未設定權限";
            break;
          } 
        case 2246:
          if (str.equals("FL")) {
            this.message = "帳號或密碼錯誤";
            break;
          } 
        default:
          this.message = "未知錯誤";
          break;
      } 
      pResponse.sendRedirect("loginbypwd");
    } 
  }
  
  @RequestMapping(value = {"/welcome"}, method = {RequestMethod.GET})
  public String redirwelcome(HttpServletRequest pRequest, Model pModel) {
    pModel.addAttribute("user", pRequest.getSession().getAttribute("user"));
    return "welcome";
  }
  
  @RequestMapping(value = {"/logout"}, method = {RequestMethod.GET})
  public String logout(HttpServletRequest pRequest) {
    pRequest.getSession().removeAttribute("user");
    return "loginpage";
  }
}