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
		个人信息
		<h3 style="text-align:center">个人信息</h3>
		<table border="1">
			<tr>
				<td>用户名</td>   <td>${user_name}</td>
			</tr>
			<tr>
				<td>身份证</td> 	<td>${user_ID}</td>
			</tr>
			<tr>
				<td>密码</td> 	<td>${user_password}</td>
			</tr>
			<tr>
				<td>用户类型</td> 	<td>${user_type}</td>
			</tr>
	</table>
  </body>
</html>
