package com.bot.bis.service;

import java.util.Collection;
import java.util.Map;

import com.bot.bis.model.Users;

public interface DataAccessService {	
	public String insert(String pOpType, Object pModel);	
	public String update(String pOpType, Object pModel);
	public int update(String pSql);
	public String delete(String pOpType, Long pId);
	public String delete(String pOpType, Object pFieldName, Object pFieldValue);
	public Collection list();
	public Collection listUat(Object pModel);
	public Collection list(Object pModel);
	public Collection list(Object pModel, String pOrderByStr, String pOrderByType);
	public Object input(Long pId);
	public Collection list(Object pModel, String pSql);
	public boolean isExists(Object pModel);
	public void setSession(Map pSession);
	public Map getSession();
	public Long getMaxId();
	public Long getMaxId(Object pModel);
	public void insertAuditLogs(String pAction, String pParam, String pStatus, String pSqlCmd, String pAcct, String pIp);
	public String insertActionApproves(String pCheckType, String pParams);
}
