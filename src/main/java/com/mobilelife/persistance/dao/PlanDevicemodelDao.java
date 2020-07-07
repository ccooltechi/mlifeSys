package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlanDevicemodelEntity;

public class PlanDevicemodelDao {
	private static Logger logger = LoggerFactory.getLogger(PlanDevicemodelDao.class);

	public PlanDevicemodelDao()
	{
		
	}
	
	public List<PlanDevicemodelEntity> findAllBrands()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlanDevicemodelEntity> planDevicebrand = null;
		Query query = session.getNamedQuery("PlanDevicemodelEntity.findAll");
		System.out.println("Size = "+query.list().size());
		planDevicebrand = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return planDevicebrand;
	}

	public PlanDevicemodelEntity findBrandByName(String deviceBrand)
	{
		Session session = HibernateSessionManager.getSession();
		PlanDevicemodelEntity planDevicebrand = null;
		Query query = session.getNamedQuery("PlanDevicemodelEntity.findByDeviceModel");
		query.setParameter("deviceModel", deviceBrand);
		System.out.println("deviceModel = "+deviceBrand);
		System.out.println("Size = "+query.list().size());
		planDevicebrand = (PlanDevicemodelEntity)query.list().get(0);
		System.out.println("planDevicebrand ID = "+planDevicebrand.getId());
		System.out.println("planDevicebrand Name = "+planDevicebrand.getDeviceModel());
		return planDevicebrand;
	}
	

	public List<PlanDevicemodelEntity> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlanDevicemodelEntity> planDevicebrand = null;
		try {
			Query query = session.getNamedQuery("PlanDevicemodelEntity.findAll");
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

	public PlanDevicemodelEntity findByName(String deviceBrand)
	{
		Session session = HibernateSessionManager.getSession();
		PlanDevicemodelEntity planDevicebrand = null;
		try {
			Query query = session.getNamedQuery("PlanDevicemodelEntity.findByDeviceModel");
			query.setParameter("deviceBrand", deviceBrand);
			planDevicebrand = (PlanDevicemodelEntity)query.list().get(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return planDevicebrand;
	}

	public PlanDevicemodelEntity findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlanDevicemodelEntity entity = null;
		try {
			Query query = session.getNamedQuery("PlanDevicemodelEntity.findById");
			query.setParameter("id", id);
			entity = (PlanDevicemodelEntity)(query.list().get(0));
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
	
	public boolean saveData(PlanDevicemodelEntity entityObj) {
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

	public boolean updateData(PlanDevicemodelEntity entityObj) {
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

	public boolean deleteData(PlanDevicemodelEntity entityObj) {
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
			List<PlanDevicemodelEntity> plansPlanfeeList = null;

			String query = "Select * from plan_devicemodel order by id desc limit 1";
			logger.debug("query in findID in  findId " + query);
			plansPlanfeeList = new HibernateDAO().findBySQLQuery(session, PlanDevicemodelEntity.class, query,"plan_devicemodel");

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
