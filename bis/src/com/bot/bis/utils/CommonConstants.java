package com.bot.bis.utils;

import java.util.HashMap;

public class CommonConstants {
	public static final String FAILED_LOGIN = "FL";
	public static final String FAILED_AUTHORIZATION = "FA";
	public static final String FAILED_OTHERS = "FO";
	public static final String SUCCESS = "S";
	public static final String ERROR = "E";
	public static final String FAILED = "F";
	public static final String INPUT = "INPUT";

	public static String getSym(String key) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("/batchmgmt/op", "batchexec_1_1");
		map.put("/batchmgmt/stop", "batchexec_1_2");
		map.put("/batchmgmt/sessionlist", "batchexec_1_3");
		map.put("/batchmgmt/sessionall", "batchexec_1_4");
		map.put("/jobmgmt/list", "batchexec_2_1");
		map.put("/jobmgmt/input", "batchexec_2_2");
		map.put("/jobmgmt/order", "batchexec_2_3");
		map.put("/filemgmt/result", "batchexec_3_1");
		map.put("/filemgmt/log", "batchexec_3_2");
		map.put("/filemgmt/upload", "fileupload_1_1");
		map.put("/filemgmt/uploadlist", "fileupload_1_2");
		map.put("/filemgmt/sysupload", "fileupload_1_3");
		map.put("/filequery/arrivelist", "fileupload_2_1");
		map.put("/filequery/inputlist", "fileupload_2_2");
		map.put("/filequery/fixlist", "fileupload_2_3");
		map.put("/filequery/risklist", "fileupload_2_4");
		map.put("/filequery/archive", "fileupload_2_5");
		map.put("/filelimit/list", "fileupload_3_1");
		map.put("/filelimit/apply", "fileupload_3_2");
		map.put("/usrmgmt/list", "sysmgmt_1_1");
		map.put("/usrmgmt/input", "sysmgmt_1_2");
		map.put("/groupmgmt/list", "sysmgmt_2_1");
		map.put("/groupmgmt/input", "sysmgmt_2_2");
		map.put("/auditlog/op", "sysmgmt_3_1");
		map.put("/list", "deptmgmt_1_1");
		map.put("/input", "deptmgmt_1_2");
		map.put("/actaprv/log", "aprvmgmt_1_1");
		map.put("/actaprv/confirm", "aprvmgmt_1_2");
		map.put("/fileupaprv/log", "aprvmgmt_2_1");
		map.put("/fileupaprv/confirm", "aprvmgmt_2_2");
		map.put("/sysfileupaprv/log", "aprvmgmt_3_1");
		map.put("/sysfileupaprv/confirm", "aprvmgmt_3_2");
		map.put("/auditlog/batchop", "sysmgmt_3_2");
		return map.get(key);
	}
}
