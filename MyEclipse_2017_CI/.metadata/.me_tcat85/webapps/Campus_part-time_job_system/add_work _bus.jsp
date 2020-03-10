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

  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-3" data-genuitec-path="/Campus_part-time_job_system/WebRoot/add_work _bus.jsp">
		添加工作项目
		<form action="add_work_bus.action" method="post" style="text-align:center" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-3" data-genuitec-path="/Campus_part-time_job_system/WebRoot/add_work _bus.jsp">
		商家用户名：<input type="text" name="user_name" value="${user_name }"/><br/><br/>
		工作标题：<input type="text" name="work_title"/><br/><br/>
		工作时长：<input type="text" name="work_time"/><br/><br/>
		工作薪酬：<input type="text" name="work_money"/><br/><br/>
		工作地点：<input type="text" name="work_place"/><br/><br/>
		工作人数：<input type="text" name="work_number"/><br/><br/>
		<input type="submit" value="发布工作">	<br/>
		</form>
  </body>
</html>
