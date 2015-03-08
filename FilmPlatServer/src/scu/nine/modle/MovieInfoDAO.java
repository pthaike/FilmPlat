package scu.nine.modle;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * MovieInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see scu.nine.modle.MovieInfo
 * @author MyEclipse Persistence Tools
 */

public class MovieInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MovieInfoDAO.class);

	public void save(MovieInfo transientInstance) {
		log.debug("saving MovieInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MovieInfo persistentInstance) {
		log.debug("deleting MovieInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MovieInfo findById(java.lang.Integer id) {
		log.debug("getting MovieInfo instance with id: " + id);
		try {
			MovieInfo instance = (MovieInfo) getSession().get(
					"scu.nine.modle.MovieInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MovieInfo instance) {
		log.debug("finding MovieInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.nine.modle.MovieInfo").add(Example.create(instance))
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
		log.debug("finding MovieInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MovieInfo as model where model."
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
		log.debug("finding all MovieInfo instances");
		try {
			String queryString = "from MovieInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MovieInfo merge(MovieInfo detachedInstance) {
		log.debug("merging MovieInfo instance");
		try {
			MovieInfo result = (MovieInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MovieInfo instance) {
		log.debug("attaching dirty MovieInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MovieInfo instance) {
		log.debug("attaching clean MovieInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	//自定义方法——条件查询
	public List findMovieInfoByCondition(String moviePublishDate,String movieName,String movieCountry)
	{
		try
		{
			String hql="from MovieInfo where 1=1 ";
			
			if(!"".equals(moviePublishDate) && moviePublishDate!=null)
			{
				hql+=" and moviePublishDate = '"+moviePublishDate+"'";   //日期不能模糊查询
			}
			if(!"".equals(movieName) && movieName!=null)
			{
				hql+=" and movieName like '%"+movieName+"%'";
			}
			if(!"".equals(movieCountry) && movieCountry!=null)
			{
				hql+=" and movieCountry like '%"+movieCountry+"%'";
			}
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
		
	}
	
	//自定义方法——排片查询
	public List findArrangeMovieInfoByCondition(String movieName)
	{
		try
		{
			String hql="from MovieInfo where 1=1 ";
			
			if(!"".equals(movieName) && movieName!=null)
			{
				hql+=" and movieName like '%"+movieName+"%'";
			}
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
		
	}
}