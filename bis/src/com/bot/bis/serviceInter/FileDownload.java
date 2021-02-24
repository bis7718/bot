package com.bot.bis.serviceInter;

import java.io.InputStream;

public interface FileDownload {
	public InputStream getInputStream() throws Exception;
	public String getDownloadFileName();
	public String getFilename();
	public void setFilename(String pFilename);
	
}
