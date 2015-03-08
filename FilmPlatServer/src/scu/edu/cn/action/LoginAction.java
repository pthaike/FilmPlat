package scu.edu.cn.action;

import java.util.List;

import scu.nine.common.MySession;
import scu.nine.modle.UserInfo;
import scu.nine.modle.UserInfoDAO;

public class LoginAction extends MySession{
//	private String loginName;
	private String userName;
	private String password;
	private List<UserInfo> userlist;
	private UserInfo userInfo;
	private String message;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
//	public void setLoginName(String loginName) {
//		this.loginName = loginName;
//	}
//	public String getLoginName() {
//		return loginName;
//	}

	@SuppressWarnings("unchecked")
	public String checkUserInfo()
    {
    	UserInfoDAO userinfoDAO = new UserInfoDAO();
    	userlist = userinfoDAO.findByUserNameAndPassword(userName, password);
    	if(userlist.isEmpty())
    	{
    		return "error";
    	}
    	else
    	{
    		userInfo=userlist.get(0);
    		MySession.saveInfo(userInfo);
    		return "ok";
    	}
    }
	public String getErrorMsg()
	{
		message="用户名或密码错误！";
		return "ok";
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
