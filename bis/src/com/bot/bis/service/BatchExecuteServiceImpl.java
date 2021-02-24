package com.bot.bis.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bot.bis.model.ActionApproves;
import com.bot.bis.model.SessionsNoMap;
import com.bot.bis.utils.BOTool;
import com.bot.bis.utils.CommonConstants;
import com.bot.bis.utils.DBConstants;

@Service
public class BatchExecServiceImpl implements BatchExecService{

	//Log Factory	
	final Logger logger = LogManager.getLogger(this);
	
	@Qualifier("auditLogsServiceImpl")
	@Autowired
	private DataAccessService gAuditLogsService;
	
	@Qualifier("actionApprovesServiceImpl")
	@Autowired
	private DataAccessService gActionApprovesService;
	
	@Qualifier("sessionsServiceImpl")
	@Autowired
	private DataAccessService gSessionsService;
	
	@Override
	@Transactional
	public String runBatch(String pDataDt, String pCode, HttpServletRequest pHttpServletRequest) {
		String vMsg;
		
		logger.info("pDataDt: " + pDataDt);
		
		if (BOTool.checkDate(pDataDt, "yyyyMMdd")== CommonConstants.SUCCESS) {
			
			String vDataMonth = pDataDt.substring(0, 6);

			vMsg = batchCheck(vDataMonth);
			
			if("".equals(vMsg)) {
				HttpSession session = pHttpServletRequest.getSession();
				logger.info("session: " + session);
				
				//Users user = (Users) session.getAttribute(SessionConstants.USER);

				String sqlcommand = gActionApprovesService.insertActionApproves("BATCH", 
						DBConstants.PRECOMMAND + " /home/bisapp/bossa_batch.sh " + pDataDt + " " + pCode);

				gAuditLogsService.insertAuditLogs("�??��?��次申�?", pDataDt, "??��??", sqlcommand, pCode, pHttpServletRequest.getRemoteAddr());

				vMsg = CommonConstants.SUCCESS;
			}

		} else {
			vMsg = CommonConstants.FAILED;
		}
		
		logger.info("msg: " + vMsg);
		
		return vMsg;
	}

	private String batchCheck(String pDataMonth) {
		String msg = "";
		
		ActionApproves vActaprv1 = new ActionApproves();
		vActaprv1.setAction_type("BATCH");
		vActaprv1.setStatus("waiting");
		
		ActionApproves vActaprv2 = new ActionApproves();
		vActaprv2.setAction_type("RERUN");
		vActaprv2.setStatus("waiting");
		
		SessionsNoMap vSessionNoMap = new SessionsNoMap();
		vSessionNoMap.setDisabled("X");
		List<SessionsNoMap> vSessionNoMaplist = (List<SessionsNoMap>) gSessionsService.list(vSessionNoMap);
		
		List<SessionsNoMap> vSessionListUat = (List<SessionsNoMap>) gSessionsService.listUat(vSessionNoMap);
		
		int vCurrentMonthSessionsCount = 0;
		
		if (findMonthSessions(pDataMonth) == null) {
			 vCurrentMonthSessionsCount = 0;
		}else {
			 vCurrentMonthSessionsCount = findMonthSessions(pDataMonth).size();
		}
		
		if (gActionApprovesService.isExists(vActaprv1) || gActionApprovesService.isExists(vActaprv2))
			msg = "??�批次正?��?��請中,請�?�審?��後�?��?�申�?";
		else if(vSessionNoMaplist.size() >= 20) {
			msg = "PRD ?��??��?? " + vSessionNoMaplist.size() + " ?��?�本, 請刪?��??��?�本!!!";
		} else if(vCurrentMonthSessionsCount >= 3) {
			msg = "PRD ?��??�份?��??��??  " + vCurrentMonthSessionsCount + " ?��?�本, 請刪?��??��?�本!!!";
		} else if(vSessionListUat.size() >= 20) {
			msg = "UAT ?��??��?? " + vSessionListUat.size() + " ?��?�本, 請刪?��??��?�本!!!";
		}

		return msg;
	}
	
	public List<SessionsNoMap> findMonthSessions(String pDataMonth) {
		SessionsNoMap vSessionNoMap = new SessionsNoMap();
		vSessionNoMap.setDisabled("X");
		List<SessionsNoMap> vSessionList = (List<SessionsNoMap>) gSessionsService.list(vSessionNoMap);
		
		List<SessionsNoMap> vResultList = new ArrayList<SessionsNoMap>();
		
		/**
		if(vSessionList != null) {
			for(int i = 0; i < vSessionList.size(); i++) {
				SessionsNoMap vTmpSessionNoMap = vSessionList.get(i);
				if(pDataMonth.substring(0, 4).equals(vTmpSessionNoMap.getYyyy()) && pDataMonth.substring(4, 6).equals(vTmpSessionNoMap.getMm()))
					vResultList.add(vTmpSessionNoMap);
			}
			logger.info("monthSessionsCount: " + vResultList.size());
			
			return vResultList;
		}else {
			return null;
		}**/
		
		for(int i = 0; i < vSessionList.size(); i++) {
			SessionsNoMap vTmpSessionNoMap = vSessionList.get(i);
			if(pDataMonth.substring(0, 4).equals(vTmpSessionNoMap.getYyyy()) && pDataMonth.substring(4, 6).equals(vTmpSessionNoMap.getMm()))
				vResultList.add(vTmpSessionNoMap);
		}
		logger.info("monthSessionsCount: " + vResultList.size());
		
		return vResultList;
	}
}
