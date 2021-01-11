package com.bot.bis.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.bot.bis.dao.AbstractDao;
import com.bot.bis.dao.SessionsDao;
import com.bot.bis.model.Functions;
import com.bot.bis.model.Sessions;

@Repository
public class SessionsDaoImpl extends AbstractDao<Functions, Object> implements SessionsDao {

	@Override 
	public String delete(String pOpType, Sessions pModel) {
		return super.delete(pOpType, pModel);
	}

	@Override
	public Collection findByTableName(String pTableName, String pOrderByStr, String pOrderByType) {
		return super.findByTableName(pTableName, pOrderByStr, pOrderByType);
	}

	@Override
	public Object findById(Sessions pSessions, Long pId) {
		return super.findById(pSessions, pId);
	}

	@Override
	public Long getMaxId(String pTableName) {
		return super.getMaxId(pTableName);
	}
	
	@Override
	public Collection findByObject(Object pModel, String pOrderByStr, String pOrderByType) {
		return super.findByObject(pModel, pOrderByStr, pOrderByType);
	}
	
	@Override
	public Collection findByObject(Object pModel, String pOrderByStr, String pOrderByType, boolean pIsUat) {
		return super.findByObject(pModel, pOrderByStr, pOrderByType, pIsUat);
	}
}
