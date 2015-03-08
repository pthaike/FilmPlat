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

		<title>My JSP 'CommonHead.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="page.css" />

	</head>


	<body>
		<div class="footer" style="height: 125px;">
			<p>
				<a target="_blank" href="">关于我们</a> |
				<a target="_blank" href="">诚聘英才</a> |
				<a target="_blank" href="">免责声明</a> |
				<a target="_blank" href="">商标声明</a> |
				<a target="_blank" href="">注册服务条款</a> |
				<a target="_blank" href="">合作信息</a> |
				<a target="_blank" href="">广告事务</a>
			</p>
			<p>
				蜀ICP备12016418号 | 增值电信业务经营许可证川B2-20110097 | 热线电话：400-0000-260 |
				地址：成都市清江西路51号中大君悦广场4层
			</p>
			<p>
				四川紫荆影业有限公司Copyright 2003-2012 sczjyy.com Inc. All rights reserved.
			</p>
		</div>
	</body>
</html>
