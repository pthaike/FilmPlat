package scu.edu.cn.model;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * MovieVityInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see scu.edu.cn.model.MovieVityInfo
 * @author MyEclipse Persistence Tools
 */

public class MovieVityInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MovieVityInfoDAO.class);
	// property constants
	public static final String MOVIE_CITY_NAME = "movieCityName";
	public static final String SUPPORT_ONLLINE = "supportOnlline";
	public static final String MOVIE_CITY_ADDRESS = "movieCityAddress";
	public static final String MOVIE_CITY_PHONE = "movieCityPhone";
	public static final String MOVIE_CITY_INTRO = "movieCityIntro";

	public void save(MovieVityInfo transientInstance) {
		log.debug("saving MovieVityInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MovieVityInfo persistentInstance) {
		log.debug("deleting MovieVityInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MovieVityInfo findById(java.lang.Integer id) {
		log.debug("getting MovieVityInfo instance with id: " + id);
		try {
			MovieVityInfo instance = (MovieVityInfo) getSession().get(
					"scu.edu.cn.model.MovieVityInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MovieVityInfo instance) {
		log.debug("finding MovieVityInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.edu.cn.model.MovieVityInfo").add(
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
		log.debug("finding MovieVityInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MovieVityInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMovieCityName(Object movieCityName) {
		return findByProperty(MOVIE_CITY_NAME, movieCityName);
	}

	public List findBySupportOnlline(Object supportOnlline) {
		return findByProperty(SUPPORT_ONLLINE, supportOnlline);
	}

	public List findByMovieCityAddress(Object movieCityAddress) {
		return findByProperty(MOVIE_CITY_ADDRESS, movieCityAddress);
	}

	public List findByMovieCityPhone(Object movieCityPhone) {
		return findByProperty(MOVIE_CITY_PHONE, movieCityPhone);
	}

	public List findByMovieCityIntro(Object movieCityIntro) {
		return findByProperty(MOVIE_CITY_INTRO, movieCityIntro);
	}

	public List findAll() {
		log.debug("finding all MovieVityInfo instances");
		try {
			String queryString = "from MovieVityInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MovieVityInfo merge(MovieVityInfo detachedInstance) {
		log.debug("merging MovieVityInfo instance");
		try {
			MovieVityInfo result = (MovieVityInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MovieVityInfo instance) {
		log.debug("attaching dirty MovieVityInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MovieVityInfo instance) {
		log.debug("attaching clean MovieVityInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}