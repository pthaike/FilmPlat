package scu.edu.cn.model;

import java.util.HashSet;
import java.util.Set;

/**
 * MovieVityInfo entity. @author MyEclipse Persistence Tools
 */

public class MovieVityInfo implements java.io.Serializable {

	// Fields

	private Integer movieCityId;
	private String movieCityName;
	private Integer supportOnlline;
	private String movieCityAddress;
	private String movieCityPhone;
	private String movieCityIntro;
	private Set movieShowInfos = new HashSet(0);
	private Set movieHallInfos = new HashSet(0);
	private Set payInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public MovieVityInfo() {
	}

	/** minimal constructor */
	public MovieVityInfo(String movieCityName, Integer supportOnlline,
			String movieCityAddress, String movieCityPhone,
			String movieCityIntro) {
		this.movieCityName = movieCityName;
		this.supportOnlline = supportOnlline;
		this.movieCityAddress = movieCityAddress;
		this.movieCityPhone = movieCityPhone;
		this.movieCityIntro = movieCityIntro;
	}

	/** full constructor */
	public MovieVityInfo(String movieCityName, Integer supportOnlline,
			String movieCityAddress, String movieCityPhone,
			String movieCityIntro, Set movieShowInfos, Set movieHallInfos,
			Set payInfos) {
		this.movieCityName = movieCityName;
		this.supportOnlline = supportOnlline;
		this.movieCityAddress = movieCityAddress;
		this.movieCityPhone = movieCityPhone;
		this.movieCityIntro = movieCityIntro;
		this.movieShowInfos = movieShowInfos;
		this.movieHallInfos = movieHallInfos;
		this.payInfos = payInfos;
	}

	// Property accessors

	public Integer getMovieCityId() {
		return this.movieCityId;
	}

	public void setMovieCityId(Integer movieCityId) {
		this.movieCityId = movieCityId;
	}

	public String getMovieCityName() {
		return this.movieCityName;
	}

	public void setMovieCityName(String movieCityName) {
		this.movieCityName = movieCityName;
	}

	public Integer getSupportOnlline() {
		return this.supportOnlline;
	}

	public void setSupportOnlline(Integer supportOnlline) {
		this.supportOnlline = supportOnlline;
	}

	public String getMovieCityAddress() {
		return this.movieCityAddress;
	}

	public void setMovieCityAddress(String movieCityAddress) {
		this.movieCityAddress = movieCityAddress;
	}

	public String getMovieCityPhone() {
		return this.movieCityPhone;
	}

	public void setMovieCityPhone(String movieCityPhone) {
		this.movieCityPhone = movieCityPhone;
	}

	public String getMovieCityIntro() {
		return this.movieCityIntro;
	}

	public void setMovieCityIntro(String movieCityIntro) {
		this.movieCityIntro = movieCityIntro;
	}

	public Set getMovieShowInfos() {
		return this.movieShowInfos;
	}

	public void setMovieShowInfos(Set movieShowInfos) {
		this.movieShowInfos = movieShowInfos;
	}

	public Set getMovieHallInfos() {
		return this.movieHallInfos;
	}

	public void setMovieHallInfos(Set movieHallInfos) {
		this.movieHallInfos = movieHallInfos;
	}

	public Set getPayInfos() {
		return this.payInfos;
	}

	public void setPayInfos(Set payInfos) {
		this.payInfos = payInfos;
	}

}