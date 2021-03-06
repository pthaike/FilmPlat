package scu.edu.cn.model;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * PayInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see scu.edu.cn.model.PayInfo
 * @author MyEclipse Persistence Tools
 */

public class PayInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(PayInfoDAO.class);
	// property constants
	public static final String PAY_AMOUNT = "payAmount";

	public void save(PayInfo transientInstance) {
		log.debug("saving PayInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PayInfo persistentInstance) {
		log.debug("deleting PayInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PayInfo findById(java.lang.Integer id) {
		log.debug("getting PayInfo instance with id: " + id);
		try {
			PayInfo instance = (PayInfo) getSession().get(
					"scu.edu.cn.model.PayInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PayInfo instance) {
		log.debug("finding PayInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.edu.cn.model.PayInfo").add(Example.create(instance))
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
		log.debug("finding PayInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PayInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPayAmount(Object payAmount) {
		return findByProperty(PAY_AMOUNT, payAmount);
	}

	public List findAll() {
		log.debug("finding all PayInfo instances");
		try {
			String queryString = "from PayInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PayInfo merge(PayInfo detachedInstance) {
		log.debug("merging PayInfo instance");
		try {
			PayInfo result = (PayInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PayInfo instance) {
		log.debug("attaching dirty PayInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PayInfo instance) {
		log.debug("attaching clean PayInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}