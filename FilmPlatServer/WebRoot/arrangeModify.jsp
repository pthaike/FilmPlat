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
    
    <title>排片管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="resources/css/reset.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/invalid.css" type="text/css"
			media="screen" />
			<script type="text/javascript"
			src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
			function validate(){
			
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
        <h3>修改排片信息</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab">
          <form onsubmit="return validata();" action="<%=basePath %>SaveArrangeMovieInfo.action" method="post">
            <fieldset>
            <table>
            <tr>
               <td><label>影城：</label>
                  <input class="text-input small-input" type="text" id="movieCityId" name="movieShowInfo.movieVityInfo.movieCityId" value="${movieShowInfo.movieVityInfo.movieCityId }">
               </td>
               <td><font color="red" size=2px>此项不能被修改</font></td>
            </tr>
            <tr>
               <td><label>影厅：</label>
                   <input type="text" class="text-input small-input" id="movieHailId" name="movieShowInfo.movieHallInfo.movieHailId" value="${movieShowInfo.movieHallInfo.movieHailId }">
               </td>
               <td><font color="red" size=2px>此项不能被修改</font></td>
            </tr>
            <tr>
               <td><label>影片：</label>
                  <input class="text-input small-input" type="text" id="movieId" name="movieShowInfo.movieInfo.movieId" value="${movieShowInfo.movieInfo.movieId }">
               </td>
               <td><font color="red" size=2px>此项不能被修改</font></td>
            </tr>
            <tr>
               <td><label>影片版本：</label>
                  <select class="text-input small-input" name="movieShowInfo.movieVison">
							<s:if test="%{#movieShowInfo.movieVison==0}">
								<option selected="selected" value="0">
									2D
								</option>
								<option value="1">
									3D
								</option>
							</s:if>
							<s:else>
								<option value="0">
									2D
								</option>
								<option selected="selected" value="1">
									3D
								</option>
							</s:else>
				 </select>
               </td>
            </tr>
            <tr>
               <td><label>场次：</label>
                  <input  class="text-input small-input" type="text" id="movieTime" name="movieShowInfo.movieTime" value="${movieShowInfo.movieTime }">
               </td>
            </tr>
            <tr>
               <td><label>价格：</label>
                  <input class="text-input small-input" type="text" id="moviePrice" name="movieShowInfo.moviePrice" value="${movieShowInfo.moviePrice }">
               </td>
            </tr>
            <tr>
               <td><label>放映日期：</label>
                  <input type="text"  id="date"  onfocus="WdatePicker({skin:'whyGreen',dataFmt:'yyyy-MM-dd'})" class="Wdate"  name="movieShowInfo.moviePlayDate" value="${movieShowInfo.moviePlayDate }"/>
               </td>
            </tr>
            
            </table>
            <p>
              <input class="button" type="submit" value="保存" />
              <input type="hidden" name="movieShowInfo.movieShowId" value="${movieShowInfo.movieShowId }" />
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
