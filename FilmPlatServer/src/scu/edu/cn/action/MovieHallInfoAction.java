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


	// 根据条件查询影厅
	public String getMovieHallInfoByCondition() {
		String mName = movieHailName;
		MovieHallInfoDAO movieDAO = new MovieHallInfoDAO();
		movieHailList = movieDAO.findHallByMovieID(movieCityID);
		return "query";
	}
	
	//保存影厅
	public String saveMovieHall() {
		MovieHallInfoDAO movieDAO = new MovieHallInfoDAO();
		movieDAO.save(movieHallInfo);
		COMMON.commit(); // 提交
		return "ok";
	}
	
	//修改影厅
	public String modifyMovieHall() {
		MovieHallInfoDAO movieDAO = new MovieHallInfoDAO();
		movieHallInfo = movieDAO.findById(Integer.parseInt(movieHallID));
		return "ok";
	}

	//保存修改影厅
	public String modifySaveMovieHall() {
		MovieHallInfoDAO movieDAO = new MovieHallInfoDAO();
		movieDAO.merge(movieHallInfo);  
		COMMON.commit(); // 提交

		return "ok";

	}
	
	//删除影厅
	public String deleteMovieHall(){
		MovieHallInfoDAO movieDAO = new MovieHallInfoDAO();
		movieHallInfo = movieDAO.findById(Integer.parseInt(movieHallID));
		movieDAO.delete(movieHallInfo);
		COMMON.commit(); // 提交
		return "delete";
	}
	
	//
	public String TurnToAddHall(){
		return "to";
	}
	
}


