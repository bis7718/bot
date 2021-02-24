package com.bot.bis.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.bot.bis.dao.AbstractDao;
import com.bot.bis.daoInter.FunctionsDao;
import com.bot.bis.model.Functions;

@Repository
public class FunctionsDaoImpl extends AbstractDao<Functions, Object> implements FunctionsDao{

	@Override
	public String delete(String pOpType, Functions pObj) {
		return super.delete(pOpType, pObj);
	}

	@Override
	public Collection findByTableName(String pTableName, String pOrderByStr, String pOrderByType) {
		return super.findByTableName(pTableName, pOrderByStr, pOrderByType);
	}

	@Override
	public Object findById(Functions pFunctions, Long pId) {
		return super.findById(pFunctions, pId);
	}

	@Override
	public Long getMaxId(String pTableName) {
		return super.getMaxId(pTableName);
	}

}
