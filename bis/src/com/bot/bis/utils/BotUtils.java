package com.bot.bis.utils;

public class BotUtils {
	public static boolean isEmptyorNull(String pString) {
		boolean vResult = false;
		
		if(pString == null || pString == "")
			vResult = true;
		
		return vResult;
	}
}
