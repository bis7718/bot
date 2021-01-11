package com.bot.bis.dao;

import java.util.Collection;

import com.bot.bis.model.AuditLogs;


public interface AuditLogsDao {

	public String delete(String pOpType, AuditLogs pObj);

	public void insertAuditLogs(String pAction, String pParam, String pStatus, String pSqlCmd, String pAcct, String pIp);

	public Long getNextKey(String pSeq);

	public Object findById(AuditLogs pAuditLogs, Long pId);

	public Collection findByTableName(String pTableName, String pOrderByStr, String pOrderByType);

	public String insert(String pOpType, Object pModel);
	
}
