package scu.edu.cn.action;

import java.util.List;

import scu.nine.common.COMMON;
import scu.nine.modle.MovieInfo;
import scu.nine.modle.MovieInfoDAO;

//影片完善
public class ScuFilmInfoAction {
	private MovieInfo movieInfo;
	private String movieName;
	private String moviePublishDate;
	private List movieList;
	private String movieID;
	private String movieCountry;
	

	public String getMovieCountry() {
		return movieCountry;
	}

	public void setMovieCountry(String movieCountry) {
		this.movieCountry = movieCountry;
	}

	public String getMoviePublishDate() {
		return moviePublishDate;
	}

	public void setMoviePublishDate(String moviePublishDate) {
		this.moviePublishDate = moviePublishDate;
	}

	public String getMovieID() {
		return movieID;
	}

	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public List getMovieList() {
		return movieList;
	}

	public void setMovieList(List movieList) {
		this.movieList = movieList;
	}

    public String getMovieName() {
      return movieName;
    }

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public MovieInfo getMovieInfo() {
		return movieInfo;
	}

	public void setMovieInfo(MovieInfo movieInfo) {
		this.movieInfo = movieInfo;
	}
	
	//保存影片信息
	public String SaveFilm(){
		MovieInfo minfo=movieInfo;
		MovieInfoDAO movieDAO = new MovieInfoDAO();
		movieDAO.save(minfo);
		COMMON.commit(); // 提交

		return "ok";
	}
	//根据条件查询电影信息
	public String getFilmInfoByCondition() {
		String mName = movieName;
		String mpDate = moviePublishDate;
		String mCountry = movieCountry;
		MovieInfoDAO movieDAO = new MovieInfoDAO();
		movieList = movieDAO.findMovieInfoByCondition(mpDate,mName,mCountry);

		return "query";
	}
	//加载将要修改的影片信息
	public String modifyMovie() {
		MovieInfoDAO movieDAO = new MovieInfoDAO();
		movieInfo = movieDAO.findById(Integer.parseInt(movieID));  //将String类型转化为整型
		
		return "ok";
	}
	//删除影片信息
	public String deleteMovie(){
		MovieInfoDAO movieDAO = new MovieInfoDAO();
		MovieInfo movieInfo= movieDAO.findById(Integer.parseInt(movieID));
		movieDAO.delete(movieInfo);
		COMMON.commit(); // 提交
		
		return "ok";
	}
	//保存修改影片信息
	public String modifySaveMovie(){
		MovieInfoDAO movieDAO = new MovieInfoDAO();
		movieDAO.merge(movieInfo);  
		COMMON.commit(); // 提交

		return "ok";
	}
	//获取当前日期
	private java.util.Date getDate() {
		java.util.Date currentTime = new java.util.Date();
		return currentTime;
	}
}
