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
        <h3>修改文章</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab">
          <form onsubmit="return validate();" action="<%=basePath %>UpdateArticleInfoAction.action" method="post">
            <fieldset>
            <p>
              <label>标题</label>
              <input class="text-input large-input" type="text" id="title" name="newsArticle.newsTitle" value="${newsArticle.newsTitle}"/>
            </p>
            <p>
              <label>内容</label>
              <textarea class="text-input textarea wysiwyg" id="content" name="newsArticle.newsContent" cols="79" rows="15">${newsArticle.newsContent }</textarea>
            </p>
            <p>
              <input class="button" type="submit" value="保存" />
  			  <input type="hidden" name="newsArticle.newsTime" value="${newsArticle.newsTime }"/>
  			  <input type="hidden" name="newsArticle.newsId" value="${newsArticle.newsId }"/>
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
