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
				if($("#title").val()==""){
					alert("标题不能为空!");
					return false;
				}
				if($("#content").val()==""){
					alert("内容不能为空!");
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
        <h3>修改影片信息</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab">
          <form onsubmit="return validata();" action="<%=basePath %>SaveModifyMovieInfo.action" method="post">
            <fieldset>
            <table>
            <tr>
               <td><label>片名：</label>
                  <input class="text-input small-input" type="text" id="movieName" name="movieInfo.movieName" value="${movieInfo.movieName }">
               </td>
            </tr>
            <tr>
               <td><label>导演：</label>
                  <input class="text-input small-input" type="text" id="movieDirector" name="movieInfo.movieDirector" value="${movieInfo.movieDirector }">
               </td>
            </tr>
            <tr>
               <td><label>主演：</label>
                  <input class="text-input small-input" type="text" id="movieActor" name="movieInfo.movieActor" value="${movieInfo.movieActor }">
               </td>
            </tr>
            <tr>
               <td><label>类型：</label>
                  <input class="text-input small-input" type="text" id="movieType" name="movieInfo.movieType"  value="${movieInfo.movieType }">
               </td>
            </tr>
            <tr>
               <td><label>国家/地区：</label>
                  <input class="text-input small-input" type="text" id="movieCountry" name="movieInfo.movieCountry" value="${movieInfo.movieCountry }">
               </td>
            </tr>
            <tr>
               <td><label>片长：</label>
                  <input class="text-input small-input" type="text" id="movieLength" name="movieInfo.movieLength" value="${movieInfo.movieLength }">
               </td>
            </tr>
           <tr>
				 <td><label>是否上映:</label>
						<select class="text-input small-input" name="movieInfo.movieShowOn">
							<s:if test="%{#movieInfo.movieShowOn==正在热映}">
								<option selected="selected" value="正在热映">
									正在热映
								</option>
								<option value="即将上映">
									即将上映
								</option>
							</s:if>
							<s:else>
								<option value="正在热映">
									正在热映
								</option>
								<option selected="selected" value="即将上映">
									即将上映
								</option>
							</s:else>
						</select>
					</td>
			</tr>
            <tr>
               <td><label>上映日期：</label>
                  <input type="text"  id="date"  onfocus="WdatePicker({skin:'whyGreen',dataFmt:'yyyy-MM-dd'})" class="Wdate"  name="movieInfo.moviePublishDate" value="${movieInfo.moviePublishDate }"/>
               </td>
            </tr>
            <tr>
               <td><label>星级：</label>
                  <input class="text-input small-input" type="text" id="movieGrade" name="movieInfo.movieGrade" value="${movieInfo.movieGrade }">
               </td>
            </tr>
            <tr>
               <td><label>点击率：</label>
                  <input class="text-input small-input" type="text" id="movieClickRate" name="movieInfo.movieClickRate" value="${movieInfo.movieClickRate }">
               </td>
            </tr>
            <tr>
               <td><label> 封面小图片：</label>
                  <input class="text-input small-input" type="text" id="movieSmallPicture" name="movieInfo.movieSmallPicture" value="${movieInfo.movieSmallPicture }">
               </td>
            </tr>
             <tr>
               <td><label> 封面大图片：</label>
                  <input class="text-input small-input" type="text" id="movieBigPicture" name="movieInfo.movieBigPicture" value="${movieInfo.movieBigPicture }">
               </td>
            </tr>
            <tr>
               <td><label> 剧照图片：</label>
                  <input class="text-input small-input" type="text" id="movieContentPicture" name="movieInfo.movieContentPicture" value="${movieInfo.movieContentPicture }">
               </td>
            </tr>
            <tr>
               <td><label>卖点短评：</label>
                  <textarea class="text-input textarea wysiwyg" id="movieShortcut" name="movieInfo.movieShortcut" cols="79" rows="15">${movieInfo.movieShortcut }</textarea>
               </td>
            </tr>
            <tr>
               <td><label> 剧情介绍：</label>
               <textarea class="text-input textarea wysiwyg" id="movieIntroduction" name="movieInfo.movieIntroduction" cols="79" rows="15">${movieInfo.movieIntroduction }</textarea>
               </td>
            </tr>
            </table>
            <p>
              <input class="button" type="submit" value="保存" />
              <input type="hidden" name="movieInfo.movieId" value="${movieInfo.movieId }" />
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
