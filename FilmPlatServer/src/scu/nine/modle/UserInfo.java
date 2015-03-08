package scu.nine.modle;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPassword;
	private String userRealname;
	private Integer userSex;
	private String userIdcard;
	private Date userBirth;
	private Integer userMarry;
	private String userCity;
	private String userAddress;
	private String userPostcode;
	private String userPnumber;
	private String userEmail;
	private Set payInfos = new HashSet(0);
	private Set newsViewInfos = new HashSet(0);
	private Set messageInfos = new HashSet(0);
	private Set movieViewInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String userName, String userPassword, String userIdcard,
			String userPnumber, String userEmail) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userIdcard = userIdcard;
		this.userPnumber = userPnumber;
		this.userEmail = userEmail;
	}

	/** full constructor */
	public UserInfo(String userName, String userPassword, String userRealname,
			Integer userSex, String userIdcard, Date userBirth,
			Integer userMarry, String userCity, String userAddress,
			String userPostcode, String userPnumber, String userEmail,
			Set payInfos, Set newsViewInfos, Set messageInfos,
			Set movieViewInfos) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRealname = userRealname;
		this.userSex = userSex;
		this.userIdcard = userIdcard;
		this.userBirth = userBirth;
		this.userMarry = userMarry;
		this.userCity = userCity;
		this.userAddress = userAddress;
		this.userPostcode = userPostcode;
		this.userPnumber = userPnumber;
		this.userEmail = userEmail;
		this.payInfos = payInfos;
		this.newsViewInfos = newsViewInfos;
		this.messageInfos = messageInfos;
		this.movieViewInfos = movieViewInfos;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRealname() {
		return this.userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	public Integer getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserIdcard() {
		return this.userIdcard;
	}

	public void setUserIdcard(String userIdcard) {
		this.userIdcard = userIdcard;
	}

	public Date getUserBirth() {
		return this.userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public Integer getUserMarry() {
		return this.userMarry;
	}

	public void setUserMarry(Integer userMarry) {
		this.userMarry = userMarry;
	}

	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPostcode() {
		return this.userPostcode;
	}

	public void setUserPostcode(String userPostcode) {
		this.userPostcode = userPostcode;
	}

	public String getUserPnumber() {
		return this.userPnumber;
	}

	public void setUserPnumber(String userPnumber) {
		this.userPnumber = userPnumber;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Set getPayInfos() {
		return this.payInfos;
	}

	public void setPayInfos(Set payInfos) {
		this.payInfos = payInfos;
	}

	public Set getNewsViewInfos() {
		return this.newsViewInfos;
	}

	public void setNewsViewInfos(Set newsViewInfos) {
		this.newsViewInfos = newsViewInfos;
	}

	public Set getMessageInfos() {
		return this.messageInfos;
	}

	public void setMessageInfos(Set messageInfos) {
		this.messageInfos = messageInfos;
	}

	public Set getMovieViewInfos() {
		return this.movieViewInfos;
	}

	public void setMovieViewInfos(Set movieViewInfos) {
		this.movieViewInfos = movieViewInfos;
	}

}