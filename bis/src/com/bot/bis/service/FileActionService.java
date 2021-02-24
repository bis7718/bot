package com.bot.bis.service;

import java.util.List;

import com.bot.bis.model.FileInfo;

@SuppressWarnings(value={"rawtypes"})
public interface FileService {
	public List<FileInfo> listFiles(String pFilePath);
	public FileInfo findFile(String pFolderPath, String pFileName);
	public String copyFile(String pSourcePath, String pTargetPath, boolean pIsCsv);
	public String deleteFile(String pFilePath);
	public String findExtension(String pFileName);	
	public String createExcelFile(String[] pFieldName, List pDataList, String pTargetPath);
}
