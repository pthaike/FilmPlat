package scu.edu.cn.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import scu.nine.modle.ManagerInfoDAO;

public class ManagerInfoAction {

	private String loginName;
	private String password;
	private String error;
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//管理员验证
	public String VeridateManager(){
		error="0";
		ManagerInfoDAO managerInfoDAO =new ManagerInfoDAO();
		if(managerInfoDAO.findManagerbyNameAndPsw(loginName,password)){
			Map session=ServletActionContext.getContext().getSession();
			session.put("admin", loginName);
			error="0";
			return "mloginOk";
		}else{
			error="1";
			return "error";
		}
	}
}
