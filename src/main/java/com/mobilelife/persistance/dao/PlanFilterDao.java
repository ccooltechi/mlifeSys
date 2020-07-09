package com.mobilelife.persistance.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobilelife.dbutils.HibernateDAO;
import com.mobilelife.dbutils.HibernateSessionManager;
import com.mobilelife.persistance.entities.PlanFilters;
import com.mobilelife.persistance.entities.PlansPlantype;

public class PlanFilterDao {
	private static Logger logger = LoggerFactory.getLogger(PlanFilterDao.class);

	public PlanFilterDao()
	{
		
	}
	
	public List<PlanFilters> findPlanFilters()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlanFilters> planFilters = null;
		Query query = session.getNamedQuery("PlanFilters.findAll");
		System.out.println("Size = "+query.list().size());
		planFilters = query.list();
//		System.out.println("operator ID = "+plansOperator.getId());
//		System.out.println("operator Name = "+plansOperator.getOperatorName());
		return planFilters;
	}

	public List<PlanFilters> findFiltersByPlanType(int plan_type)
	{
		PlanTypeDao planTypeDao = new PlanTypeDao();
		PlansPlantype plansPlantype = planTypeDao.findPlanTypesById(plan_type);
		List<PlanFilters> planFilters = (List<PlanFilters>) plansPlantype.getPlanFiltersCollection();
		return planFilters;
	}

	public HashMap<String,String> findFilterMajors(int plan_type)
	{
		return null;
	}

	public HashMap<String,Object> findFilterKeyName(int plan_type, String keyMajor)
	{
		PlanTypeDao planTypeDao = new PlanTypeDao();
		HashMap<String, Object> dataHM = new HashMap<String, Object>();
//		HashMap<String,String> filterMajors = null;
		HashMap<Integer,String> filterkeyName = null;
		HashMap<Integer,PlanFilters> filtersData = null;
		Session session = HibernateSessionManager.getSession();
		int counter=0;
		try {
			List<PlanFilters> planFiltersList = null;

			String query = "select * from plan_filters where isActive=1 and plan_type="+plan_type+" and key_major= '"+keyMajor+"' order by orderno";
//			String query = "select * from plan_filters where plan_type="+plan_type;
			System.out.println("query in findPlansByOperatorID for all " + query);
			planFiltersList = new HibernateDAO().findBySQLQuery(session, PlanFilters.class, query,"plan_filters");

			System.out.println("findPlansByOperatorID Size = "+planFiltersList.size());
			if ((null!=planFiltersList) && (planFiltersList.size()>0))
			{
//				filterMajors = new HashMap<String,String>();
				filterkeyName = new HashMap<Integer,String>();
				filtersData = new HashMap<Integer,PlanFilters>();
				String keynm ="";
				for(int i=0;i<planFiltersList.size();i++)
				{
					PlanFilters planFilters = planFiltersList.get(i);
//					filterMajors.put(planFilters.getKeyMajor(), planFilters.getKeyMajor());
					String keyname = planFilters.getKeyName();
					if(!keynm.equalsIgnoreCase(keyname))
					{
						keynm = keyname;
						filterkeyName.put(counter, keyname);
						counter++;
					}
					filtersData.put(i,planFilters);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
//		dataHM.put("majors",filterMajors);
		dataHM.put("keyName",filterkeyName);
		dataHM.put("data",filtersData);
		return dataHM;
	}

	public PlanFilters findFilterKeyMajor_Name(String plan_type, String keyMajor, String keyName)
	{
		PlanTypeDao planTypeDao = new PlanTypeDao();
		Session session = HibernateSessionManager.getSession();
		PlanFilters planFilters = null;
		try {
			List<PlanFilters> planFiltersList = null;

			String query = "select * from plan_filters where isActive=1 and plan_type="+plan_type+" and key_major= '"+keyMajor+"' and key_name='"+keyName+"' order by orderno";
//			String query = "select * from plan_filters where plan_type="+plan_type;
			System.out.println("query in findPlansByOperatorID for all " + query);
			planFiltersList = new HibernateDAO().findBySQLQuery(session, PlanFilters.class, query,"plan_filters");

			System.out.println("findPlansByOperatorID Size = "+planFiltersList.size());
			if ((null!=planFiltersList) && (planFiltersList.size()>0))
			{
				for(int i=0;i<planFiltersList.size();i++)
				{
					planFilters = planFiltersList.get(i);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
			// HibernateSessionManager.closeSession()();
		}
		return planFilters;
	}

	
	public List<PlanFilters> findAll()
	{
		Session session = HibernateSessionManager.getSession();
		List<PlanFilters> planDevicebrand = null;
		try {
			Query query = session.getNamedQuery("PlanFilters.findAll");
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

	public PlanFilters findByName(String deviceBrand)
	{
		Session session = HibernateSessionManager.getSession();
		PlanFilters planDevicebrand = null;
		try {
			Query query = session.getNamedQuery("PlanFilters.findByDeviceBrand");
			query.setParameter("deviceBrand", deviceBrand);
			planDevicebrand = (PlanFilters)query.list().get(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.clear();
			session.close();
		}
		return planDevicebrand;
	}

	public PlanFilters findById(Integer id) {
		Session session = HibernateSessionManager.getSession();
		PlanFilters entity = null;
		try {
			Query query = session.getNamedQuery("PlanFilters.findById");
			query.setParameter("id", id);
			entity = (PlanFilters)(query.list().get(0));
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
	
	public boolean saveData(PlanFilters entityObj) {
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

	public boolean updateData(PlanFilters entityObj) {
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

	public boolean deleteData(PlanFilters entityObj) {
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
			List<PlanFilters> plansPlanfeeList = null;

			String query = "Select * from plan_filters order by id desc limit 1";
			logger.debug("query in findID in  findId " + query);
			plansPlanfeeList = new HibernateDAO().findBySQLQuery(session, PlanFilters.class, query,"plan_filters");

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

	public static void main(String[] args) {
	}
}
