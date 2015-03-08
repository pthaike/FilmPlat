package scu.edu.cn.action;

import java.util.List;

import scu.edu.cn.common.COMMON;
import scu.edu.cn.common.MySession;
import scu.edu.cn.model.MessageInfoDAO;
import scu.edu.cn.model.UserInfo;
import scu.edu.cn.model.UserInfoDAO;

public class UserInfoAction {
	private UserInfo userInfo;
	private int userID;
	private String userRealname;
	private String userName;
	private String phonenumber;
	private String email;
	private List  userList; 
	private List messageList;

	public void setMessageList(List messageList) {
		this.messageList = messageList;
	}
	public List getMessageList() {
		return messageList;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setUserList(List userList) {
		this.userList = userList;
	}
	public List getUserList() {
		return userList;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}
	public String getUserRealname() {
		return userRealname;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	//�����û���Ϣ
	public String saveUser() {
		UserInfo user = userInfo;
		UserInfoDAO sysDAO = new UserInfoDAO();
		sysDAO.save(user);
		COMMON.commit(); // �ύ
		return "ok";
	}
	//�����û���Ϣ
	public String getUserInfoByCondition(){
		UserInfoDAO sysDAO = new UserInfoDAO();
	    if(userID!=0)
	    {
	    //	id = Integer.parseInt(userID);
	    	userList=sysDAO.findByUserID2(userID);
	    	return "ok";
	    }
	    else if(!"".equals(userRealname))
	    {
	    	userList=sysDAO.findByUserRealname2(userRealname);
	    }
	    else if(!"".equals(userName))
	    {
	    	userList=sysDAO.findByUserName2(userName);
	    }
	    else if(!"".equals(phonenumber))
	    {
	    	userList=sysDAO.findByUserPnumber2(phonenumber);
	    }
	    else if(!"".equals(email))
	    {
	    	userList=sysDAO.findByUserEmail2(email);
	    }
	    else
	    {
	    	userList=sysDAO.findAll();
	    }
		return "ok";
	}
	//�����޸��û�
	public String modifyUser() {
		UserInfoDAO sysDAO = new UserInfoDAO();
		userInfo = sysDAO.findById(userID);
		return "ok";
	}
	//�����޸��û���Ϣ
	public String saveModify() {
		UserInfoDAO sysDAO = new UserInfoDAO();
		sysDAO.merge(userInfo);  
		COMMON.commit(); // �ύ
		userList=sysDAO.findAll();
		MySession.saveInfo(userInfo);
		return "ok";
	}
	//ɾ���û���Ϣ
	public String deleteUserInfo(){
		UserInfoDAO sysDAO = new UserInfoDAO();
		userInfo = sysDAO.findById(userID);
		sysDAO.delete(userInfo);
		COMMON.commit();
		userList=sysDAO.findAll();
		return "ok";
	}
	//��������û���Ϣ
	public String reGetUserList(){
		UserInfoDAO sysDAO = new UserInfoDAO();
		userList=sysDAO.findAll();
		return "ok";
	}
	//�����û�������û���Ϣ
	public String getUserInfoByLoginName()
	{
		UserInfoDAO sysDAO = new UserInfoDAO();
		userList=sysDAO.findByUserName2(userName);
		userInfo=(UserInfo) userList.get(0);
		return "ok";
	}
	//����Session����û���Ϣ
	public String getUserInfoByMySession()
	{
		userInfo=MySession.getUserInfoBySession();
		messageList=getUserMessageAndReplyByUserID();
		return "ok";
	}
	//��ȡ�û���������Ϣ
	public List getUserMessageAndReplyByUserID()
	{
		MessageInfoDAO msgDAO= new MessageInfoDAO();
		messageList=msgDAO.findMsgByUserId(userInfo.getUserId());
		return messageList;
	}
}
