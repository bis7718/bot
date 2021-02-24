package com.bot.bis.utils;

public class BotUtils {
	public static boolean isEmptyorNull(String pString) {
		boolean vResult = false;
		
		if(pString == null || pString == "")
			vResult = true;
		
		return vResult;
	}
	
	public static String findBisHome() {
//		Context ctx;
//		String bisHome = null;
//		try {
//			ctx = new InitialContext();
//			bisHome = (String)ctx.lookup("java:comp/env/BIS_HOME");
//			logger.fatal(Utility.filter("bisHome：" + bisHome));
//		} catch (NamingException e) {
//			bisHome = "";
//			logger.fatal("findBisHome error");
//		}  

		return "C:/Users/Administrator/Desktop/temp";
	}
}
