<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="content-type" content="text/html;" charset="UTF-8">
  	<script type="text/javascript" src="js/jquery-easyui-1.8.2/jquery.min.js" charset="uft-8"></script> 
  	<script type="text/javascript" src="js/jquery.cookie.js" charset="UTF-8"></script>
  	    <%
		//从cookies中读取主题名称
		String easyuiThemeName = "default";
		Cookie cookies[] = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for(int i=0; i<cookies.length; i++){
				if(cookies[i].getName().equals("easyuiThemeName")){
					easyuiThemeName = cookies[i].getValue();
					break;
				}
			}
		}
     %>
  <link id="easyuiTheme" rel="stylesheet" type="text/css" href="js/jquery-easyui-1.8.2/themes/<%=easyuiThemeName%>/easyui.css">   <%--   即索引的样式--%>
   <link rel="stylesheet" href="js/jquery-easyui-1.8.2/themes/icon.css" type="text/css" charset="uft-8"> 
  	<script type="text/javascript" src="js/jquery-easyui-1.8.2/jquery.easyui.min.js" charset="uft-8"></script>
     <script type="text/javascript" src="js/jquery-easyui-1.8.2/locale/easyui-lang-zh_CN.js" charset="uft-8"></script> 
   <link rel="stylesheet" href="js/jquery-easyui-1.8.2/themes/gray/easyui.css" type="text/css" charset="uft-8">
     <script type="text/javascript" src="js/syUtils.js" charset="uft-8"></script> 
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0" data-genuitec-path="/hdquan2/WebRoot/BaseJsp.jsp">
  </body>
</html>