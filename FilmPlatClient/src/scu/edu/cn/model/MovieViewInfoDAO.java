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
 * MovieViewInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see scu.edu.cn.model.MovieViewInfo
 * @author MyEclipse Persistence Tools
 */

public class MovieViewInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MovieViewInfoDAO.class);
	// property constants
	public static final String MOVIE_VIEW_CONTENT = "movieViewContent";
	public static final String MOVIE_COMMENT_SHIELD = "movieCommentShield";

	public void save(MovieViewInfo transientInstance) {
		log.debug("saving MovieViewInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MovieViewInfo persistentInstance) {
		log.debug("deleting MovieViewInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MovieViewInfo findById(java.lang.Integer id) {
		log.debug("getting MovieViewInfo instance with id: " + id);
		try {
			MovieViewInfo instance = (MovieViewInfo) getSession().get(
					"scu.edu.cn.model.MovieViewInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MovieViewInfo instance) {
		log.debug("finding MovieViewInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.edu.cn.model.MovieViewInfo").add(
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
		log.debug("finding MovieViewInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MovieViewInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMovieViewContent(Object movieViewContent) {
		return findByProperty(MOVIE_VIEW_CONTENT, movieViewContent);
	}

	public List findByMovieCommentShield(Object movieCommentShield) {
		return findByProperty(MOVIE_COMMENT_SHIELD, movieCommentShield);
	}

	public List findAll() {
		log.debug("finding all MovieViewInfo instances");
		try {
			String queryString = "from MovieViewInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MovieViewInfo merge(MovieViewInfo detachedInstance) {
		log.debug("merging MovieViewInfo instance");
		try {
			MovieViewInfo result = (MovieViewInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MovieViewInfo instance) {
		log.debug("attaching dirty MovieViewInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MovieViewInfo instance) {
		log.debug("attaching clean MovieViewInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	public List findMovieViewByMovieId(int movieId)
	{
		try
		{
			String hql="from MovieViewInfo where ";
			hql+="movieInfo.movieId = "+movieId;
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
	}
}