package scu.edu.cn.action;

import java.util.List;

import scu.nine.common.COMMON;
import scu.nine.modle.MovieInfo;
import scu.nine.modle.MovieInfoDAO;
import scu.nine.modle.MovieViewInfo;
import scu.nine.modle.MovieViewInfoDAO;

public class CommentInfoAction {
	private MovieViewInfo movieViewInfo;
	private String movieName;
	private List commentList;
	private String movieViewID;
	private String movieID;
	private MovieInfo movieInfo;
	private String comstate;
	

	public String getComstate() {
		return comstate;
	}

	public void setComstate(String comstate) {
		this.comstate = comstate;
	}

	public MovieInfo getMovieInfo() {
		return movieInfo;
	}

	public void setMovieInfo(MovieInfo movieInfo) {
		this.movieInfo = movieInfo;
	}

	public String getMovieID() {
		return movieID;
	}

	public void setMovieID(String movieID) {
		this.movieID = movieID;
	}

	public String getMovieViewID() {
		return movieViewID;
	}

	public void setMovieViewID(String movieViewID) {
		this.movieViewID = movieViewID;
	}

	public MovieViewInfo getMovieViewInfo() {
		return movieViewInfo;
	}

	public void setMovieViewInfo(MovieViewInfo movieViewInfo) {
		this.movieViewInfo = movieViewInfo;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public List getCommentList() {
		return commentList;
	}

	public void setCommentList(List commentList) {
		this.commentList = commentList;
	}
	
    //根据条件查询评论
	public String getCommentInfoByCondition(){
		MovieViewInfoDAO commentDAO = new MovieViewInfoDAO();
		MovieInfoDAO minfo= new MovieInfoDAO();
		commentList = commentDAO.findCommentInfoByCondition(movieID);
		movieInfo = minfo.findById(Integer.parseInt(movieID));
		if (commentList.size()==0){
			comstate = "0";
		}else{
			comstate = "1";
		}
		return "query";
		
	}
	
	//???????????????????????????/未实现public String shieldComment(){}
		
	//删除评论
	public String deleteComment(){
		MovieViewInfoDAO commentDAO = new MovieViewInfoDAO();
		MovieViewInfo movieViewInfo = commentDAO.findById(Integer.parseInt(movieViewID));
		commentDAO.delete(movieViewInfo);
		COMMON.commit(); // 提交
		
		return "ok";
		
	}

}
