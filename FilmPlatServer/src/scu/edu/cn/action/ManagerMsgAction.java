package scu.edu.cn.action;

import java.util.List;

import scu.nine.common.COMMON;
import scu.nine.modle.MessageInfo;
import scu.nine.modle.MessageInfoDAO;

public class ManagerMsgAction {

	private MessageInfo msgInfo;
	private String keyWord;
	private List msgList;
	private List noreplymsgList;
	private String messageID;
	private String repstate;
	
	public List getNoreplymsgList() {
		return noreplymsgList;
	}

	public void setNoreplymsgList(List noreplymsgList) {
		this.noreplymsgList = noreplymsgList;
	}

	public String getRepstate() {
		return repstate;
	}

	public void setRepstate(String repstate) {
		this.repstate = repstate;
	}

	public String getMessageID() {
		return messageID;
	}

	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}

	public MessageInfo getMsgInfo() {
		return msgInfo;
	}

	public void setMsgInfo(MessageInfo msgInfo) {
		this.msgInfo = msgInfo;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public List getMsgList() {
		return msgList;
	}

	public void setMsgList(List msgList) {
		this.msgList = msgList;
	}

	//��������
	public String queryMsg(){
		String kw = keyWord;
		MessageInfoDAO messageDAO = new MessageInfoDAO();
		if ("1".equals(repstate)){
			msgList = messageDAO.findIsReplyMsg(kw);
		}else if("0".equals(repstate)){
			noreplymsgList = messageDAO.findNoReplyMsg(kw);
		}else{
			msgList = messageDAO.findIsReplyMsg(kw);
			noreplymsgList = messageDAO.findNoReplyMsg(kw);
		}
		return "query";
	}
	
	//ɾ������
	public String deleteMsg(){
		MessageInfoDAO msgDAO = new MessageInfoDAO();
		msgInfo = msgDAO.findById(Integer.parseInt(messageID));
		msgDAO.delete(msgInfo);
		COMMON.commit();
		return "deletemsg";
	}
	
	//�ظ�����
	public String replyMsg(){
		MessageInfoDAO msgDAO = new MessageInfoDAO();
		msgInfo = msgDAO.findById(Integer.parseInt(messageID));
		return "replymsg";
	}
	
	//������Իظ�
	public String addReply(){
		MessageInfoDAO msgDAO = new MessageInfoDAO();
		MessageInfo msg = msgDAO.findById(Integer.parseInt(messageID));
		msg.setMessageReply(msgInfo.getMessageReply());
		msgDAO.merge(msg);  
		COMMON.commit(); // �ύ
		return "addreply";
	}
	
	//�༭�ظ�
	public String editReply(){
		MessageInfoDAO msgDAO = new MessageInfoDAO();
		msgInfo = msgDAO.findById(Integer.parseInt(messageID));
		return "editreply";
	}
	
	//���»ظ�
	public String updateReply(){
		MessageInfoDAO msgDAO = new MessageInfoDAO();
		msgDAO.merge(msgInfo);  
		COMMON.commit(); // �ύ
		return "updatereply";
	}
	
	//ɾ���ظ�
	public String deleteReply(){
		MessageInfoDAO msgDAO = new MessageInfoDAO();
		MessageInfo msginf =  msgDAO.findById(Integer.parseInt(messageID));
		msginf.setMessageReply(null);
		msgDAO.merge(msginf);  
		COMMON.commit(); // �ύ
		return "delreply";
	}
}
