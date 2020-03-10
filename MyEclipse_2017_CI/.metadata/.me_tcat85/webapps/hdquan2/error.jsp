<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<jsp:include page="BaseJsp.jsp" />
		
  <script type="text/javascript">
  
  $(function()
  {
		$.messager.show({
			title:'温馨提示',
			msg:${exe},
			timeout:5000,
			showType:'slide'
					});
  })
  </script>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-6" data-genuitec-path="/hdquan2/WebRoot/error.jsp">
 抱歉，权限认证失败
   </body>
</html>
