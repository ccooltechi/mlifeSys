package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.OrderPlanprimaryEntity;
import com.mobilelife.persistance.entities.PlansPlanfeeEntity;

public class OrderPlanprimaryDao {
	private static Logger logger = LoggerFactory.getLogger(OrderPlanprimaryDao.class);

	public OrderPlanprimaryDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<OrderPlanprimaryEntity> orderPlanprimaryList = null;

			String query = "Select * from order_planprimary order by id desc limit 1";
			logger.debug("query in findID in  OrderPlanprimaryDao " + query);
			orderPlanprimaryList = new HibernateDAO().findBySQLQuery(session, OrderPlanprimaryEntity.class, query,"order_planprimary");

			logger.debug("findID  in  OrderPlanprimaryDao Size = "+orderPlanprimaryList.size());
			if ((null!=orderPlanprimaryList) && (orderPlanprimaryList.size()>0))
			{
				rid = orderPlanprimaryList.get(0).getId();
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
	public void saveData(OrderPlanprimaryEntity entityObj) {
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
	public OrderPlanprimaryEntity vaidateOrderidCouponid(String couponid) {
		OrderPlanprimaryEntity orderPlanprimary = null;
		String orderid = couponid.replace("ALD", "");;
		if (orderid.indexOf("C")>0)
		{
			orderid = orderid.substring(0, orderid.indexOf("C"));
		}
		
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<OrderPlanprimaryEntity> orderPlanprimaryList = null;

			String query = "Select * from order_planprimary where id = "+orderid+" and order_coupon_code = '"+couponid+"'";
			logger.debug("query in vaidateOrderidCouponid in  OrderPlanprimaryDao " + query);
			orderPlanprimaryList = new HibernateDAO().findBySQLQuery(session, OrderPlanprimaryEntity.class, query,"order_planprimary");

			logger.debug("vaidateOrderidCouponid  in  OrderPlanprimaryDao Size = "+orderPlanprimaryList.size());
			if ((null!=orderPlanprimaryList) && (orderPlanprimaryList.size()>0))
			{
				rid = orderPlanprimaryList.get(0).getId();
				orderPlanprimary = orderPlanprimaryList.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return orderPlanprimary;
	}
	
	public boolean invoiceIfExist(String order_id)
	{
		Session session = HibernateSessionManager.getSession();
		boolean retVal = false;
		try {
			List<OrderPlanprimaryEntity> orderPlanprimaryList = null;

			String query = "Select * from order_planprimary where order_id ='"+order_id+"'";
			logger.debug("query in findID in  OrderPlanprimaryDao " + query);
			orderPlanprimaryList = new HibernateDAO().findBySQLQuery(session, OrderPlanprimaryEntity.class, query,"order_planprimary");

			logger.debug("findID  in  OrderPlanprimaryDao Size = "+orderPlanprimaryList.size());
			if ((null!=orderPlanprimaryList) && (orderPlanprimaryList.size()>0))
			{
				retVal = true;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return retVal;
	}

}
