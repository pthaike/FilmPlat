package scu.nine.modle;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * MessageInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see scu.nine.modle.MessageInfo
 * @author MyEclipse Persistence Tools
 */

public class MessageInfoDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(MessageInfoDAO.class);

	public void save(MessageInfo transientInstance) {
		log.debug("saving MessageInfo instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MessageInfo persistentInstance) {
		log.debug("deleting MessageInfo instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MessageInfo findById(java.lang.Integer id) {
		log.debug("getting MessageInfo instance with id: " + id);
		try {
			MessageInfo instance = (MessageInfo) getSession().get(
					"scu.nine.modle.MessageInfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MessageInfo instance) {
		log.debug("finding MessageInfo instance by example");
		try {
			List results = getSession().createCriteria(
					"scu.nine.modle.MessageInfo").add(Example.create(instance))
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
		log.debug("finding MessageInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MessageInfo as model where model."
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
		log.debug("finding all MessageInfo instances");
		try {
			String queryString = "from MessageInfo";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MessageInfo merge(MessageInfo detachedInstance) {
		log.debug("merging MessageInfo instance");
		try {
			MessageInfo result = (MessageInfo) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MessageInfo instance) {
		log.debug("attaching dirty MessageInfo instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MessageInfo instance) {
		log.debug("attaching clean MessageInfo instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	//≤È’““—ªÿ∏¥¡Ù—‘
	public List findIsReplyMsg(String keyword){
		try
		{
			String hql="from MessageInfo where 1=1 and messageReply is not null";
			if(!"".equals(keyword) && keyword!=null)
			{
				hql+=" and userInfo.userId = '"+keyword+"'";
			}
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
	}
	
	//≤È’“Œ¥ªÿ∏¥¡Ù—‘
	public List findNoReplyMsg(String keyword){
		try
		{
			String hql="from MessageInfo where 1=1 and messageReply is null";
			if(!"".equals(keyword) && keyword!=null)
			{
				hql+=" and userInfo.userId = '"+keyword+"'";
			}
			Query qObject=getSession().createQuery(hql);
			return qObject.list();
		}
		catch(RuntimeException re){ 
			throw re;
		}
	}
}