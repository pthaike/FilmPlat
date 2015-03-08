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

		<title>后台会员管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<% if(session.getAttribute("ManagerInfo")==null)
   {
 %>
    <script>
        alert("未登录，请先登录！");
        window.location.href='manager_login.jsp';
    </script>
<%} %>
	</head>

    
	<body>
		您好！
		<font color="FF0000"><s:property
				value="#session.ManagerInfo.managerName" />
		</font>
		<a href="loginout.jsp">退出</a>
		<form action="<%=basePath%>QueryUserInfoAction.action" method="get">
			<table>
				<tr>
					<td>
						用户ID：
					</td>
					<td>
						<input type="text" name="userID" id="userID">
					</td>
				</tr>
				<tr>
					<td>
						真实姓名：
					</td>
					<td>
						<input type="text" name="userRealname" id="userRealname">
					</td>
				</tr>
				<tr>
					<td>
						用户名：
					</td>
					<td>
						<input type="text" name="userName" id="userName">
					</td>
				</tr>
				<tr>
					<td>
						手机号：
					</td>
					<td>
						<input type="text" name="phonenumber" id="phonenumber">
					</td>
				</tr>
				<tr>
					<td>
						邮箱：
					</td>
					<td>
						<input type="text" name="email" id="email">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="查询">
					</td>
					<td>
						<a href="<%=basePath%>manager_addvip.jsp">添加会员</a>
					</td>
				</tr>
			</table>
		</form>
		<table border="1">
			<tr>
				<td>
					<center>
						用户ID
					</center>
				</td>
				<td>
					<center>
						真实姓名
					</center>
				</td>
				<td>
					<center>
						性别
					</center>
				</td>
				<td>
					<center>
						身份证号
					</center>
				</td>
				<td>
					<center>
						出生日期
					</center>
				</td>
				<td>
					<center>
						是否已婚
					</center>
				</td>
				<td>
					<center>
						所在城市
					</center>
				</td>
				<td>
					<center>
						通讯地址
					</center>
				</td>
				<td>
					<center>
						邮编
					</center>
				</td>
				<td>
					<center>
						用户名
					</center>
				</td>
				<td>
					<center>
						密码
					</center>
				</td>
				<td>
					<center>
						手机号码
					</center>
				</td>
				<td>
					<center>
						电子邮箱
					</center>
				</td>
				<td colspan="2">
					<center>
						操作
					</center>
				</td>
			</tr>
			<s:iterator value="userList" var="user">
				<tr>
					<td>
						<s:property value="#user.userId" />
					</td>
					<td>
						<s:property value="#user.userRealname" />
					</td>
					<td>
						<s:if test="#user.userSex==0">
							男
						</s:if>
						<s:elseif test="#user.userSex==1">
							女
						</s:elseif>
						<s:else>暂无信息</s:else>
					</td>
					<td>
						<s:property value="#user.userIdcard" />
					</td>
					<td>
						<s:property value="#user.userBirth" />
					</td>
					<td>
						<s:if test="#user.userMarry==0">已婚</s:if>
						<s:elseif test="#user.userMarry==1">未婚</s:elseif>
						<s:else>暂无信息</s:else>
					</td>
					<td>
						<s:property value="#user.userCity" />
					</td>
					<td>
						<s:property value="#user.userAddress" />
					</td>
					<td>
						<s:property value="#user.userPostcode" />
					</td>
					<td>
						<s:property value="#user.userName" />
					</td>
					<td>
						<s:property value="#user.userPassword" />
					</td>
					<td>
						<s:property value="#user.userPnumber" />
					</td>
					<td>
						<s:property value="#user.userEmail" />
					</td>
					<td>
						<a
							href="<%=basePath%>updataUserInfo.action?userID=<s:property value="#user.userId" />">修改</a>
					</td>
					<td>
						<a
							href="<%=basePath%>deleteUserInfo.action?userID=<s:property value="#user.userId" />">删除</a>
					</td>
			</s:iterator>
		</table>
	</body>
</html>





