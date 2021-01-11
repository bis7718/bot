package com.bot.bis.utils;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Base64Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author JamesTzeng
 *
 */

@SuppressWarnings(value={"unused", "unchecked", "rawtypes"})
public class BOTool {
	protected static Logger logger = LogManager.getLogger(BOTool.class);
	
	public static void jsonToObject(JSONObject pJsonObj ,Object pModel) {
		JSONArray jsonArrayNames = pJsonObj.names();
		logger.info("json model: " + pModel);
		
		for (int i = 0; i < jsonArrayNames.length(); i++) {
			String vAttributeName;
			String vAttributeValue;
			try {
				vAttributeName = jsonArrayNames.get(i).toString();

				vAttributeValue = pJsonObj.get(vAttributeName).toString();

				logger.info("attributeName, attributeValue: " + vAttributeName + "," + vAttributeValue);
				//set value to object
				BOTool.setFieldValue(pModel, vAttributeName, vAttributeValue);
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				logger.info("e: " + e);
				e.printStackTrace();
			}
		}
	}
	
	public static JSONObject toJSONObject(Object pModel) {
		JSONObject vResult = new JSONObject(pModel);
		
		JSONArray vJsonArrayNames = vResult.names();
		
		for (int i = 0; i < vJsonArrayNames.length(); i++) {
			String vAttributeName;
			String vAttributeValue;
			try {
				vAttributeName = vJsonArrayNames.get(i).toString();

				vAttributeValue = vResult.get(vAttributeName).toString();

				if ("{}".equals(vAttributeValue) ||
						"[]".equals(vAttributeValue) ||
						"locale".equals(vAttributeName) ||
						vAttributeValue.indexOf("class") >= 0)
					vResult.remove(vAttributeName);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		logger.debug("JSONObject: " + vResult);
		
		return vResult;
	}
	
	
	public static Long getId(Object pModel) {
			Long vResult = null;
			logger.info("model: " + pModel);
			logger.info("getFieldValue: " + getFieldValue(pModel, "id"));
			vResult = (Long) getFieldValue(pModel, "id");
			logger.info("ID: " + vResult);
			return vResult;
	}
	
	/** annotation
	 * @param pModel
	 * @param pAnnotationName
	 * @return boolean
	 */
	public static boolean hasFieldAnnotation(Object pModel, String pAnnotationName) {
		boolean vResult = false;
		Class<?> vClass = pModel.getClass();
		Field[] vFileds = vClass.getDeclaredFields();

		if (vFileds.length > 0)
			for (int i = 0; i < vFileds.length; i++) {
				Annotation[] vAnnotations = vFileds[i].getAnnotations();

				if (vAnnotations.length > 0)
					for (int j = 0; j < vAnnotations.length; j++) {
						String vAnnotationNameInModel = vAnnotations[j].annotationType()
								.getSimpleName();
						if (pAnnotationName.equals(vAnnotationNameInModel))
							return true;
					}
			}
		return vResult;
	}
	
	public static void setFieldValue(Object pModel, Object pFieldName, Object pFieldValue) {
		Object vResult = null;

		Class<?> vClass = pModel.getClass();
		String vExpectedSetter = "set" + Character.toUpperCase(String.valueOf(pFieldName).charAt(0)) + String.valueOf(pFieldName).substring(1);
		String vExpectedGetter = "get" + Character.toUpperCase(String.valueOf(pFieldName).charAt(0)) + String.valueOf(pFieldName).substring(1);
		
		logger.debug("expectedSetter: " + vExpectedSetter);
		
		try {
			Method vMethod;
			String vStr = pFieldValue.toString();
			
			try {
				if (vExpectedSetter.indexOf("IdList") > 0 &&
						!"[]".equals(vStr)) {
					List vIdList = new ArrayList();
					
					vStr = vStr.substring(1, vStr.length()-1);
					
					String[] vStrArray = vStr.split(",");
					
					for(int i = 0; i < vStrArray.length; i++) {
						vIdList.add(Long.parseLong(vStrArray[i]));
					}
					
					vMethod = vClass.getDeclaredMethod(vExpectedSetter, List.class);
					vMethod.invoke(pModel, vIdList);
					
				} else if (vExpectedSetter.indexOf("List") > 0 &&
						!"[]".equals(vStr)) {
					logger.debug("List.class");
					vMethod = vClass.getDeclaredMethod(vExpectedSetter, List.class);
					vMethod.invoke(pModel, pFieldValue);
				} else if (vExpectedSetter.indexOf("List") > 0 &&
						"[]".equals(vStr)) {
					logger.debug("Empty List");
					vMethod = vClass.getDeclaredMethod(vExpectedSetter, List.class);
					vMethod.invoke(pModel, Collections.EMPTY_LIST);
				} else {
					//String.class, Departments.class, ...
					logger.debug("fieldValue.getClass(): " + pFieldValue.getClass());
					vMethod = vClass.getDeclaredMethod(vExpectedSetter, pFieldValue.getClass());
					vMethod.invoke(pModel, pFieldValue);
				}
			} catch (NoSuchMethodException nsme) {
				logger.debug("Long.class");
				vMethod = vClass.getDeclaredMethod(vExpectedSetter, Long.class);
				vMethod.invoke(pModel, Long.parseLong(pFieldValue.toString()));
			}
			
			vMethod = vClass.getDeclaredMethod(vExpectedGetter, new Class[]{});
			vResult = vMethod.invoke(pModel, new Object[]{});
			
			logger.debug("invoke method (" + vExpectedSetter + ")");
			logger.debug("result: " + vResult + ")");
		} catch (Exception e) {
			logger.debug("e: " + e);
			//e.printStackTrace();
		}
	} 
	
	
	/**
	 * @param pModel
	 * @param pFieldName
	 * @return Object
	 */
	public static Object getFieldValue(Object pModel, String pFieldName) {
		Object vResult = null;

		Class<?> vClass = pModel.getClass();
		String vExpectedGetter = "get" + Character.toUpperCase(pFieldName.charAt(0)) + pFieldName.substring(1);
		
		try {
			Method vMethod = vClass.getDeclaredMethod(vExpectedGetter, new Class[]{});
			vResult = vMethod.invoke(pModel, new Object[]{});
			logger.debug("invoke method (" + vExpectedGetter + "): " + vResult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug("e: " + e);
		}

		return vResult;
	} 
	
	public static String getBoIdListName(String pBotListName) {
		String vResult = null;
		
		//boListName: functionsList
		if(pBotListName.indexOf("List") > 0)
			vResult = pBotListName.substring(0, pBotListName.indexOf("List")) + "IdList";
		
		return vResult;
	}
	
	public static Map<String, Object> getAnnotationFieldValue(Object pModel, String pAnnotationName) {
		Map vResult = null;

		Class<?> vClass = pModel.getClass();
		Field[] vFileds = vClass.getDeclaredFields();

		if (vFileds.length > 0) {
			vResult = new HashMap();

			for (int i = 0; i < vFileds.length; i++) {
				boolean vCheckAnnotation = false;

				if ("ManyToMany".equals(pAnnotationName)) {
					if (vFileds[i].getAnnotation(ManyToMany.class) != null)
						vCheckAnnotation = true;
				}
				
				if ("ManyToOne".equals(pAnnotationName)) {
					if (vFileds[i].getAnnotation(ManyToOne.class) != null)
						vCheckAnnotation = true;
				}

				if (vCheckAnnotation)
					vResult.put(vFileds[i].getName(),
							getFieldValue(pModel, vFileds[i].getName()));
			}
		}

		return vResult;
	}
	
	/**	
	 * @param pModel
	 * @return Map
	 */
	public static Map getFieldValueMap(Object pModel, boolean pIsIncludeList, boolean pIsIncludeObject) {
		Map vResult = null;
		
		Class<?> vClass = pModel.getClass();
		Field[] vFileds = vClass.getDeclaredFields();
		
		if (vFileds.length > 0) {
			vResult = new HashMap();

			for (int i = 0; i < vFileds.length; i++) {
				//?��??? String ??? Long 類�?��?��?�數??��?�到 Map 中�?�其他�?�是 List 等物件�?��?�數??��?��??
				//@Transient也�?��??
				boolean vCheckTransient = false;
				if(vFileds[i].getAnnotation(Transient.class) != null)
					vCheckTransient = true;
				
				boolean vIsList = false;
				
				if(pIsIncludeList)
					vIsList = getFieldValue(pModel,vFileds[i].getName()) instanceof List;
				
				if(!vCheckTransient)
					if(!pIsIncludeObject) {
						if(getFieldValue(pModel,vFileds[i].getName()) instanceof String
								|| getFieldValue(pModel,vFileds[i].getName()) instanceof Long
								|| vIsList)
							if(getFieldValue(pModel,vFileds[i].getName()) != null &&
							!"".equals(getFieldValue(pModel,vFileds[i].getName())))
								vResult.put(vFileds[i].getName(), 
										getFieldValue(pModel,vFileds[i].getName()));
					} else {
						if(getFieldValue(pModel,vFileds[i].getName()) != null &&
								!"".equals(getFieldValue(pModel,vFileds[i].getName())))
									vResult.put(vFileds[i].getName(), 
											getFieldValue(pModel,vFileds[i].getName()));
					}
			}	
		}	
		
		return vResult;
	} 

	public static String getWhereString(Object pModel) {
		String vResult = "";
		
		Map vFieldMap = BOTool.getFieldValueMap(pModel, false, false);
		
		if (vFieldMap.size() > 0) {
			vResult = vResult + " where ";
			Iterator vIter = vFieldMap.entrySet().iterator();
			while (vIter.hasNext()) {
				Map.Entry entry = (Map.Entry) vIter.next();
				Object vKey = entry.getKey();
				Object vVal = entry.getValue();
				logger.info("key: " + vKey + ", val: " + vVal);
				
				if(vVal != null) {
					vResult = vResult + vKey + " = :" + vKey;
				
					if (vIter.hasNext() == true)
						vResult = vResult + " and ";
				}
					
			}
		}
		
		int vCheckStrLast = vResult.lastIndexOf(" and ");
		
		logger.info("checkStrLast: " + vCheckStrLast + ", length: " + vCheckStrLast);
		
		if(vCheckStrLast!= -1 && " and ".equals(vResult.substring(vCheckStrLast, vResult.length())))
			vResult = vResult.substring(0, vCheckStrLast);
		
		return vResult;
	}
	
	public static java.sql.Timestamp getCurrentTime() {	
		java.util.Date vUtilDate = new java.util.Date();
		java.sql.Timestamp vSqlDate = new java.sql.Timestamp(vUtilDate.getTime());
		
		return vSqlDate;
	}
	
	public static Long getCurrentTimeLong() {
		Date vDt = new java.util.Date();
		return vDt.getTime();
	}
	
	public static String getFormatedTimestamp(Timestamp pTs, String pPattern) {
		//pattern = "yyyy-MM-dd HH:mm:ss"
		DateFormat vSdf = new SimpleDateFormat(pPattern);
		String vTsStr = vSdf.format(pTs.getTime());
		return vTsStr;
	}
	
	public static String checkDate(String pDateStr, String pFormat) {
		String vDt;
		
		if("yyyyMMdd".equals(pFormat)) {
			if(pDateStr.length() != 8)
				return CommonConstants.ERROR;
			
			vDt = pDateStr.substring(0,4) + "/" +
						pDateStr.substring(4,6) + "/" +
						pDateStr.substring(6,8);
		}
		else if("yyyy-MM-dd".equals(pFormat)) {
			if(pDateStr.length() != 10)
				return CommonConstants.ERROR;
			
			vDt = pDateStr.substring(0,4) + "/" +
						pDateStr.substring(5,7) + "/" +
						pDateStr.substring(8,10);
		}
		else if("yyyy/MM/dd".equals(pFormat)) {
			if(pDateStr.length() != 10)
				return CommonConstants.ERROR;
			
			vDt = pDateStr;
		}
		else {
			vDt = "";
		}
		
		SimpleDateFormat vDf = new SimpleDateFormat("yyyy/MM/dd");
		
		logger.info("dt: " + vDt);
		
		try {
			Date vDate = vDf.parse(vDt);
			return CommonConstants.SUCCESS;
		} catch (ParseException e) {
			logger.info("e: " + e);
			e.printStackTrace();
			return CommonConstants.ERROR;
		} catch (Exception e) {
			logger.info("e: " + e);
			e.printStackTrace();
			return CommonConstants.ERROR;
		}
	}
	
	public static boolean isBlankOrNull(String pObj) {
		if(pObj == null || "".equals(pObj))
			return true;
		else
			return false;
	}
}
