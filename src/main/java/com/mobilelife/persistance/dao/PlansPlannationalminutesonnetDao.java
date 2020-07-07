package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlannationalminutesoffnetEntity;
import com.mobilelife.persistance.entities.PlansPlannationalminutesonnetEntity;

public class PlansPlannationalminutesonnetDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlannationalminutesonnetDao.class);

	public PlansPlannationalminutesonnetDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlannationalminutesonnetEntity> resultList = null;

			String query = "Select * from plans_plannationalminutesonnet order by id desc";
			logger.debug("query in findID in  PlansPlannationalminutesonnet " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlannationalminutesonnetEntity.class, query,"plans_plannationalminutesonnet");

			logger.debug("findID  in  PlansPlannationalminutesonnet Size = "+resultList.size());
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

	public boolean saveData(PlansPlannationalminutesonnetEntity entityObj) {
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

	public boolean updateData(PlansPlannationalminutesonnetEntity entityObj) {
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

	public PlansPlannationalminutesonnetEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlannationalminutesonnetEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlannationalminutesonnetEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlannationalminutesonnetEntity)(query.list().get(0));
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
