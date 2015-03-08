package scu.nine.modle;

import java.util.Date;

/**
 * NewsViewInfo entity. @author MyEclipse Persistence Tools
 */

public class NewsViewInfo implements java.io.Serializable {

	// Fields

	private Integer newsviewId;
	private UserInfo userInfo;
	private NewsArticalInfo newsArticalInfo;
	private String newsviewContent;
	private Date newsviewTime;

	// Constructors

	/** default constructor */
	public NewsViewInfo() {
	}

	/** minimal constructor */
	public NewsViewInfo(String newsviewContent, Date newsviewTime) {
		this.newsviewContent = newsviewContent;
		this.newsviewTime = newsviewTime;
	}

	/** full constructor */
	public NewsViewInfo(UserInfo userInfo, NewsArticalInfo newsArticalInfo,
			String newsviewContent, Date newsviewTime) {
		this.userInfo = userInfo;
		this.newsArticalInfo = newsArticalInfo;
		this.newsviewContent = newsviewContent;
		this.newsviewTime = newsviewTime;
	}

	// Property accessors

	public Integer getNewsviewId() {
		return this.newsviewId;
	}

	public void setNewsviewId(Integer newsviewId) {
		this.newsviewId = newsviewId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public NewsArticalInfo getNewsArticalInfo() {
		return this.newsArticalInfo;
	}

	public void setNewsArticalInfo(NewsArticalInfo newsArticalInfo) {
		this.newsArticalInfo = newsArticalInfo;
	}

	public String getNewsviewContent() {
		return this.newsviewContent;
	}

	public void setNewsviewContent(String newsviewContent) {
		this.newsviewContent = newsviewContent;
	}

	public Date getNewsviewTime() {
		return this.newsviewTime;
	}

	public void setNewsviewTime(Date newsviewTime) {
		this.newsviewTime = newsviewTime;
	}

}