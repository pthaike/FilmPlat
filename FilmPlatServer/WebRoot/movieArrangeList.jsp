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

    <link rel="stylesheet" href="css/reset.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/style.css" type="text/css"
			media="screen" />
		<link rel="stylesheet" href="css/invalid.css" type="text/css"
			media="screen" />
		<script type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
       function validata()
    {  
       
    }
    </script>
  </head>
  
  <body>
       <s:include value="/side.jsp"></s:include>
   <div id="main-content">
    <noscript>
    <div class="notification error png_bg">
      <div> Javascript is disabled or is not supported by your browser. Please <a href="http://browsehappy.com/" title="Upgrade to a better browser">upgrade</a> your browser or <a href="http://www.google.com/support/bin/answer.py?answer=23852" title="Enable Javascript in your browser">enable</a> Javascript to navigate the interface properly.
        Download From <a href="http://www.exet.tk">exet.tk</a></div>
    </div>
    </noscript>
    
    <h2>影视后台管理</h2>
    <div class="clear"></div>
    <div class="content-box">
      <div class="content-box-header">
        <h3>Content box</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab">排片列表</a></li>
          <!-- href must be unique and match the id of target div -->
          <li><a href="#tab2">添加排片</a></li>
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
       <form action="<%=basePath %>QueryMovieArrangeInfoAction.action" method="get">
        <table>
        	<tr>
				<td>
					影城:
				   <select name="movieCityId">
                      <option  value="" ></option>
                      <s:iterator value="cityList" var="city">
                        <option value="${city.movieCityId }">
                           <s:property value="#city.movieCityName " />
                        </option>
                      </s:iterator>
                   </select>
				</td>
               <td>
                                              影厅:
				   <select name="movieHailId">
                      <option  value="" ></option>
                      <s:iterator value="hallList" var="hall">
                        <option value="${hall.movieHailId }">
                           <s:property value="#hall.movieHailName " />
                        </option>
                      </s:iterator>
                   </select>
			   </td>
			   <td>
                                              放映日期:
                    <input type="text"  id="date"  onfocus="WdatePicker({skin:'whyGreen',dataFmt:'yyyy-MM-dd'})" class="Wdate"  name="moviePlayDate" />                          
			   </td>
			   <td><input type="submit" class="button" value="查询"/></td>
			</tr>
			<tr> <td colspan="2"><font color="gray" size=2px>注：影片版本为0代表2D电影，1代表3D电影</font></td></tr>
        </table>
        </form>
          <table>
            <thead>
              <tr>
              	<th>影城</th>
                <th>影厅</th>
                <th>影片</th>
                <th>影片版本</th>
                <th>放映日期</th>
                <th>场次</th>
                <th>价格</th>
                <th> 操作</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="6">
                  <div class="pagination"> <a href="#" title="First Page">&laquo; First</a><a href="#" title="Previous Page">&laquo; Previous</a> <a href="#" class="number" title="1">1</a> <a href="#" class="number" title="2">2</a> <a href="#" class="number current" title="3">3</a> <a href="#" class="number" title="4">4</a> <a href="#" title="Next Page">Next &raquo;</a><a href="#" title="Last Page">Last &raquo;</a> </div>
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
            <tbody>
            <s:iterator value="arrangeMovieList" var="arrange"> 
				<tr>
					<td>
						<s:property value="#arrange.movieVityInfo.movieCityName" />
					</td>
					<td>
						<s:property value="#arrange.movieHallInfo.movieHailName" />
					</td>
					<td>
						<s:property value="#arrange.movieInfo.movieName" />
					</td>
					<td>
						<s:property value="#arrange.movieVison" />
					</td>
					<td>
						<s:property value="#arrange.moviePlayDate" />
					</td>
					<td>
						<s:property value="#arrange.movieTime" />
					</td>
					<td>
						<s:property value="#arrange.moviePrice" />
					</td>
					<td>
					<a href="<%=basePath %>DeleteArrangeInfo.action?movieShowID=<s:property value="#arrange.movieShowId" />"><img src="images/icons/cross.png" alt="Delete" /></a>
					<a href="<%=basePath %>ModifyArrangeInfo.action?movieShowID=<s:property value="#arrange.movieShowId" />"><img src="images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a>
					</td>
				</tr>
			</s:iterator>
            </tbody>
          </table>
        </div>
        <!-- End #tab1 -->
      <div class="tab-content" id="tab2">
          <form onsubmit="return validata();" action="<%=basePath %>SelectBeforeAddArrange.action" method="post">
            <fieldset>
            <table>
            <tr>
               <td><label>影城：</label>
                  <select  name="movieCityId">
                     <option  value="" ></option>
                     <s:iterator value="cityList" var="city">
                        <option value="${city.movieCityId }">
                           <s:property value="#city.movieCityName" />
                        </option>
                     </s:iterator>
                  </select>
               </td>
            </tr>
            <tr>
               <td><label>影厅：</label>
                  <select name="movieHailId">
                     <option  value="" ></option>
                     <s:iterator value="hallList" var="hall">
                        <option value="${hall.movieHailId }">
                           <s:property value="#hall.movieHailName" />
                        </option>
                     </s:iterator>
                  </select>
               </td>
            </tr>
            <tr>
               <td><label>影片：</label>
                  <select name="movieId">
                     <option  value="" ></option>
                     <s:iterator value="movieList" var="movie">
                        <option value="${movie.movieId }">
                           <s:property value="#movie.movieName" />
                        </option>
                     </s:iterator>
                  </select>
               </td>
            </tr>
            <tr>
               <td><label>影片版本：</label>
                  <select name="movieShowInfo.movieVison">
							<option value="0">
								2D
							</option>
							<option value="1">
								3D
							</option>
						</select>
               </td>
            </tr>
            <tr>
               <td><label>场次：</label>
                  <input class="text-input small-input" type="text" id="movieTime" name="movieShowInfo.movieTime">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label>价格：</label>
                  <input class="text-input small-input" type="text" id="moviePrice" name="movieShowInfo.moviePrice">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label>放映日期：</label>
                  <input type="text"  id="date"  onfocus="WdatePicker({skin:'whyGreen',dataFmt:'yyyy-MM-dd'})" class="Wdate"  name="movieShowInfo.moviePlayDate" />
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
