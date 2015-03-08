package scu.edu.cn.action;

import java.util.List;

import scu.nine.common.COMMON;
import scu.nine.modle.MovieHallInfo;
import scu.nine.modle.MovieHallInfoDAO;
import scu.nine.modle.MovieInfo;
import scu.nine.modle.MovieInfoDAO;
import scu.nine.modle.MovieShowInfo;
import scu.nine.modle.MovieShowInfoDAO;
import scu.nine.modle.MovieVityInfo;
import scu.nine.modle.MovieVityInfoDAO;

public class ArrangeMovieInfoAction {
	private String movieCityName;
	private String movieHailName;
	private String movieName;
	private List cityList;
	private List hallList;
	private List movieList;
	private MovieShowInfo movieShowInfo;
	//private Integer movieShowId;
	private String movieShowID;
	private List arrangeMovieList;
	private String moviePlayDate;
	
	private int movieCityId;
	private int movieHailId;
	private int movieId;
	
	private String movieCityID;
	private String movieHailID;
	
	public String getMoviePlayDate() {
		return moviePlayDate;
	}

	public void setMoviePlayDate(String moviePlayDate) {
		this.moviePlayDate = moviePlayDate;
	}

	public List getArrangeMovieList() {
		return arrangeMovieList;
	}

	public void setArrangeMovieList(List arrangeMovieList) {
		this.arrangeMovieList = arrangeMovieList;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List getMovieList() {
		return movieList;
	}

	public void setMovieList(List movieList) {
		this.movieList = movieList;
	}

	public MovieShowInfo getMovieShowInfo() {
		return movieShowInfo;
	}

	public void setMovieShowInfo(MovieShowInfo movieShowInfo) {
		this.movieShowInfo = movieShowInfo;
	}

	public String getMovieCityName() {
		return movieCityName;
	}

	public void setMovieCityName(String movieCityName) {
		this.movieCityName = movieCityName;
	}

	public String getMovieHailName() {
		return movieHailName;
	}

	public void setMovieHailName(String movieHailName) {
		this.movieHailName = movieHailName;
	}

	public List getCityList() {
		return cityList;
	}

	public void setCityList(List cityList) {
		this.cityList = cityList;
	}

	public List getHallList() {
		return hallList;
	}

	public void setHallList(List hallList) {
		this.hallList = hallList;
	}

	//private List arrangeMovieList;

	//public List getArrangeMovieList() {
	//	return arrangeMovieList;
	//}

	//�����Ƭ֮ǰ��ѯӰ�ǡ�Ӱ����ӰƬ��
	public String getMovieCityHallInfoByCondition(){
		String mcName = movieCityName;
		String mhName = movieHailName;
		String mName = movieName;
		MovieVityInfoDAO cityDAO = new MovieVityInfoDAO();
		MovieHallInfoDAO hallDAO = new MovieHallInfoDAO();
		MovieInfoDAO movieDAO = new MovieInfoDAO();
		cityList = cityDAO.findArrangeMovieCityInfoByCondition(mcName);
		hallList = hallDAO.findArrangeMovieHallInfoByCondition(mhName);
		movieList = movieDAO.findArrangeMovieInfoByCondition(mName);
		
		return "query";
	}
	//���������Ƭ��Ϣ
	public String SaveMovieArrange(){
		
		//ͨ��movieCityId�õ�city����Ϣ
		MovieVityInfo city = new MovieVityInfo();
		city = new MovieVityInfoDAO().findById(movieCityId);
		
     	MovieHallInfo  hall = new MovieHallInfo();
     	hall = new MovieHallInfoDAO().findById(movieHailId);
		
     	MovieInfo movie = new MovieInfo();
     	movie = new MovieInfoDAO().findById(movieId);
     	
     	
		movieShowInfo.setMovieVityInfo(city);
		movieShowInfo.setMovieHallInfo(hall);
		movieShowInfo.setMovieInfo(movie);
		
		MovieShowInfoDAO movieSIDAO = new MovieShowInfoDAO();
		movieSIDAO.save(movieShowInfo);
		COMMON.commit(); // �ύ

		return "ok";
	}
	//����������ѯ��Ƭ��Ϣ
	public String getMovieArrangeInfoByCondition() {
		
		MovieShowInfoDAO movieSIDAO = new MovieShowInfoDAO();
		//���������������У���������
		cityList = new MovieVityInfoDAO().findAll();
		hallList = new MovieHallInfoDAO().findAll();
		
		arrangeMovieList = movieSIDAO.findMovieArrangeInfoByCondition(movieCityID,movieHailID,moviePlayDate);

		return "query";
	}
	//ɾ����Ƭ��Ϣ
	public String deleteArrange(){
		MovieShowInfoDAO movieSIDAO = new MovieShowInfoDAO();
		MovieShowInfo movieShowInfo= movieSIDAO.findById(Integer.parseInt(movieShowID));
		movieSIDAO.delete(movieShowInfo);
		COMMON.commit(); // �ύ
		
		return "ok";
	}
	
	//�������޸ĵ���Ƭ��Ϣ
	public String modifyArrange() {
		MovieShowInfoDAO movieSIDAO = new MovieShowInfoDAO();
		movieShowInfo = movieSIDAO.findById(Integer.parseInt(movieShowID));  //��String����ת��Ϊ����
		
		return "ok";
	}
	
	//�����޸ĵ���Ƭ��Ϣ
	public String modifySaveArrange(){
		MovieShowInfoDAO movieSIDAO = new MovieShowInfoDAO();
		movieSIDAO.merge(movieShowInfo);  
		COMMON.commit(); // �ύ

		return "ok";
	}

	public int getMovieCityId() {
		return movieCityId;
	}

	public void setMovieCityId(int movieCityId) {
		this.movieCityId = movieCityId;
	}

	public int getMovieHailId() {
		return movieHailId;
	}

	public void setMovieHailId(int movieHailId) {
		this.movieHailId = movieHailId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	
	
	
	
	public String getMovieCityID() {
		return movieCityID;
	}

	public void setMovieCityID(String movieCityID) {
		this.movieCityID = movieCityID;
	}

	public String getMovieHailID() {
		return movieHailID;
	}

	public void setMovieHailID(String movieHailID) {
		this.movieHailID = movieHailID;
	}

	public String getMovieShowID() {
		return movieShowID;
	}

	public void setMovieShowID(String movieShowID) {
		this.movieShowID = movieShowID;
	}

}
