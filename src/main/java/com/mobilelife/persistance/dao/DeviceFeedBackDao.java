package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.DeviceFeedback;

public class DeviceFeedBackDao {
	private static Logger logger = LoggerFactory.getLogger(DeviceFeedBackDao.class);

	public DeviceFeedBackDao()
	{
		
	}

	public int findagv(int palnrefid)
	{
		Session session = HibernateSessionManager.getSession();
		int rating = 0;
		try {
			String query = "select avg(rating) as rate from device_feedback where deviceprimaryid ="+palnrefid; 
            List palnDeviceDataList = new HibernateDAO().findBySQLQuery(session, query);
			logger.debug("getTotalPlans Size = "+palnDeviceDataList.size());
			if ((null!=palnDeviceDataList) && (palnDeviceDataList.size()>0))
			{
                for (int i = 0; i < palnDeviceDataList.size(); i++) {
                	Double ratingx = Double.parseDouble(palnDeviceDataList.get(i)+"");
                	rating = ratingx.intValue();
        			logger.debug("rating = "+rating);
        			
                }
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return rating;
	}

	public int findtotalFeedback(int palnrefid)
	{
		Session session = HibernateSessionManager.getSession();
		int rating = 0;
		try {
			String query = "select count(rating) as rate from device_feedback where deviceprimaryid ="+palnrefid; 
            List palnDeviceDataList = new HibernateDAO().findBySQLQuery(session, query);
			logger.debug("getTotalPlans Size = "+palnDeviceDataList.size());
			if ((null!=palnDeviceDataList) && (palnDeviceDataList.size()>0))
			{
                for (int i = 0; i < palnDeviceDataList.size(); i++) {
                	Double ratingx = Double.parseDouble(palnDeviceDataList.get(i)+"");
                	rating = ratingx.intValue();
        			logger.debug("rating = "+rating);
        			
                }
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return rating;
	}

	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<DeviceFeedback> resultList = null;

			String query = "Select * from device_feedback order by id desc";
			logger.debug("query in findID in  device_feedback " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, DeviceFeedback.class, query,"device_feedback");

			logger.debug("findID  in  device_feedback Size = "+resultList.size());
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

	public void saveData(DeviceFeedback entityObj) {
		Session session = HibernateSessionManager.getSession();
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

	public static void main(String args[])
	{
		new DeviceFeedBackDao().findagv(600);
	}

}
