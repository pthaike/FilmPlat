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
 * NewsViewInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see scu.edu.cn.model.NewsViewInfo
 * @author MyEclipse Persistence Tools
 */

public class NewsViewInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(NewsViewInfoDAO.class);
	// property constants
	public static final String NEWSVIEW_CONTENT = "newsviewContent";

	public void save(NewsViewInfo transientInstance) {
		log.debug("saving NewsViewInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(NewsViewInfo persistentInstance) {
		log.debug("deleting NewsViewInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public NewsViewInfo findById(java.lang.Integer id) {
		log.debug("getting NewsViewInfo instance with id: " + id);
		try {
			NewsViewInfo instance = (NewsViewInfo) getSession().get(
					"scu.edu.cn.model.NewsViewInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(NewsViewInfo instance) {
		log.debug("finding NewsViewInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.edu.cn.model.NewsViewInfo").add(
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
		log.debug("finding NewsViewInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from NewsViewInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNewsviewContent(Object newsviewContent) {
		return findByProperty(NEWSVIEW_CONTENT, newsviewContent);
	}

	public List findAll() {
		log.debug("finding all NewsViewInfo instances");
		try {
			String queryString = "from NewsViewInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public NewsViewInfo merge(NewsViewInfo detachedInstance) {
		log.debug("merging NewsViewInfo instance");
		try {
			NewsViewInfo result = (NewsViewInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(NewsViewInfo instance) {
		log.debug("attaching dirty NewsViewInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(NewsViewInfo instance) {
		log.debug("attaching clean NewsViewInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public List findnewsViewBynewsId(int newsId)
	{
		try
		{
			String hql="from NewsViewInfo where ";
			hql+="newsArticalInfo.newsId = "+newsId;
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
	}
}