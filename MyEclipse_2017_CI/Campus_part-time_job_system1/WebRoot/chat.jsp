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
	
<script type="text/javascript" src="js/jquery.min.js" charset="uft-8"></script> 
<script type="text/javascript">
	var user_name=${user_name};
			var ws;
  		var target="ws://localhost:8080/Campus_part-time_job_system1/chatSocket?user_name="+user_name;
	window.onload=function()
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
           eval("var msg="+event.data+";");
           if(undefined!=msg.welcome)
           $('#content').append(msg.welcome);
           
           if(undefined!=msg.usernames)
	           {
		           $('#userlist').html("");
		           $(msg.usernames).each(function(){
		           	$('#userlist').append("<input type=checkbox value='"+this+"'/>"+this+"<br/>");
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
	var ss=$("input[type='checkbox']:checked");
	var msg=document.getElementById("msg").value;
	console.info(ss.size());
	if(ss.size()==0)
	{
		var obj={
			msg : msg,
			type : 1
		}					
				var str=JSON.stringify(obj);
						ws.send(str);
						$("#msg").val("");
	}else{
	var to=$("input[type='checkbox']:checked").each(function() {
					var obj={
						to : $(this).val(),
						msg : msg,
						type : 2
					}
						var str=JSON.stringify(obj);
						ws.send(str);
						$("#msg").val("");
				});
	}
	}
</script>

  </head>
  
  <body>
 <div style="background-color:#333;margin:0 auto;">
	<div style="width:80%;height:100%;float:left;">
		<div id="content">
		</div>
	<div id="a" style='width:80%;height:30px;position:absolute;bottom:0px'>
	当前用户：${user_name}
		<input type="text" id="msg" style='width:850px'/>
		<button onclick="subSend();">发送</button>
	</div>
	</div>
	<div style="width:20%;height:30px;float:right;">
		当前在线用户或商家如下表：
		<div id="userlist"></div>
	</div>
</div>

  </body>
</html>
