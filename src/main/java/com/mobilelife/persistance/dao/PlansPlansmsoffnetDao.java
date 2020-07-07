package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlansmsEntity;
import com.mobilelife.persistance.entities.PlansPlansmsoffnetEntity;

public class PlansPlansmsoffnetDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlansmsoffnetDao.class);

	public PlansPlansmsoffnetDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlansmsoffnetEntity> resultList = null;

			String query = "Select * from plans_plansmsoffnet order by id desc";
			logger.debug("query in findID in  PlansPlansmsoffnet " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlansmsoffnetEntity.class, query,"plans_plansmsoffnet");

			logger.debug("findID  in  PlansPlansmsoffnet Size = "+resultList.size());
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

	public PlansPlansmsoffnetEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlansmsoffnetEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlansmsoffnetEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlansmsoffnetEntity)(query.list().get(0));
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

	public boolean saveData(PlansPlansmsoffnetEntity entityObj) {
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

	public boolean updateData(PlansPlansmsoffnetEntity entityObj) {
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
