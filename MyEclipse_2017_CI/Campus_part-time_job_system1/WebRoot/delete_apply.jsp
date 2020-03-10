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
<script type="text/javascript" src="js/jquery.min.js" charset="uft-8"></script> 
	 <script type="text/javascript">
	  function delete_Apply()
	  {
	  var to=$("input[type='checkbox']:checked").each(function() {
	 		  $.ajax({ 
				url:"delete_apply.action",
				data: {applyids:$(this).val()}
				})
					});
	}
	 </script>
  </head>
  
  <body>
  	工作申请列表<br/>
  	挑选需要删除申请的<br/>
		<div style="text-align: center">
			<table border="1" style="margin: auto">
			<c:forEach items="${apply }" var="apply">
				<input name="students" type="checkbox" value="${apply.apply_id }"/>学生用户名：${apply.user_id }--工作ID：${apply.work_id}<br/>
			</c:forEach>
			</table>
			<button onclick="delete_Apply();">删除</button>
		</div>
  </body>
</html>
