<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
 	session.invalidate();
	out.print("<script>alert('用户即将退出，确定后退出该页面。');window.location.href='mlogin.jsp'</script>");
%>
