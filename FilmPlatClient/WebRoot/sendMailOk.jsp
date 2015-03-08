<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<script type="text/javascript">
    alert("已将您的密码信息发送到您的邮箱中，请及时查收！");
    window.location.href = "vip_login.jsp";
</script>
