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
    
    <title>My JSP 'OnLine.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	
			
		var list = '<%=request.getAttribute("list")%>';
		console.info(list);
</script>
  </head>
  
  <body>
 								  <table border="1">
								  <tr>
								  <th>id</th>
								  <th>startTimestamp</th>
								  <th>host</th>
								  <th>lastAccessTime</th>
								    <th>登录用户</th>
								  </tr>
								  <c:forEach items="${requestScope.list}" var="Onelist">
								  <tr>
								  <td>${Onelist.id}</td>
								   <td>${Onelist.startTimestamp}</td>
								    <td>${Onelist.host}</td>
								     <td>${Onelist.lastAccessTime}</td>
								      <td>${Onelist.use}</td>
								  </tr>
								  </c:forEach>
								  </table>
  </body>
</html>
