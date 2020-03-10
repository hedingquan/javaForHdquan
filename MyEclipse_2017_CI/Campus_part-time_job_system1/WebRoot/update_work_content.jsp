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
		修改工作内容
		<div style="text-align: center">
			<table border="1" style="margin: auto">
			<tr>
				<td>工作标题</td>
				<td>${Ready_update_work.work_title }</td>
			</tr>
			<tr>	
				<td>工作时长</td>
				<td>${Ready_update_work.work_time }</td>
			</tr>
			<tr>		
				<td>工作薪酬</td>
				<td>${Ready_update_work.work_money }</td>
			</tr>
			<tr>		
				<td>工作地点</td>
				<td>${Ready_update_work.work_place }</td>
			</tr>
			<tr>		
				<td>工作人数</td>
				<td>${Ready_update_work.work_number }</td>
			</tr>	
			<tr>		
				<td>工作描述</td>
				<td>${Ready_update_work.work_description }</td>
			</tr>	
			</table>
			
		<form action="update_work_content.action" method="post" style="text-align:center">
		工作标题：<input type="text" name="work_title"/><br/>
		工作时长：<input type="text" name="work_time"/><br/>
		工作薪酬：<input type="text" name="work_money"/><br/>
		工作地点：<input type="text" name="work_place"/><br/>
		工作人数：<input type="text" name="work_number"/><br/>
		工作描述：<input type="text" name="work_description"/><br/>
		<input type="submit" value="确认修改">	<br/>
		</form>
		</div>
  </body>
</html>
