package scu.nine.modle;

import java.util.Date;

/**
 * MovieViewInfo entity. @author MyEclipse Persistence Tools
 */

public class MovieViewInfo implements java.io.Serializable {

	// Fields

	private Integer movieViewId;
	private UserInfo userInfo;
	private MovieInfo movieInfo;
	private String movieViewContent;
	private Date movieViewDate;
	private String movieCommentShield;

	// Constructors

	/** default constructor */
	public MovieViewInfo() {
	}

	/** minimal constructor */
	public MovieViewInfo(UserInfo userInfo, MovieInfo movieInfo,
			String movieViewContent, Date movieViewDate) {
		this.userInfo = userInfo;
		this.movieInfo = movieInfo;
		this.movieViewContent = movieViewContent;
		this.movieViewDate = movieViewDate;
	}

	/** full constructor */
	public MovieViewInfo(UserInfo userInfo, MovieInfo movieInfo,
			String movieViewContent, Date movieViewDate,
			String movieCommentShield) {
		this.userInfo = userInfo;
		this.movieInfo = movieInfo;
		this.movieViewContent = movieViewContent;
		this.movieViewDate = movieViewDate;
		this.movieCommentShield = movieCommentShield;
	}

	// Property accessors

	public Integer getMovieViewId() {
		return this.movieViewId;
	}

	public void setMovieViewId(Integer movieViewId) {
		this.movieViewId = movieViewId;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public MovieInfo getMovieInfo() {
		return this.movieInfo;
	}

	public void setMovieInfo(MovieInfo movieInfo) {
		this.movieInfo = movieInfo;
	}

	public String getMovieViewContent() {
		return this.movieViewContent;
	}

	public void setMovieViewContent(String movieViewContent) {
		this.movieViewContent = movieViewContent;
	}

	public Date getMovieViewDate() {
		return this.movieViewDate;
	}

	public void setMovieViewDate(Date movieViewDate) {
		this.movieViewDate = movieViewDate;
	}

	public String getMovieCommentShield() {
		return this.movieCommentShield;
	}

	public void setMovieCommentShield(String movieCommentShield) {
		this.movieCommentShield = movieCommentShield;
	}

}