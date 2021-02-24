package com.bot.bis.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.bot.bis.dao.AbstractDao;
import com.bot.bis.daoInter.UsersDao;
import com.bot.bis.model.Users;

@SuppressWarnings("rawtypes")
@Repository
public class UsersDaoImpl extends AbstractDao<Users, Object> implements UsersDao {

  @Override
  public List<Users> getAllUser() {
	  CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
	  CriteriaQuery<Users> cq = builder.createQuery(Users.class);
	  Root<Users> root = cq.from(Users.class);
	  cq.select(root);
	  
	  return getEntityManager().createQuery(cq).getResultList();
  }

  @Override
  public Users getUser(String pAcct) {
	  return (Users) getEntityManager().createQuery("FROM Users u WHERE u.code LIKE :acct").setParameter("acct", pAcct).getSingleResult();
	  
  }

  @Override
  public boolean isExists(Object pUsr) {
	  return super.isExistsByObject(pUsr);
  }

  @Override
  public Collection list(Object pUsr) {
	  
	  return super.findByObject(pUsr, "id", "desc");
  }
}
