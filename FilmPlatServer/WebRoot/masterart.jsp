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
			function validate() {
				if ($("#title").val() == "") {
					alert("标题不能为空!");
					return false;
				}
				if ($("#content").val() == "") {
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
        <h3>Content box</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab">文章管理</a></li>
          <!-- href must be unique and match the id of target div -->
          <li><a href="#tab2">添加文章</a></li>
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
        <form action="<%=basePath %>QueryArticleInfoAction.action?page=${page}" method="get">
        <table>
        	<tr>
				<td>
					关键字:
					<input class="text-input small-input" type="text" id="small-input" name="keyWord" />
					<input type="submit" class="button" value="查询"/>
				</td>
			</tr>
        </table>
        </form>
          <table>
            <thead>
              <tr>
              	<th>ID</th>
                <th>标题</th>
                <th>内容</th>
                <th>时间</th>
                <th>操作</th>
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
            <s:iterator value="articleList" var="article">
				<tr>
					<td>
						<s:property value="#article.newsId" />
					</td>
					<td>
						<s:property value="#article.newsTitle" />
					</td>
					<td>
						<s:property value="#article.newsContent" />
					</td>
					<td>
						<s:property value="#article.newsTime" />
					</td>
					<td>
					<a href="<%=basePath %>LoadArticleInfoAction.action?articleID=<s:property value="#article.newsId" />"><img src="images/icons/pencil.png" alt="Edit" /></a>
					<a href="<%=basePath %>DeleteArticleInfoAction.action?articleID=<s:property value="#article.newsId" />"><img src="images/icons/cross.png" alt="Delete" /></a>
					<a href="<%=basePath %>CommentAction.action?articleID=<s:property value="#article.newsId" />"><img src="images/icons/hammer_screwdriver.png" alt="Edit Meta" /></a>
					</td>
				</tr>
			</s:iterator>
            </tbody>
          </table>
        </div>
        <!-- End #tab1 -->
        <div class="tab-content" id="tab2">
          <form action="<%=basePath %>AddArticleAction.action" method="post">
            <fieldset>
            <p>
              <label>标题</label>
              <input class="text-input large-input" type="text" id="title" name="newsArticle.newsTitle" />
            </p>
            <p>
              <label>内容</label>
              <textarea class="text-input textarea wysiwyg" id="content" name="newsArticle.newsContent" cols="79" rows="15"></textarea>
            </p>
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
