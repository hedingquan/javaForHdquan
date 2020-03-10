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
	<form action="upload" enctype="multipart/form-data" method="post">
		姓名：<input type="text" name="name"/><br/>
		文件：<input type="file" name="file"/><br/>
		<input type="submit" value="提交"/>
	</form>
  </body>
</html>
