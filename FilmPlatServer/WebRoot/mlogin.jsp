<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>管理员登录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/reset.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/invalid.css" type="text/css"
			media="screen" />
		<script type="text/javascript" src="scripts/jquery-1.3.2.min.js"></script>
		<script type="text/javascript"
			src="scripts/simpla.jquery.configuration.js"></script>
		<script type="text/javascript" src="scripts/facebox.js"></script>
		<script type="text/javascript" src="scripts/jquery.wysiwyg.js"></script>
	</head>
	
<body id="login">
  <div id="login-wrapper" class="png_bg">
  <div id="login-top">
    <h1>管理员登陆</h1>
  <div id="login-content">
    <form action="<%=basePath %>ManagerLogin.action" method="post">
      <s:if test='error=="1"'>
      	<div class="notification information png_bg">
        	<div> 密码或账号出错</div>
      	</div>
      </s:if>
      <p>
        <label>管理员账户</label>
        <input class="text-input" type="text" name="loginName"/>
      </p>
      <div class="clear"></div>
      <p>
        <label>密码</label>
        <input class="text-input" type="password" name="password"/>
      </p>
      <div class="clear"></div>
      <p id="remember-password">
        <input type="checkbox" />
        Remember me </p>
      <div class="clear"></div>
      <p>
        <input class="button" type="submit" value="登陆" />
      </p>
    </form>
  </div>
</div>
  </body>
</html>
