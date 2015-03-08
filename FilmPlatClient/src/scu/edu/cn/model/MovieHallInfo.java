package scu.edu.cn.model;

import java.util.HashSet;
import java.util.Set;

/**
 * MovieHallInfo entity. @author MyEclipse Persistence Tools
 */

public class MovieHallInfo implements java.io.Serializable {

	// Fields

	private Integer movieHailId;
	private MovieVityInfo movieVityInfo;
	private String movieHailName;
	private Set movieShowInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public MovieHallInfo() {
	}

	/** minimal constructor */
	public MovieHallInfo(String movieHailName) {
		this.movieHailName = movieHailName;
	}

	/** full constructor */
	public MovieHallInfo(MovieVityInfo movieVityInfo, String movieHailName,
			Set movieShowInfos) {
		this.movieVityInfo = movieVityInfo;
		this.movieHailName = movieHailName;
		this.movieShowInfos = movieShowInfos;
	}

	// Property accessors

	public Integer getMovieHailId() {
		return this.movieHailId;
	}

	public void setMovieHailId(Integer movieHailId) {
		this.movieHailId = movieHailId;
	}

	public MovieVityInfo getMovieVityInfo() {
		return this.movieVityInfo;
	}

	public void setMovieVityInfo(MovieVityInfo movieVityInfo) {
		this.movieVityInfo = movieVityInfo;
	}

	public String getMovieHailName() {
		return this.movieHailName;
	}

	public void setMovieHailName(String movieHailName) {
		this.movieHailName = movieHailName;
	}

	public Set getMovieShowInfos() {
		return this.movieShowInfos;
	}

	public void setMovieShowInfos(Set movieShowInfos) {
		this.movieShowInfos = movieShowInfos;
	}

}