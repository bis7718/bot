package com.bot.bis.dao;

import java.util.Collection;

import com.bot.bis.model.Functions;

public interface FunctionsDao {

	public String delete(String pOpType, Functions pObj);

	public Collection findByTableName(String pTableName, String pOrderByStr, String pOrderByType);

	public Object findById(Functions punctions, Long pId);

	public Long getMaxId(String pTableName);

}
