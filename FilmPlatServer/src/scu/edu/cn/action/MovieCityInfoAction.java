package scu.edu.cn.action;
import java.util.List;

import scu.nine.common.COMMON;
import scu.nine.modle.MovieVityInfo;
import scu.nine.modle.MovieVityInfoDAO;

public class MovieCityInfoAction {
	
	private String movieCityName;
	private List movieCityList;
	private MovieVityInfo movieVityInfo;
	private String movieCityID;

	public MovieVityInfo getMovieVityInfo() {
		return movieVityInfo;
	}

	public String getMovieCityID() {
		return movieCityID;
	}

	public void setMovieCityID(String movieCityID) {
		this.movieCityID = movieCityID;
	}

	public void setMovieVityInfo(MovieVityInfo movieVityInfo) {
		this.movieVityInfo = movieVityInfo;
	}

	public String getMovieCityName() {
		return movieCityName;
	}

	public void setMovieCityName(String movieCityName) {
		this.movieCityName = movieCityName;
	}

	public void setMovieCityList(List movieCityList) {
		this.movieCityList = movieCityList;
	}

	public List getMovieCityList() {
		return movieCityList;
	}
	
	
	// 根据条件查询影城
	public String getMovieCityInfoByCondition() {
		String mName = movieCityName;
		MovieVityInfoDAO movieDAO = new MovieVityInfoDAO();
		movieCityList = movieDAO.findmovieCityInfoByCondition(mName);

		return "query";
	}
	
	//保存修改影城
	public String modifySaveMovieCity() {
		MovieVityInfoDAO movieDAO = new MovieVityInfoDAO();
		movieDAO.merge(movieVityInfo);  
		COMMON.commit(); // 提交

		return "ok";

	}
	
	//加载修改影城
	public String modifyMovieCity() {
		MovieVityInfoDAO movieDAO = new MovieVityInfoDAO();
		movieVityInfo = movieDAO.findById(Integer.parseInt(movieCityID));
		return "ok";
	}
	
	//删除影城
	public String deleteMovieCity(){
		MovieVityInfoDAO movieDAO = new MovieVityInfoDAO();
		movieVityInfo = movieDAO.findById(Integer.parseInt(movieCityID));
		movieDAO.delete(movieVityInfo);
		COMMON.commit(); // 提交
		return "delete";
	}
	//保存影城
	public String saveMovieCity() {
		MovieVityInfoDAO movieDAO = new MovieVityInfoDAO();
		movieDAO.save(movieVityInfo);
		COMMON.commit(); // 提交

		return "ok";
	}

}
