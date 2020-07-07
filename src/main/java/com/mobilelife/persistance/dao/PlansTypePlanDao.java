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

public class PlansTypePlanDao {
	private static Logger logger = LoggerFactory.getLogger(PlansTypePlanDao.class);

	public PlansTypePlanDao()
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


	public List<PlansPlantypeEntity> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlantypeEntity> entityList = null;
		try {
			Query query = session.getNamedQuery("PlansPlantypeEntity.findAll");
			entityList = (List<PlansPlantypeEntity>)query.list();
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
	public PlansPlantypeEntity findById(Integer id)
	{
		Session session = HibernateSessionManager.getSession();
		PlansPlantypeEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlantypeEntity.findById");
			query.setParameter("id", id);
			System.out.println("findById = "+id);
			entity = (PlansPlantypeEntity)(query.list().get(0));
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
	

	public List<PlansPlantypeEntity> findByName(String name)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlantypeEntity> entityList = null;
		try {
			Query query = session.getNamedQuery("PlansPlantypeEntity.findByOperatorName");
			query.setParameter("operatorName", name);
			System.out.println("findByName = "+name);
			entityList = (List<PlansPlantypeEntity>)query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return entityList;
	}
	

	public boolean saveData(PlansPlantypeEntity entityObj) {
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

	public boolean updateData(PlansPlantypeEntity entityObj) {
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

	public boolean deleteData(PlansPlantypeEntity entityObj) {
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
			List<PlansPlantypeEntity> plansPlanfeeList = null;

			String query = "Select * from plans_plantype order by id desc limit 1";
			logger.debug("query in findID in  findId " + query);
			plansPlanfeeList = new HibernateDAO().findBySQLQuery(session, PlansPlantypeEntity.class, query,"plans_plantype");

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
