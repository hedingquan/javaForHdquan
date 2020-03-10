<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
  <script type="text/javascript">
  	$(function(){
  		$.post("show",function(data){
  			var result="";
  			for(var i=0;i<data.length;i++)
  			{
  			result+="<dl>";
  			result+="<dt style='cursor:pointer'>"+data[i].name+"</dt>";
  			for(var j=0;j<data[i].children.length;j++)
  			{
  			result+="<dd>"+data[i].children[j].name+"</dd>";
  			}
  			result+="<dl>";
  			}
  			$("body").html(result);
  		});
  		
  		//对所有父菜单添加点击事件--静态绑定事件（没办法起作用）-因为只加载一次dt，后面不再加载
  		//	$("dt").click(function(){
  		//	alert("adsf");
  		//});
  		//live("事件名,多个事件使用空格分割",function(){})--动态绑定事件（不管是先添加dt还是后添加dt）
  		$("dt").live("click",function(){
  		//slow  normal fast 数值   		若写成“5000”的形式走“normal”的
  			$(this).siblings().slideToggle(1);
  		});
  	})
  </script>
   	<title></title>
  </head>
  
  <body>

  </body>
</html>
