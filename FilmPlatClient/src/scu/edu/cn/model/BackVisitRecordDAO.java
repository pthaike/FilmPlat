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
 * BackVisitRecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see scu.edu.cn.model.BackVisitRecord
 * @author MyEclipse Persistence Tools
 */

public class BackVisitRecordDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(BackVisitRecordDAO.class);

	// property constants

	public void save(BackVisitRecord transientInstance) {
		log.debug("saving BackVisitRecord instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BackVisitRecord persistentInstance) {
		log.debug("deleting BackVisitRecord instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BackVisitRecord findById(scu.edu.cn.model.BackVisitRecordId id) {
		log.debug("getting BackVisitRecord instance with id: " + id);
		try {
			BackVisitRecord instance = (BackVisitRecord) getSession().get(
					"scu.edu.cn.model.BackVisitRecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BackVisitRecord instance) {
		log.debug("finding BackVisitRecord instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.edu.cn.model.BackVisitRecord").add(
					Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding BackVisitRecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BackVisitRecord as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all BackVisitRecord instances");
		try {
			String queryString = "from BackVisitRecord";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BackVisitRecord merge(BackVisitRecord detachedInstance) {
		log.debug("merging BackVisitRecord instance");
		try {
			BackVisitRecord result = (BackVisitRecord) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BackVisitRecord instance) {
		log.debug("attaching dirty BackVisitRecord instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BackVisitRecord instance) {
		log.debug("attaching clean BackVisitRecord instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}