package scu.nine.modle;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * NewsArticalInfo entity. @author MyEclipse Persistence Tools
 */

public class NewsArticalInfo implements java.io.Serializable {

	// Fields

	private Integer newsId;
	private String newsTitle;
	private Date newsTime;
	private String newsContent;
	private Set newsViewInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public NewsArticalInfo() {
	}

	/** minimal constructor */
	public NewsArticalInfo(String newsTitle, Date newsTime, String newsContent) {
		this.newsTitle = newsTitle;
		this.newsTime = newsTime;
		this.newsContent = newsContent;
	}

	/** full constructor */
	public NewsArticalInfo(String newsTitle, Date newsTime, String newsContent,
			Set newsViewInfos) {
		this.newsTitle = newsTitle;
		this.newsTime = newsTime;
		this.newsContent = newsContent;
		this.newsViewInfos = newsViewInfos;
	}

	// Property accessors

	public Integer getNewsId() {
		return this.newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return this.newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public Date getNewsTime() {
		return this.newsTime;
	}

	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}

	public String getNewsContent() {
		return this.newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public Set getNewsViewInfos() {
		return this.newsViewInfos;
	}

	public void setNewsViewInfos(Set newsViewInfos) {
		this.newsViewInfos = newsViewInfos;
	}

}