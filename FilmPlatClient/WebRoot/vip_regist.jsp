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

				<!-- before -->
				<div class="regbor">
					<form onsubmit="return validate();" action="registAction.action"
						name="regist" method="post">
						<div class="f16px bt sl fB">
							会员注册
						</div>
						<table width="263" height="452">
							<tr>
								<td>
									真实姓名：
								</td>
								<td>
									<input type="text" id="userRealname"
										name="userInfo.userRealname" />
								</td>
								<td>
									<font color="#FF0000">*</font>
								</td>
							</tr>
							<tr>
								<td>
									性别：
								</td>
								<td>
									<select name="userInfo.userSex">
										<option value="0">
											男
										</option>
										<option value="1">
											女
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									身份证号：
								</td>
								<td>
									<input type="text" id="userIdcard" name="userInfo.userIdcard" />
								</td>
								<td>
									<font color="#FF0000">*</font>
								</td>
							</tr>
							<tr>
								<td>
									出生日期：
								</td>
								<td>
									<input type="text" id="userBirth"
										onfocus="WdatePicker({skin:'whyGreen',dataFmt:'yyyy-MM-dd'})"
										class="Wdate" name="userInfo.userBirth" />
								</td>
							</tr>
							<tr>
								<td>
									是否已婚：
								</td>
								<td>
									<select name="userInfo.userMarry">
										<option value="0">
											已婚
										</option>
										<option value="1">
											未婚
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									所在城市：
								</td>
								<td>
									<input type="text" id="userCity" name="userInfo.userCity" />
								</td>
							</tr>
							<tr>
								<td>
									通讯地址：
								</td>
								<td>
									<input type="text" id="userAddress" name="userInfo.userAddress" />
								</td>
							</tr>
							<tr>
								<td>
									邮编：
								</td>
								<td>
									<input type="text" id="userPostcode"
										name="userInfo.userPostcode" />
								</td>
							</tr>
							<tr>
								<td>
									用户名：
								</td>
								<td>
									<input type="text" id="userName" name="userInfo.userName" />
								</td>
								<td>
									<font color="#FF0000">*</font>
								</td>
							</tr>
							<tr>
								<td>
									密码：
								</td>
								<td>
									<input type="password" id="userPassword"
										name="userInfo.userPassword" />
								</td>
								<td>
									<font color="#FF0000">*</font>
								</td>
							</tr>
							<tr>
								<td>
									确认密码：
								</td>
								<td>
									<input type="password" id="MSpassword" name="MSpassword" />
								</td>
								<td>
									<font color="#FF0000">*</font>
								</td>
							</tr>
							<tr>
								<td>
									手机号码：
								</td>
								<td>
									<input type="text" id="userPnumber" name="userInfo.userPnumber" />
								</td>
								<td>
									<font color="#FF0000">*</font>
								</td>
							</tr>
							<tr>
								<td>
									邮箱：
								</td>
								<td>
									<input type="text" id="userEmail" name="userInfo.userEmail" />
								</td>
								<td>
									<font color="#FF0000">*</font>
								</td>
							</tr>
							<tr>
								<td colspan="2">
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
