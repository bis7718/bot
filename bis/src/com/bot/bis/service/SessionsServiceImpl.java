package com.bot.bis.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bot.bis.daoInter.SessionsDao;
import com.bot.bis.model.Sessions;
import com.bot.bis.serviceInter.DataAccessService;

@SuppressWarnings(value={"rawtypes"})
@Service
public class SessionsServiceImpl implements DataAccessService {
	
	@Autowired
	SessionsDao gSessionsDao;
	
	@Override
	public String delete(String pOpType, Long pId) {
		Sessions vObj = new Sessions();
		vObj.setId(pId);
		return gSessionsDao.delete(pOpType, vObj);
	}

	public Collection list() {
		return gSessionsDao.findByTableName("Sessions", "id", "");
	}
	
	@Override
	public Object input(Long id) {
		return gSessionsDao.findById(new Sessions(), id);
	}
	
	@Override
	public Long getMaxId() {
		return gSessionsDao.getMaxId("SessionsNoMap");
	}

	@Override
	public String insert(String pOpType, Object pModel) {
		// TODO Auto-generated method stub
		return null;
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
		return gSessionsDao.findByObject(pModel, "id", "desc", true);
	}

	@Override
	public Collection list(Object pModel) {
		return gSessionsDao.findByObject(pModel, "id", "desc");
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
	public void insertAuditLogs(String pAction, String pController, String pParam, String pStatus, String pSqlCmd, String pAcct,
			String pIp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String insertActionApproves(String pCheckType, String pParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAuditLogs(String pAction, String pController, String pParam, String pStatus, String pSqlCmd) {
		// TODO Auto-generated method stub
		
	}
}
