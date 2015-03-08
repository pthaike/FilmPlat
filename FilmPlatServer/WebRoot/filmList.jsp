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
		<script type="text/javascript" src="<%=basePath %>js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript">
       function validata()
    {  
       if($("#movieName").val()=="")
       {
          alert("影片名不能为空!");
          return false;
       }
       if($("#movieName").val().length>50)
       {
          alert("影片名已超出最大长度!");
          return false;
       }
       if($("#movieDirector").val()=="")
       {
          alert("导演不能为空!");
          return false;
       }
       if($("#movieDirector").val().length>30)
       {
          alert("导演名已超出最大长度!");
          return false;
       }
       if($("#movieActor").val()=="")
       {
          alert("主演不能为空!");
          return false;
       }
       if($("#movieActor").val().length>30)
       {
          alert("主演名已超出最大长度!");
          return false;
       }
       if($("#movieType").val()=="")
       {
          alert("类型不能为空!");
          return false;
       }
       if($("#movieType").val().length>11)
       {
          alert("类型已超出最大长度!");
          return false;
       }
       if($("#movieCountry").val()=="")
       {
          alert("国家/地区不能为空!");
          return false;
       }
       if($("#movieCountry").val().length>50)
       {
          alert("此项已超出最大长度!");
          return false;
       }
       if($("#movieLength").val()=="")
       {
          alert("片长不能为空!");
          return false;
       }
       if($("#movieLength").val().length>11)
       {
          alert("片长已超出最大值!");
          return false;
       }
       if($("#movieGrade").val()=="")
       {
          alert("星级不能为空!");
          return false;
       }
       if($("#movieGrade").val().length>11)
       {
          alert("星级已超出最大值!");
          return false;
       }
       if($("#movieClickRate").val()=="")
       {
          alert("点击率不能为空!");
          return false;
       }
       if($("#movieClickRate").val().length>11)
       {
          alert("点击率已超出最大值!");
          return false;
       }
       if($("#movieShortcut").val()=="")
       {
          alert("卖点短评不能为空!");
          return false;
       }
       if($("#movieShortcut").val().length>300)
       {
          alert("此项已超出最大长度!");
          return false;
       }
       if($("#movieIntroduction").val()=="")
       {
          alert("剧情介绍不能为空!");
          return false;
       }
       if($("#movieIntroduction").val().length>300)
       {
          alert("此项已超出最大长度!");
          return false;
       }
       if($("#movieSmallPicture").val()=="")
       {
          alert("封面小图片不能为空!");
          return false;
       }
       if($("#movieSmallPicture").val().length>50)
       {
          alert("图片大小超出最大值!");
          return false;
       }
       if($("#movieBigPicture").val()=="")
       {
          alert("封面大图片不能为空!");
          return false;
       }
       if($("#movieBigPicture").val().length>50)
       {
          alert("图片大小已超出最大值!");
          return false;
       }
       if($("#movieContentPicture").val()=="")
       {
          alert("剧照图片不能为空!");
          return false;
       }
       if($("#movieContentPicture").val().length>50)
       {
          alert("图片大小已超出最大值!");
          return false;
       }
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
          <li><a href="#tab1" class="default-tab">影片列表</a></li>
          <!-- href must be unique and match the id of target div -->
          <li><a href="#tab2">添加影片</a></li>
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
        <form action="<%=basePath %>QueryFilmInfoAction.action" method="get">
        <table>
        	<tr>
        	    <td>
        	                    国家地区：
        	    </td>
        	    <td>
        	        <select name="movieCountry">
                     <option  value="" ></option>
                     <s:iterator value="movieList" var="country">
                        <option value="${country.movieCountry }">
                           <s:property value="#country.movieCountry" />
                        </option>
                     </s:iterator>
                   </select>            
        	    </td>
				<td>
					影片名:
					<input class="text-input small-input" type="text" id="small-input" name="movieName" />
				</td>
               <td>上映日期：
				<input  type="text" id="date" onfocus="WdatePicker({skin:'whyGreen',dataFmt:'yyyy-MM-dd'})" class="Wdate" name="moviePublishDate"/>
			   </td>
			   <td><input type="submit" class="button" value="查询"/></td>
			</tr>
        </table>
        </form>
          <table>
            <thead>
              <tr>
              	<th>片名</th>
                <th>上映日期</th>
                <th>国家/地区</th>
                <th>星级</th>
                <th>卖点短评</th>
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
            <s:iterator value="movieList" var="movie">
				<tr>
					<td>
						<s:property value="#movie.movieName" />
					</td>
					<td>
						<s:property value="#movie.moviePublishDate" />
					</td>
					<td>
						<s:property value="#movie.movieCountry" />
					</td>
					<td>
						<s:property value="#movie.movieGrade" />
					</td>
					<td>
						<s:property value="#movie.movieShortcut" />
					</td>
					<td>
					<a href="<%=basePath %>DeleteMovieInfo.action?movieID=<s:property value="#movie.movieId" />"><img src="images/icons/cross.png" alt="Delete" /></a>
					<a href="<%=basePath %>ModifyMovieInfo.action?movieID=<s:property value="#movie.movieId" />"><img src="images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a>
					<a href="<%=basePath %>QueryCommentInfoAction.action?movieID=<s:property value="#movie.movieId" />"><img src="images/icons/pencil.png" alt="Edit" /></a>
					</td>
				</tr>
			</s:iterator>
            </tbody>
          </table>
        </div>
        <!-- End #tab1 -->
        <div class="tab-content" id="tab2">
          <form onsubmit="return validata();" action="<%=basePath %>SaveFilmInfoAction.action" method="post">
            <fieldset>
            <table>
            <tr>
               <td><label>片名：</label>
                  <input class="text-input small-input" type="text" id="movieName" name="movieInfo.movieName">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label>导演：</label>
                  <input class="text-input small-input" type="text" id="movieDirector" name="movieInfo.movieDirector">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label>主演：</label>
                  <input class="text-input small-input" type="text" id="movieActor" name="movieInfo.movieActor">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label>类型：</label>
                  <input class="text-input small-input" type="text" id="movieType" name="movieInfo.movieType">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label>国家/地区：</label>
                  <input class="text-input small-input" type="text" id="movieCountry" name="movieInfo.movieCountry">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label>片长：</label>
                  <input class="text-input small-input" type="text" id="movieLength" name="movieInfo.movieLength">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
              <tr>
				 <td><label>是否上映:</label>
						<select class="text-input small-input" name="movieInfo.movieShowOn">
							<option value="正在热映">
								正在热映
							</option>
							<option value="即将上映">
								即将上映
							</option>
						</select>
				</td>
			</tr>
            <tr>
               <td><label>上映日期：</label>
                  <input type="text"  id="date"  onfocus="WdatePicker({skin:'whyGreen',dataFmt:'yyyy-MM-dd'})" class="Wdate"  name="movieInfo.moviePublishDate" />
               </td>
            </tr>
            <tr>
               <td><label>星级：</label>
                  <input class="text-input small-input" type="text" id="movieGrade" name="movieInfo.movieGrade">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label>点击率：</label>
                  <input class="text-input small-input" type="text" id="movieClickRate" name="movieInfo.movieClickRate">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label> 封面小图片：</label>
                  <input class="text-input small-input" type="text" id="movieSmallPicture" name="movieInfo.movieSmallPicture">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
             <tr>
               <td><label> 封面大图片：</label>
                  <input class="text-input small-input" type="text" id="movieBigPicture" name="movieInfo.movieBigPicture">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label> 剧照图片：</label>
                  <input class="text-input small-input" type="text" id="movieContentPicture" name="movieInfo.movieContentPicture">
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label>卖点短评：</label>
                  <textarea class="text-input textarea wysiwyg" id="movieShortcut" name="movieInfo.movieShortcut" cols="79" rows="15"></textarea>
                  <font color="#FF0000">*</font>
               </td>
            </tr>
            <tr>
               <td><label> 剧情介绍：</label>
               <textarea class="text-input textarea wysiwyg" id="movieIntroduction" name="movieInfo.movieIntroduction" cols="79" rows="15"></textarea>
               <font color="#FF0000">*</font>
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
