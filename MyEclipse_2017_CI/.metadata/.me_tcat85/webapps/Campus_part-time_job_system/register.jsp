<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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

  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-24" data-genuitec-path="/Campus_part-time_job_system/WebRoot/register.jsp">
  	<form action="register.action" method="post" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-24" data-genuitec-path="/Campus_part-time_job_system/WebRoot/register.jsp">
		用户名&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text" name="user_name"/><br/>
		身份证&nbsp;&nbsp;&nbsp;&nbsp;：<input type="password" name="user_ID"/><br/>
		密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input type="password" name="user_password"/><br/>
		确认密码：<input type="password" name="accOutPassword"/><br/>
		用户类型<input name="user_type" type="radio" value="0" />学生
				<input name="user_type" type="radio" value="1" />商家
		<br/>
		<input type="submit" value="注册">	<br/>
	</form>
  </body>
</html>
