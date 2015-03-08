package scu.nine.modle;

import java.util.Date;

/**
 * MessageInfo entity. @author MyEclipse Persistence Tools
 */

public class MessageInfo implements java.io.Serializable {

	// Fields

	private Integer messageId;
	private UserInfo userInfo;
	private String messageContent;
	private Date messageTime;
	private String messageReply;

	// Constructors

	/** default constructor */
	public MessageInfo() {
	}

	/** minimal constructor */
	public MessageInfo(String messageContent, Date messageTime) {
		this.messageContent = messageContent;
		this.messageTime = messageTime;
	}

	/** full constructor */
	public MessageInfo(UserInfo userInfo, String messageContent,
			Date messageTime, String messageReply) {
		this.userInfo = userInfo;
		this.messageContent = messageContent;
		this.messageTime = messageTime;
		this.messageReply = messageReply;
	}

	// Property accessors

	public Integer getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getMessageContent() {
		return this.messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public Date getMessageTime() {
		return this.messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public String getMessageReply() {
		return this.messageReply;
	}

	public void setMessageReply(String messageReply) {
		this.messageReply = messageReply;
	}

}