package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansOperatorTncEntity;
import com.mobilelife.persistance.entities.PlansPlanOperatorTncEntity;

public class PlansPlanOperatorTncDao {

	private static Logger logger = LoggerFactory.getLogger(PlansPlanprimaryDao.class);
	
	public PlansPlanOperatorTncDao()
	{
		
	}
	
	public List<PlansPlanOperatorTncEntity> findPlansTncByPlanID(int planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanOperatorTncEntity> plansPlanprimary = null;
		try {
			List<PlansPlanOperatorTncEntity> plansPlanprimaryList = null;

			String query = "Select a.* from plans_plan_operator_tnc a where a.is_active=1 and a.plan_primary_id ="+planID;
			logger.debug("query in findPlansTncByPlanID for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanOperatorTncEntity.class, query,"plans_plan_operator_tnc");

			logger.debug("findPlansTncByPlanID Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return plansPlanprimary;
	}
	
	public PlansOperatorTncEntity findPlansTnc(int plansOperatorTnc)
	{
		Session session = HibernateSessionManager.getSession();
		PlansOperatorTncEntity plansPlanprimary = null;
		try {
			List<PlansOperatorTncEntity> plansPlanprimaryList = null;

			String query = "Select a.* from plans_operator_tnc a where a.is_active=1 and a.id ="+plansOperatorTnc;
			logger.debug("query in findPlansByIDs for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansOperatorTncEntity.class, query,"plans_operator_tnc");

			logger.debug("findPlansByIDs Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return plansPlanprimary;
	}

	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanOperatorTncEntity> plansPlanOperatorTncList = null;

			String query = "Select * from plans_plan_operator_tnc order by id desc limit 2";
			logger.debug("query in findID in  PlansPlanOperatorTncDao " + query);
			plansPlanOperatorTncList = new HibernateDAO().findBySQLQuery(session, PlansPlanOperatorTncEntity.class, query,"plans_plan_operator_tnc");

			logger.debug("findID  in  PlansPlanfeeDao Size = "+plansPlanOperatorTncList.size());
			if ((null!=plansPlanOperatorTncList) && (plansPlanOperatorTncList.size()>0))
			{
				rid = plansPlanOperatorTncList.get(0).getId();
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

	public boolean saveData(PlansPlanOperatorTncEntity entityObj) {
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

	public boolean updateData(PlansPlanOperatorTncEntity entityObj) {
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

	public PlansPlanOperatorTncEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanOperatorTncEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanOperatorTncEntity.findById");
			query.setParameter("id", id);
			entity = (PlansPlanOperatorTncEntity)(query.list().get(0));
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
