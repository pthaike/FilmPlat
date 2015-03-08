<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'side.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!-- Reset Stylesheet -->
		<link rel="stylesheet" href="css/reset.css" type="text/css"
			media="screen" />
		<!-- Main Stylesheet -->
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
		<link rel="stylesheet" href="css/invalid.css" type="text/css"
			media="screen" />
		<script type="text/javascript" src="scripts/jquery-1.3.2.min.js"></script>
		<script type="text/javascript"
			src="scripts/simpla.jquery.configuration.js"></script>
		<script type="text/javascript" src="scripts/facebox.js"></script>
		<script type="text/javascript" src="scripts/jquery.wysiwyg.js"></script>
		<script type="text/javascript" src="scripts/jquery.datePicker.js"></script>
		<script type="text/javascript" src="scripts/jquery.date.js"></script>
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
   <div id="sidebar">
    <div id="sidebar-wrapper">
      <!-- Sidebar with logo and menu -->
      <h1 id="sidebar-title"><a href="#">后台管理</a></h1>
      <!-- Logo (221px wide) -->
      <a href="http://www.865171.cn"><img id="logo" src="images/logo.png" alt="Simpla Admin logo" /></a>
      <!-- Sidebar Profile links -->
      <div id="profile-links"> Hello, <a href="#" title="Edit your profile">${loginName }</a><br />
        <br />
        <a href="<%=basePath %>/loginout.jsp" title="Sign Out">退出</a> </div>
      <ul id="main-nav">
        <li> <a href="#" class="nav-top-item">信息发布 </a>
          <ul>
            <li><a href="<%=basePath %>QueryArticleInfoAction.action">新闻管理</a></li>
            <li><a class="current" href="<%=basePath %>QueryMsgAction.action">留言管理</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 影视后台管理 </a>
          <ul>
            <li><a href="<%=basePath %>QueryFilmInfoAction.action">影片信息管理</a></li>
            <li><a href="<%=basePath %>QueryMovieArrangeInfoAction">排片</a></li>
            <li><a href="<%=basePath %>QueryMovieCityInfoAction">影城信息</a></li>
          </ul>
        </li>
        <li> <a href="#" class="nav-top-item"> 会员管理 </a>
          <ul>
            <li><a href="<%=basePath%>QueryUserInfoAction.action">会员信息管理</a></li>
            <!--<li><a href="<%=basePath%>manager_addvip.jsp">添加用户</a></li>-->
          </ul>
        </li>
      </ul>
      <!-- End #main-nav -->
      
      <!-- End #messages -->
    </div>
  </div>
  <!-- End #sidebar -->
  </body>
</html>
