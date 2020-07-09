package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.Countries;
import com.mobilelife.persistance.entities.PlansOperator;
import com.mobilelife.persistance.entities.PlansPlantype;
import com.mobilelife.persistance.entities.PlansPlantypeConf;;

public class PlansTypePlanDao {
	private static Logger logger = LoggerFactory.getLogger(PlansTypePlanDao.class);

	public PlansTypePlanDao()
	{
		
	}
	
	public List<PlansPlantype> findPlanTypes(int operator)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlantype> plansPlantype = null;
		try {
			String query = "select * from plans_plantype where id in (Select plan_primary_id from plans_operator_plan where is_active=1 and operator_id="+operator+")";
			logger.debug("query in findPlanTypes for  " + query);
			plansPlantype = new HibernateDAO().findBySQLQuery(session, PlansPlantype.class, query,"plans_plantype");

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


	public List<PlansPlantype> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlantype> entityList = null;
		try {
			Query query = session.getNamedQuery("PlansPlantype.findAll");
			entityList = (List<PlansPlantype>)query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return entityList;
	}
	public PlansPlantype findById(Integer id)
	{
		Session session = HibernateSessionManager.getSession();
		PlansPlantype entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlantype.findById");
			query.setParameter("id", id);
			System.out.println("findById = "+id);
			entity = (PlansPlantype)(query.list().get(0));
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
	

	public List<PlansPlantype> findByName(String name)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlantype> entityList = null;
		try {
			Query query = session.getNamedQuery("PlansPlantype.findByOperatorName");
			query.setParameter("operatorName", name);
			System.out.println("findByName = "+name);
			entityList = (List<PlansPlantype>)query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return entityList;
	}
	

	public boolean saveData(PlansPlantype entityObj) {
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
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean updateData(PlansPlantype entityObj) {
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
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean deleteData(PlansPlantype entityObj) {
		boolean retVal = false;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(entityObj);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return retVal;
	}

	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlantype> plansPlanfeeList = null;

			String query = "Select * from plans_plantype order by id desc limit 1";
			logger.debug("query in findID in  findId " + query);
			plansPlanfeeList = new HibernateDAO().findBySQLQuery(session, PlansPlantype.class, query,"plans_plantype");

			logger.debug("findID  in  findId Size = "+plansPlanfeeList.size());
			if ((null!=plansPlanfeeList) && (plansPlanfeeList.size()>0))
			{
				rid = plansPlanfeeList.get(0).getId();
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


}
