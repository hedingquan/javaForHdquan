<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div style="text-align: center;">
  	<img alt="" src="/Campus_part-time_job_system1/image/1.png">
  	<form action="login.action" method="post">
		账号：<input type="text" name="user_name"/>
		密码：<input type="password" name="user_password"/>
		<input type="submit" value="登录">	<br/>
	</form>
		<a href="register.jsp">新用户注册</a><br/>
			<a href="forget_password.jsp">忘记密码</a>
	</div>
			<a href="login.jsp">如果身份为管理员，请点击这里</a>
  </body>
</html>
