package com.bot.bis.service;

import java.util.Base64;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bot.bis.dao.UsersDao;
import com.bot.bis.model.Users;
import com.bot.bis.service.UsersServiceInterface;

@Service
public class UsersServiceImpl implements UsersServiceInterface {

	//Log Factory	
	final Logger logger = LogManager.getLogger(this);
	
	@Autowired
	private UsersDao gUsersDao;
	
	@Override
	public Object authenticate(Object pModel) {
		Users vValidUser = null;
		Users vUsr = (Users) pModel;
		
		logger.info("Authenticating: username = " + vUsr.getCode());
		
		//?è™Ë¶ÅCode, Pass ?õ∏??åÂ∞±Ë™çÂ?öË©≤?ì°Â∑•Áôª?Ö•??êÂ??
		boolean vIsExistsResult = gUsersDao.isExists(vUsr);
		
		if (vIsExistsResult) {
	    	
			Users vUser = (Users) ((List<Users>) gUsersDao.list(vUsr)).get(0);

	    	/* If the username mapped to a real user, check password */
			if ( vUser != null && vUsr.getPass().equals(vUser.getPass())) {
				vValidUser = vUser;
			
			}
		}
		
		logger.info("validUser = " + vValidUser );
		
		return vValidUser;
	}
	
	@Override
	public String getUserName(String pEncryptAcct) {
		logger.info("Encode Acct:"+pEncryptAcct);
		String vDecodeAcct = new String(Base64.getDecoder().decode(pEncryptAcct));
		logger.info("Decode Acct:"+vDecodeAcct);
		return gUsersDao.getUser(vDecodeAcct).getName();
	}

}
