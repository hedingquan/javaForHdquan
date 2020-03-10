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
String ation=(String)request.getAttribute("Ation");
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
	<script type="text/javascript" src="js/jquery.min.js" charset="uft-8"></script> 
	 <script type="text/javascript">
	 if('<%=ation%>'!=null&&'<%=ation%>'!='null')
	 {
	 alert('<%=ation%>');
	 }
	   function getkey(a) {
	    if(<%=notCuser%>)
			  {	
	        var work_title= $("#work_title").val();
			  a.href = 'Search_work_state.action?work_title=' + work_title;
			  }else
			  {
			   a.href='Anothererror.jsp';
			  }
		  }
		  function addwork(a)
		  {
		  if(<%=notCuser%>)
		  {		  
		   a.href='add_work _bus.jsp';
		  }else{
		   a.href='Anothererror.jsp';
		  }
		  }
		  
		   function work(a,b) {
	    if(<%=notCuser%>)
			  {	
			  a.href = 'get_work_ifmormation_self2.action?a='+b;
			  }else
			  {
			   a.href='Anothererror.jsp';
			  }
		  }
	 </script>
  </head>
  
  <body>
		工作主界面
		<h3 style="text-align:center">
		<a href="void(0)" onclick="addwork(this)">添加工作</a></h3>
		<div style="text-align:center">
			<h3 style="text-align:center">
			请填写需要修改的工作标题：<input type="text" id="work_title">
			<a href="void(0)" onclick="getkey(this)">修改工作</a>
			</h3>
		</div>
		<a href="get_work_iformation.action"><h3 style="text-align:center">查询平台所有工作界面</h3></a>
		<a href="get_work_ifmormation_self.action"><h3 style="text-align:center">查询参与工作</h3></a>
		<a href="void(0)" onclick="work(this,1)"><h3 style="text-align:center">开始工作</h3></a>
		<a href="void(0)" onclick="work(this,2)"><h3 style="text-align:center">结束工作</h3></a>
  </body>
</html>
