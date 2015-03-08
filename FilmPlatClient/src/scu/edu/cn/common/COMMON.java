package scu.edu.cn.common;

import org.hibernate.Session;


public class COMMON {

	//提交信息
	public static void commit() {
		Session session= HibernateSessionFactory.getSession();
		session.beginTransaction().commit();
	}
	
	
	public static String GetUUID()
	{
		String uuid = java.util.UUID.randomUUID().toString();
		StringBuilder bf = new StringBuilder(32);
		for (int i = 0; i < uuid.length(); ++i) {
			char c = uuid.charAt(i);
			if (c != '-' && c != '_') {
				bf.append(c);
			}
		}
		return bf.toString();
	}
	

}
