package scu.edu.cn.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * MovieInfo entity. @author MyEclipse Persistence Tools
 */

public class MovieInfo implements java.io.Serializable {

	// Fields

	private Integer movieId;
	private String movieName;
	private String movieDirector;
	private String movieActor;
	private Integer movieType;
	private String movieCountry;
	private Integer movieLength;
	private Date moviePublishDate;
	private Integer movieGrade;
	private Integer movieClickRate;
	private String movieShortcut;
	private String movieIntroduction;
	private String movieSmallPicture;
	private String movieBigPicture;
	private String movieContentPicture;
	private Integer movieShowOn;
	private Set movieShowInfos = new HashSet(0);
	private Set movieViewInfos = new HashSet(0);
	private Set movieTypes = new HashSet(0);
	private Set payInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public MovieInfo() {
	}

	/** minimal constructor */
	public MovieInfo(String movieName, String movieDirector, String movieActor,
			Integer movieType, String movieCountry, Integer movieLength,
			Date moviePublishDate, String movieIntroduction, Integer movieShowOn) {
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieActor = movieActor;
		this.movieType = movieType;
		this.movieCountry = movieCountry;
		this.movieLength = movieLength;
		this.moviePublishDate = moviePublishDate;
		this.movieIntroduction = movieIntroduction;
		this.movieShowOn = movieShowOn;
	}

	/** full constructor */
	public MovieInfo(String movieName, String movieDirector, String movieActor,
			Integer movieType, String movieCountry, Integer movieLength,
			Date moviePublishDate, Integer movieGrade, Integer movieClickRate,
			String movieShortcut, String movieIntroduction,
			String movieSmallPicture, String movieBigPicture,
			String movieContentPicture, Integer movieShowOn,
			Set movieShowInfos, Set movieViewInfos, Set movieTypes, Set payInfos) {
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieActor = movieActor;
		this.movieType = movieType;
		this.movieCountry = movieCountry;
		this.movieLength = movieLength;
		this.moviePublishDate = moviePublishDate;
		this.movieGrade = movieGrade;
		this.movieClickRate = movieClickRate;
		this.movieShortcut = movieShortcut;
		this.movieIntroduction = movieIntroduction;
		this.movieSmallPicture = movieSmallPicture;
		this.movieBigPicture = movieBigPicture;
		this.movieContentPicture = movieContentPicture;
		this.movieShowOn = movieShowOn;
		this.movieShowInfos = movieShowInfos;
		this.movieViewInfos = movieViewInfos;
		this.movieTypes = movieTypes;
		this.payInfos = payInfos;
	}

	// Property accessors

	public Integer getMovieId() {
		return this.movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return this.movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieActor() {
		return this.movieActor;
	}

	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}

	public Integer getMovieType() {
		return this.movieType;
	}

	public void setMovieType(Integer movieType) {
		this.movieType = movieType;
	}

	public String getMovieCountry() {
		return this.movieCountry;
	}

	public void setMovieCountry(String movieCountry) {
		this.movieCountry = movieCountry;
	}

	public Integer getMovieLength() {
		return this.movieLength;
	}

	public void setMovieLength(Integer movieLength) {
		this.movieLength = movieLength;
	}

	public Date getMoviePublishDate() {
		return this.moviePublishDate;
	}

	public void setMoviePublishDate(Date moviePublishDate) {
		this.moviePublishDate = moviePublishDate;
	}

	public Integer getMovieGrade() {
		return this.movieGrade;
	}

	public void setMovieGrade(Integer movieGrade) {
		this.movieGrade = movieGrade;
	}

	public Integer getMovieClickRate() {
		return this.movieClickRate;
	}

	public void setMovieClickRate(Integer movieClickRate) {
		this.movieClickRate = movieClickRate;
	}

	public String getMovieShortcut() {
		return this.movieShortcut;
	}

	public void setMovieShortcut(String movieShortcut) {
		this.movieShortcut = movieShortcut;
	}

	public String getMovieIntroduction() {
		return this.movieIntroduction;
	}

	public void setMovieIntroduction(String movieIntroduction) {
		this.movieIntroduction = movieIntroduction;
	}

	public String getMovieSmallPicture() {
		return this.movieSmallPicture;
	}

	public void setMovieSmallPicture(String movieSmallPicture) {
		this.movieSmallPicture = movieSmallPicture;
	}

	public String getMovieBigPicture() {
		return this.movieBigPicture;
	}

	public void setMovieBigPicture(String movieBigPicture) {
		this.movieBigPicture = movieBigPicture;
	}

	public String getMovieContentPicture() {
		return this.movieContentPicture;
	}

	public void setMovieContentPicture(String movieContentPicture) {
		this.movieContentPicture = movieContentPicture;
	}

	public Integer getMovieShowOn() {
		return this.movieShowOn;
	}

	public void setMovieShowOn(Integer movieShowOn) {
		this.movieShowOn = movieShowOn;
	}

	public Set getMovieShowInfos() {
		return this.movieShowInfos;
	}

	public void setMovieShowInfos(Set movieShowInfos) {
		this.movieShowInfos = movieShowInfos;
	}

	public Set getMovieViewInfos() {
		return this.movieViewInfos;
	}

	public void setMovieViewInfos(Set movieViewInfos) {
		this.movieViewInfos = movieViewInfos;
	}

	public Set getMovieTypes() {
		return this.movieTypes;
	}

	public void setMovieTypes(Set movieTypes) {
		this.movieTypes = movieTypes;
	}

	public Set getPayInfos() {
		return this.payInfos;
	}

	public void setPayInfos(Set payInfos) {
		this.payInfos = payInfos;
	}

}