package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansDeviceprice;
import com.mobilelife.persistance.entities.PlansDeviceprimary;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansDevicePriceDao {
	private static Logger logger = LoggerFactory.getLogger(PlansDevicePriceDao.class);

	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansDeviceprice> resultList = null;

			String query = "Select * from plans_deviceprice order by id desc";
			logger.debug("query in findID in  plans_deviceprice " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansDeviceprice.class, query,"plans_deviceprice");

			logger.debug("findID  in  plans_deviceprice Size = ");
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
	
	public List<PlansDeviceprice> findPlansByID(int planID, String flexi_nationalx)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansDeviceprice> resultList = null;
		String flexi_national = "NATIONAL";
		try {
			if (flexi_nationalx.trim().isEmpty())
				flexi_national = "NATIONAL";
			List<PlansDeviceprice> resultListx = null;
			String query = "Select * from plans_deviceprice where stock > 0 and flexi_national='"+flexi_national+"' and deviceprimary_id = "+planID+" order by cost ";
			logger.debug("query in findPlansByID in  plans_deviceprice " + query);
			resultListx = new HibernateDAO().findBySQLQuery(session, PlansDeviceprice.class, query,"plans_deviceprice");
			if ((null!=resultListx) && (resultListx.size()>0))
			{
				resultList = resultListx;
			}
			logger.debug("findPlansByID  in  plans_deviceprice Size = ");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return resultList;
	}

	public List<PlansDeviceprice> findPlansByID(int planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansDeviceprice> resultList = null;
		try {
			List<PlansDeviceprice> resultListx = null;
			String query = "Select * from plans_deviceprice where stock > 0 and deviceprimary_id = "+planID+" order by cost ";
			logger.debug("query in findPlansByID in  plans_deviceprice " + query);
			resultListx = new HibernateDAO().findBySQLQuery(session, PlansDeviceprice.class, query,"plans_deviceprice");
			if ((null!=resultListx) && (resultListx.size()>0))
			{
				resultList = resultListx;
			}
			logger.debug("findPlansByID  in  plans_deviceprice Size = ");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return resultList;
	}

	public void saveData(PlansDeviceprice entityObj) {
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(entityObj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateData(PlansDeviceprice entityObj) {
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(entityObj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public PlansDeviceprice findPlansBydeviceColorIDs(Integer planID, String color) {
		Session session = HibernateSessionManager.getSession();
		PlansDeviceprice plansPlanprimary = null;
		try {
			List<PlansDeviceprice> plansPlanprimaryList = null;

			String query = "Select * from plans_deviceprice where deviceprimary_id = "+planID+" and device_color ="+color;
			logger.debug("query in findPlansBydeviceColorIDs in  plans_deviceprice " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansDeviceprice.class, query,"plans_deviceprice");

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
}
