package com.bot.bis.service;

import java.util.Base64;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bot.bis.daoInter.UsersDao;
import com.bot.bis.model.Users;
import com.bot.bis.serviceInter.DataAccessService;
import com.bot.bis.serviceInter.UsersService;

@SuppressWarnings("unchecked")
@Service
public class UsersServiceImpl implements UsersService {

	// Log Factory
	final Logger logger = LogManager.getLogger(this);

	@Autowired
	private UsersDao gUsersDao;

	@Qualifier("auditLogsServiceImpl")
	@Autowired
	private DataAccessService gAuditLogsService;

	@Override
	public Object authenticate(Object pModel) {
		Users vValidUser = null;
		Users vUsr = (Users) pModel;

		logger.info("Authenticating: username = " + vUsr.getCode());

		boolean vIsExistsResult = gUsersDao.isExists(vUsr);

		if (vIsExistsResult) {

			Users vUser = (Users) ((List<Users>) gUsersDao.list(vUsr)).get(0);

			/* If the username mapped to a real user, check password */
			if (vUser != null && vUsr.getPass().equals(vUser.getPass())) {
				vValidUser = vUser;
				gAuditLogsService.insertAuditLogs("認證使用者", this.getClass().getSimpleName(), null, "成功", null);
			} else {
				gAuditLogsService.insertAuditLogs("認證使用者", this.getClass().getSimpleName(), null, "失敗", null);
			}
		} else {
			gAuditLogsService.insertAuditLogs("認證使用者", this.getClass().getSimpleName(), null, "使用者不存在", null);
		}
		return vValidUser;
	}

	@Override
	public String getUserName(String pEncryptAcct) {
		logger.info("Encode Acct:" + pEncryptAcct);
		String vDecodeAcct = new String(Base64.getDecoder().decode(pEncryptAcct));
		logger.info("Decode Acct:" + vDecodeAcct);
		gAuditLogsService.insertAuditLogs("使用者名稱加密", this.getClass().getSimpleName(), null, "成功", null);
		return gUsersDao.getUser(vDecodeAcct).getName();
	}

	@Override
	public List<Users> getAllUser() {
		return gUsersDao.getAllUser();
	}

	@Override
	public Users getUser(String pAcct) {
		return gUsersDao.getUser(pAcct);
	}

}
