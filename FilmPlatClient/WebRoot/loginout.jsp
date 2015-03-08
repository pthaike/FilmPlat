<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	session.invalidate();
	out.print("<script language='javascript'> alert('您已经安全退出！');window.location.href='index.jsp' </script>");
%>
