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
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-21" data-genuitec-path="/Campus_part-time_job_system/WebRoot/login.jsp">
  <div style="text-align: center;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-21" data-genuitec-path="/Campus_part-time_job_system/WebRoot/login.jsp">
  	<img alt="" src="/Campus_part-time_job_system/image/1.png">
  	<form action="login.action" method="post">
		账号：<input type="text" name="user_name"/>
		密码：<input type="password" name="user_password"/>
		<input type="submit" value="登录">	<br/>
	</form>
		<a href="register.jsp">新用户注册</a><br/>
			<a href="register.jsp">忘记密码</a>
	</div>
			<a href="register.jsp">如果身份为管理员，请点击这里</a>
  </body>
</html>
