package scu.edu.cn.action;

import scu.edu.cn.common.COMMON;
import scu.edu.cn.common.MySession;
import scu.edu.cn.model.MessageInfo;
import scu.edu.cn.model.MessageInfoDAO;
import scu.edu.cn.model.UserInfo;

public class MessageAction {

	private MessageInfo message;
	
	
	public MessageInfo getMessage() {
		return message;
	}

	public void setMessage(MessageInfo message) {
		this.message = message;
	}

	public String addMessage(){
		MessageInfo msg=message;
		msg.setMessageTime(getDate());		
		UserInfo user= new UserInfo();
		user=MySession.getUserInfoBySession();
		if(user==null)
			return "error";
		msg.setUserInfo(user);		
		msg.setMessageTime(getDate());
		MessageInfoDAO msgDAO= new MessageInfoDAO();
		msgDAO.save(msg);
		COMMON.commit();
		return "addmessage";
	}
	
	//获取当前时间
	private java.util.Date getDate(){
		java.util.Date currTime = new java.util.Date();
		return currTime;
	}
}
