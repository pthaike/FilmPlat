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
						会员管理
					</h3>
					<ul class="content-box-tabs">
						<li>
							<a href="#tab1" class="default-tab">会员列表</a>
						</li>
						<!-- href must be unique and match the id of target div -->
						<li>
							<a href="#tab2">添加会员</a>
						</li>
					</ul>
					<div class="clear"></div>
				</div>
				<!-- End .content-box-header -->
				<div class="content-box-content">
					<div class="tab-content default-tab" id="tab1">
						<form action="<%=basePath%>QueryUserInfoAction.action"
							method="get">
							<table>
								<tr>
									<td>
										用户ID：
										<input class="text-input small-input" type="text" id="small-input"
											name="userID" />
									</td>
									<td>
										真实姓名：
										<input class="text-input small-input" type="text"
											id="small-input" name="userRealname" />
									</td>
									<td>
										用户名：
										<input class="text-input small-input" type="text"
											id="userName" name="userName" />
									</td>
									<td>
										手机号：
										<input class="text-input small-input" type="text"
											id="phonenumber" name="phonenumber" />
									</td>
									<td>
										邮箱：
										<input class="text-input small-input" type="text" id="email"
											name="email" />
									</td>
									<td>
										<input type="submit" class="button" value="查询" />
									</td>
								</tr>
							</table>
						</form>
						<table>
							<thead>
								<tr>
									<th>
										用户ID
									</th>
									<th>
										用户名
									</th>
									<th>
										用户密码
									</th>
									<th>
										真实姓名
									</th>
									<th>
										性别
									</th>
									<th>
										身份证号
									</th>
									<th>
										出生日期
									</th>
									<th>
										是否已婚
									</th>
									<th>
										所在城市
									</th>
									<th>
										通讯地址
									</th>
									<th>
										邮编
									</th>
									<th>
										手机号
									</th>
									<th>
										电子邮箱
									</th>
									<th>
										操作
									</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td colspan="6">
										<div class="pagination">
											<a href="#" title="First Page">&laquo; First</a><a href="#"
												title="Previous Page">&laquo; Previous</a>
											<a href="#" class="number" title="1">1</a>
											<a href="#" class="number" title="2">2</a>
											<a href="#" class="number current" title="3">3</a>
											<a href="#" class="number" title="4">4</a>
											<a href="#" title="Next Page">Next &raquo;</a><a href="#"
												title="Last Page">Last &raquo;</a>
										</div>
										<!-- End .pagination -->
										<div class="clear"></div>
									</td>
								</tr>
							</tfoot>
							<tbody>
								<s:iterator value="userList" var="user">
									<tr>
										<td>
											<s:property value="#user.userId" />
										</td>
										<td>
											<s:property value="#user.userName" />
										</td>
										<td>
											<s:property value="#user.userPassword" />
										</td>
										<td>
											<s:property value="#user.userRealname" />
										</td>
										<td>
											<s:if test="#user.userSex==0">
							男
						</s:if>
											<s:elseif test="#user.userSex==1">
							女
						</s:elseif>
											<s:else>暂无信息</s:else>
										</td>
										<td>
											<s:property value="#user.userIdcard" />
										</td>
										<td>
											<s:property value="#user.userBirth" />
										</td>
										<td>
											<s:if test="#user.userMarry==0">已婚</s:if>
											<s:elseif test="#user.userMarry==1">未婚</s:elseif>
											<s:else>暂无信息</s:else>
										</td>
										<td>
											<s:property value="#user.userCity" />
										</td>
										<td>
											<s:property value="#user.userAddress" />
										</td>
										<td>
											<s:property value="#user.userPostcode" />
										</td>
										<td>
											<s:property value="#user.userPnumber" />
										</td>
										<td>
											<s:property value="#user.userEmail" />
										</td>
										<td>
											<a
												href="<%=basePath%>deleteUserInfo.action?userID=<s:property value="#user.userId" />"><img
													src="images/icons/cross.png" alt="Delete" /> </a>
											<a
												href="<%=basePath%>updataUserInfo.action?userID=<s:property value="#user.userId" />"><img
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
						<form onsubmit="return validate();" action="addVipAction.action"
							name="regist" method="post">
							<fieldset>
								<table>
									<tr>
										<td>
											<label>
												真实姓名：
											</label>
											<input class="text-input small-input" type="text"
												id="userRealname" name="userInfo.userRealname">
												<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												性别：
											</label>
											<select name="userInfo.userSex" class="small-input">
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
											<label>
												身份证号：
											</label>
											<input class="text-input small-input" type="text"
												id="userIdcard" name="userInfo.userIdcard">
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
												class="Wdate" name="userInfo.userBirth" />
										</td>
									</tr>
									<tr>
										<td>
											<label>
												是否已婚：
											</label>
											<select name="userInfo.userMarry" class="small-input">
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
											<label>
												所在城市：
											</label>
											<input class="text-input small-input" type="text"
												id="userCity" name="userInfo.userCity">
										</td>
									</tr>
									<tr>
										<td>
											<label>
												通讯地址：
											</label>
											<input class="text-input small-input" type="text"
												id="userAddress" name="userInfo.userAddress">
										</td>
									</tr>
									<tr>
										<td>
											<label>
												邮编：
											</label>
											<input class="text-input small-input" type="text"
												id="userPostcode" name="userInfo.userPostcode">
										</td>
									</tr>
									<tr>
										<td>
											<label>
												用户名：
											</label>
											<input class="text-input small-input" type="text"
												id="userName" name="userInfo.userName">
												<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												密码：
											</label>
											<input class="text-input small-input" type="password"
												id="userPassword" name="userInfo.userPassword">
												<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												确认密码：
											</label>
											<input class="text-input small-input" type="password"
												id="MSpassword" name="MSpassword">
												<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												手机号码：
											</label>
											<input class="text-input small-input" type="text"
												id="userPnumber" name="userInfo.userPnumber">
												<font color="#FF0000">*</font>
										</td>
									</tr>
									<tr>
										<td>
											<label>
												邮箱：
											</label>
											<input class="text-input small-input" type="text"
												id="userEmail" name="userInfo.userEmail">
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
