package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.OrderOffersMapEntity;
import com.mobilelife.persistance.entities.PlansPlanfeeEntity;

public class OrderOffersMapDao {
	private static Logger logger = LoggerFactory.getLogger(OrderOffersMapDao.class);

	public OrderOffersMapDao()
	{
		
	}
	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<OrderOffersMapEntity> orderOffersMapList = null;

			String query = "Select * from order_offers_map order by id desc limit 1";
			logger.debug("query in findID in  OrderOffersMapDao " + query);
			orderOffersMapList = new HibernateDAO().findBySQLQuery(session, OrderOffersMapEntity.class, query,"order_offers_map");

			logger.debug("findID  in  OrderOffersMapDao Size = "+orderOffersMapList.size());
			if ((null!=orderOffersMapList) && (orderOffersMapList.size()>0))
			{
				rid = orderOffersMapList.get(0).getId();
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
	public void saveData(OrderOffersMapEntity entityObj) {
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
