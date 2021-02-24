package com.bot.bis.dao;

import java.util.Collection;

import com.bot.bis.model.Sessions;

public interface SessionsDao {

	public String delete(String pOpType, Sessions pObj);

	public Collection findByTableName(String pTableName, String pOrderByStr, String pOrderByType);

	public Object findById(Sessions pSessions, Long pId);

	public Long getMaxId(String pTableName);

	public Collection findByObject(Object pModel, String string, String string2);

	public Collection findByObject(Object pModel, String pOrderByStr, String pOrderByType, boolean pIsUat);

}
