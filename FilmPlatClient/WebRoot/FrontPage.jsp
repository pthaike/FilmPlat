<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>首页</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="page.css" />
		<script type="text/javascript">
	
</script>
	</head>
	<body>
		<div id="container">
			<div id="header">
				<jsp:include page="CommonHead.jsp" />
			</div>
			<div class="main">
				<div class="nav">
					<div class="nav_menu">
						<ul>
							<li>
								<a id="fontpage" href="<%=basePath %>index.jsp" class="nac_click">首页</a>
							</li>
							<li>
								<a href="<%=basePath%>newsShow.action">影城动态</a>
							</li>
							<li>
								<a href="<%=basePath%>movieShow.action">看电影</a>
							</li>
							<li>
								<a href="">移动购片</a>
							</li>
							<li>
								<a href="<%=basePath%>vip_message.jsp">用户留言</a>
							</li>
							<li>
								<a href="">商务合作</a>
							</li>
							<li>
								<a href="">关于紫荆</a>
							</li>
						</ul>
					</div>
				</div>
				<div class="bar_line"></div>
				<div id="main_info">
					<div class="main_info_line"></div>
					<div class="main_info_main">
						<div class=main_info_news">
							<div class="main_info_right">
								<div class="abtg">
									影城动态
								</div>
								<table  width="650" align="center" >
									<s:iterator value="newsList" var="news">
									<tr>
								  		 <td class="STYLE4" height="20" align="left">
								   			<img border="0" src="./images/arrow_02.gif">
								   			<a target="_blank" href="<%=basePath%>quarynewsID.action?newsId=<s:property value="#news.newsId"/>">
								   				<span style="color:#2E2E2E;font-size:13px">
								   					<s:property value="#news.newsTitle"/>
								   				</span>
								   			</a>
								  		 </td>
								  		 <td align="right">
								   			<font color="#999999">[<s:property value="#news.newsTime"/>]</font>
								  		 </td>
									</tr>
									</s:iterator>
								</table>
							</div>
							<div class="main_info_left" style="margin-top: 40px;">
								<div class="main_info_left_m">
									<img width="243" height="32" src="./images/hyzq_t.jpg">
									<a title="会员登录" href="vip_login.jsp" target="_blank"> <img
											width="243" height="61" src="./images/viplogin.jpg" /> </a>
									<a title="会员注册" href="vip_regist.jsp" target="_blank"> <img
											width="243" height="61" src="./images/vipregist.jpg" /> </a>
								</div>
							</div>
						</div>
					</div>
					<div class="cl"></div>
				</div>
				<div class="bar_line"></div>
				<div id="main_info">
					<div class="main_info_line"></div>
					<div class="main_info_main">
						<div class=main_info_news">
							<div class="main_info_right">
								<div class="abtg">
									电影信息
								</div>
								<div class="kdy_jjsyshow">
								       <%	int flag = 1; %>
									<s:iterator value="movie_onshow_list" var="movies">
										<div id="movie_show1" class="dyjjsy left dyjjsyleft">
										<%
												System.out.println(flag);
												if (flag == 1) {
													flag = 0;
										%>
										<script>
										    var div1 = document.getElementbyId("movie_show1"); 
											div1.className="dyjjsy left";
											alert(div1.className);
			 							</script>
										<%
											} else {
												flag=1;
										%>
										<script>
											var div1 = document.getElementbyId("movie_show1"); 
										    div1.className="dyjjsy left dyjjsyleft";
										    alert(div1.className);
										</script>
										<%} %>
										
											<img class="left" width="150" height="200"
												style="cursor: pointer;" src="${movies.movieSmallPicture }" onclick="javascript:window.open('<%=basePath %>quaryMovieDetail.action?movieId=${movies.movieId}')"/>
											<p class="sl f14px" title="" style="cursor: pointer;" onclick="javascript:window.open('<%=basePath %>quaryMovieDetail.action?movieId=${movies.movieId}')">
												<s:property value="#movies.movieName" />
											</p>
											<p>
												上映时间：
												<s:property value="#movies.moviePublishDate" />
											</p>
											<p>
												导演：
												<s:property value="#movies.movieDirector" />
											</p>
											<p>
												国家/地区：
												<s:property value="#movies.movieCountry" />
											</p>
										<!-- 	<p>
												类型：
											</p> -->
											<p>
												片长：
												<s:property value="#movies.movieLength" />
											</p>
											<div class="xzgp" title="选座购票">
												选座购票
											</div>
										</div>
										<div class="cl"></div>
									</s:iterator>
								</div>
							</div>

						</div>
					</div>
					<div class="cl"></div>
				</div>
				<div class="commonFooter">
					<jsp:include page="CommonFooter.jsp" />
				</div>
			</div>
		</div>
	</body>
</html>
