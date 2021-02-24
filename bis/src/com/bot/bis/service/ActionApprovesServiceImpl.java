package com.bot.bis.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bot.bis.daoInter.ActionApprovesDao;
import com.bot.bis.model.ActionApproves;
import com.bot.bis.serviceInter.DataAccessService;


@SuppressWarnings(value={"rawtypes"})
@Service
public class ActionApprovesServiceImpl implements DataAccessService {
	
	@Autowired
	ActionApprovesDao gActionApprovesDao;
	
	@Override
	public String delete(String pOpType, Long pId) {
		ActionApproves vObj = new ActionApproves();
		vObj.setId(pId);
		return gActionApprovesDao.delete(pOpType, vObj);
	}

	@Override
	public Collection list() {
		return gActionApprovesDao.findByTableName("ActionApproves", "id", "desc");
	}

	@Override
	public Object input(Long pId) {
		return gActionApprovesDao.findById(new ActionApproves(), pId);
	}
	
	@Override
	public Long getMaxId() {
		return gActionApprovesDao.getMaxId("ActionApproves");
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
