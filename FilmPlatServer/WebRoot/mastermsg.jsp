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

		<title>My JSP 'index.jsp' starting page</title>
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
	</head>

	<body>
  <s:include value="/side.jsp"></s:include>
   <div id="main-content">
    <h2>影视后台管理</h2>
    <div class="clear"></div>
    <!-- End .clear -->
    <div class="content-box">
      <!-- Start Content Box -->
      <div class="content-box-header">
        <h3>Content box</h3>
        <ul class="content-box-tabs">
          <li><a href="#tab1" class="default-tab">未回复</a></li>
          <!-- href must be unique and match the id of target div -->
          <li><a href="#tab2">已回复</a></li>
        </ul>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="content-box-content">
        <div class="tab-content default-tab" id="tab1">
        <form action="<%=basePath %>QueryMsgAction.action?repstate=0" method="get">
	        <table>
	        	<tr>
					<td>
						用户ID:
						<input class="text-input small-input" type="text" id="small-input" name="keyWord" />
						<input type="submit" class="button" value="查询"/>
					</td>
				</tr>
	        </table>
        </form>
          <table>
            <thead>
              <tr>
                <th>用户ID</th>
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
            <s:iterator value="noreplymsgList" var="message">
            	<tr>
					<td>
						<s:property value="#message.userInfo.userId" />
					</td>
					<td>
						<s:property value="#message.messageContent" />
					</td>
					
					<td>
						<s:property value="#message.messageTime" />
					</td>
					<td>
					<a href="<%=basePath %>DeleteMsgInfoAction.action?messageID=<s:property value="#message.messageId" />"><img src="images/icons/cross.png" alt="Delete" /></a>
					<a href="<%=basePath %>ReplyAction.action?messageID=<s:property value="#message.messageId" />"><img src="images/icons/pencil.png" alt="Edit" /></a>
					</td>
				</tr>
            </s:iterator>
            </tbody>
          </table>
        </div>
        <div class="tab-content" id="tab2">
        <form action="<%=basePath %>QueryMsgAction.action?repstate=1" method="get">
	        <table>
	        	<tr>
					<td>
						用户ID:
						<input class="text-input small-input" type="text" id="small-input" name="keyWord" />
						<input type="submit" class="button" value="查询"/>
					</td>
				</tr>
	        </table>
        </form>
          <table>
            <thead>
              <tr>
                <th>用户ID</th>
                <th>内容</th>
                <th>时间</th>
                <th>回复内容</th>
                <th>操作</th>
              </tr>
            </thead>
            <tfoot>
              <tr>
                <td colspan="6">
                  <div class="pagination"> 
                  <a href="#" title="First Page">&laquo; First</a>
                  <a href="#" title="Previous Page">&laquo; Previous</a> 
                  <a href="#" class="number" title="1">1</a> <a href="#" class="number" title="2">2</a> <a href="#" class="number current" title="3">3</a> <a href="#" class="number" title="4">4</a> <a href="#" title="Next Page">Next &raquo;</a><a href="#" title="Last Page">Last &raquo;</a> </div>
                  <!-- End .pagination -->
                  <div class="clear"></div>
                </td>
              </tr>
            </tfoot>
            <tbody>
            <s:iterator value="msgList" var="message">
            	<tr>
					<td>
						<s:property value="#message.userInfo.userId" />
					</td>
					<td>
						<s:property value="#message.messageContent" />
					</td>
					
					<td>
						<s:property value="#message.messageTime" />
					</td>
					<td>
						<s:property value="#message.messageReply" />
					</td>
					<td>
					<a href="<%=basePath %>DeleteMsgInfoAction.action?messageID=<s:property value="#message.messageId" />"><img src="images/icons/cross.png" alt="Delete" /></a>
					<a href="<%=basePath %>EditReplyAction.action?messageID=<s:property value="#message.messageId" />"><img src="images/icons/pencil.png" alt="Edit" /></a>
					</td>
				</tr>
            </s:iterator>
            </tbody>
          </table>
        </div>
      </div>
    </div>
    
    <div class="clear"></div>
    
    <s:include value="/footer.jsp"></s:include>
  </div>
  </body>
</html>
