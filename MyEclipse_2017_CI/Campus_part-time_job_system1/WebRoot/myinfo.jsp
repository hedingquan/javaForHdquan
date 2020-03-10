<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myinfo.jsp' starting page</title>
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
		个人信息主页面
		<a href="Search_myinfo.action"><h3 style="text-align:center">个人信息查询</h3></a>
		<a href="cancel.jsp"><h3 style="text-align:center">账号注销</h3></a>
		<a href="change_password.jsp"><h3 style="text-align:center">修改密码</h3></a>
		<a href="change_myinfo.jsp"><h3 style="text-align:center">个人信息修改</h3></a>
		<a href="chat.jsp"><h3 style="text-align:center">前往聊天</h3></a>
		<a href="work.jsp"><h3 style="text-align:center">前往工作主页面</h3></a>
		<a href="add_apply.jsp"><h3 style="text-align:center">前往申请主页面</h3></a>
		<a href="point.jsp"><h3 style="text-align:center">前往评分主页面</h3></a>
  </body>
</html>
