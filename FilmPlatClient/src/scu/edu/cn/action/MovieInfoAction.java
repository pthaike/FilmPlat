package scu.edu.cn.action;

import java.util.List;

import scu.edu.cn.common.COMMON;
import scu.edu.cn.common.MySession;
import scu.edu.cn.model.MovieInfo;
import scu.edu.cn.model.MovieInfoDAO;
import scu.edu.cn.model.MovieViewInfo;
import scu.edu.cn.model.MovieViewInfoDAO;
import scu.edu.cn.model.MovieVityInfo;
import scu.edu.cn.model.MovieVityInfoDAO;
import scu.edu.cn.model.NewsArticalInfo;
import scu.edu.cn.model.NewsArticalInfoDAO;
import scu.edu.cn.model.NewsViewInfo;
import scu.edu.cn.model.NewsViewInfoDAO;
import scu.edu.cn.model.UserInfo;


public class MovieInfoAction {
	private List movie_onshow_list;
	private List movie_willshow_list;
	private List newsList;
	private List movieCityList;
	private int newsId;
	private int movieCityId;
	private int movieId;
	private NewsArticalInfo news;
	private MovieVityInfo movieCity;
	private MovieInfo movieInfo;
	private List movieViewList;
	private List newsViewList;
	private int newsviewId;
	private NewsViewInfo newsViewInfo; 
	private MovieViewInfo movieViewInfo;
	
	
	public void setMovieViewInfo(MovieViewInfo movieViewInfo) {
		this.movieViewInfo = movieViewInfo;
	}
	public MovieViewInfo getMovieViewInfo() {
		return movieViewInfo;
	}
	public void setNewsViewInfo(NewsViewInfo newsViewInfo) {
		this.newsViewInfo = newsViewInfo;
	}
	public NewsViewInfo getNewsViewInfo() {
		return newsViewInfo;
	}
	public void setNewsViewList(List newsViewList) {
		this.newsViewList = newsViewList;
	}
	public List getNewsViewList() {
		return newsViewList;
	}
	public void setMovieViewList(List movieViewList) {
		this.movieViewList = movieViewList;
	}
	public List getMovieViewList() {
		return movieViewList;
	}
	public void setMovieInfo(MovieInfo movieInfo) {
		this.movieInfo = movieInfo;
	}
	public MovieInfo getMovieInfo() {
		return movieInfo;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieCity(MovieVityInfo movieCity) {
		this.movieCity = movieCity;
	}
	public MovieVityInfo getMovieCity() {
		return movieCity;
	}
	public void setMovieCityId(int movieCityId) {
		this.movieCityId = movieCityId;
	}
	public int getMovieCityId() {
		return movieCityId;
	}
	public void setNews(NewsArticalInfo news) {
		this.news = news;
	}
	public NewsArticalInfo getNews() {
		return news;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setMovieCityList(List movieCityList) {
		this.movieCityList = movieCityList;
	}
	public List getMovieCityList() {
		return movieCityList;
	}
	public void setNewsList(List newsList) {
		this.newsList = newsList;
	}
	public List getNewsList() {
		return newsList;
	}
	public void setMovie_onshow_list(List movie_onshow_list) {
		this.movie_onshow_list = movie_onshow_list;
	}
	public List getMovie_onshow_list() {
		return movie_onshow_list;
	}
	public void setMovie_willshow_list(List movie_willshow_list) {
		this.movie_willshow_list = movie_willshow_list;
	}
	public List getMovie_willshow_list() {
		return movie_willshow_list;
	}
	public String quarryMovieInfo(){
		MovieInfoDAO movieDAO=new MovieInfoDAO();
		movie_onshow_list = movieDAO.findMovieOnShow();
		movie_willshow_list=movieDAO.findMovieWillShow();	
		return "ok";
	}
	public String quarryMovieInfoById()
	{
		MovieInfoDAO movieDAO=new MovieInfoDAO();
		movieInfo=movieDAO.findById(movieId);
		return "ok";
	}
	public String quarryNewsInfo(){
		NewsArticalInfoDAO newsDAO=new NewsArticalInfoDAO();
		newsList=newsDAO.findAll();
		return "ok";
	}
	public String quarryNewsInfoById(){
		NewsArticalInfoDAO newsDAO=new NewsArticalInfoDAO();
		news=newsDAO.findById(newsId);
		return "ok";
	}
	public String quarryMovieCityInfo(){
		MovieVityInfoDAO movieCityDAO=new MovieVityInfoDAO();
		movieCityList=movieCityDAO.findAll();
		return "ok";
	}
	public String quarryMovieCityInfoById(){
		MovieVityInfoDAO movieCityDAO=new MovieVityInfoDAO();
		movieCity=movieCityDAO.findById(movieCityId);
		return "ok";
	}
	public String quarryMovieCityAndNewsInfo(){
		NewsArticalInfoDAO newsDAO=new NewsArticalInfoDAO();
		newsList=newsDAO.findAll();
		MovieVityInfoDAO movieCityDAO=new MovieVityInfoDAO();
		movieCityList=movieCityDAO.findAll();
		return "ok";
	}
	public String quarryNewsAndMovieInfo(){
		MovieInfoDAO movieDAO=new MovieInfoDAO();
		movie_onshow_list = movieDAO.findAll();
		NewsArticalInfoDAO newsDAO=new NewsArticalInfoDAO();
		newsList=newsDAO.findAll();
		return "ok";
	}
	public String quaryMovieViewByMovieId(){
		MovieViewInfoDAO movieViewDAO=new MovieViewInfoDAO();
		movieViewList=movieViewDAO.findMovieViewByMovieId(movieId);
		return "ok";
	}
	public String quaryMovieInfoAndViewByMovieId(){
		MovieInfoDAO movieDAO=new MovieInfoDAO();
		movieInfo=movieDAO.findById(movieId);
		MovieViewInfoDAO movieViewDAO=new MovieViewInfoDAO();
		movieViewList=movieViewDAO.findMovieViewByMovieId(movieId);
		return "ok";
	}
	public String quaryNewsAndViewBynewsId(){
		NewsArticalInfoDAO newsDAO=new NewsArticalInfoDAO();
		news=newsDAO.findById(newsId);
		NewsViewInfoDAO newsViewDAO=new NewsViewInfoDAO();
		newsViewList=newsViewDAO.findnewsViewBynewsId(newsId);
		return "ok";
	}
	public String addNewsView()
	{
		NewsViewInfo msg=newsViewInfo;
		UserInfo user= new UserInfo();
		user=MySession.getUserInfoBySession();
		if(user==null)
			return "error";
		msg.setUserInfo(user);
		msg.setNewsviewTime(getDate());
		NewsArticalInfoDAO newsDAO=new NewsArticalInfoDAO();
		news=newsDAO.findById(newsId);
		msg.setNewsArticalInfo(news);
		NewsViewInfoDAO msgDAO= new NewsViewInfoDAO();
		msgDAO.save(msg);
		COMMON.commit();
		return "ok";
	}
	public String addMovieView(){
		MovieViewInfo msg=movieViewInfo;
		UserInfo user= new UserInfo();
		user=MySession.getUserInfoBySession();
		if(user==null)
			return "error";
		msg.setUserInfo(user);
		msg.setMovieViewDate(getDate());
		MovieInfoDAO movieDAO=new MovieInfoDAO();
		movieInfo=movieDAO.findById(movieId);
		msg.setMovieInfo(movieInfo);
		MovieViewInfoDAO msgDAO=new MovieViewInfoDAO();
		msgDAO.save(msg);
		COMMON.commit();
		return "ok";
	}
	//获取当前时间
	private java.util.Date getDate(){
		java.util.Date currTime = new java.util.Date();
		return currTime;
	}
	public void setNewsviewId(int newsviewId) {
		this.newsviewId = newsviewId;
	}
	public int getNewsviewId() {
		return newsviewId;
	}
}
