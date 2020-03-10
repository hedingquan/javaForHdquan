<%@page import="com.pojo.Cuser"%>
<%@page import="com.pojo.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user=(User)request.getServletContext().getAttribute("user");
boolean notCuser=true;
if(user instanceof Cuser)
{
notCuser=false;
}
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
<script type="text/javascript" src="js/jquery.min.js" charset="uft-8"></script> 
	 <script type="text/javascript">
	   function SearchAppalyUser(a)
		  {
			  if(<%=notCuser%>)
			  {		  
			   a.href='getApply.action';
			  }else{
			   a.href='Anothererror.jsp';
			  }
		  }
	 
	 </script>
  </head>
  
  <body>
		申请主页面
		<a href="void(0)" onclick="SearchAppalyUser(this)"><h3 style="text-align:center">查询申请工作学生</h3></a>
		<a href="getMyApply.action"><h3 style="text-align:center">查询我的申请工作</h3></a>
		<a href="getAllApply.action"><h3 style="text-align:center">删除申请学生</h3></a>
  </body>
</html>
