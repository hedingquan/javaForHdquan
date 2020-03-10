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
    
    <title>My JSP 'index.jsp' starting page</title>
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
  <table border="1">
  	<tr>
  	<th>编号</th>
  	<th>姓名</th>
  	<th>年龄</th>
  	</tr>
<c:forEach items="${PageInfo.list }" var="pi">
  	<tr>
  	<td>${pi.id}</td>
  		<td>${pi.name}</td>
  			<td>${pi.price}</td>
  			<td>${pi.production}</td>
  	</tr>
  	</c:forEach>
  </table>
  
  <a href="page?pageNumber=${PageInfo.pageNumber-1 }&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.pageNumber<=1}"> onclick="javascript:return false;"</c:if> >上一页</a>
  <a href="page?pageNumber=${PageInfo.pageNumber+1 }&pageSize=${PageInfo.pageSize}" <c:if test="${PageInfo.pageNumber>=PageInfo.total}"> onclick="javascript:return false;"</c:if> >下一页</a>
  </body>
</html>
