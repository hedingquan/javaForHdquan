<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript">
  		var ws;//一个ws对象就是一个通信管道！！
  		var target="ws://localhost:8080/websocket01/echo";
  		function subOpen()
  		{
  		  if ('WebSocket' in window) {
                ws = new WebSocket(target);
            } else if ('MozWebSocket' in window) {
                ws = new MozWebSocket(target);
            } else {
                alert('WebSocket is not supported by this browser.');
                return;
            }
            	ws.onmessage=function(event)
		  		{
		  	var dv=	document.getElementById("dv");
		  	dv.innerHTML+=event.data;
		  		console.info(event);
		  		};
  		}
  	
  		function subSend()
  		{
  			var msg=document.getElementById("msg").value;
  			ws.send(msg);
  			document.getElementById("msg").value='';
  		}
  </script>
  <body>
  	<button onclick="subOpen();">开启管道,open</button>
  	<input id="msg"/><button onclick="subSend();">send</button>
 	<div id="dv"></div>
  </body>
</html>
