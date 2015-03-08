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

		<title>管理员登录页面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript">
	  function validata()
	{
		var loginName=document.getElementById("loginName").value;
		if(loginName=="")
		{
			alert("登陆名不能为空!");
			document.getElementById("loginName").focus();
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
	<font color="FF0000">${message }</font>
		<form name="loginForm" onsubmit="return validata();"
			action="<%=basePath%>MNGloginAction.action" method="post">
			<table border="1px">
				<tr>
					<td>
						用户名：
					</td>
					<td>
						<input type="text" name="loginName" id="loginName" />
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
					<td colspan="2">
						<input type="submit" value="登录" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
