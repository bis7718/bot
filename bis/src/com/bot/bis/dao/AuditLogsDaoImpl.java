package com.bot.bis.dao;

import java.util.Collection;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bot.bis.dao.AbstractDao;
import com.bot.bis.daoInter.AuditLogsDao;
import com.bot.bis.model.AuditLogs;

@Repository
@Transactional
public class AuditLogsDaoImpl extends AbstractDao<AuditLogs, Object> implements AuditLogsDao {

	@Override
	public String delete(String pOpType, AuditLogs pObj) {
		return super.delete(pOpType,pObj);
	}

	@Override
	public void insertAuditLogs(String pAction, String pController, String pParam, String pStatus, String pSqlCmd, String pAcct, String pIp) {
		super.insertAuditLogs(pAction, pController, pParam, pStatus, pSqlCmd, pAcct, pIp);		
	}
	
	@Override
	public Long getNextKey(String pSeq) {
		return super.getNextKey(pSeq);
	}

	@Override
	public Object findById(AuditLogs pAuditLogs, Long pId) {
		return super.findById(pAuditLogs, pId);
	}
	
	@Override
	public Collection findByTableName(String pTableName, String pOrderByStr, String pOrderByType) {
		return super.findByTableName(pTableName, pOrderByStr, pOrderByType);
	}
    
	@Override
	public String insert(String pOpType, Object pModel) {
		return super.insert(pOpType, pModel);
	}
}
