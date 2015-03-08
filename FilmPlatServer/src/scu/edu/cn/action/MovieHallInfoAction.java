package scu.edu.cn.action;

import java.util.List;

import scu.nine.common.COMMON;
import scu.nine.modle.MovieHallInfo;
import scu.nine.modle.MovieHallInfoDAO;

public class MovieHallInfoAction {
	
	private String movieHailName;
	private List movieHailList;
	private MovieHallInfo movieHallInfo;
	private String movieHallID;
	private String movieCityID;
	
	public String getMovieCityID() {
		return movieCityID;
	}

	public void setMovieCityID(String movieCityID) {
		this.movieCityID = movieCityID;
	}

	public String getMovieHailName() {
		return movieHailName;
	}

	public void setMovieHailName(String movieHailName) {
		this.movieHailName = movieHailName;
	}

	public List getMovieHailList() {
		return movieHailList;
	}

	public void setMovieHailList(List movieHailList) {
		this.movieHailList = movieHailList;
	}
	
	public MovieHallInfo getMovieHallInfo() {
		return movieHallInfo;
	}

	public void setMovieHallInfo(MovieHallInfo movieHallInfo) {
		this.movieHallInfo = movieHallInfo;
	}

	public String getMovieHallID() {
		return movieHallID;
	}

	public void setMovieHallID(String movieHallID) {
		this.movieHallID = movieHallID;
	}


	// ����������ѯӰ��
	public String getMovieHallInfoByCondition() {
		String mName = movieHailName;
		MovieHallInfoDAO movieDAO = new MovieHallInfoDAO();
		movieHailList = movieDAO.findHallByMovieID(movieCityID);
		return "query";
	}
	
	//����Ӱ��
	public String saveMovieHall() {
		MovieHallInfoDAO movieDAO = new MovieHallInfoDAO();
		movieDAO.save(movieHallInfo);
		COMMON.commit(); // �ύ
		return "ok";
	}
	
	//�޸�Ӱ��
	public String modifyMovieHall() {
		MovieHallInfoDAO movieDAO = new MovieHallInfoDAO();
		movieHallInfo = movieDAO.findById(Integer.parseInt(movieHallID));
		return "ok";
	}

	//�����޸�Ӱ��
	public String modifySaveMovieHall() {
		MovieHallInfoDAO movieDAO = new MovieHallInfoDAO();
		movieDAO.merge(movieHallInfo);  
		COMMON.commit(); // �ύ

		return "ok";

	}
	
	//ɾ��Ӱ��
	public String deleteMovieHall(){
		MovieHallInfoDAO movieDAO = new MovieHallInfoDAO();
		movieHallInfo = movieDAO.findById(Integer.parseInt(movieHallID));
		movieDAO.delete(movieHallInfo);
		COMMON.commit(); // �ύ
		return "delete";
	}
	
	//
	public String TurnToAddHall(){
		return "to";
	}
	
}


