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

		<title>影城管理</title>

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
		
		<link rel="stylesheet" href="resources/css/reset.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/invalid.css" type="text/css"
			media="screen" />

		<script type="text/javascript">
	
	function validata()
	{
		
		var loginName=$("#movieCityName").val();
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
		<s:include value="/side.jsp"></s:include>
   <div id="main-content">
    <h2>影视后台管理</h2>
    <div class="clear"></div>
    <div class="content-box">
      <div class="content-box-header">
        <h3>修改影城信息</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab">
          <form onsubmit="return validata();" action="<%=basePath %>SaveModifyMovieCityInfo.action" method="post">
            <fieldset>
            <table>
            <tr>
               <td><label>影城名称：</label>
                     <input class="text-input small-input"
                            type="text" id="movieCityName"
							name="movieVityInfo.movieCityName"
							value="${movieVityInfo.movieCityName }" />
               </td>
            </tr>
            <tr>
               <td><label>支持在线售票：</label>
                   <select class="text-input small-input" name="movieVityInfo.supportOnlline">
							<s:if test="%{#movieVityInfo.supportOnlline==0}">
								<option selected="selected" value="0">
									是
								</option>
								<option value="1">
									否
								</option>
							</s:if>
							<s:else>
								<option value="0">
									是
								</option>
								<option selected="selected" value="1">
									否
								</option>
							</s:else>
					</select>
               </td>
            </tr>
            <tr>
               <td><label>地址：</label>
                     <input class="text-input small-input"
                            type="text" id="movieCityAddress"
							name="movieVityInfo.movieCityAddress"
							value="${movieVityInfo.movieCityAddress }" />
               </td>
            </tr>
            <tr>
               <td><label>联系电话：</label>
                  <input    class="text-input small-input"
                            type="text" id="movieCityPhone"
							name="movieVityInfo.movieCityPhone"
							value="${movieVityInfo.movieCityPhone }" />
               </td>
             </tr>
             <tr>
               <td><label>影城简介：</label>
                   <textarea class="text-input textarea wysiwyg" id="movieCityIntro" name="movieVityInfo.movieCityIntro" cols="79" rows="15">${movieVityInfo.movieCityIntro }</textarea>
               </td>
             </tr>
            
            </table>
            <p>
              <input class="button" type="submit" value="保存" />
              <input type="hidden" name="movieVityInfo.movieCityId"
							value="${movieVityInfo.movieCityId }" />
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
