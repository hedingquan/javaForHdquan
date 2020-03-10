<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
	<script type="text/javascript">
	$(function(){
			$("a").click(function(){
			$("img").attr("src","validcode?date"+new Date())
			return false;
			})	
	
	})
	</script>
  </head>
  
  <body>
  ${error}
  	action="${PageContext.request.contextPath }/form1.action"
  <form action="login" method="post">
  	用户名<input type="text" name="username"/><br/>
  	密码<input type="password" name="password"/><br/>
  	验证码<input type="text" size="1" name="code"/>  <img src="validcode" width="80" height="40"/><a href="">看不清</a><br/>
  	<input type="submit" value="登录"/><input type="reset" value="重置"/>
  </form>
  </body>
</html>
