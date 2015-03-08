package scu.edu.cn.model;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * NewsArticalInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see scu.edu.cn.model.NewsArticalInfo
 * @author MyEclipse Persistence Tools
 */

public class NewsArticalInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(NewsArticalInfoDAO.class);
	// property constants
	public static final String NEWS_TITLE = "newsTitle";
	public static final String NEWS_CONTENT = "newsContent";

	public void save(NewsArticalInfo transientInstance) {
		log.debug("saving NewsArticalInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewsArticalInfo persistentInstance) {
		log.debug("deleting NewsArticalInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewsArticalInfo findById(java.lang.Integer id) {
		log.debug("getting NewsArticalInfo instance with id: " + id);
		try {
			NewsArticalInfo instance = (NewsArticalInfo) getSession().get(
					"scu.edu.cn.model.NewsArticalInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(NewsArticalInfo instance) {
		log.debug("finding NewsArticalInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.edu.cn.model.NewsArticalInfo").add(
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
		log.debug("finding NewsArticalInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from NewsArticalInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNewsTitle(Object newsTitle) {
		return findByProperty(NEWS_TITLE, newsTitle);
	}

	public List findByNewsContent(Object newsContent) {
		return findByProperty(NEWS_CONTENT, newsContent);
	}

	public List findAll() {
		log.debug("finding all NewsArticalInfo instances");
		try {
			String queryString = "from NewsArticalInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewsArticalInfo merge(NewsArticalInfo detachedInstance) {
		log.debug("merging NewsArticalInfo instance");
		try {
			NewsArticalInfo result = (NewsArticalInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewsArticalInfo instance) {
		log.debug("attaching dirty NewsArticalInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewsArticalInfo instance) {
		log.debug("attaching clean NewsArticalInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}