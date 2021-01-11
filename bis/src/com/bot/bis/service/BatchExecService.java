package com.bot.bis.service;

import javax.servlet.http.HttpServletRequest;

public interface BatchExecService {

	String runBatch(String pDataDt, String pCode, HttpServletRequest pHttpServletRequest);

}
