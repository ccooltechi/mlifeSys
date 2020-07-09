package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlanDevicebrand;
import com.mobilelife.persistance.entities.PlansPlantype;

public class PlanDevicebrandDao {
	private static Logger logger = LoggerFactory.getLogger(PlanDevicebrandDao.class);

	public PlanDevicebrandDao()
	{
		
	}
	
	public List<PlanDevicebrand> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlanDevicebrand> planDevicebrand = null;
		try {
			Query query = session.getNamedQuery("PlanDevicebrand.findAll");
			System.out.println("Size = "+query.list().size());
			planDevicebrand = query.list();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return planDevicebrand;
	}

	public PlanDevicebrand findByName(String deviceBrand)
	{
		Session session = HibernateSessionManager.getSession();
		PlanDevicebrand planDevicebrand = null;
		try {
			Query query = session.getNamedQuery("PlanDevicebrand.findByDeviceBrand");
			query.setParameter("deviceBrand", deviceBrand);
			System.out.println("deviceBrand = "+deviceBrand);
			System.out.println("Size = "+query.list().size());
			planDevicebrand = (PlanDevicebrand)query.list().get(0);
			System.out.println("planDevicebrand ID = "+planDevicebrand.getId());
			System.out.println("planDevicebrand Name = "+planDevicebrand.getDeviceBrand());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return planDevicebrand;
	}

	public PlanDevicebrand findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlanDevicebrand entity = null;
		try {
			Query query = session.getNamedQuery("PlanDevicebrand.findById");
			query.setParameter("id", id);
			System.out.println("findById = "+id);
			entity = (PlanDevicebrand)(query.list().get(0));
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
	
	public boolean saveData(PlanDevicebrand entityObj) {
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

	public boolean updateData(PlanDevicebrand entityObj) {
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

	public boolean deleteData(PlanDevicebrand entityObj) {
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
			List<PlanDevicebrand> plansPlanfeeList = null;

			String query = "Select * from plan_devicebrand order by id desc limit 1";
			logger.debug("query in findID in  findId " + query);
			plansPlanfeeList = new HibernateDAO().findBySQLQuery(session, PlanDevicebrand.class, query,"plan_devicebrand");

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
