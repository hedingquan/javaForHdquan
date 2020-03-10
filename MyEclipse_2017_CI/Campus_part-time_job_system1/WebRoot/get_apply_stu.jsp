<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		我申请的工作
		<div style="text-align: center">
			<table border="1" style="margin: auto">
			<tr>
				<td>学生ID</td>
				<td>申请状态</td>
				<td>工作标题</td>
			</tr>
			<c:forEach items="${apply }" var="apply">
				<tr>
					<td>${apply.user_id }</td>
					<td>${apply.apply_state }</td>
					<td>${apply.work_id }</td>
				</tr>
			</c:forEach>
			</table>
			<a href="add_apply.jsp">返回</a>
		</div>
  </body>
</html>
