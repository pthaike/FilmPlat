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
 * UserInfo entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see scu.edu.cn.model.UserInfo
 * @author MyEclipse Persistence Tools
 */

public class UserInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UserInfoDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_REALNAME = "userRealname";
	public static final String USER_SEX = "userSex";
	public static final String USER_IDCARD = "userIdcard";
	public static final String USER_MARRY = "userMarry";
	public static final String USER_CITY = "userCity";
	public static final String USER_ADDRESS = "userAddress";
	public static final String USER_POSTCODE = "userPostcode";
	public static final String USER_PNUMBER = "userPnumber";
	public static final String USER_EMAIL = "userEmail";

	public void save(UserInfo transientInstance) {
		log.debug("saving UserInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserInfo persistentInstance) {
		log.debug("deleting UserInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserInfo findById(java.lang.Integer id) {
		log.debug("getting UserInfo instance with id: " + id);
		try {
			UserInfo instance = (UserInfo) getSession().get(
					"scu.edu.cn.model.UserInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserInfo instance) {
		log.debug("finding UserInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.edu.cn.model.UserInfo").add(Example.create(instance))
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
		log.debug("finding UserInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserInfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByUserPassword(Object userPassword) {
		return findByProperty(USER_PASSWORD, userPassword);
	}

	public List findByUserRealname(Object userRealname) {
		return findByProperty(USER_REALNAME, userRealname);
	}

	public List findByUserSex(Object userSex) {
		return findByProperty(USER_SEX, userSex);
	}

	public List findByUserIdcard(Object userIdcard) {
		return findByProperty(USER_IDCARD, userIdcard);
	}

	public List findByUserMarry(Object userMarry) {
		return findByProperty(USER_MARRY, userMarry);
	}

	public List findByUserCity(Object userCity) {
		return findByProperty(USER_CITY, userCity);
	}

	public List findByUserAddress(Object userAddress) {
		return findByProperty(USER_ADDRESS, userAddress);
	}

	public List findByUserPostcode(Object userPostcode) {
		return findByProperty(USER_POSTCODE, userPostcode);
	}

	public List findByUserPnumber(Object userPnumber) {
		return findByProperty(USER_PNUMBER, userPnumber);
	}

	public List findByUserEmail(Object userEmail) {
		return findByProperty(USER_EMAIL, userEmail);
	}

	public List findAll() {
		log.debug("finding all UserInfo instances");
		try {
			String queryString = "from UserInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserInfo merge(UserInfo detachedInstance) {
		log.debug("merging UserInfo instance");
		try {
			UserInfo result = (UserInfo) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserInfo instance) {
		log.debug("attaching dirty UserInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserInfo instance) {
		log.debug("attaching clean UserInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
    public List findByUserNameAndPassword(String userName,String password)
    {
		try
		{
			String hql="from UserInfo where ";
			hql+="userName = '"+userName+"' and userPassword = '"+password+"'";
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
    }
    public List findByUserName2(String userName)
    {
		try
		{
			String hql="from UserInfo where ";
			hql+="userName = '"+userName+"'";
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
    }
    public List findByUserRealname2(String realName)
    {
		try
		{
			String hql="from UserInfo where ";
			hql+="userRealname = '"+realName+"'";
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
    }
    public List findByUserID2(int userID)
    {
		try
		{
			String hql="from UserInfo where ";
			hql+="userId = "+userID;
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
    }
    public List findByUserPnumber2(String pnumber)
    {
		try
		{
			String hql="from UserInfo where ";
			hql+="userPnumber = '"+pnumber+"'";
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
    }
    public List findByUserEmail2(String email)
    {
		try
		{
			String hql="from UserInfo where ";
			hql+="userEmail = '"+email+"'";
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
    }
}