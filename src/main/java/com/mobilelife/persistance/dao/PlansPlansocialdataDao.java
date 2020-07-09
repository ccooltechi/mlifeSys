package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlansmsonnet;
import com.mobilelife.persistance.entities.PlansPlansocialdata;

public class PlansPlansocialdataDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansocialdataDao.class);

	public PlansPlansocialdataDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlansocialdata> resultList = null;

			String query = "Select * from plans_plansocialdata order by id desc";
			logger.debug("query in findID in  PlansPlansocialdata " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlansocialdata.class, query,"plans_plansocialdata");

			logger.debug("findID  in  PlansPlansocialdata Size = "+resultList.size());
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

	public PlansPlansocialdata findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlansocialdata entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlansocialdata.findById");
			query.setParameter("id", id);
			entity = (PlansPlansocialdata)(query.list().get(0));
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

	public boolean saveData(PlansPlansocialdata entityObj) {
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

	public boolean updateData(PlansPlansocialdata entityObj) {
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

}
