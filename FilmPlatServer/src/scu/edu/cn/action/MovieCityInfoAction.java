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
	
	
	// ����������ѯӰ��
	public String getMovieCityInfoByCondition() {
		String mName = movieCityName;
		MovieVityInfoDAO movieDAO = new MovieVityInfoDAO();
		movieCityList = movieDAO.findmovieCityInfoByCondition(mName);

		return "query";
	}
	
	//�����޸�Ӱ��
	public String modifySaveMovieCity() {
		MovieVityInfoDAO movieDAO = new MovieVityInfoDAO();
		movieDAO.merge(movieVityInfo);  
		COMMON.commit(); // �ύ

		return "ok";

	}
	
	//�����޸�Ӱ��
	public String modifyMovieCity() {
		MovieVityInfoDAO movieDAO = new MovieVityInfoDAO();
		movieVityInfo = movieDAO.findById(Integer.parseInt(movieCityID));
		return "ok";
	}
	
	//ɾ��Ӱ��
	public String deleteMovieCity(){
		MovieVityInfoDAO movieDAO = new MovieVityInfoDAO();
		movieVityInfo = movieDAO.findById(Integer.parseInt(movieCityID));
		movieDAO.delete(movieVityInfo);
		COMMON.commit(); // �ύ
		return "delete";
	}
	//����Ӱ��
	public String saveMovieCity() {
		MovieVityInfoDAO movieDAO = new MovieVityInfoDAO();
		movieDAO.save(movieVityInfo);
		COMMON.commit(); // �ύ

		return "ok";
	}

}
