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

		<title>编辑回复</title>
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
				if($("#content").val()==""){
					alert("内容不能为空!");
					return false;
				}
				return true;
			}
			function deletebutton(){
				form = document.forms[0];
	    		form.action = "<%=basePath %>DelReplyAction.action?messageID=${messageID }";
	    		form.submit();
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
        <h3>回复</h3>
        <div class="clear"></div>
      </div>
      <!-- End .content-box-header -->
      <div class="tab-content default-tab">
        <div class="tab-content">
          <form onsubmit="return validate();" action="<%=basePath %>UpdReplyAction.action?messageID=${msgInfo.messageId}" method="post">
            <fieldset>
            <h4>留言</h4>
            <p>${msgInfo.messageContent }</p>
            <p>
              <label>回复</label>
              <textarea class="text-input textarea wysiwyg" id="content" name="msgInfo.messageReply" cols="79" rows="15">${msgInfo.messageReply}</textarea>
            </p>
            <p>
              <tr>
    			<td><input class="button" type="submit" value="保存"></td>
    			<td>
    			<input class="button" type="button" onclick="deletebutton()" value="删除">
    			<input type="hidden" name="msgInfo.messageId" value="${msgInfo.messageId }"/>
    			<input type="hidden" name="msgInfo.userInfo.userId" value="${msgInfo.userInfo.userId }"/>
    			<input type="hidden" name="msgInfo.messageTime" value="${msgInfo.messageTime }"/>
    			<input type="hidden" name="msgInfo.messageContent" value="${msgInfo.messageContent }"/>
    			</td>
    		  </tr>
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
