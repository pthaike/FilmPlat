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

		<title>会员登录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="page.css" />

		<script type="text/javascript">
	  function validata()
	{
		var loginName=document.getElementById("userName").value;
		if(loginName=="")
		{
			alert("登陆名不能为空!");
			document.getElementById("userName").focus();
			return false;
		}
        var password=document.getElementById("password").value;
		if(password=="")
		{
			alert("密码不能为空!");
			document.getElementById("password").focus();
			return false;
		}
		return true;		
	}
	</script>
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
							<a id="fontpage" href="<%=basePath %>index.jsp">首页</a>
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
			<div class="hy_login">
				<div class="hy_login_main right">
					<div class="hy_login_main_c">
						<img alt="会员登录" src="./images/viplogin_bg.jpg">
						<font color="FF0000">${message }</font>
						<form name="loginForm" onsubmit="return validata();"
							action="<%=basePath%>loginAction.action" method="post">
							<table border="1px">
								<tr>
									<td>
										用户名:
									</td>
									<td>
										<input type="text" name="userName" id="userName" />
									</td>
								</tr>
								<tr>
									<td>
										密码：
									</td>
									<td>
										<input type="password" name="password" id="password" />
									</td>
								</tr>
								<tr>
									<td>
										<input type="submit" value="登录" />
									</td>
									<td>
										<a href="vip_regist.jsp">注册</a>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<a href="vip_getbackPassword.jsp"> 忘记密码？点击找回</a>
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
			<div class="commonFooter">
				<jsp:include page="CommonFooter.jsp" />
			</div>
		</div>

	</body>
</html>
