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

		<title>看电影</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="page.css" />
	</head>

	<body>
		<div id="header">
			<jsp:include page="CommonHead.jsp" />
		</div>
		<div class="main">
			<div class="nav">
				<div class="nav_menu">
					<ul>
						<li>
							<a id="fontpage" href="<%=basePath%>index.jsp">首页</a>
						</li>
						<li>
							<a href="<%=basePath%>newsShow.action" class="nac_click">影城动态</a>
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
			<!--新闻资讯 -->
			<div class="bar_line"></div>
			<div id="main_info">
				<div class="main_info_line"></div>
				<div class="main_info_main">
					<div class=main_info_news">
						<div class="main_info_right">
							<div class="abtg">
								新闻资讯
							</div>
							<table width="650" align="center">
								<s:iterator value="newsList" var="news">
									<tr>
										<td class="STYLE4" height="20" align="left">
											<img border="0" src="./images/arrow_02.gif">
											<a target="_blank"
												href="<%=basePath%>quarynewsID.action?newsId=<s:property value="#news.newsId"/>">
												<span style="color: #2E2E2E; font-size: 13px"> <s:property
														value="#news.newsTitle" /> </span> </a>
										</td>
										<td align="right">
											<font color="#999999">[<s:property
													value="#news.newsTime" />]</font>
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
					</div>
				</div>
				<div class="cl"></div>
			</div>
			<!--影城信息 -->
			<div class="bar_line"></div>
			<div id="main_info">
				<div class="main_info_line"></div>
				<div class="main_info_main">
					<div class=main_info_news">
						<div class="main_info_right">
							<div class="abtg">
								影城信息
							</div>
							<table width="650" align="center">
								<s:iterator value="movieCityList" var="movieCitys">
									<tr>
										<td class="STYLE4" height="20" align="left">
											<img border="0" src="./images/arrow_02.gif">
											<a target="_blank"
												href="<%=basePath%>quarymovieCityId.action?movieCityId=<s:property value="#movieCitys.movieCityId"/>">
												<span style="color: #2E2E2E; font-size: 13px"> <s:property
														value="#movieCitys.movieCityName" /> </span> </a>
										</td>
									</tr>
								</s:iterator>
							</table>
						</div>
					</div>
				</div>
				<div class="cl"></div>
			</div>
			<div class="commonFooter">
				<jsp:include page="CommonFooter.jsp" />
			</div>
		</div>
	</body>
</html>
