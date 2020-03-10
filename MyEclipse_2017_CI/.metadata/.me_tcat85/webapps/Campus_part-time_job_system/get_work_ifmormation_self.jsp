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

  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-17" data-genuitec-path="/Campus_part-time_job_system/WebRoot/get_work_ifmormation_self.jsp">
		查询参与的平台
		<div style="text-align: center" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-17" data-genuitec-path="/Campus_part-time_job_system/WebRoot/get_work_ifmormation_self.jsp">
			<table border="1" style="margin: auto">
				<tr>	
			<td> 商家用户名</td>
			<td> 工作标题</td>
			<td> 工作时长</td>
			<td> 工作薪酬</td>
			<td> 工作地点</td>
			<td> 工作人数</td>
			<td> 工作状态</td>
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
				<td><a href="download?user_id=${work.work_id }">删除工作</a></td>
				<td><a href="download?user_id=${work.work_id }">删除学生</a></td>
				<td><a href="download?user_id=${work.work_id }">修改工作</a></td>
			</tr>
			</c:forEach>
			</table>
		</div>
  </body>
</html>
