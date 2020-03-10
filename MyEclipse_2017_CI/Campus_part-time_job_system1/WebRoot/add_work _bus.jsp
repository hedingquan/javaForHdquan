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
		添加工作项目
		<form action="add_work_bus.action" method="post" style="text-align:center">
		商家用户名：<input type="text" name="user_name" value="${user_name }"/><br/><br/>
		工作标题：<input type="text" name="work_title"/><br/><br/>
		工作时长：<input type="text" name="work_time"/><br/><br/>
		工作薪酬：<input type="text" name="work_money"/><br/><br/>
		工作地点：<input type="text" name="work_place"/><br/><br/>
		工作人数：<input type="text" name="work_number"/><br/><br/>
		工作描述：<input type="text" name="work_description"/><br/><br/>
		<input type="submit" value="发布工作">	<br/>
		</form>
  </body>
</html>
