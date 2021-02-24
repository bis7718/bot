package com.bot.bis.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bot.bis.daoInter.AuditLogsDao;
import com.bot.bis.model.AuditLogs;
import com.bot.bis.serviceInter.DataAccessService;


@SuppressWarnings(value={"rawtypes"})
@Transactional
@Service
public class AuditLogsServiceImpl implements DataAccessService {
	
	@Autowired
	private AuditLogsDao gAuditLogsDao;
	
	@Override
	public String delete(String pOpType, Long pId) {
		AuditLogs vObj = new AuditLogs();
		vObj.setId(pId);
		return gAuditLogsDao.delete(pOpType, vObj);
	}

	@Override
	public void insertAuditLogs(String pAction, String pController, String pParam, String pStatus, String pSqlCmd, String pAcct, String pIp) {
		gAuditLogsDao.insertAuditLogs(pAction, pController, pParam, pStatus, pSqlCmd, pAcct, pIp);		
	}

	@Override
	public String insert(String pOpType, Object pModel) {
		return gAuditLogsDao.insert(pOpType, pModel);
	}

	@Override
	public Collection list() {
		return gAuditLogsDao.findByTableName("AuditLogs", "id", "desc");
	}

	@Override
	public Object input(Long pId) {
		return gAuditLogsDao.findById(new AuditLogs(), pId);
	}

	@Override
	public Long getMaxId() {
		return gAuditLogsDao.getNextKey("AUDIT_LOGS_SEQ");
	}

	@Override
	public String update(String pOpType, Object pModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String pSql) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String delete(String pOpType, Object pFieldName, Object pFieldValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection listUat(Object pModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection list(Object pModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection list(Object pModel, String pOrderByStr, String pOrderByType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection list(Object pModel, String pSql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExists(Object pModel) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSession(Map pSession) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getMaxId(Object pModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertActionApproves(String pCheckType, String pParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAuditLogs(String pAction, String pController, String pParam, String pStatus, String pSqlCmd) {
		gAuditLogsDao.insertAuditLogs(pAction, pController, pParam, pStatus, pSqlCmd, "USEER", "IP");
	}

}
