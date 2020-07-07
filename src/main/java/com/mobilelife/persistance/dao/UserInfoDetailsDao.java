package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.TelcoMisHibernateSessionManager;
import com.mobilelife.persistance.entities.UserInfoDetailsEntity;

public class UserInfoDetailsDao {
	private static Logger logger = LoggerFactory.getLogger(UserInfoDetailsDao.class);
	
	
	public UserInfoDetailsDao()
	{
		
	}
	
	public List<UserInfoDetailsEntity> findAllCountry()
	{
		Session session = TelcoMisHibernateSessionManager.getSession();
		List<UserInfoDetailsEntity> userInfoList = null;
		Query query = session.getNamedQuery("UserInfoDetails.findAll");
		System.out.println("Size = "+query.list().size());
		userInfoList = (List<UserInfoDetailsEntity>)query.list();
		return userInfoList;
	}

	public List<UserInfoDetailsEntity> findUserInfoDetailsBySubID(String subId)
	{
		Session session = TelcoMisHibernateSessionManager.getSession();
		List<UserInfoDetailsEntity> userInfoList = null;
		Query query = session.getNamedQuery("UserInfoDetails.findBySubId");
		query.setParameter("subId", subId);
		System.out.println("findUserInfoByID = "+subId);
		userInfoList = (List<UserInfoDetailsEntity>)query.list();
		return userInfoList;
	}
	
	public int findId()
	{
		Session session = TelcoMisHibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<UserInfoDetailsEntity> resultList = null;

			String query = "Select * from user_info_details order by id desc";
			logger.debug("query in findID in  user_info_details " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, UserInfoDetailsEntity.class, query,"user_info_details");

			logger.debug("findID  in  UserInfo Size = "+resultList.size());
			if ((null!=resultList) && (resultList.size()>0))
			{
				rid = resultList.get(0).getSubId();
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


	public void saveData(UserInfoDetailsEntity entityObj) {
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
		UserInfoDetailsDao searchPlan = new UserInfoDetailsDao();
	}


}
