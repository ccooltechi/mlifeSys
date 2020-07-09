package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansOperator;

public class OperatorDao {
	private static Logger logger = LoggerFactory.getLogger(OperatorDao.class);

	public OperatorDao()
	{
		
	}
	
	public List<PlansOperator> findAllOperators()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansOperator> plansOperator = null;
		Query query = session.getNamedQuery("PlansOperator.findAll");
		System.out.println("Size = "+query.list().size());
		plansOperator = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}

	public PlansOperator findPlansByOperatorByName(String operator_name)
	{
		Session session = HibernateSessionManager.getSession();
		PlansOperator plansOperator = null;
		Query query = session.getNamedQuery("PlansOperator.findByOperatorName");
		query.setParameter("operatorName", operator_name);
		System.out.println("Size = "+query.list().size());
		plansOperator = (PlansOperator)query.list().get(0);
		System.out.println("operator ID = "+plansOperator.getId());
		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}
	
	public PlansOperator findPlansByOperatorByID(int operator_id)
	{
		Session session = HibernateSessionManager.getSession();
		PlansOperator plansOperator = null;
		Query query = session.getNamedQuery("PlansOperator.findById");
		query.setParameter("id", operator_id);
		System.out.println("Size = "+query.list().size());
		plansOperator = (PlansOperator)query.list().get(0);
		System.out.println("operator ID = "+plansOperator.getId());
		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}
	

	public List<PlansOperator> findOperatorsByCountry(String operatorCountry)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansOperator> plansOperator = null;
		Query query = session.getNamedQuery("PlansOperator.findByCountry");
		query.setParameter("operatorCountry", operatorCountry);
		System.out.println("Size = "+query.list().size());
		plansOperator = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return plansOperator;
	}

	public List<PlansOperator> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansOperator> entityList = null;
		try {
			Query query = session.getNamedQuery("PlansOperator.findAll");
			entityList = (List<PlansOperator>)query.list();
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
	public PlansOperator findById(Integer id)
	{
		Session session = HibernateSessionManager.getSession();
		PlansOperator entity = null;
		try {
			Query query = session.getNamedQuery("PlansOperator.findById");
			query.setParameter("id", id);
			System.out.println("findById = "+id);
			entity = (PlansOperator)(query.list().get(0));
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
	

	public List<PlansOperator> findByName(String name)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansOperator> entityList = null;
		try {
			Query query = session.getNamedQuery("PlansOperator.findByOperatorName");
			query.setParameter("operatorName", name);
			System.out.println("findByName = "+name);
			entityList = (List<PlansOperator>)query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return entityList;
	}
	

	public boolean saveData(PlansOperator entityObj) {
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

	public boolean updateData(PlansOperator entityObj) {
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

	public boolean deleteData(PlansOperator entityObj) {
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
			List<PlansOperator> plansPlanfeeList = null;

			String query = "Select * from plans_operator order by id desc limit 1";
			logger.debug("query in findID in  findId " + query);
			plansPlanfeeList = new HibernateDAO().findBySQLQuery(session, PlansOperator.class, query,"plans_operator");

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
