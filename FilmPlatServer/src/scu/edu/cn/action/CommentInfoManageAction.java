package scu.edu.cn.action;

import java.util.List;

import scu.nine.modle.NewsViewInfo;
import scu.nine.modle.NewsViewInfoDAO;

public class CommentInfoManageAction {

	private NewsViewInfo newsViewInfo;
	private String articleID;
	private List commentList;
	private String commentID;
	
	public NewsViewInfo getNewsViewInfo() {
		return newsViewInfo;
	}

	public void setNewsViewInfo(NewsViewInfo newsViewInfo) {
		this.newsViewInfo = newsViewInfo;
	}

	public String getArticleID() {
		return articleID;
	}

	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}

	//º”‘ÿ∆¿¬€
	public String loadComment(){
		 NewsViewInfoDAO newsViewDAO = new NewsViewInfoDAO();
		 commentList = newsViewDAO.findViewInfoByCondition(articleID);
		 return "load";
	}
	//…æ≥˝∆¿¬€
	public String deleteComment(){
		
		return "delete";
	}
}
