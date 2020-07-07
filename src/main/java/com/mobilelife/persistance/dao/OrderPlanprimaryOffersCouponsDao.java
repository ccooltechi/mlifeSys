package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.OrderPlanprimaryOffersCouponsEntity;
import com.mobilelife.persistance.entities.PlansPlanfeeEntity;

public class OrderPlanprimaryOffersCouponsDao {
	private static Logger logger = LoggerFactory.getLogger(OrderPlanprimaryOffersCouponsDao.class);

	public OrderPlanprimaryOffersCouponsDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<OrderPlanprimaryOffersCouponsEntity> orderPlanprimaryOffersCouponsList = null;

			String query = "Select * from order_planprimary_offers_coupons order by id desc limit 1";
			logger.debug("query in findID in  OrderPlanprimaryOffersCouponsDao " + query);
			orderPlanprimaryOffersCouponsList = new HibernateDAO().findBySQLQuery(session, OrderPlanprimaryOffersCouponsEntity.class, query,"order_planprimary_offers_coupons");

			logger.debug("findID  in  OrderPlanprimaryOffersCouponsDao Size = "+orderPlanprimaryOffersCouponsList.size());
			if ((null!=orderPlanprimaryOffersCouponsList) && (orderPlanprimaryOffersCouponsList.size()>0))
			{
				rid = orderPlanprimaryOffersCouponsList.get(0).getId();
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
	public void saveData(OrderPlanprimaryOffersCouponsEntity entityObj) {
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
	
}
