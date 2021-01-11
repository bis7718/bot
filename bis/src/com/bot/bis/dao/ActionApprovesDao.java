package com.bot.bis.dao;

import java.util.Collection;

import com.bot.bis.model.ActionApproves;

public interface ActionApprovesDao {

	public String delete(String pOpType, ActionApproves pObj);

	public Collection findByTableName(String pTableName, String pOrderByStr, String pOrderByType);

	public Object findById(ActionApproves pActionApproves, Long pId);

	public Long getMaxId(String pTableName);

	public String insertActionApproves(String pCheckType, String pParams);

}
