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

		<title>My JSP 'main.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<script type="text/javascript"
			src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/jquery-ui-1.7.2.custom.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/JScript.js"></script>

		<script type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>

		<script type="text/javascript">
	
	function validata()
	{
 		if(movieCityName=="")
		{
			alert("影城名称不能为空!");
			return false;
		}
		
		if($("#movieCityAddress").val()=="")
		{
			alert("地址不能为空!");
			return false;
		}
		
		if($("#movieCityPhone").val()=="")
		{
			alert("联系方式不能为空!");
			return false;
		}
		
		return true;
	}
	
	
	</script>


	</head>

	<body>
		<form onsubmit="return validata();"
			action="<%=basePath%>SaveMovieCityInfoAction.action" method="post">
			<table>
				<tr>
					<td>
						影城名称
					</td>
					<td>
						<input type="text" id="movieCityName"
							name="movieVityInfo.movieCityName" />
					</td>
				</tr>
				<tr>
					<td>
						支持在线售票
					</td>
					<td>
						<select name="movieVityInfo.supportOnlline">
							<option value="0">
								是
							</option>
							<option value="1">
								否
							</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						地址
					</td>
					<td>
						<input type="text" id="movieCityAddress"
							name="movieVityInfo.movieCityAddress" />
					</td>
				</tr>
				<tr>
					<td>
						联系电话
					</td>
					<td>
						<input type="text" id="movieCityPhone"
							name="movieVityInfo.movieCityPhone" />
					</td>
				</tr>
				<tr>
					<td>
						影城简介
					</td>
					<td>
						<input type="text" id="movieCityIntro"
							name="movieVityInfo.movieCityIntro" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="保存" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>