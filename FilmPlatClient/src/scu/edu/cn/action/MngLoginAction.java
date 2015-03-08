package scu.edu.cn.action;

import java.util.List;

import scu.edu.cn.common.MySession;
import scu.edu.cn.model.ManagerInfo;
import scu.edu.cn.model.ManagerInfoDAO;

public class MngLoginAction {
	private String loginName;
	private String password;
	private List managerList;
	private ManagerInfo mngInfo;
	private String message;
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setManagerList(List managerList) {
		this.managerList = managerList;
	}
	public List getManagerList() {
		return managerList;
	}
	public String checkMngInfo(){
		ManagerInfoDAO mngDAO=new ManagerInfoDAO();
		managerList=mngDAO.findByManagerNameAndPassword(loginName,password);
		if(managerList.isEmpty())
			return "error";
		else
		{
			mngInfo=(ManagerInfo) managerList.get(0);
			MySession.saveMngInfo(mngInfo);
			return "ok";
		}
	}
	public String getErrorMsg()
	{
		message="用户名或密码错误！";
		return "ok";
	}
}
