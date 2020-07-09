package com.mobilelife.persistance.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PartnerRouteArchive;
import com.mobilelife.persistance.entities.PartnerRouteChild;
import com.mobilelife.persistance.entities.PartnerRouteMaster;
import com.mobilelife.persistance.entities.ReferencesMaster;

public class BounceRouteDao {
	private static Logger logger = LoggerFactory.getLogger(BounceRouteDao.class);

	public BounceRouteDao()
	{
		
	}
	
	public List<PartnerRouteMaster> findAllPartnerRoutes()
	{
		Session session = HibernateSessionManager.getSession();
		List<PartnerRouteMaster> partnerRouteMaster = null;
		Query query = session.getNamedQuery("PlansOperator.findAll");
		System.out.println("Size = "+query.list().size());
		partnerRouteMaster = query.list();
		return partnerRouteMaster;
	}

	public PartnerRouteMaster findAllPartnerRoutesByCode(String routingCode)
	{
		Session session = HibernateSessionManager.getSession();
		PartnerRouteMaster partnerRouteMaster = null;
		logger.debug("routingCode = " +routingCode);
		Query query = session.getNamedQuery("PartnerRouteMaster.findByRoutingCode");
		query.setParameter("routingCode", routingCode);
//		System.out.println("Size = "+query.list().size());
		partnerRouteMaster = (PartnerRouteMaster)query.list().get(0);
		System.out.println("operator ID = "+partnerRouteMaster.getId());
		return partnerRouteMaster;
	}

	public PartnerRouteChild findParternRoute(String routing_code)
	{
		Session session = HibernateSessionManager.getSession();
		Timestamp currentdattime  = new Timestamp(System.currentTimeMillis());
		PartnerRouteChild partnerRouteChild = null;
		try {
			List<PartnerRouteChild> partnerRouteChildList = null;
//			String query = "Select a.* from partner_route_child a where a.is_active=1 and (calls_allowed - calls_used) >1 and a.routing_code ="+routing_code+" and  activation_start_date < '"+currentdattime+"' and activation_end_date >'"+currentdattime+"' order by a.priority_level ";
			String query = "Select a.* from partner_route_child a where a.is_active=1 and (calls_allowed - calls_used) >1 and a.routing_code ="+routing_code+" and  activation_start_date < '"+currentdattime+"' order by a.priority_level ";
			logger.debug("query in findParternRoute for all " + query);
			partnerRouteChildList = new HibernateDAO().findBySQLQuery(session, PartnerRouteChild.class, query,"partner_route_child");

			if ((null!=partnerRouteChildList) && (partnerRouteChildList.size()>0))
			{
				partnerRouteChild = partnerRouteChildList.get(0);
				if (partnerRouteChild.getActivationEndDate().getTime()<currentdattime.getTime())
				{
					partnerRouteChild = createNewRouting(partnerRouteChild.getId());
				}
			}
			else
			{
				partnerRouteChild = createNewRouting(routing_code);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return partnerRouteChild;
	}

	public PartnerRouteChild checkParternRoute(String routing_code)
	{
		Session session = HibernateSessionManager.getSession();
		PartnerRouteChild partnerRouteChild = null;
		try {
			List<PartnerRouteChild> partnerRouteChildList = null;
			String query = "Select a.* from partner_route_child a where a.is_active=1 and a.routing_code ="+routing_code+"  order by a.priority_level ";
			logger.debug("query in checkParternRoute for all " + query);
			partnerRouteChildList = new HibernateDAO().findBySQLQuery(session, PartnerRouteChild.class, query,"partner_route_child");

			if ((null!=partnerRouteChildList) && (partnerRouteChildList.size()>0))
			{
				partnerRouteChild = partnerRouteChildList.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return partnerRouteChild;
	}

	public PartnerRouteChild checkParternRoute(int routing_child_id)
	{
		Session session = HibernateSessionManager.getSession();
		PartnerRouteChild partnerRouteChild = null;
		try {
			List<PartnerRouteChild> partnerRouteChildList = null;
			String query = "Select a.* from partner_route_child a where a.is_active=1 and a.id ="+routing_child_id;
			logger.debug("query in checkParternRoute for all " + query);
			partnerRouteChildList = new HibernateDAO().findBySQLQuery(session, PartnerRouteChild.class, query,"partner_route_child");

			if ((null!=partnerRouteChildList) && (partnerRouteChildList.size()>0))
			{
				partnerRouteChild = partnerRouteChildList.get(0);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return partnerRouteChild;
	}

	private PartnerRouteChild createNewRouting(String routing_code) {
		PartnerRouteChild partnerRouteChild = checkParternRoute(routing_code);
		if (null!=partnerRouteChild)
		{
			Calendar activationStartDateC  = Calendar.getInstance();
			activationStartDateC.set(Calendar.HOUR_OF_DAY, 0);
			activationStartDateC.set(Calendar.MINUTE, 1);
			Calendar activationEndDateC  = Calendar.getInstance();
			activationEndDateC.set(Calendar.HOUR_OF_DAY, 23);
			activationEndDateC.set(Calendar.MINUTE, 29);

			Timestamp activationStartDate  = new Timestamp(activationStartDateC.getTimeInMillis());
			Timestamp activationEndDate  = new Timestamp(activationEndDateC.getTimeInMillis());

			partnerRouteChild.setActivationStartDate(activationStartDate);
			partnerRouteChild.setActivationEndDate(activationEndDate);
			partnerRouteChild.setCallsUsed(0);
			updateData(partnerRouteChild);
		}
		return partnerRouteChild;
	}

	private PartnerRouteChild createNewRouting(int routing_child_id) {
		PartnerRouteChild partnerRouteChild = checkParternRoute(routing_child_id);
		if (null!=partnerRouteChild)
		{
			Calendar activationStartDateC  = Calendar.getInstance();
			activationStartDateC.set(Calendar.HOUR_OF_DAY, 0);
			activationStartDateC.set(Calendar.MINUTE, 1);
			Calendar activationEndDateC  = Calendar.getInstance();
			activationEndDateC.set(Calendar.HOUR_OF_DAY, 23);
			activationEndDateC.set(Calendar.MINUTE, 29);

			Timestamp activationStartDate  = new Timestamp(activationStartDateC.getTimeInMillis());
			Timestamp activationEndDate  = new Timestamp(activationEndDateC.getTimeInMillis());

			partnerRouteChild.setActivationStartDate(activationStartDate);
			partnerRouteChild.setActivationEndDate(activationEndDate);
			partnerRouteChild.setCallsUsed(0);
			updateData(partnerRouteChild);
		}
		return partnerRouteChild;
	}

	public PartnerRouteChild updateRouting(int routing_child_id) {
		PartnerRouteChild partnerRouteChild = checkParternRoute(routing_child_id);
		if (null!=partnerRouteChild)
		{
			int callused = partnerRouteChild.getCallsUsed()+1;
			partnerRouteChild.setCallsUsed(callused);
			updateData(partnerRouteChild);
		}
		return partnerRouteChild;
	}

	public void saveData(PartnerRouteChild entityObj) {
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

	public void updateData(PartnerRouteChild entityObj) {
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
	
	public void saveData(PartnerRouteArchive entityObj) {
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

	public static void main(String[] args) {
		BounceRouteDao searchPlan = new BounceRouteDao();
		PartnerRouteMaster partnerRouteMaster = searchPlan.findAllPartnerRoutesByCode("DU_DSA");
		List<String> returnValue = new ArrayList<String>();
		PartnerRouteChild partnerRouteChild = searchPlan.findParternRoute(partnerRouteMaster.getId()+"");
		if ((partnerRouteChild.getCallsAllowed()-partnerRouteChild.getCallsUsed())==1)
			returnValue.add("true");
		returnValue.add(partnerRouteChild.getMerchantCode());
		logger.debug("answer in main " + partnerRouteChild.getId());
	}

	public int findIdNextID() {
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PartnerRouteArchive> partnerRouteArchive = null;

			String query = "Select * from partner_route_archive order by id desc limit 1";
			logger.debug("query in findIdreferencesMaster in  BounceRouteDao " + query);
			partnerRouteArchive = new HibernateDAO().findBySQLQuery(session, PartnerRouteArchive.class, query,"partner_route_archive");

			logger.debug("findIdNextID in  ReferencesDao Size = "+partnerRouteArchive.size());
			if ((null!=partnerRouteArchive) && (partnerRouteArchive.size()>0))
			{
				rid = partnerRouteArchive.get(0).getId();
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
