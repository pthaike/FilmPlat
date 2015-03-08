<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
    alert("您填写的用户名不存在，请确认您的用户名！");
    window.location.href="vip_getbackPassword.jsp";
</script>
