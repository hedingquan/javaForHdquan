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
    
    <title>My JSP 'add_point.jsp' starting page</title>
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
	  function add_point(a)
	  {
	 var work_id=document.getElementById("work").value;
	 console.info(work_id);
	  var point_score=document.getElementById("point_score").value;
	  	   a.href = 'add_point.action?work_id='+work_id+'&point_score='+point_score;
	}
	 </script>
  </head>
  
  <body>
    添加评分<br>
    	<h3 style="text-align: center">未添加评分的工作名称：
    		<select id="work" >
    				<c:forEach items="${work }" var="work">
						<option value="${work.work_id }">${work.work_title }</option>
					</c:forEach>
            </select>
            <br/>
                  评分：<input type="text" id="point_score"> <br/>
     <a href="void(0)" onclick="add_point(this)">确定</a>
            </h3>
  </body>
</html>
