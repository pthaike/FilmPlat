package scu.edu.cn.common;

import java.util.Map;

import scu.edu.cn.model.ManagerInfo;
import scu.edu.cn.model.UserInfo;

import com.opensymphony.xwork2.ActionContext;

public class MySession {
	private static Map session;
	
	public static void saveInfo(UserInfo userInfo)
	{
		 ActionContext actionContext = ActionContext.getContext();   
		 session = actionContext.getSession();
		 session.put("userInfo", userInfo);
	}
	public static UserInfo getUserInfoBySession()
	{
		if(session==null)
			return null;
		return (UserInfo) session.get("userInfo");
	}
	
	public static void saveMngInfo(ManagerInfo mngInfo)
	{
		 ActionContext actionContext = ActionContext.getContext();   
		 session = actionContext.getSession();
		 session.put("ManagerInfo", mngInfo);
	}
	public static ManagerInfo getMngInfoBySession()
	{
		return (ManagerInfo) session.get("ManagerInfo");
	}
	public static Map getMySession()
	{
		
		return session;
	}
	
}
