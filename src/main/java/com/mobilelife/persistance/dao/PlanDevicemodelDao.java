package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlanDevicemodel;

public class PlanDevicemodelDao {
	private static Logger logger = LoggerFactory.getLogger(PlanDevicemodelDao.class);

	public PlanDevicemodelDao()
	{
		
	}
	
	public List<PlanDevicemodel> findAllBrands()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlanDevicemodel> planDevicebrand = null;
		Query query = session.getNamedQuery("PlanDevicemodel.findAll");
		System.out.println("Size = "+query.list().size());
		planDevicebrand = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return planDevicebrand;
	}

	public PlanDevicemodel findBrandByName(String deviceBrand)
	{
		Session session = HibernateSessionManager.getSession();
		PlanDevicemodel planDevicebrand = null;
		Query query = session.getNamedQuery("PlanDevicemodel.findByDeviceModel");
		query.setParameter("deviceModel", deviceBrand);
		System.out.println("deviceModel = "+deviceBrand);
		System.out.println("Size = "+query.list().size());
		planDevicebrand = (PlanDevicemodel)query.list().get(0);
		System.out.println("planDevicebrand ID = "+planDevicebrand.getId());
		System.out.println("planDevicebrand Name = "+planDevicebrand.getDeviceModel());
		return planDevicebrand;
	}
	

	public List<PlanDevicemodel> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlanDevicemodel> planDevicebrand = null;
		try {
			Query query = session.getNamedQuery("PlanDevicemodel.findAll");
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

	public PlanDevicemodel findByName(String deviceBrand)
	{
		Session session = HibernateSessionManager.getSession();
		PlanDevicemodel planDevicebrand = null;
		try {
			Query query = session.getNamedQuery("PlanDevicemodel.findByDeviceModel");
			query.setParameter("deviceBrand", deviceBrand);
			planDevicebrand = (PlanDevicemodel)query.list().get(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return planDevicebrand;
	}

	public PlanDevicemodel findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlanDevicemodel entity = null;
		try {
			Query query = session.getNamedQuery("PlanDevicemodel.findById");
			query.setParameter("id", id);
			entity = (PlanDevicemodel)(query.list().get(0));
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
	
	public boolean saveData(PlanDevicemodel entityObj) {
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

	public boolean updateData(PlanDevicemodel entityObj) {
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

	public boolean deleteData(PlanDevicemodel entityObj) {
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
			List<PlanDevicemodel> plansPlanfeeList = null;

			String query = "Select * from plan_devicemodel order by id desc limit 1";
			logger.debug("query in findID in  findId " + query);
			plansPlanfeeList = new HibernateDAO().findBySQLQuery(session, PlanDevicemodel.class, query,"plan_devicemodel");

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
