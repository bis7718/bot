package com.bot.bis.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.bot.bis.dao.AbstractDao;
import com.bot.bis.dao.ActionApprovesDao;
import com.bot.bis.model.ActionApproves;

@Repository
public class ActionApprovesDaoImpl extends AbstractDao<ActionApproves, Object> implements ActionApprovesDao {

	@Override
	public String delete(String pOpType, ActionApproves pObj) {
		return super.delete(pOpType, pObj);
	}

	@Override
	public Object findById(ActionApproves pActionApproves, Long pId) {
		return super.findById(pActionApproves, pId);
	}
	
	@Override
	public Collection findByTableName(String pTableName, String pOrderByStr, String pOrderByType) {
		return super.findByTableName(pTableName, pOrderByStr, pOrderByType);
	}

	@Override
	public Long getMaxId(String pTableName) {
		return super.getMaxId(pTableName);
	}

	@Override
	public String insertActionApproves(String pCheckType, String pParams) {
		// TODO Auto-generated method stub
		return null;
	}
}
