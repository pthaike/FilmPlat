package scu.nine.modle;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * MovieShowInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see scu.nine.modle.MovieShowInfo
 * @author MyEclipse Persistence Tools
 */

public class MovieShowInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MovieShowInfoDAO.class);

	public void save(MovieShowInfo transientInstance) {
		log.debug("saving MovieShowInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MovieShowInfo persistentInstance) {
		log.debug("deleting MovieShowInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MovieShowInfo findById(java.lang.Integer id) {
		log.debug("getting MovieShowInfo instance with id: " + id);
		try {
			MovieShowInfo instance = (MovieShowInfo) getSession().get(
					"scu.nine.modle.MovieShowInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MovieShowInfo instance) {
		log.debug("finding MovieShowInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.nine.modle.MovieShowInfo").add(
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
		log.debug("finding MovieShowInfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from MovieShowInfo as model where model."
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
		log.debug("finding all MovieShowInfo instances");
		try {
			String queryString = "from MovieShowInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MovieShowInfo merge(MovieShowInfo detachedInstance) {
		log.debug("merging MovieShowInfo instance");
		try {
			MovieShowInfo result = (MovieShowInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MovieShowInfo instance) {
		log.debug("attaching dirty MovieShowInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MovieShowInfo instance) {
		log.debug("attaching clean MovieShowInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	//自定义方法——排片查询
	public List findMovieArrangeInfoByCondition(String movieCityID,String movieHailID,String moviePlayDate)
	{
		try
		{
			String hql="from MovieShowInfo where 1=1 ";
			
			if(!"".equals(movieCityID) && movieCityID!=null)
			{
				hql+=" and movieVityInfo.movieCityId = '"+movieCityID+"'";
			}
			if(!"".equals(movieHailID) && movieHailID!=null)
			{
				hql+=" and movieHallInfo.movieHailId = '"+movieHailID+"'";
			}
			if(!"".equals(moviePlayDate) && moviePlayDate!=null)
			{
				hql+=" and moviePlayDate = '"+moviePlayDate+"'";   //日期不能模糊查询
			}
			Query qObject=getSession().createQuery(hql);
			
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
		
	}
}