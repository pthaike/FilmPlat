<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'movieHall.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link rel="stylesheet" href="css/reset.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/invalid.css" type="text/css"
			media="screen" />
		<script type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>

  </head>
  
  <body>
    <s:include value="/side.jsp"></s:include>
		<div id="main-content">
			<h2>
				影视后台管理
			</h2>
			<div class="clear"></div>
			<div class="content-box">
				<div class="content-box-header">
					<h3>
						影厅管理
					</h3>
					<ul class="content-box-tabs">
						<li>
							<a href="#tab1" class="default-tab">影厅列表</a>
						</li>
						<!-- href must be unique and match the id of target div -->
						<li>
							<a href="#tab2">添加影厅</a>
						</li>
					</ul>
					<div class="clear"></div>
				</div>
				<!-- End .content-box-header -->
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<form action="<%=basePath%>QueryMovieHallInfoAction.action"
							method="get">
							<table>
								<tr>
									<td>
										影厅名称:
										<input class="text-input small-input" type="text" id="movieHailName"
											name="email" />
										<input type="submit" class="button" value="查询" />
									</td>
								</tr>
							</table>
						</form>
						<table>
							<thead>
								<tr>
									<th>
										影厅名称
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="movieHailList" var="movieHallInfo">
									<tr>
										<td>
											<s:property value="#movieHallInfo.movieHailName" />
										</td>
										<td>
											<a
												href="<%=basePath%>deleteMovieHallInfo.action?movieHallID=<s:property value="#movieHallInfo.movieHailId" />"><img
													src="images/icons/cross.png" alt="Delete" /> </a>
											<a
												href="<%=basePath%>updateMovieHallInfo.action?movieHallID=<s:property value="#movieHallInfo.movieHailId" />"><img
													src="images/icons/hammer_screwdriver.png" alt="Edit Meta" />
											</a>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
					<!-- End #tab1 -->
					<div class="tab-content" id="tab2">
						<form onsubmit="return validata();"
							action="<%=basePath%>SaveMovieHallInfoAction.action"
							method="post">
							<fieldset>
								<table>
									<tr>
										<td>
											<label>
												影厅名称：
											</label>
											<input class="text-input small-input" type="text"
												id="movieHailName" name="movieHallInfo.movieHailName">
											<input type="hidden" name="movieHallInfo.movieVityInfo.movieCityId" value="${movieCityID }">
											<font color="#FF0000">*</font>
										</td>
									</tr>
								</table>
								<p>
									<input class="button" type="submit" value="保存" />
								</p>
							</fieldset>
							<div class="clear"></div>
							<!-- End .clear -->
						</form>
					</div>
					<!-- End #tab2 -->
				</div>
				<!-- End .content-box-content -->
			</div>

			<div class="clear"></div>

			<s:include value="/footer.jsp"></s:include>
		</div>
  </body>
</html>
