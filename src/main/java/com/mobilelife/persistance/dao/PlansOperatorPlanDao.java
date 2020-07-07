package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.CountriesEntity;
import com.mobilelife.persistance.entities.PlansOperatorEntity;
import com.mobilelife.persistance.entities.PlansPlantypeEntity;
import com.mobilelife.persistance.entities.PlansPlantypeConfEntity;;

public class PlansOperatorPlanDao {
	private static Logger logger = LoggerFactory.getLogger(PlansOperatorPlanDao.class);

	public PlansOperatorPlanDao()
	{
		
	}
	
	public List<PlansPlantypeEntity> findPlanTypes(int operator)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlantypeEntity> plansPlantype = null;
		try {
			String query = "select * from plans_plantype where id in (Select plan_primary_id from plans_operator_plan where is_active=1 and operator_id="+operator+")";
			logger.debug("query in findPlanTypes for  " + query);
			plansPlantype = new HibernateDAO().findBySQLQuery(session, PlansPlantypeEntity.class, query,"plans_plantype");

			logger.debug("findPlanTypes Size = "+plansPlantype.size());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return plansPlantype;
	}

	public List<PlansOperatorEntity> findoperators(int planType)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansOperatorEntity> plansOperator = null;
		try {
			String query = "select * from plans_operator where id in (Select operator_id from plans_operator_plan where is_active=1 and plan_primary_id="+planType+")";
			logger.debug("query in findoperators for  " + query);
			plansOperator = new HibernateDAO().findBySQLQuery(session, PlansOperatorEntity.class, query,"plans_operator");

			logger.debug("findoperators Size = "+plansOperator.size());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return plansOperator;
	}



}
