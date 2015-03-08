package scu.nine.modle;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * VisitorInnfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see scu.nine.modle.VisitorInnfo
 * @author MyEclipse Persistence Tools
 */

public class VisitorInnfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(VisitorInnfoDAO.class);

	public void save(VisitorInnfo transientInstance) {
		log.debug("saving VisitorInnfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(VisitorInnfo persistentInstance) {
		log.debug("deleting VisitorInnfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public VisitorInnfo findById(scu.nine.modle.VisitorInnfoId id) {
		log.debug("getting VisitorInnfo instance with id: " + id);
		try {
			VisitorInnfo instance = (VisitorInnfo) getSession().get(
					"scu.nine.modle.VisitorInnfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(VisitorInnfo instance) {
		log.debug("finding VisitorInnfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.nine.modle.VisitorInnfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding VisitorInnfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from VisitorInnfo as model where model."
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
		log.debug("finding all VisitorInnfo instances");
		try {
			String queryString = "from VisitorInnfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public VisitorInnfo merge(VisitorInnfo detachedInstance) {
		log.debug("merging VisitorInnfo instance");
		try {
			VisitorInnfo result = (VisitorInnfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(VisitorInnfo instance) {
		log.debug("attaching dirty VisitorInnfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(VisitorInnfo instance) {
		log.debug("attaching clean VisitorInnfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}