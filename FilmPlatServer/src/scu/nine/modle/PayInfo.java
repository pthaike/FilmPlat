package scu.nine.modle;

import java.util.Date;

/**
 * PayInfo entity. @author MyEclipse Persistence Tools
 */

public class PayInfo implements java.io.Serializable {

	// Fields

	private Integer payId;
	private UserInfo userInfo;
	private MovieInfo movieInfo;
	private MovieVityInfo movieVityInfo;
	private Float payAmount;
	private Date payDate;

	// Constructors

	/** default constructor */
	public PayInfo() {
	}

	/** full constructor */
	public PayInfo(UserInfo userInfo, MovieInfo movieInfo,
			MovieVityInfo movieVityInfo, Float payAmount, Date payDate) {
		this.userInfo = userInfo;
		this.movieInfo = movieInfo;
		this.movieVityInfo = movieVityInfo;
		this.payAmount = payAmount;
		this.payDate = payDate;
	}

	// Property accessors

	public Integer getPayId() {
		return this.payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
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

	public MovieVityInfo getMovieVityInfo() {
		return this.movieVityInfo;
	}

	public void setMovieVityInfo(MovieVityInfo movieVityInfo) {
		this.movieVityInfo = movieVityInfo;
	}

	public Float getPayAmount() {
		return this.payAmount;
	}

	public void setPayAmount(Float payAmount) {
		this.payAmount = payAmount;
	}

	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

}