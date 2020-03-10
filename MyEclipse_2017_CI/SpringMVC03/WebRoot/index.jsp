<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
	request:${requestScope.req }<br/>
	session:${sessionScope.session }<br/>
	sessionParam:${sessionScope.sessionParam }<br/>
	application:${applicationScope.application } <br/>
	<hr/>
	map:${requestScope.map }
	<hr/>
	model:${model }
	<hr/>
	mav:${requestScope.mav }
  </body>
</html>
