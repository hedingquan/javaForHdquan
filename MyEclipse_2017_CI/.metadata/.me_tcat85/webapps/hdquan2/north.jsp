<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'north.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 	 <meta http-equiv="content-type" content="text/html;" charset="UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-773" data-genuitec-path="/hdquan2/WebRoot/north.jsp">
  <div style="position:absolute; right:0px; buttom:0px;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-773" data-genuitec-path="/hdquan2/WebRoot/north.jsp">
  	<a href="javascript:void(0);" class="easyui-menubutton" menu="#layout_north_kzmbMenu" iconCls="icon-help">控制面板</a>
  	<a></a>
  </div>
  <div id="layout_north_kzmbMenu" syle="width:100px; display:none;">
  	<div onclick="">个人信息</div>
  	<div class="menu-sep"></div>
  	<div>
  		<span>更换主题</span>
  		<div style="width:120px;">
  			<div onclick="changeTheme('default');">default</div>
  			<div onclick="changeTheme('ui-cupertino');">ui-cupertino</div>
  			<div onclick="changeTheme('ui-dark-hive');">ui-dark-hive</div>
  			<div onclick="changeTheme('ui-pepper-grinder');">ui-pepper-grinder</div>
  			<div onclick="changeTheme('ui-sunny');">ui-sunny</div>
  		</div>
  	</div>
  </div>
  <div id="layout_north_zxMenu" style="width:100px; display:none;">
  	<div onclick="loginAndRegDialog.dialog('open');">锁定窗口</div>
  	<div class="menu-sep"></div>
  	<div onclick="logout();">重新登录</div>
  	<div onclick="logout(true);">退出系统</div>
  </div>
  </body>
</html>
