package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.dbutils.TelcoMisHibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanprimary;
import com.mobilelife.persistance.entities.UserInfo;

public class UserInfoDao {
	private static Logger logger = LoggerFactory.getLogger(UserInfoDao.class);
	
	
	public UserInfoDao()
	{
		
	}
	
	public List<UserInfo> findAllCountry()
	{
		Session session = TelcoMisHibernateSessionManager.getSession();
		List<UserInfo> userInfoList = null;
		Query query = session.getNamedQuery("UserInfo.findAll");
		System.out.println("Size = "+query.list().size());
		userInfoList = (List<UserInfo>)query.list();
		return userInfoList;
	}

	public List<UserInfo> findUserInfoByID(String userid)
	{
		Session session = TelcoMisHibernateSessionManager.getSession();
		List<UserInfo> userInfoList = null;
		Query query = session.getNamedQuery("UserInfo.findByUserId");
		query.setParameter("userId", userid);
		System.out.println("findUserInfoByID = "+userid);
		userInfoList = (List<UserInfo>)query.list();
		return userInfoList;
	}
	
	public int findId()
	{
		Session session = TelcoMisHibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<UserInfo> resultList = null;

			String query = "Select * from user_info order by id desc";
			logger.debug("query in findID in  user_info " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, UserInfo.class, query,"user_info");

			logger.debug("findID  in  UserInfo Size = "+resultList.size());
			if ((null!=resultList) && (resultList.size()>0))
			{
				rid = resultList.get(0).getId();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return rid;
	}


	public void saveData(UserInfo entityObj) {
		Session session = TelcoMisHibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entityObj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	
	public static void main(String[] args) {
		UserInfoDao searchPlan = new UserInfoDao();
	}


}
