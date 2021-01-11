package com.bot.bis.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bot.bis.dao.FunctionsDao;
import com.bot.bis.model.Functions;


@SuppressWarnings(value={"rawtypes"})
@Service
public class FunctionsServiceImpl implements DataAccessService {

	@Autowired
	FunctionsDao gFunctionDao;
	
	@Override
	public String delete(String pOpType, Long pId) {
		Functions vObj = new Functions();
		vObj.setId(pId);
		return gFunctionDao.delete(pOpType, vObj);
	}

	@Override
	public Collection list() {
		return gFunctionDao.findByTableName("Functions", "id", "");
	}

	@Override
	public Object input(Long pId) {
		return gFunctionDao.findById(new Functions(), pId);
	}
	
	@Override
	public Long getMaxId() {
		return gFunctionDao.getMaxId("Functions");
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
	public void insertAuditLogs(String pAction, String pParam, String pStatus, String pSqlCmd, String pAcct,
			String pIp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String insertActionApproves(String pCheckType, String pParams) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
