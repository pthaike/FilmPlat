package scu.edu.cn.action;

import java.util.List;

import scu.nine.common.COMMON;
import scu.nine.modle.NewsArticalInfo;
import scu.nine.modle.NewsArticalInfoDAO;
import scu.nine.modle.NewsViewInfo;
import scu.nine.modle.NewsViewInfoDAO;

public class ManagerArticleInfoAction {

	private NewsArticalInfo newsArticle;
	private List commentList;
	private List articleList;
	private String articleID;
	private String commentID;
	private NewsViewInfo newsView;
	private String keyWord;
	private String page;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public NewsViewInfo getNewsView() {
		return newsView;
	}
	public void setNewsView(NewsViewInfo newsView) {
		this.newsView = newsView;
	}
	public NewsArticalInfo getNewsArticle() {
		return newsArticle;
	}
	public void setNewsArticle(NewsArticalInfo newsArticle) {
		this.newsArticle = newsArticle;
	}
	public List getArticleList() {
		return articleList;
	}
	public void setArticleList(List articleList) {
		this.articleList = articleList;
	}
	public String getArticleID() {
		return articleID;
	}
	public void setArticleID(String articleID) {
		this.articleID = articleID;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	
	public List getCommentList() {
		return commentList;
	}
	public void setCommentList(List commentList) {
		this.commentList = commentList;
	}
	
	public String getCommentID() {
		return commentID;
	}
	public void setCommentID(String commentID) {
		this.commentID = commentID;
	}
	public String turnToadd(){
		return "to";
	}
	
	//查询文章列表
	public String getArticleInfoByCondition() {
		String kw = keyWord;
		NewsArticalInfoDAO articleDAO = new NewsArticalInfoDAO();
		articleList = articleDAO.findAticleByKeyWord(kw);
		return "query";
	}
	
	//添加文章
	public String addArticleInfo(){
		NewsArticalInfo article=newsArticle;
		article.setNewsTime(getDate());
		NewsArticalInfoDAO articleDAO=new NewsArticalInfoDAO();
		articleDAO.save(article);
		COMMON.commit();  //提交事务
		return "add";
	}
	
	//获取当前时间
	private java.util.Date getDate(){
		java.util.Date currTime = new java.util.Date();
		return currTime;
	}
	
	//加载修改文章
	public String loadArticleInfo(){
		NewsArticalInfoDAO articleDAO=new NewsArticalInfoDAO();
		newsArticle = articleDAO.findById(Integer.parseInt(articleID));
		return "load";
	}
	
	//更新修改文章
	public String updateArticleInfo(){
		//NewsArticalInfo article
		NewsArticalInfoDAO articleDAO=new NewsArticalInfoDAO();
		//newsArticle.setNewsTime(getDate());
		articleDAO.merge(newsArticle);  
		COMMON.commit(); // 提交
		return "update";
	}
	
	//删除文章
	public String deleteArticle(){
		NewsArticalInfoDAO articleDAO = new NewsArticalInfoDAO();
		newsArticle = articleDAO.findById(Integer.parseInt(articleID));
		articleDAO.delete(newsArticle);
		COMMON.commit(); // 提交
		return "delete";
	}
	
	//加载评论
	public String loadComment(){
		 NewsViewInfoDAO newsViewDAO = new NewsViewInfoDAO();
		 commentList = newsViewDAO.findViewInfoByCondition(articleID);
		 return "load";
	}
	
	//加载评论管理页面
	public String LoadArticleAndCom(){
		loadArticleInfo();
		loadComment();
		return "load";
	}
	
	//删除评论
	public String deleteComment(){
		NewsViewInfoDAO newsViewDAO = new NewsViewInfoDAO();
		NewsViewInfo newsViewInfo = newsViewDAO.findById(Integer.parseInt(commentID));
		newsViewDAO.delete(newsViewInfo);
		COMMON.commit();
		return "delete";
	}
}
