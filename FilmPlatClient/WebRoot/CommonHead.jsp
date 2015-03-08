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

		<title>My JSP 'CommonHead.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="page.css" />

	</head>

	<body>
		<div class="bar">
			<div class="bar_w">
				欢迎来到电影网 |
				<a target="_blank" href="vip_login.jsp">会员登录</a> |
				<a target="_blank" href="vip_regist.jsp">免费注册</a> |
				<a target="_blank" href="<%=basePath %>visitPersonalPage.action">
				<font color="FF0000">
					<s:property value="#session.userInfo.userName" />
				</font>个人主页</a>
				<%if(session.getAttribute("userInfo")!=null) {%>
				   	<a href="loginout.jsp" >退出</a>
				<%} %>
				|<a target="_blank" href="http://localhost:8082/NineFilmPlat/mlogin.jsp">管理员登录</a>
				|客服电话：18200288036
			</div>
		</div>
		<div class="logo">
			<div class="logo_w">
				<a href="<%=basePath%>index.jsp"> <img class="left" alt="电影网"
						src="./images/logo.jpg"> </a>
			</div>
		</div>
	</body>
</html>
