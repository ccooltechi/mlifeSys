package com.mobilelife.dbutils;


import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateDAO {
	
	private static Logger logger = LoggerFactory.getLogger(HibernateDAO.class);
	private final int RESULTS_PER_PAGE = 10;
	
    public <T> List<T> findAll(Class<T> clazz) {
        Session session = HibernateSessionManager.getSession();
        List<T> objects = null;
        try {
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
        } catch (Exception ex) {
        	logger.error("EXCEPTION",ex);
        } finally {
            session.close();
        }
        return objects;
    }

    public <T> List<T> findAll(Session session, Class<T> clazz) {
        List<T> objects = null;
        try {
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return objects;
    }

    public <T> List<T> findByWhere(Class<T> clazz, String whereClause) {
        Session session = HibernateSessionManager.getSession();
        List<T> objects = null;
        try {
            String qry = "from " + clazz.getSimpleName() + " tb where " + whereClause;
            //logger.debug("Find qry =====>" + qry);
            Query query = session.createQuery(qry);
            objects = query.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
            session.close();
        }
        return objects;
    }

    public <T> List<T> findByWhere(Session session, Class<T> clazz, String whereClause) {
        List<T> objects = null;
        try {
            String qry = "from " + clazz.getSimpleName() + " tb where " + whereClause;
            //logger.debug("qry=====>" + qry);
            Query query = session.createQuery(qry);
            objects = query.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return objects;
    }
    


    public <T> List<T> findBySQLQuery(Class<T> clazz, String qry, String tableName) {
        Session session = HibernateSessionManager.getSession();
        List<T> objects = null;
        try {
//            //logger.debug("qry=====>" + qry);
            Query query = session.createSQLQuery(qry).addEntity(tableName, clazz);
            objects = query.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
            session.close();
        }
        return objects;
    }

    public <T> List<T> findBySQLQuery(Session session, Class<T> clazz, String qry, String tableName) {
        List<T> objects = null;
        try {
//            //logger.debug("qry=====>" + qry);
            Query query = session.createSQLQuery(qry).addEntity(tableName, clazz);
            objects = query.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return objects;
    }

    public <T> List<T> findBySQLQuery(String qry) {
        Session session = HibernateSessionManager.getSession();
        List<T> objects = null;
        try {
//            //logger.debug("qry=====>" + qry);
            Query query = session.createSQLQuery(qry);
            objects = query.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
            session.close();
        }
        return objects;
    }

    public <T> List<T> findBySQLQuery(Session session, String qry) {
        List<T> objects = null;
        try {
//            //logger.debug("qry=====>" + qry);
            Query query = session.createSQLQuery(qry);
            objects = query.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return objects;
    }

    public <T> T findByPK(Class<T> clazz, Long id) {
        Session session = HibernateSessionManager.getSession();
        T obj = null;
        try {
            obj = (T) session.load(clazz, id);
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
            session.close();
        }
        return obj;
    }

    public <T> T findByPK(Session session, Class<T> clazz, Long id) {
        T obj = null;
        try {
            obj = (T) session.get(clazz, id);
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return obj;
    }

    public <T> T findByPK(Class<T> clazz, String id) {
        Session session = HibernateSessionManager.getSession();
        T obj = null;
        try {
            obj = (T) session.get(clazz, id);
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
            session.close();
        }
        return obj;
    }

    public <T> T findByPK(Session session, Class<T> clazz, String id) {
        T obj = null;
        try {
            obj = (T) session.get(clazz, id);
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return obj;
    }

    public <T> List<T> findByCollectionFilter(Collection<T> list, String whereClause) {
        Session session = HibernateSessionManager.getSession();
        List<T> objects = null;
        try {
            Query qry = session.createFilter(list, "where " + whereClause);
            objects = qry.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
            session.close();
        }
        return objects;
    }

    public <T> List<T> findByCollectionFilter(Session session, Collection<T> list, String whereClause) {
        List<T> objects = null;
        try {
            Query qry = session.createFilter(list, "where " + whereClause);
            objects = qry.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return objects;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

/*    public <T> T findByCompositePK(Class<T> clazz, Object pk) {
        Session session = HibernateSessionManager.getSession();
        T obj = null;
        try {
            //obj = (T)session.load(clazz, pk);
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
            session.close()()();
        }
        return obj;
    }

    public <T> T findByCompositePK(Session session, Class<T> clazz) {
        T obj = null;
        try {
            //obj = (T)session.load(clazz, pk);
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
            session.close()()();
        }
        return obj;
    }


    public <T> List<T> findByCriteriaParams(Class<T> clazz, Criterion... criterion) {
        Session session = HibernateSessionManager.getSession();
        List<T> objects = null;
        try {
            Criteria crit = session.createCriteria(clazz);
            for (Criterion c : criterion) {
                crit.add(c);
            }
            objects = crit.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
            session.close()()();
        }
        return objects;
    }

    public <T> List<T> findByCriteriaParams(Session session, Class<T> clazz, Criterion... criterion) {
        List<T> objects = null;
        try {
            Criteria crit = session.createCriteria(clazz);
            for (Criterion c : criterion) {
                crit.add(c);
            }
            objects = crit.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return objects;
    }

    public <T> List<T> findByCriteriaList(Class<T> clazz, ArrayList<Criterion> criterion) {
        Session session = HibernateSessionManager.getSession();
        List<T> objects = null;
        try {
            Criteria crit = session.createCriteria(clazz);
            for (Criterion c : criterion) {
                crit.add(c);
            }
            objects = crit.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
            session.close()()();
        }
        return objects;
    }

    public <T> List<T> findByCriteriaList(Session session, Class<T> clazz, ArrayList<Criterion> criterion) {
        List<T> objects = null;
        try {
            Criteria crit = session.createCriteria(clazz);
            for (Criterion c : criterion) {
                crit.add(c);
            }
            objects = crit.list();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return objects;
    }*/
    public boolean deleteBySQLQuery(Session session, String qry) {
        boolean retVal=false;
        int valueReturned=0;
        try {
//            //logger.debug("qry=====>" + qry);
            Query query = session.createSQLQuery(qry);
            valueReturned = query.executeUpdate();
            if (valueReturned == 1)
                retVal = true;
            else
                retVal = false;

        } catch (Exception ex) {
            retVal = false;
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return retVal;
    }

    public boolean updateBySQLQuery(Session session, String qry) {
        boolean retVal=false;
        int valueReturned=0;
        try {
//            //logger.debug("qry=====>" + qry);
            Query query = session.createSQLQuery(qry);
            valueReturned = query.executeUpdate();
            if (valueReturned == 1)
                retVal = true;
            else
                retVal = false;

        } catch (Exception ex) {
            retVal = false;
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return retVal;
    }

    public <T> List<T> findBySQLQueryWithPagination(Session session, String qry, int pageNumber, int results_per_page) {
        List<T> objects = null;
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery(qry);
            //logger.debug("qry=====>" + qry);
            query = query.setFirstResult(results_per_page * (pageNumber - 1));
            query.setMaxResults(results_per_page);
            objects = query.list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return objects;
    }

    public <T> List<T> findBySQLQueryWithPagination(Session session, String qry, Class<T> clazz,  String tableName, int pageNumber, int results_per_page) {
        List<T> objects = null;
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery(qry).addEntity(tableName, clazz);;
            //logger.debug("qry=====>" + qry);
            query = query.setFirstResult(results_per_page * (pageNumber - 1));
            query.setMaxResults(results_per_page);
            objects = query.list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return objects;
    }

    public <T> List<T> findBySQLQueryWithPagination(Session session, String qry,  String tableName, int pageNumber, int results_per_page) {
        List<T> objects = null;
        try {
            session.beginTransaction();
            Query query = session.createSQLQuery(qry).addEntity(tableName);;
            //logger.debug("qry=====>" + qry);
            query = query.setFirstResult(results_per_page * (pageNumber - 1));
            query.setMaxResults(results_per_page);
            objects = query.list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            logger.error("EXCEPTION",ex);
        } finally {
        }
        return objects;
    }

}
