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

		<title>看电影</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="page.css" />
		<script type="text/javascript">
		   function inputSubmit()
		   {
		     	if(document.getElementById("vscontent").value=="")
		     	{
		     	    alert("评价不能为空！");
		     	    return false;	   
		     	}
		     	<%
		     	if(session.getAttribute("userInfo")==null)
		   		{
		   		%>
		   		    alert("登录后才能评价！");
		   		    return false
		   		<%}%>
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
							<a id="fontpage" href="<%=basePath%>index.jsp">首页</a>
						</li>
						<li>
							<a href="<%=basePath%>newsShow.action" class="nac_click">影城动态</a>
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
			<div class="newspage">
				<h1 class="f16px fB" style="color: null">
					${news.newsTitle }
				</h1>
				<p align="center">
					${news.newsTime }
				</p>
				<p align="center">
				</p>
				<p>
					${news.newsContent }
				</p>
			</div>
			<div class="main_info_line gwtg"></div>
			<div class="abtg">
				历史评论
			</div>
			<div id="newsview">
				<s:iterator value="newsViewList" var="newsView">
					<p>
						<s:property value="#newsView.userInfo.userName" />
						:
						<s:property value="#newsView.newsviewContent" />
					</p>
				</s:iterator>
			</div>
			<div class="main_info_line gwtg"></div>
			<div class="abtg">
				网友点评
			</div>
			<form
			    name="form1" onsubmit="return inputSubmit();"
				action="<%=basePath %>addNewsView.action?newsId=${news.newsId }"
				method="post">
				<div class="kdy_wyyp_textyu">
					<textarea id="vscontent" class="texy_w" cols=""
						name="newsViewInfo.newsviewContent"></textarea>
				</div>
				<div class="login_h">
					发布点评前，请
					<span class="sl hand"
						onclick="javascript:window.location.href='<%=basePath %>vip_login.jsp'">登录</span>
				</div>
				<div class="fb_btn">
					<img width="81" height="34" style="cursor: pointer;"
						onclick="document.form1.submit()" src="./images/fb_btn.jpg">
				</div>
			</form>
			<div class="commonFooter">
				<jsp:include page="CommonFooter.jsp" />
			</div>
		</div>
	</body>
</html>
