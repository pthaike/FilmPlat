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

		<title>找回登录密码页面</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="page.css" />
		<script type="text/javascript">
    function validate()
    {
      if(document.getElementById("userName").value =="")
      {
          alert("用户名不能为空！");
          return false;
      }
      return true;
    }
    function changeValidateCode(obj) {
         //获取当前的时间作为参数，无具体意义
         var timenow = new Date().getTime();
         //每次请求需要一个不同的参数，否则可能会返回同样的验证码
         //可能和浏览器的缓存机制有关系
         obj.src="movie.com/ValidateImage?d="+timenow;
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
							<a id="fontpage" href="<%=basePath%>movieShow.action">首页</a>
						</li>
						<li>
							<a href="">影城动态</a>
						</li>
						<li>
							<a href="">看电影</a>
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
			<div class="hy_zc">
				<div class="hyzq_title"></div>
				<div class="getbackpass">
					<form method="post" onsubmit="return validate();"
						action="<%=basePath%>sendMail.action">
						<div class="f16px bt sl fB">
							找回登录密码
						</div>
						<table>
							<tr>
								<td>
									用户名:
								</td>
								<td>
									<input type="text" name="userName" id="userName" />
								</td>
								<td>
								</td>
							</tr>
							<tr>
								<td>
									验证码:
								</td>
								<td>
									<input type="text" name="CheckCode">
								</td>
								<td>
									<img src="movie.com/ValidateImage"
										onClick="changeValidateCode(this)" width="45" height="22">
								</td>
							</tr>
							<tr>
								<td colspan="3">
									<input type="submit" value="提交" />
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<div class="commonFooter">
				<jsp:include page="CommonFooter.jsp" />
			</div>
		</div>
	</body>
</html>
