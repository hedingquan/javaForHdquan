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
    
    <title>My JSP 'add_point.jsp' starting page</title>
      <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery.min.js" charset="uft-8"></script> 
	 <script type="text/javascript">
	  function delete_point(a)
	  {
		 var point_id=document.getElementById("point").value;
		  a.href = 'delete_point.action?point_id=' + point_id;
	}
	 </script>
  </head>
  
  <body>
    删除评分<br>
    	<h3 style="text-align: center">需要删除评分商家：	
    		<select id="point" >
    				<c:forEach items="${point }" var="point">
						<option value="${point.point_id }">商家ID：${point.user_id2 }-您的评分为：${point.point_score }</option>
					</c:forEach>
            </select>
    <a href="void(0)" onclick="delete_point(this)">确定</a>
            </h3>
  </body>
</html>
