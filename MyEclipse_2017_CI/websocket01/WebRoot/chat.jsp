<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'chat.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<script type="text/javascript">
	

	var username=${sessionScope.username};
			var ws;//一个ws对象就是一个通信管道！！
  		var target="ws://localhost:8080/websocket01/chatSocket?username="+username;
	window.onload=function()
	{
	//进入聊天页面，就打开socket通道
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
           eval("var msg="+event.data+";");
           if(undefined!=msg.welcome)
           $('#content').append(msg.welcome);
           
           if(undefined!=msg.usernames)
	           {
		           $('#userlist').html("");
		           $(msg.usernames).each(function(){
		           	$('#userlist').append("<input type=checkbox value='"+this+"'/>"++this+"<br/>");
		           });
	           }
	           if(undefined!=content)
	           {
	           $('#content').append(msg.content);
	           }
           }
	}
	function subSend()
	{
	var ss=$("#userlist:checked");
	var val=$("#msg").val();
	if(ss.size()==0)
	{
		var obj={
			msg : val,
			type : 1//1广播  2单聊
		}
	}else{
	var to=$("#userlist:checked").val();//找到userlist下选中checked的
		var obj={
			to : to,
			msg : val,
			type : 2//1广播  2单聊
		}
	}
	var str=JSON.stringify(obj);
	
	ws.send(str);
	$("#msg").val("");
	}
</script>

  </head>
  
  <body>
	<div id="content">
	</div>
	<div>
		<div id="msg"/>
		<button onclick="subSend();">send</button>
	</div>
	<div id="userlist"></div>
  </body>
</html>
