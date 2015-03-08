<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
	<script type="text/javascript"
		src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/jquery-ui-1.7.2.custom.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/JScript.js"></script>


	<body>
		<jsp:forward page="movie_list.action"></jsp:forward><!--
		<table style="height: 84px;" width="219" height="84">
			<tr>
				<td>
					<a href="vip_login.jsp">会员登录入口</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="vip_regist.jsp">会员注册</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="manager_login.jsp">管理员登录入口</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="manager_vip_management.jsp">管理用户资料入口（测试用）</a>
				</td>
			</tr>
		</table>
	--></body>
</html>
