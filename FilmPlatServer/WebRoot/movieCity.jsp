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

		<title>文章管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" href="css/reset.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/invalid.css" type="text/css"
			media="screen" />
		<script type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
     function validate()
     {
         if($("#userRealname").val()=="")
        {
           alert("真实姓名不能为空！");
           return false;
        }
        if($("#userIdcard").val()=="")
        {
           alert("身份证号不能为空！");
           return false;
        }
        else{
			if($valid($("#userIdcard"),'身份证',false,'身份证格式不正确!')==false)
			{
				return false;
			}
		}
        if($("#userName").val()=="")
        {
           alert("用户名不能为空！");
           return false;
        }
        if($("#userPassword").val()=="")
        {
           alert("密码不能为空！");
           return false;
        }
        if($("#MSpassword").val()=="")
        {
           alert("确认密码不能为空！");
           return false;
        }
        
        if($("#userPassword").val()!= $("#MSpassword").val())
        {
           alert("请重新确认密码！");
           return false;
        }
        if($("#userPnumber").val()=="")
        {
           alert("手机号码不能为空！");
           return false;
        }
        else
        {
            if($valid($("#userPnumber"),'手机',false,'手机号码格式不正确!')==false)
           {
              return false;
           }
        }
        if($("#userEmail").val()=="")
        {
           alert("邮箱不能为空！");
           return false;
        }
        else
        {
           if($valid($("#userEmail"),'Email',false,'邮箱格式不正确!')==false)
           {
              return false;
           }
        }
        return true;
     }
    
   </script>
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
						影城管理
					</h3>
					<ul class="content-box-tabs">
						<li>
							<a href="#tab1" class="default-tab">影城列表</a>
						</li>
						<!-- href must be unique and match the id of target div -->
						<li>
							<a href="#tab2">添加影城</a>
						</li>
					</ul>
					<div class="clear"></div>
				</div>
				<!-- End .content-box-header -->
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<form action="<%=basePath%>QueryMovieCityInfoAction.action"
							method="get">
							<table>
								<tr>
									<td>
										影城名称:
										<input class="text-input small-input" type="text" id="email"
											name="email" />
										<input type="submit" class="button" value="查询" />
									</td>
								</tr>
								<tr> <td colspan="2"><font color="gray" size=2px>注：影片版本为0代表支持在线售票，1代表不支持在线售票</font></td></tr>
							</table>
						</form>
						<table>
							<thead>
								<tr>
									<th>
										影城名称
									</th>
									<th>
										支持在线售票
									</th>
									<th>
										地址
									</th>
									<th>
										联系电话
									</th>
									<th>
										影城简介
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="movieCityList" var="movieVityInfo">
									<tr>
										<td>
											<s:property value="#movieVityInfo.movieCityName" />
										</td>
										<td>
											<s:property value="#movieVityInfo.supportOnlline" />
										</td>
										<td>
											<s:property value="#movieVityInfo.movieCityAddress" />
										</td>
										<td>
											<s:property value="#movieVityInfo.movieCityPhone" />
										</td>
										<td>
											<s:property value="#movieVityInfo.movieCityIntro" />
										</td>
										<td>
											<a
												href="<%=basePath%>deleteMovieCityInfo.action?movieCityID=<s:property value="#movieVityInfo.movieCityId" />"><img
													src="images/icons/cross.png" alt="Delete" /> </a>
											<a
												href="<%=basePath%>updateMovieCityInfo.action?movieCityID=<s:property value="#movieVityInfo.movieCityId" />"><img
													src="images/icons/hammer_screwdriver.png" alt="Edit Meta" />
											</a>
											<a href="<%=basePath%>movieHall.jsp">选择影厅</a>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
					<!-- End #tab1 -->
					<div class="tab-content" id="tab2">
						<form onsubmit="return validata();"
							action="<%=basePath%>SaveMovieCityInfoAction.action"
							method="post">
							<fieldset>
								<table>
									<tr>
										<td>
											<label>
												影城名称：
											</label>
											<input class="text-input small-input" type="text"
												id="movieCityName" name="movieVityInfo.movieCityName">
											<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												支持在线售票：
											</label>
											<select class="text-input small-input"
												name="movieVityInfo.supportOnlline">
												<option value="0">
													否
												</option>
												<option value="1">
													是
												</option>
											</select>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												地址：
											</label>
											<input class="text-input small-input" type="text"
												id="movieCityAddress" name="movieVityInfo.movieCityAddress">
											<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												联系电话：
											</label>
											<input class="text-input small-input" type="text"
												id="movieCityPhone" name="movieVityInfo.movieCityPhone">
										</td>
									</tr>
									<tr>
										<td>
											<label>
												影城简介
											</label>
											<textarea class="text-input textarea wysiwyg"
												id="movieCityIntro" name="movieVityInfo.movieCityIntro"
												cols="79" rows="15"></textarea>
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
