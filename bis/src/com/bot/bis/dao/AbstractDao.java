package com.bot.bis.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.bot.bis.model.ActionApproves;
import com.bot.bis.model.AuditLogs;
import com.bot.bis.model.JobWorks;
import com.bot.bis.model.Users;
import com.bot.bis.service.DataAccessService;
import com.bot.bis.utils.BOTool;
import com.bot.bis.utils.DBConstants;
import com.bot.bis.utils.SessionConstants;

 
/**From Original BaseAction.java and BotActionSupport**/
@EnableTransactionManagement
public abstract class AbstractDao<PK extends Serializable, T> {
     
	//Log Factory	
	final Logger logger = LogManager.getLogger(this);
	
	/* JavaBeans Properties to Receive Request Parameters */
	private Map gSession;
	
	@Qualifier("actionApprovesServiceImpl")
	@Autowired
	private DataAccessService gActionApprovesService;
	
	@Qualifier("auditLogsServiceImpl")
	@Autowired
	private DataAccessService gAuditLogsService;
	
    private final Class<T> gPersistentClass;
     
    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.gPersistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
     
    @PersistenceContext
    EntityManager gEntityManager;
     
    protected EntityManager getEntityManager(){
        return this.gEntityManager;
    }
 
    protected T getByKey(PK pKey) {
        return (T) gEntityManager.find(gPersistentClass, pKey);
    }
 
    protected void persist(T pEntity) {
        gEntityManager.persist(pEntity);
    }
     
    protected void update(T pEntity) {
        gEntityManager.merge(pEntity);
    }
 
    protected void delete(T pEntity) {
        gEntityManager.remove(pEntity);
    }

    @Transactional
    public String insert(String pOpType, Object pModel) {
		if(DBConstants.APPLY.equals(pOpType))
			return apply("INSERT", pModel);
		else if(DBConstants.CONFIRM.equals(pOpType))
			return insertConfirm(pModel);
		else
			return "ERROR";
	}

	public String update(String pOpType, Object pModel) {
		if(DBConstants.APPLY.equals(pOpType))
			return apply("UPDATE", pModel);
		else if(DBConstants.CONFIRM.equals(pOpType))
			return updateConfirm(pModel);
		else
			return "ERROR";
	}
	
	public String delete(String pOpType, Object pFieldName, Object pFieldValue) {
		JobWorks pObj = new JobWorks();
		BOTool.setFieldValue(pObj, pFieldName, pFieldValue);
		
		return delete(pOpType, pObj);
	}

	public String delete(String pOpType, Object pModel) {
		if(DBConstants.APPLY.equals(pOpType))
			return apply("DELETE", pModel);
		else if(DBConstants.CONFIRM.equals(pOpType))
			return deleteConfirm(pModel);
		else
			return "ERROR";
	}
	
	//list Uat
	public Collection listUat(Object pModel) {
		return findByObject(pModel, "id", "desc", true);
	}
	
	//list
	public Collection list(Object pModel) {
		return findByObject(pModel, "id", "desc");
	}
	
	public Collection list(Object pModel, String pOrderByStr, String pOrderByType) {
		return findByObject(pModel, pOrderByStr, pOrderByType);
	}
	
	public Collection list(Object pModel, String pSql) {
		return findBySQL(pModel, pSql);
	}
	
	private String apply(String pApplyType, Object pModel) {
		
		String vApplyName;
		
		if("INSERT".equals(pApplyType))
			vApplyName = "新增";
		else if("UPDATE".equals(pApplyType))
			vApplyName = "修改";
		else if("DELETE".equals(pApplyType))
			vApplyName = "刪除";
		else
			vApplyName = "";
		
		try {
			if (pModel != null) {
				Class<?> vClass = pModel.getClass();
				String vBotName = vClass.getSimpleName();
				logger.info("session: " + gSession);
				Users vUser = (Users) gSession.get(SessionConstants.USER);

				ActionApproves vActprv = new ActionApproves();
				vActprv.setId(getMaxId("ActionApproves") + 1);
				vActprv.setAction_type(pApplyType + "_" + vBotName);
				vActprv.setParams(BOTool.toJSONObject(pModel).toString());
				vActprv.setApply_user(vUser.getCode());
				vActprv.setApply_name(vUser.getName());
				vActprv.setApply_at(BOTool.getCurrentTime());
				vActprv.setStatus("waiting");

				gEntityManager.persist(vActprv);

				String vSqlcommand = "INSERT INTO action_approves (id, action_type,params,apply_user,apply_name,apply_at,status) "
						+ "values ("
						+ vActprv.getId() + ",'" 
						+ vActprv.getAction_type() + "','"
						+ vActprv.getParams() + "','"
						+ vActprv.getApply_user() + "','"
						+ vActprv.getApply_name() + "','"
						+ vActprv.getApply_at().toString() + "','"
						+ vActprv.getStatus() + "')";
				
				
				this.insertAuditLogs("申請" + vApplyName + vBotName, BOTool
						.toJSONObject(pModel).toString(), "成功", vSqlcommand, vUser.getCode(), vUser.getIp());
				return vSqlcommand;

			} else {
				logger.info("申請" + vApplyName + "操作：傳入物件為空");
				//setMessage("申請" + applyName + "操作：傳入物件為空");
				this.insertAuditLogs("申請" + vApplyName + "操作：傳入物件為空", null, "失敗", null, "NULL", "NULL");
				return "ERROR";
			}

		} catch (Exception e) {
			
			if (pModel != null) {
				Class<?> vClass = pModel.getClass();
				String vBotName = vClass.getSimpleName();
				
				logger.info("申請" + vApplyName + vBotName + "發生Exception: " + e);
				//setMessage("申請" + applyName + boName + "發生Exception");
				
				this.insertAuditLogs("申請" + vApplyName + vBotName + "發生Exception", e.getMessage(), "失敗", null, "NULL", "NULL");
			}
			else {
				logger.info("申請" + vApplyName + "操作發生Exception: " + e);
				//setMessage("申請" + applyName + "操作發生Exception");
				this.insertAuditLogs("申請" + vApplyName + "操作發生Exception", e.getMessage(), "失敗", null, "NULL", "NULL");
			}
			return "ERROR";
		}
	}

	public String insertConfirm(Object pModel) {
		logger.info("start insertConfirm...");
		logger.info("model: " + pModel);
		if (pModel != null) {
			if (isExistsById(pModel) != true) {
				gEntityManager.persist(pModel);
			} else {
				logger.fatal("修改操作：資料已存在");
				return "ERROR";
			}
		} else {
			logger.fatal("新增操作：傳入物件為空");
			return "ERROR";
		}
		
		logger.info("RETURN SUCCESS");
		return "SUCCESS";
	}

	private String updateConfirm(Object pModel) {
		logger.info("start updateConfirm...");
		
		if (pModel != null) {
			if (isExistsById(pModel) == true) {
				Object vModelOri = findById(pModel, BOTool.getId(pModel));
				
				//isIncludeObject設為true, 因為有些物件是bo, 要取出來
				Map vFieldMap = BOTool.getFieldValueMap(pModel, true, true);

				Iterator vIter = vFieldMap.entrySet().iterator();
				while (vIter.hasNext()) {
					Map.Entry vEntry = (Map.Entry) vIter.next();
					Object vKey = vEntry.getKey();
					Object vVal = vEntry.getValue();
					
					logger.info("key, val: " + vKey + "," + vVal);
					
					if (vVal != null) {
						BOTool.setFieldValue(vModelOri, vKey, vVal);
					}
				}
				
				transformDateStr(vModelOri);
				gEntityManager.merge(vModelOri);
			} else {
				logger.info("修改操作：資料不存在");
				//setMessage("修改操作：資料不存在");
				return "ERROR";
			}

		} else {
			logger.info("修改操作：傳入物件為空");
			//setMessage("修改操作：傳入物件為空");
			return "ERROR";
		}
		return "SUCCESS";
	}

	
	public void transformDateStr(Object pModel) {
		Set vDateFields = new HashSet();
		vDateFields.add("apply_at");
		vDateFields.add("approve_at");
		vDateFields.add("created_at");
		vDateFields.add("datadate");
		
		Map vFieldMap = BOTool.getFieldValueMap(pModel, false, false);
		
		Iterator vIter = vFieldMap.entrySet().iterator();
		while (vIter.hasNext()) {
			Map.Entry vEntry = (Map.Entry) vIter.next();
			Object vKey = vEntry.getKey();
			Object vVal = vEntry.getValue();
			
			if (vDateFields.contains(vKey)) {
				Object vTmp = BOTool.getFieldValue(pModel, vKey.toString());
				logger.info("transf_" + vKey + ": " + vTmp);
				BOTool.setFieldValue(pModel, vKey, vTmp);
			}
		}
	}
	
	private String deleteConfirm(Object pModel) {
		logger.info("start deleteConfirm...");
		if (pModel != null) {
			if (isExistsById(pModel) == true) {
				// 執行完merge後persistentInstance還是detached, merge後返回的新物件才是允許刪除的
				//merge前要先找回資料庫object, 否則會刪不掉 findById 2014.5.30
				//entityManager.remove(entityManager.merge(findById(model, BOTool.getId(model))));
				logger.info("model_id: " + BOTool.getId(pModel));
				logger.info("model_class: " + pModel.getClass().getName());
				logger.info("model: " + pModel);
				
				//entityManager.merge(model);
				//entityManager.remove(entityManager.merge(findById(model, BOTool.getId(model))));
				//entityManager.remove(findById(model, BOTool.getId(model)));
				
				Object vObj = gEntityManager.find(pModel.getClass(), BOTool.getId(pModel));
				logger.info("obj_before: " + vObj);
				
				//entityManager.remove(entityManager.merge(model));
				gEntityManager.remove(gEntityManager.merge(vObj));

				vObj = gEntityManager.find(pModel.getClass(), BOTool.getId(pModel));
				logger.info("obj_after: " + vObj);
				//entityManager.remove(obj);
				
			} else {
				logger.info("刪除操作：刪除資料不存在");
				//setMessage("刪除操作：刪除資料不存在");
				return "ERROR";
			}
		} else {
			logger.info("刪除操作：傳入物件為空");
			//setMessage("刪除操作：傳入物件為空");
			return "ERROR";
		}
		return "SUCCESS";
	}

	public boolean isExistsById(Object pModel) {
		boolean vResult = false;

		if (findById(pModel, BOTool.getId(pModel)) != null)
			vResult = true;

		return vResult;
	}
	
	// 檢查資料是否存在
	public boolean isExists(Object pModel) {
		return isExistsByObject(pModel);
	}
	
	public boolean isExistsByObject(Object pModel) {
		boolean vResult = false;
		if (findByObject(pModel, null, null).size() > 0)
			vResult = true;
		return vResult;
	}

	// 透過資料表名稱查詢結果
	// orderByStr 為排序欄位清單，不要加上 order by
	public Collection findByTableName(String pTableName, String pOrderByStr, String pOrderByType) {
		Collection vResult = Collections.EMPTY_LIST;
		
		Query vQuery = gEntityManager.createQuery("from " + pTableName + getOrderByStr(pOrderByStr, pOrderByType));
		vResult = vQuery.getResultList();
		
		logger.debug("查詢操作：找出 " + vResult.size() + " 筆資料");
		return vResult;
	}
	
	public String getOrderByStr(String pOrderByStr, String pOrderByType) {
		String vResult = null;
		if(!"".equals(pOrderByStr) && pOrderByStr != null) {
			pOrderByStr = " order by " + pOrderByStr;
		
			if(pOrderByType == null)
				pOrderByType = "";
			
			vResult = pOrderByStr + " " + pOrderByType;
		}
		else vResult = "";
			
		return vResult;
	}

	// 透過 Id 查詢物件
	public Object findById(Object pModel, Long pId) {
		Object vResult = null;
		String vClassName = pModel.getClass().getSimpleName();
		logger.info("class: " + pModel.getClass());
		logger.info("className: " + vClassName);
		logger.info("id: " + pId);
		
		Query vQuery = gEntityManager.createQuery("from " + vClassName
						+ " where id = :id");
		vQuery.setParameter("id", pId);
		
		try {
			vResult = vQuery.getSingleResult();
			logger.info("查詢操作：找出 1 筆資料");
			logger.info("obj class: " + vResult);

		} catch (NoResultException nre) {
			logger.info("nre: " + nre);
			vResult = null;
		} 
		
		return vResult;
	}

	public Collection findByObject(Object pModel, String pOrderByStr, String pOrderByType) {
		return findByObject(pModel, pOrderByStr, pOrderByType, false);
	}
	
	// 透過 field 查詢物件
	public Collection findByObject(Object pModel, String pOrderByStr, String pOrderByType, boolean pIsUat) {
		Collection vResult = Collections.EMPTY_LIST;
		String vClassName = pModel.getClass().getSimpleName();

		String vWhereStr = BOTool.getWhereString(pModel);
		
		Query vQuery = null;
		vQuery = gEntityManager.createQuery("from " + vClassName + vWhereStr + getOrderByStr(pOrderByStr, pOrderByType));
			
		logger.info("SQL字串: " + "select * from " + vClassName + vWhereStr + getOrderByStr(pOrderByStr, pOrderByType));
		
		Map vFieldMap = BOTool.getFieldValueMap(pModel, false, false);

		Iterator vIter = vFieldMap.entrySet().iterator();
		while (vIter.hasNext()) {
			Map.Entry vEntry = (Map.Entry) vIter.next();
			Object vKey = vEntry.getKey();
			Object vVal = vEntry.getValue();

			if (vVal != null) {
				vQuery.setParameter(vKey.toString(), vVal);
			}
		}

		try {
			vResult = vQuery.getResultList();
			logger.info("取得 " + vResult.size() + " 筆資料");
		} catch (NoResultException nre) {
			vResult = null;
		}

		return vResult;
	}
	
	public Collection findBySQL(Object pModel, String pSql) {
		Collection vResult = Collections.EMPTY_LIST;
		
		Query vQuery = gEntityManager.createNativeQuery(pSql, pModel.getClass());
		logger.info("SQL字串: " + pSql);

		try {
			vResult = vQuery.getResultList();
			logger.info("取得 " + vResult.size() + " 筆資料");
		} catch (NoResultException nre) {
			vResult = null;
		}

		return vResult;
	}
	
	public Long  getNextKey(String pSeq) {
		Query vQuery = gEntityManager.createNativeQuery("select " + pSeq + ".nextval from dual");
	    Long vKey = Long.parseLong(vQuery.getSingleResult().toString());
	    return vKey;
	}
	
	public int update(String pSql) {
		int vResult = 0;
		
		Query vQuery = gEntityManager.createNativeQuery(pSql);
		logger.info("SQL字串: " + pSql);
		
		vResult = vQuery.executeUpdate();
		logger.info("更新 " + vResult + " 筆資料");
		return vResult;
	}

	
	// Override from SessionAware
	public void setSession(Map pSession) {
		this.gSession = pSession;
	}
	
	public Map getSession() {
		return gSession;
	}

	public void setEntityManager(EntityManager pEntityManager) {
		this.gEntityManager = pEntityManager;
	}
	
	public void setEntityManagerUat(EntityManager pEntityManagerUat) {
		//this.entityManagerUat = entityManagerUat;
	}

	public Long getMaxId(String pTableName) {
		ArrayList vLst = (ArrayList) findByTableName(pTableName, "id", "desc");
		Object vModel;
		
		if(vLst != null && vLst.size() > 0) {
			vModel = vLst.get(0);
			logger.info("max id of " + pTableName + ": " + BOTool.getId(vModel));
			return BOTool.getId(vModel);
		} else {
			logger.info("max id of " + pTableName + ": 0");
			return 0L;
		}
		
	}
	
	public Long getMaxId(Object pModel) {
		String vClassName = pModel.getClass().getSimpleName();
		
		ArrayList vLst = (ArrayList) findByObject(pModel, "id", "desc");
		Object vResult;
		
		if(vLst != null && vLst.size() > 0) {
			vResult = vLst.get(0);
			logger.info("max id of " + vClassName + ": " + BOTool.getId(vResult));
			return BOTool.getId(vResult);
		} else {
			logger.info("max id of " + vClassName + ": 0");
			return 0L;
		}
		
	}
	
	public String insertActionApproves(String pCheckType, String pParams, String pAcct, String pUserName) {				
		ActionApproves vActaprv = new ActionApproves();
		vActaprv.setAction_type(pCheckType);
		vActaprv.setStatus("waiting");
		vActaprv.setId(this.gActionApprovesService.getMaxId() + 1);
		vActaprv.setParams(pParams);
		vActaprv.setApply_user(pAcct);
		vActaprv.setApply_name(pUserName);
		vActaprv.setApply_at(BOTool.getCurrentTime());
		
		String vSqlcommand = "INSERT INTO action_approves (id, action_type,params,apply_user,apply_name,apply_at,status) " +
				"values (" + vActaprv.getId() + "," +
						 "'" + vActaprv.getAction_type() + "',"+
						 "'" + vActaprv.getParams() + "',"+
						 "'" + vActaprv.getApply_user() + "'," + 
						 "'" + vActaprv.getApply_name() + "'," +
						 "'" + vActaprv.getApply_at().toString() +"'," +
						 "'" + vActaprv.getStatus() + "')";
		
		logger.info("sqlcommand: " + vSqlcommand);
		
		this.gActionApprovesService.insert(DBConstants.CONFIRM, vActaprv);
		
		return vSqlcommand;
	}
	
	// auditLogs
	public void insertAuditLogs(String pAction, String pParam, String pStatus, String pSqlCmd, String pAcct, String pIp) {
		AuditLogs vAuditlog = new AuditLogs();
		
		vAuditlog.setId(this.gAuditLogsService.getMaxId() + 1);
		vAuditlog.setIp(pIp);
		vAuditlog.setUser_id(pAcct);
		vAuditlog.setController(this.getClass().getSimpleName());
		vAuditlog.setAction(pAction);
		vAuditlog.setParams(pParam);
		vAuditlog.setStatus(pStatus);
		vAuditlog.setUpdated_at(BOTool.getCurrentTime());
		vAuditlog.setCompanydomain(null);
		vAuditlog.setSqlcommand(pSqlCmd);
		
		this.gAuditLogsService.insert(DBConstants.CONFIRM, vAuditlog);

	}

}
