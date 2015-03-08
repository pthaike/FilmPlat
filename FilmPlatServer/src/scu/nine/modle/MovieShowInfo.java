package scu.nine.modle;

import java.util.Date;

/**
 * MovieShowInfo entity. @author MyEclipse Persistence Tools
 */

public class MovieShowInfo implements java.io.Serializable {

	// Fields

	private Integer movieShowId;
	private MovieHallInfo movieHallInfo;
	private MovieInfo movieInfo;
	private MovieVityInfo movieVityInfo;
	private Integer movieVison;
	private String movieTime;
	private Integer moviePrice;
	private Date moviePlayDate;

	// Constructors

	/** default constructor */
	public MovieShowInfo() {
	}

	/** minimal constructor */
	public MovieShowInfo(MovieHallInfo movieHallInfo, MovieInfo movieInfo,
			MovieVityInfo movieVityInfo, String movieTime, Integer moviePrice,
			Date moviePlayDate) {
		this.movieHallInfo = movieHallInfo;
		this.movieInfo = movieInfo;
		this.movieVityInfo = movieVityInfo;
		this.movieTime = movieTime;
		this.moviePrice = moviePrice;
		this.moviePlayDate = moviePlayDate;
	}

	/** full constructor */
	public MovieShowInfo(MovieHallInfo movieHallInfo, MovieInfo movieInfo,
			MovieVityInfo movieVityInfo, Integer movieVison, String movieTime,
			Integer moviePrice, Date moviePlayDate) {
		this.movieHallInfo = movieHallInfo;
		this.movieInfo = movieInfo;
		this.movieVityInfo = movieVityInfo;
		this.movieVison = movieVison;
		this.movieTime = movieTime;
		this.moviePrice = moviePrice;
		this.moviePlayDate = moviePlayDate;
	}

	// Property accessors

	public Integer getMovieShowId() {
		return this.movieShowId;
	}

	public void setMovieShowId(Integer movieShowId) {
		this.movieShowId = movieShowId;
	}

	public MovieHallInfo getMovieHallInfo() {
		return this.movieHallInfo;
	}

	public void setMovieHallInfo(MovieHallInfo movieHallInfo) {
		this.movieHallInfo = movieHallInfo;
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

	public Integer getMovieVison() {
		return this.movieVison;
	}

	public void setMovieVison(Integer movieVison) {
		this.movieVison = movieVison;
	}

	public String getMovieTime() {
		return this.movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public Integer getMoviePrice() {
		return this.moviePrice;
	}

	public void setMoviePrice(Integer moviePrice) {
		this.moviePrice = moviePrice;
	}

	public Date getMoviePlayDate() {
		return this.moviePlayDate;
	}

	public void setMoviePlayDate(Date moviePlayDate) {
		this.moviePlayDate = moviePlayDate;
	}

}