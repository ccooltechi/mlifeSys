package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansOperatorEntity;

public class OperatorDao {
	private static Logger logger = LoggerFactory.getLogger(OperatorDao.class);

	public OperatorDao()
	{
		
	}
	
	public List<PlansOperatorEntity> findAllOperators()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansOperatorEntity> plansOperator = null;
		Query query = session.getNamedQuery("PlansOperator.findAll");
		System.out.println("Size = "+query.list().size());
		plansOperator = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}

	public PlansOperatorEntity findPlansByOperatorByName(String operator_name)
	{
		Session session = HibernateSessionManager.getSession();
		PlansOperatorEntity plansOperator = null;
		Query query = session.getNamedQuery("PlansOperator.findByOperatorName");
		query.setParameter("operatorName", operator_name);
		System.out.println("Size = "+query.list().size());
		plansOperator = (PlansOperatorEntity)query.list().get(0);
		System.out.println("operator ID = "+plansOperator.getId());
		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}
	
	public PlansOperatorEntity findPlansByOperatorByID(int operator_id)
	{
		Session session = HibernateSessionManager.getSession();
		PlansOperatorEntity plansOperator = null;
		Query query = session.getNamedQuery("PlansOperator.findById");
		query.setParameter("id", operator_id);
		System.out.println("Size = "+query.list().size());
		plansOperator = (PlansOperatorEntity)query.list().get(0);
		System.out.println("operator ID = "+plansOperator.getId());
		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}
	

	public List<PlansOperatorEntity> findOperatorsByCountry(String operatorCountry)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansOperatorEntity> plansOperator = null;
		Query query = session.getNamedQuery("PlansOperator.findByCountry");
		query.setParameter("operatorCountry", operatorCountry);
		System.out.println("Size = "+query.list().size());
		plansOperator = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}

	public List<PlansOperatorEntity> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansOperatorEntity> entityList = null;
		try {
			Query query = session.getNamedQuery("PlansOperatorEntity.findAll");
			entityList = (List<PlansOperatorEntity>)query.list();
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
	public PlansOperatorEntity findById(Integer id)
	{
		Session session = HibernateSessionManager.getSession();
		PlansOperatorEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlansOperatorEntity.findById");
			query.setParameter("id", id);
			System.out.println("findById = "+id);
			entity = (PlansOperatorEntity)(query.list().get(0));
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
	

	public List<PlansOperatorEntity> findByName(String name)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansOperatorEntity> entityList = null;
		try {
			Query query = session.getNamedQuery("PlansOperatorEntity.findByOperatorName");
			query.setParameter("operatorName", name);
			System.out.println("findByName = "+name);
			entityList = (List<PlansOperatorEntity>)query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return entityList;
	}
	

	public boolean saveData(PlansOperatorEntity entityObj) {
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

	public boolean updateData(PlansOperatorEntity entityObj) {
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

	public boolean deleteData(PlansOperatorEntity entityObj) {
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
			List<PlansOperatorEntity> plansPlanfeeList = null;

			String query = "Select * from plans_operator order by id desc limit 1";
			logger.debug("query in findID in  findId " + query);
			plansPlanfeeList = new HibernateDAO().findBySQLQuery(session, PlansOperatorEntity.class, query,"plans_operator");

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
