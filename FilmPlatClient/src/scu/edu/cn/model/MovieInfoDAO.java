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
 * MovieInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see scu.edu.cn.model.MovieInfo
 * @author MyEclipse Persistence Tools
 */

public class MovieInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MovieInfoDAO.class);
	// property constants
	public static final String MOVIE_NAME = "movieName";
	public static final String MOVIE_DIRECTOR = "movieDirector";
	public static final String MOVIE_ACTOR = "movieActor";
	public static final String MOVIE_TYPE = "movieType";
	public static final String MOVIE_COUNTRY = "movieCountry";
	public static final String MOVIE_LENGTH = "movieLength";
	public static final String MOVIE_GRADE = "movieGrade";
	public static final String MOVIE_CLICK_RATE = "movieClickRate";
	public static final String MOVIE_SHORTCUT = "movieShortcut";
	public static final String MOVIE_INTRODUCTION = "movieIntroduction";
	public static final String MOVIE_SMALL_PICTURE = "movieSmallPicture";
	public static final String MOVIE_BIG_PICTURE = "movieBigPicture";
	public static final String MOVIE_CONTENT_PICTURE = "movieContentPicture";
	public static final String MOVIE_SHOW_ON = "movieShowOn";

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
					"scu.edu.cn.model.MovieInfo", id);
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
					"scu.edu.cn.model.MovieInfo").add(Example.create(instance))
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

	public List findByMovieName(Object movieName) {
		return findByProperty(MOVIE_NAME, movieName);
	}

	public List findByMovieDirector(Object movieDirector) {
		return findByProperty(MOVIE_DIRECTOR, movieDirector);
	}

	public List findByMovieActor(Object movieActor) {
		return findByProperty(MOVIE_ACTOR, movieActor);
	}

	public List findByMovieType(Object movieType) {
		return findByProperty(MOVIE_TYPE, movieType);
	}

	public List findByMovieCountry(Object movieCountry) {
		return findByProperty(MOVIE_COUNTRY, movieCountry);
	}

	public List findByMovieLength(Object movieLength) {
		return findByProperty(MOVIE_LENGTH, movieLength);
	}

	public List findByMovieGrade(Object movieGrade) {
		return findByProperty(MOVIE_GRADE, movieGrade);
	}

	public List findByMovieClickRate(Object movieClickRate) {
		return findByProperty(MOVIE_CLICK_RATE, movieClickRate);
	}

	public List findByMovieShortcut(Object movieShortcut) {
		return findByProperty(MOVIE_SHORTCUT, movieShortcut);
	}

	public List findByMovieIntroduction(Object movieIntroduction) {
		return findByProperty(MOVIE_INTRODUCTION, movieIntroduction);
	}

	public List findByMovieSmallPicture(Object movieSmallPicture) {
		return findByProperty(MOVIE_SMALL_PICTURE, movieSmallPicture);
	}

	public List findByMovieBigPicture(Object movieBigPicture) {
		return findByProperty(MOVIE_BIG_PICTURE, movieBigPicture);
	}

	public List findByMovieContentPicture(Object movieContentPicture) {
		return findByProperty(MOVIE_CONTENT_PICTURE, movieContentPicture);
	}

	public List findByMovieShowOn(Object movieShowOn) {
		return findByProperty(MOVIE_SHOW_ON, movieShowOn);
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
	public List findMovieOnShow(){
		try
		{
			String hql="from MovieInfo where ";
			hql+="movieShowOn = "+1;
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
	}
	public List findMovieWillShow(){
		try
		{
			String hql="from MovieInfo where ";
			hql+="movieShowOn = "+0;
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
	}
}