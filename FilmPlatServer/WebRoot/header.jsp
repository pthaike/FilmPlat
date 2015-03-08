<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>




<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript">
	function(){
		window.location = "http://www.baidu.com";
	}  	
  </script>  
  </head>
  
  <body>
    <%
  if(session.getAttribute("admin")==null){
   %>
   <script>
   	alert("请先登录!");
   	window.location.href="mlogin.jsp";
   </script>
   <%
    }%>
  <div>
  欢迎使用影视管理平台!
  </div>

  </body>
</html>
