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

		<title>注册页面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="page.css" />
		<script type="text/javascript"
			src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/jquery-ui-1.7.2.custom.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/JScript.js"></script>

		<script type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
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
							<a href="#" class="nac_click">用户留言</a>
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
			<div class="hy_zc">
				<div class="hyzq_title"></div>

				<!-- before -->
				<div class="regbor">
					<div class="cl"></div>
					<div class="abtg">
						留言版
					</div>
					<form name="form1" onsubmit="return inputSubmit();"
						action="<%=basePath%>liuyanAction.action"
						method="post">
						<div class="kdy_wyyp_textyu">
							<textarea id="vscontent" class="texy_w" cols=""
								name="message.messageContent"></textarea>
						</div>
						<div class="login_h">
							留言前，请
							<span class="sl hand"
								onclick="javascript:window.location.href='<%=basePath %>vip_login.jsp'">登录</span>
						</div>
						<div class="fb_btn">
							<img width="81" height="34" style="cursor: pointer;"
								onclick="document.form1.submit()" src="./images/fb_btn.jpg">
						</div>
					</form>
				</div>
			</div>
			<div class="commonFooter">
				<jsp:include page="CommonFooter.jsp" />
			</div>
		</div>
	</body>
</html>
