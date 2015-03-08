package scu.edu.cn.model;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * CUserinfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see scu.edu.cn.model.CUserinfo
 * @author MyEclipse Persistence Tools
 */

public class CUserinfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CUserinfoDAO.class);
	// property constants
	public static final String MAX_BUY_AMOUNT = "maxBuyAmount";
	public static final String BUY_DEADLINE = "buyDeadline";

	public void save(CUserinfo transientInstance) {
		log.debug("saving CUserinfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CUserinfo persistentInstance) {
		log.debug("deleting CUserinfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CUserinfo findById(java.lang.Integer id) {
		log.debug("getting CUserinfo instance with id: " + id);
		try {
			CUserinfo instance = (CUserinfo) getSession().get(
					"scu.edu.cn.model.CUserinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CUserinfo instance) {
		log.debug("finding CUserinfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.edu.cn.model.CUserinfo").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CUserinfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CUserinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMaxBuyAmount(Object maxBuyAmount) {
		return findByProperty(MAX_BUY_AMOUNT, maxBuyAmount);
	}

	public List findByBuyDeadline(Object buyDeadline) {
		return findByProperty(BUY_DEADLINE, buyDeadline);
	}

	public List findAll() {
		log.debug("finding all CUserinfo instances");
		try {
			String queryString = "from CUserinfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CUserinfo merge(CUserinfo detachedInstance) {
		log.debug("merging CUserinfo instance");
		try {
			CUserinfo result = (CUserinfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CUserinfo instance) {
		log.debug("attaching dirty CUserinfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CUserinfo instance) {
		log.debug("attaching clean CUserinfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}