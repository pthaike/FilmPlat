package scu.nine.modle;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * MovieHallInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see scu.nine.modle.MovieHallInfo
 * @author MyEclipse Persistence Tools
 */

public class MovieHallInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MovieHallInfoDAO.class);

	public void save(MovieHallInfo transientInstance) {
		log.debug("saving MovieHallInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MovieHallInfo persistentInstance) {
		log.debug("deleting MovieHallInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MovieHallInfo findById(java.lang.Integer id) {
		log.debug("getting MovieHallInfo instance with id: " + id);
		try {
			MovieHallInfo instance = (MovieHallInfo) getSession().get(
					"scu.nine.modle.MovieHallInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MovieHallInfo instance) {
		log.debug("finding MovieHallInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.nine.modle.MovieHallInfo").add(
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
		log.debug("finding MovieHallInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MovieHallInfo as model where model."
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
		log.debug("finding all MovieHallInfo instances");
		try {
			String queryString = "from MovieHallInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MovieHallInfo merge(MovieHallInfo detachedInstance) {
		log.debug("merging MovieHallInfo instance");
		try {
			MovieHallInfo result = (MovieHallInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MovieHallInfo instance) {
		log.debug("attaching dirty MovieHallInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MovieHallInfo instance) {
		log.debug("attaching clean MovieHallInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	//自定义查询排片中影厅
	public List findArrangeMovieHallInfoByCondition(String movieHailName)
	{
		try
		{
			String hql="from MovieHallInfo where 1=1 ";
			
			if(!"".equals(movieHailName) && movieHailName!=null)
			{
				hql+=" and movieHailName like '%"+movieHailName+"%'";
			}
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
		
	}
	
	//查找影厅
	public List findHallByMovieID(String movieCityID){
		try
		{
			String hql="from MovieHallInfo where 1=1";
			if(!"".equals(movieCityID) && movieCityID!=null)
			{
				hql+=" and movieVityInfo.movieCityId = '"+movieCityID+"'";
			}
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
	}
}