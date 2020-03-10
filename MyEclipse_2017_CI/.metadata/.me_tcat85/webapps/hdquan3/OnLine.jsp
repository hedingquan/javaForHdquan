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
    
    <title>My JSP 'OnLine.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	
			
		var list = '<%=request.getAttribute("list")%>';
		console.info(list);
</script>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/hdquan3/WebRoot/OnLine.jsp">
 								  <table border="1" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/hdquan3/WebRoot/OnLine.jsp">
								  <tr>
								  <th>id</th>
								  <th>startTimestamp</th>
								  <th>host</th>
								  <th>lastAccessTime</th>
								    <th>登录用户</th>
								  </tr>
								  <c:forEach items="${requestScope.list}" var="Onelist">
								  <tr>
								  <td>${Onelist.id}</td>
								   <td>${Onelist.startTimestamp}</td>
								    <td>${Onelist.host}</td>
								     <td>${Onelist.lastAccessTime}</td>
								      <td>${Onelist.use}</td>
								  </tr>
								  </c:forEach>
								  </table>
  </body>
</html>
