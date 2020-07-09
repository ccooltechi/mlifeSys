package com.mobilelife.persistance.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlansPlanprimary;

public class PlansPlanprimaryDao {
	private static Logger logger = LoggerFactory.getLogger(PlansPlanprimaryDao.class);

	public PlansPlanprimaryDao()
	{
		
	}
	
	public List<PlansPlanprimary> findAll(int pageno, int resultperpage, int operatorid, int plantype)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		try {
			List<PlansPlanprimary> plansPlanprimaryList = null;

			String query = "Select a.* from plans_planprimary a order by id";
			if ((plantype>0) && (operatorid>0))
				query = "Select a.* from plans_planprimary a where a.operator_id="+operatorid+" and plan_type="+plantype+" order by id";
			else if ((operatorid>0))
				query = "Select a.* from plans_planprimary a where a.operator_id="+operatorid+" order by id";
			else if ((plantype>0))
				query = "Select a.* from plans_planprimary a where plan_type="+plantype+" order by id";
			
//			logger.debug("query in findAllPlans for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimary.class, "plans_planprimary", pageno, resultperpage);

			logger.debug("findPlansByOperatorID Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
		
	}

	public List<PlansPlanprimary> findAllPlans(int pageNumber, int results_per_page)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		try {
			List<PlansPlanprimary> plansPlanprimaryList = null;

			String query = "Select a.* from plans_planprimary a, plans_planfee b  where a.is_active=1 and b.plan_primary_id =a.id order by b.plan_monthly_fee";
			logger.debug("query in findAllPlans for all " + query);
//			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");
			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimary.class, "plans_planprimary", pageNumber, results_per_page);

			logger.debug("findPlansByOperatorID Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}

	public List<PlansPlanprimary> findPlansByIDs(String planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		try {
			List<PlansPlanprimary> plansPlanprimaryList = null;

			String query = "Select a.* from plans_planprimary a where a.is_active=1 and a.id in ("+planID+")";
//			logger.debug("query in findPlansByIDs for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");
//			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimary.class, "plans_planprimary", pageNumber, results_per_page);

//			logger.debug("findPlansByIDs Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
//		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}
	
	public List<PlansPlanprimary> findPlansByPlanID(String planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansPlanprimary.findByPlanId");
		query.setParameter("planId", planID);
		logger.debug("findPlansByID planID = "+planID);
		plansPlanprimary = (List<PlansPlanprimary>)query.list();
		return plansPlanprimary;
	}

	public List<PlansPlanprimary> findByPlanID(String planID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		try {
			List<PlansPlanprimary> plansPlanprimaryList = null;

			String query = "Select a.* from plans_planprimary a where a.is_active=1 and a.plan_id = '"+planID+"'";
			logger.debug("query in findByPlanID for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");
//			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimary.class, "plans_planprimary", pageNumber, results_per_page);

			logger.debug("findPlansByIDs Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}


	public List<PlansPlanprimary> findPlansByID(String planID){
	Session session = HibernateSessionManager.getSession();
            try {                
		List<PlansPlanprimary> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansPlanprimary.findById");
		query.setParameter("id", Integer.parseInt(planID));
		// logger.debug("findPlansByID planID = "+planID);
		plansPlanprimary = (List<PlansPlanprimary>)query.list();
		return plansPlanprimary;
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                session.flush();
			session.clear();
			session.close();
            }
		return null;
	}

	public List<PlansPlanprimary> findPlansByName(String planNM){
	Session session = HibernateSessionManager.getSession();
            try {                
		List<PlansPlanprimary> plansPlanprimary = null;
		Query query = session.getNamedQuery("PlansPlanprimary.findByPlanName");
		query.setParameter("planName", planNM);
		 logger.debug("findPlansByName planID = "+planNM);
		plansPlanprimary = (List<PlansPlanprimary>)query.list();
		return plansPlanprimary;
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                session.flush();
			session.clear();
			session.close();
            }
		return null;
	}


	public List<PlansPlanprimary> findPlansByOperatorID(String operatorID)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		int pageNumber=2;
		int results_per_page=10;
		try {
			List<PlansPlanprimary> plansPlanprimaryList = null;

			String query = "Select * from plans_planprimary where is_active=1 and operator_id ="+operatorID;
			logger.debug("query in findPlansByOperatorID for all " + query);
//			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");
			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimary.class, "plans_planprimary", pageNumber, results_per_page);

			logger.debug("findPlansByOperatorID Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}

	public List<PlansPlanprimary> findPlansByFilter(String filterSqlQuery, int pageNumber, int results_per_page) {
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		try {
			List<PlansPlanprimary> plansPlanprimaryList = null;
//			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, filterSqlQuery,"plans_planprimary");
			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, filterSqlQuery, PlansPlanprimary.class, "plans_planprimary", pageNumber, results_per_page);

			logger.debug("findPlansByFilter Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0)) 
			{
				plansPlanprimary = plansPlanprimaryList;
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

	public int getTotalPlans(String filterSqlQuery) {
		Session session = HibernateSessionManager.getSession();
		int totalPlans = 0;
		try {
            List palnMasterDataList = new HibernateDAO().findBySQLQuery(session, filterSqlQuery);
			logger.debug("getTotalPlans Size = "+palnMasterDataList.size());
			if ((null!=palnMasterDataList) && (palnMasterDataList.size()>0))
			{
                totalPlans = palnMasterDataList.size();
//                for (int i = 0; i < palnMasterDataList.size(); i++) {
//                    totalPlans = Integer.parseInt(palnMasterDataList.get(i)+"");
//        			logger.debug("totalPlans = "+totalPlans);
//                }
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return totalPlans;
	}

	public int findId()
	{
		Session session = HibernateSessionManager.getSession();
		int rid = 0;
		try {
			List<PlansPlanprimary> resultList = null;

			String query = "Select * from plans_planprimary order by id desc";
			logger.debug("query in findID in  PlansPlanprimary " + query);
			resultList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");

			logger.debug("findID  in  PlansPlanprimary Size = "+resultList.size());
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

	public List<PlansPlanprimary> findPlansByPlanName(String planName, int plan_type, int operator_id, String flexinational)
	{
		Session session = HibernateSessionManager.getSession();
		List<PlansPlanprimary> plansPlanprimary = null;
		try {
			String query = "";
			List<PlansPlanprimary> plansPlanprimaryList = null;
//			if (flexinational.trim().isEmpty())
				query = "Select a.* from plans_planprimary a where a.is_active=1 and operator_id="+operator_id+" and a.plan_type="+plan_type+" and a.plan_name in ('"+planName.trim()+"')";
//			else
//				query = "Select a.* from plans_planprimary a where a.is_active=1 and operator_id="+operator_id+" and a.plan_type="+plan_type+" and a.plan_name in ('"+planName.trim()+"') and plan_longname like '%"+flexinational+"%' ";
				
			logger.debug("query in findPlansByPlanName for all " + query);
			plansPlanprimaryList = new HibernateDAO().findBySQLQuery(session, PlansPlanprimary.class, query,"plans_planprimary");
//			plansPlanprimaryList = new HibernateDAO().findBySQLQueryWithPagination(session, query, PlansPlanprimary.class, "plans_planprimary", pageNumber, results_per_page);

			logger.debug("findPlansByIDs Size = "+plansPlanprimaryList.size());
			if ((null!=plansPlanprimaryList) && (plansPlanprimaryList.size()>0))
			{
				plansPlanprimary = plansPlanprimaryList;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		System.out.println("plansPlanprimary.size "+plansPlanprimary.size());
		return plansPlanprimary;
	}


	public boolean savePlansPlanprimary(PlansPlanprimary plansPlanprimary) {
		boolean retVal = false;
		Session session = HibernateSessionManager.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(plansPlanprimary);
			tx.commit();
			retVal = true;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean saveData(PlansPlanprimary entityObj) {
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
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public boolean updateData(PlansPlanprimary entityObj) {
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
			retVal = false;
		} finally {
			session.close();
		}
		return retVal;
	}

	public PlansPlanprimary findByName(String deviceBrand)
	{
		Session session = HibernateSessionManager.getSession();
		PlansPlanprimary planDevicebrand = null;
		try {
			Query query = session.getNamedQuery("PlansPlanprimary.findByPlanName");
			query.setParameter("deviceBrand", deviceBrand);
			planDevicebrand = (PlansPlanprimary)query.list().get(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return planDevicebrand;
	}

	public PlansPlanprimary findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlansPlanprimary entity = null;
		try {
			Query query = session.getNamedQuery("PlansPlanprimary.findById");
			query.setParameter("id", id);
			entity = (PlansPlanprimary)(query.list().get(0));
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

	public boolean deleteData(PlansPlanprimary entityObj) {
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
	


}
