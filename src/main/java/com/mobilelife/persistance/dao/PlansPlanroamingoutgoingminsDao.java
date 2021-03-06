package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanroamingincomingmins;
import com.mobilelife.persistance.entities.PlansPlanroamingoutgoingmins;

public class PlansPlanroamingoutgoingminsDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanroamingoutgoingminsDao.class);

	public PlansPlanroamingoutgoingminsDao()
	{
		
	}
	
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanroamingoutgoingmins> resultList = null;

			String query = "Select * from plans_planroamingoutgoingmins order by id desc";
			logger.debug("query in findID in  PlansPlanroamingoutgoingmins " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanroamingoutgoingmins.class, query,"plans_planroamingoutgoingmins");

			logger.debug("findID  in  PlansPlanroamingoutgoingmins Size = "+resultList.size());
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

	public PlansPlanroamingoutgoingmins findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanroamingoutgoingmins entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanroamingoutgoingmins.findById");
			query.setParameter("id", id);
			entity = (PlansPlanroamingoutgoingmins)(query.list().get(0));
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

	public boolean saveData(PlansPlanroamingoutgoingmins entityObj) {
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

	public boolean updateData(PlansPlanroamingoutgoingmins entityObj) {
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
