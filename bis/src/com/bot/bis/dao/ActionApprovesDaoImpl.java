package com.bot.bis.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bot.bis.dao.AbstractDao;
import com.bot.bis.daoInter.ActionApprovesDao;
import com.bot.bis.model.ActionApproves;
import com.bot.bis.model.Users;
import com.bot.bis.utils.BOTool;





@SuppressWarnings(value={"rawtypes"})
@Repository
public class ActionApprovesDaoImpl extends AbstractDao<ActionApproves, Object> implements ActionApprovesDao {
	
	private ActionApproves actionApproves;
	
	// 篩選條件
	private String gYyyy;
	private String gMm;

	private List gYyyyList;
	private List gMmList;
	
	public String getYyyy() {
		return gYyyy;
	}

	public void setYyyy(String pYyyy) {
		this.gYyyy = pYyyy;
	}

	public String getMm() {
		return gMm;
	}

	public void setMm(String pMm) {
		this.gMm = pMm;
	}

	public List getYyyyList() {
		return gYyyyList;
	}

	public void setYyyyList(List pYyyyList) {
		this.gYyyyList = pYyyyList;
	}

	public List getMmList() {
		return gMmList;
	}

	public void setMmList(List pMmList) {
		this.gMmList = pMmList;
	}
	
//	public String reject() {
//		ActionApproves actionApproves = new ActionApproves();
//		setUpdateInfo(actionApproves);
//
//		actionApproves.setStatus("rejected");
//		logger.fatal("approve_at：" + actionApproves.getApprove_at());
//
//		String updateResultStr = this.actionApprovesService.update(DBConstants.CONFIRM, actionApproves);
//		logger.fatal("updateResultStr：" + updateResultStr);
//
//		if (!ERROR.equals(updateResultStr)) {
//
//			String sqlcommand = this.findUpdateActionApprovesSQL(actionApproves);
//			this.insertAuditLogs("一般審核退件", "退件編號" + this.id.toString(), "成功", sqlcommand);
//			confirm();
//		}
//
//		return "confirm";
//	}
	
//	private String findUpdateActionApprovesSQL(ActionApproves actionApproves) {
//		ActionApproves actprv = (ActionApproves) this.actionApprovesService.input(actionApproves.getId());
//
//		String sqlcommand = "update action_approves set status='" + actprv.getStatus() + "'," + "approve_user='"
//				+ actprv.getApprove_user() + "'," + "approve_name='" + actprv.getApprove_name() + "'," + "approve_at='"
//				+ actprv.getApprove_at() + "'" + " where id=" + actprv.getId();
//		return sqlcommand;
//	}
//	
//	private void setUpdateInfo(ActionApproves pActionApproves,Users pUser) {
//		actionApproves.setId(this.id);
//		actionApproves.setApprove_user(pUser.getCode());
//		actionApproves.setApprove_name(pUser.getName());
//		actionApproves.setApprove_at(BOTool.getCurrentTime());
//	}
	

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
