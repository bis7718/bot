package com.bot.bis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bot.bis.model.Functions;
import com.bot.bis.model.Users;
import com.bot.bis.service.DataAccessService;
import com.bot.bis.utils.CommonConstants;
import com.bot.bis.utils.SessionConstants;

@Service
public class LoginServiceImpl implements LoginService { 
  //Log Factory	
  final Logger logger = LogManager.getLogger(this);
  
  private Map<String, Users> gSession = new HashMap<String, Users>();
  private String gUsername;
  private String gPassword;
  
  @Autowired
  private UsersServiceInterface gUsersService;
  
  @Qualifier("auditLogsServiceImpl")
  @Autowired
  private DataAccessService gAuditLogsService;
  
  @Qualifier("functionsServiceImpl")
  @Autowired
  private DataAccessService gFunctionsService;
  
  @SuppressWarnings("unchecked")
  @Override
  @Transactional
  public String check(String pAcct, String pPwd, HttpServletRequest pHttpServletRequest) {
	  	  
	  String vIp = new String();
	  vIp = pHttpServletRequest.getRemoteAddr();
	  
	  Users vTmpUser = new Users(); 
	  vTmpUser.setCode(pAcct);
	  vTmpUser.setIp(vIp);
	  
	  gSession.put(SessionConstants.USER_NOT_LOGIN_YET, vTmpUser);
		
	  Users vInputUser = new Users();
	  vInputUser.setCode(pAcct);
	  vInputUser.setPass(pPwd);
		
	  Users vUser = (Users) getUsersService().authenticate(vInputUser);
				
	  if ( vUser == null ){
		  logger.info("查無使用者");
		  /* User not valid, return to input page. */
		  gAuditLogsService.insertAuditLogs("登入", null, "失敗", null, pAcct, vIp);//2014.5.30
		  
		  return CommonConstants.FAILED_LOGIN;
	  }else{
		vUser.setIp(vIp);
		logger.info("user ip: " + vIp);
			
		vUser.setAllFunctionsList((List<Functions>) getFunctionsService().list());
		vUser.createMenusList();
			
		if(vUser.getMenusList().size() == 0) {
			//setMessage("使用者未設定權限");
			logger.info("User:"+pAcct+" doesn't configure authrization.");
			gSession.put(SessionConstants.USER, vUser);
			/* User not valid, return to input page. */
			gAuditLogsService.insertAuditLogs("登入", null, "失敗", null, pAcct, vIp);//2014.5.30
			
			return CommonConstants.FAILED_AUTHORIZATION;
		}
	}
		
	  logger.info("Starting login...");
	  gAuditLogsService.insertAuditLogs("登入", null, "失敗", null, pAcct, vIp);//2014.5.30
		
	  return CommonConstants.SUCCESS;
	
  	}
  
  public String loginbypwd(){
	  return "SUCCESS";
	}
	
  public String logout(){
	gSession.remove(SessionConstants.USER);
	gSession.remove(SessionConstants.MESSAGE);
		
	//setMessage("已登出");
	logger.info("已登出");
	return "SUCCESS";
  }
	
	
  public void setSession(Map<String, Users> pSession) {
	this.gSession = pSession;	
  }
	
  public UsersServiceInterface getUsersService() {
	return gUsersService;
  }

  public void setUsersService(UsersServiceInterface pUsersService) {
	this.gUsersService = pUsersService;
  }

  public String getPassword() {
	return gPassword;
  }

  public void setPassword(String pPassword) {
	this.gPassword = pPassword;
  }

  public String getUsername() {
	return gUsername;
  }

  public void setUsername(String pUsername) {
	this.gUsername = pUsername;
  }

  public DataAccessService getFunctionsService() {
	return gFunctionsService;
  }

  public void setFunctionsService(DataAccessService pFunctionsService) {
	this.gFunctionsService = pFunctionsService;
  }
  
  @Override
  public List<Users> findAllUsers() {
    return null;
  }
  
}
