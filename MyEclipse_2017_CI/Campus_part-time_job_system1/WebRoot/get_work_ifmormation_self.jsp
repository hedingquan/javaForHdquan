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
		查询参与的平台
		<div style="text-align: center">
			<table border="1" style="margin: auto">
				<tr>	
			<td> 商家用户名</td>
			<td> 工作标题</td>
			<td> 工作时长</td>
			<td> 工作薪酬</td>
			<td> 工作地点</td>
			<td> 工作人数</td>
			<td> 工作状态</td>
			<td> 删除工作（仅商家未开始可删）</td>
			<td> 删除学生（仅商家未开始可删）</td>
			<td> 修改工作（仅商家未开始可删）</td>
				</tr>
			<c:forEach items="${work }" var="work">
			<tr>	
				<td> ${work.user_id }</td>
				<td> ${work.work_title }</td>
				<td> ${work.work_time }</td>
				<td> ${work.work_money }</td>
				<td> ${work.work_place }</td>
				<td> ${work.work_number }</td>
				<td> ${work.work_state }</td>
				<td><a href="delete_work.action?work_id=${work.work_id }">删除工作</a></td>
				<td><a href="delete_work_stu.jsp?work_id=${work.work_id }&work_title=${work.work_title }&work_time=${work.work_time }&work_money=${work.work_money }&work_place=${work.work_place }&work_content=${work.work_content }">删除学生</a></td>
				<td><a href="Search_work_state.action?work_id=${work.work_id }">修改工作</a></td>
			</tr>
			</c:forEach>
			</table>
		</div>
  </body>
</html>