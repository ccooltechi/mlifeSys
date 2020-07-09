package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanprimaryLocale;

public class PlansPlanprimaryLocaleDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanprimaryLocaleDao.class);

	public PlansPlanprimaryLocaleDao()
	{
		
	}
	
	public List<PlansPlanprimaryLocale> findAll(int palnprimaryid, String locale)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimaryLocale> plansPlanprimary = null;
		try {
			List<PlansPlanprimaryLocale> plansPlanprimaryList = null;

			String query = "Select a.* from plans_planprimary_locale a where plan_primary_id = "+palnprimaryid+" order by id";
			if (!locale.isEmpty())
				query = "Select a.* from plans_planprimary_locale a where plan_primary_id = "+palnprimaryid+" and locale='"+locale+"' order by id";
			
//			logger.debug("query in findAllPlans for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimaryLocale.class, query,"plans_planprimary_locale");

			logger.debug("findPlansByOperatorID Size = "+plansPlanprimaryList.size());
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
		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
		
	}


	
	public List<PlansPlanprimaryLocale> findPlansByPlanID(String planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimaryLocale> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansPlanprimaryLocale.findByPlanId");
		query.setParameter("planId", planID);
		logger.debug("findPlansByID planID = "+planID);
		plansPlanprimary = (List<PlansPlanprimaryLocale>)query.list();
		return plansPlanprimary;
	}

	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanprimaryLocale> resultList = null;

			String query = "Select * from plans_planprimary_locale order by id desc";
			logger.debug("query in findID in  PlansPlanprimaryLocale " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimaryLocale.class, query,"plans_planprimary_locale");

			logger.debug("findID  in  PlansPlanprimaryLocale Size = "+resultList.size());
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

	
	public boolean savePlansPlanprimary(PlansPlanprimaryLocale plansPlanprimary) {
		boolean retVal = false;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(plansPlanprimary);
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

	public boolean saveData(PlansPlanprimaryLocale entityObj) {
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

	public boolean updateData(PlansPlanprimaryLocale entityObj) {
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
