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
		<link rel="stylesheet" href="resources/css/reset.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/invalid.css" type="text/css"
			media="screen" />

		<script type="text/javascript"
			src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>js/jquery-ui-1.7.2.custom.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/JScript.js"></script>

		<script type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>

		<script type="text/javascript">
	function validate() {
		if ($("#userRealname").val() == "") {
			alert("真实姓名不能为空！");
			return false;
		}
		if ($("#userIdcard").val() == "") {
			alert("身份证号不能为空！");
			return false;
		} else {
			if ($valid($("#userIdcard"), '身份证', false, '身份证格式不正确!') == false) {
				return false;
			}
		}
		if ($("#userName").val() == "") {
			alert("用户名不能为空！");
			return false;
		}
		if ($("#userPassword").val() == "") {
			alert("密码不能为空！");
			return false;
		}
		if ($("#MSpassword").val() == "") {
			alert("确认密码不能为空！");
			return false;
		}

		if ($("#userPassword").val() != $("#MSpassword").val()) {
			alert("请重新确认密码！");
			return false;
		}
		if ($("#userPnumber").val() == "") {
			alert("手机号码不能为空！");
			return false;
		} else {
			if ($valid($("#userPnumber"), '手机', false, '手机号码格式不正确!') == false) {
				return false;
			}
		}
		if ($("#userEmail").val() == "") {
			alert("邮箱不能为空！");
			return false;
		} else {
			if ($valid($("#userEmail"), 'Email', false, '邮箱格式不正确!') == false) {
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
			<noscript>
				<div class="notification error png_bg">
					<div>
						Javascript is disabled or is not supported by your browser. Please
						<a href="http://browsehappy.com/"
							title="Upgrade to a better browser">upgrade</a> your browser or
						<a href="http://www.google.com/support/bin/answer.py?answer=23852"
							title="Enable Javascript in your browser">enable</a> Javascript
						to navigate the interface properly. Download From
						<a href="http://www.exet.tk">exet.tk</a>
					</div>
				</div>
			</noscript>

			<h2>
				会员后台管理
			</h2>
			<div class="clear"></div>
			<div class="content-box">
				<div class="content-box-header">
					<h3>
						会员管理
					</h3>
					<div class="clear"></div>
				</div>
				<!-- End .content-box-header -->
				<div class="content-box-content">
					<div class="tab-content default-tab">
						<form onsubmit="return validate();" action="saveModifyUser.action"
							name="saveModifyUser" method="post">
							<fieldset>

								<table>
									<tr>
										<td>
											<label>
												真实姓名：
											</label>
											<input type="text" id="userRealname"
												name="userInfo.userRealname"
												value="${userInfo.userRealname}" class="text-input small-input"/>
												<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												性别：
											</label>
											<select name="userInfo.userSex" class="text-input small-input">
												<s:if test="%{#userInfo.userSex==0}">
													<option selected="selected" value="0" >
														男
													</option>
													<option value="1">
														女
													</option>
												</s:if>
												<s:else>
													<option value="0">
														男
													</option>
													<option selected="selected" value="1">
														女
													</option>
												</s:else>
											</select>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												身份证号：
											</label>
											<input class="text-input small-input" type="text" id="userIdcard" name="userInfo.userIdcard"
												value="${userInfo.userIdcard }" />
											<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												出生日期：
											</label>
											<input type="text" id="date"
												onfocus="WdatePicker({skin:'whyGreen',dataFmt:'yyyy-MM-dd'})"
												class="Wdate" name="userInfo.userBirth"
												value="${userInfo.userBirth}" />
										</td>
									</tr>
									<tr>
										<td>
											<label>
												是否已婚：
											</label>
											<select name="userInfo.userMarry" class="text-input small-input">
												<s:if test="%{#userInfo.userMarry==0}">
													<option selected="selected" value="0">
														已婚
													</option>
													<option value="1">
														未婚
													</option>
												</s:if>
												<s:else>
													<option value="0">
														已婚
													</option>
													<option selected="selected" value="1">
														未婚
													</option>
												</s:else>
											</select>
										</td>
									</tr>
									<tr>
									</tr>
									<tr>
										<td>
											<label>
												所在城市：
											</label>
											<input class="text-input small-input" type="text" id="userCity" name="userInfo.userCity"
												value="${userInfo.userCity }" />
										</td>
									</tr>
									<tr>
										<td>
											<label>
												通讯地址：
											</label>
											<input class="text-input small-input" type="text" id="userAddress"
												name="userInfo.userAddress" value="${userInfo.userAddress }" />
										</td>
									</tr>
									<tr>
										<td>
											<label>
												邮编：
											</label>
											<input class="text-input small-input" type="text" id="userPostcode"
												name="userInfo.userPostcode"
												value="${userInfo.userPostcode }" />
										</td>
									</tr>
									<tr>
										<td>
											<label>
												用户名：
											</label>
											<input class="text-input small-input" type="text" id="userName" name="userInfo.userName"
												value="${userInfo.userName }" />
												<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												密码：
											</label>
											<input class="text-input small-input" type="password" id="userPassword"
												name="userInfo.userPassword"
												value="${userInfo.userPassword }" />
												<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												确认密码：
											</label>
											<input class="text-input small-input" type="password" id="MSpassword" name="MSpassword"
												value="${userInfo.userPassword }" />
												<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												手机号码：
											</label>
											<input class="text-input small-input" type="text" id="userPnumber"
												name="userInfo.userPnumber" value="${userInfo.userPnumber }" />
												<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												邮箱：
											</label>
											<input class="text-input small-input" type="text" id="userEmail" name="userInfo.userEmail"
												value="${userInfo.userEmail }" />
												<font color="#FF0000">*</font>
										</td>
									</tr>
								</table>
								<p>
									<input class="button" type="submit" value="保存" />
									<input type="hidden" name="movieInfo.movieId"
										value="${movieInfo.movieId }" />
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
