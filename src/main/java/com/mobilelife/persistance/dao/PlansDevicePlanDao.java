package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansDeviceplans;

public class PlansDevicePlanDao {
	private static Logger logger = LoggerFactory.getLogger(PlansDevicePlanDao.class);

	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansDeviceplans> resultList = null;

			String query = "Select * from plans_deviceplans order by id desc limit 2";
			logger.debug("query in findID in  PlansDevicePlanDao " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansDeviceplans.class, query,"plans_deviceplans");

			logger.debug("findID  in  PlansDeviceprimary Size = ");
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

	public PlansDeviceplans findPlansDevicePlan(String id)
	{
		Session session = HibernateSessionManager.getSession();
		PlansDeviceplans plansDeviceplans = null;
		try {
			List<PlansDeviceplans> resultList = null;

			String query = "Select * from plans_deviceplans where id='"+id+"'";
			logger.debug("query in findID in  PlansDevicePlanDao " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansDeviceplans.class, query,"plans_deviceplans");

			logger.debug("findID  in  PlansDeviceprimary Size = ");
			if ((null!=resultList) && (resultList.size()>0))
			{
				plansDeviceplans = resultList.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return plansDeviceplans;
	}

	public List<PlansDeviceplans> findAllPlansDevicePlan()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansDeviceplans> resultListRet = null;
		try {
			List<PlansDeviceplans> resultList = null;
			String query = "Select * from plans_deviceplans where is_active=1";
			logger.debug("query in findID in  PlansDevicePlanDao " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansDeviceplans.class, query,"plans_deviceplans");

			logger.debug("findID  in  PlansDeviceprimary Size = ");
			if ((null!=resultList) && (resultList.size()>0))
			{
				resultListRet = resultList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return resultListRet;
	}
	
	public void saveData(PlansDeviceplans entityObj) {
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

	public void updateData(PlansDeviceplans entityObj) {
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(entityObj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

}
