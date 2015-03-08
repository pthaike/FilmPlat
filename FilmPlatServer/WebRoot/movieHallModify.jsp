<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'movieHallModify.jsp' starting page</title>
    
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
		
		if(movieHailName=="")
		{
			alert("影城名称不能为空!");
			return false;
		}
		
		if($("#movieVityInfo").val()=="")
		{
			alert("所属影城不能为空!");
			return false;
		}
		
		return true;
	}
	
	
	</script>
  </head>
  
  <body>
     <s:include value="/side.jsp"></s:include>
   <div id="main-content">
    <h2>影视后台管理</h2>
    <div class="clear"></div>
    <div class="content-box">
      <div class="content-box-header">
        <h3>修改影厅信息</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab">
          <form onsubmit="return validata();" action="<%=basePath %>SaveModifyMovieHallInfoAction.action" method="post">
            <fieldset>
            <table>
            <tr>
               <td><label>影厅名：</label>
                  <input class="text-input small-input" type="text" id="movieHailName" name="movieHallInfo.movieHailName" value="${movieHallInfo.movieHailName }">
                  <input type="hidden" name="movieHallInfo.movieHailId" value="${movieHallInfo.movieHailId }"/>
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
