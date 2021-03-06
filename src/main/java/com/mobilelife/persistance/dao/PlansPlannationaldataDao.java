package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanmiscellaneous;
import com.mobilelife.persistance.entities.PlansPlannationaldata;

public class PlansPlannationaldataDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationaldataDao.class);

	public PlansPlannationaldataDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlannationaldata> resultList = null;

			String query = "Select * from plans_plannationaldata order by id desc";
			logger.debug("query in findID in  PlansPlannationaldata " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlannationaldata.class, query,"plans_plannationaldata");

			logger.debug("findID  in  PlansPlannationaldata Size = "+resultList.size());
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

	public boolean saveData(PlansPlannationaldata entityObj) {
		boolean retVal = false; 
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entityObj);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean updateData(PlansPlannationaldata entityObj) {
		boolean retVal = false; 
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(entityObj);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public PlansPlannationaldata findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlannationaldata entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlannationaldata.findById");
			query.setParameter("id", id);
			entity = (PlansPlannationaldata)(query.list().get(0));
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return entity;
	}

}
