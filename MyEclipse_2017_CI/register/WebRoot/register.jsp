<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
  <script type="text/javascript">
  $(function(){
  var username=false;
  var password=false;
  var passwordSure=false;
  //用户名的验证
 	$(":text:eq(0)").blur(function(){
 	if($(this).val()==""){
 		$(this).next().css("color","red").html("X");
 		username=false;
 	}
 	else{
 	$(this).next().css("color","green").html("√");
 	username=true;
 	}
 	});
 	//密码的验证
 	$(":password:eq(0)").blur(function(){
 	//在js中要求正则两侧//
 	// ^表示开始标记，$表示结束标记
 	if(!$(this).val().match(/^\w{6,12}$/)){
 		$(this).next().css("color","red").html("X");
 		password=false;
 	}
 	else{
 	$(this).next().css("color","green").html("√");
 	password=true;
 	}
 	});
 	//确认密码
 	$(":password:eq(1)").blur(function(){
 		if($(this).val()==""||$(this).val()!=$(":password:eq(0)").val()){
 		$(this).next().css("color","red").html("X");
 		passwordSure=false;
 	}
 	else{
 	$(this).next().css("color","green").html("√");
 	passwordSure=true;
 	}
 	});
 	
 	
 	//file只能读，不能写
 	$(":submit").click(function(){
 		alert($(":file:eq(0)").val());
 		if(username==false||password==false||passwordSure==false||$(":file").val()=="")
 		{
 		alert("请填写完整信息");
 		return false;
 		}
 	});
  });
  </script>
  </head>
  
  <body>
	<form action="register" enctype="multipart/form-data" method="post">
		用户名：<input type="text" name="username"/><span></span><br/>
		密码：<input type="password" name="password"/><span></span><br/>
		确认密码：<input type="password" name="passwordSure"/><span></span><br/>
		头像：<input type="file" name="file"><br/>
		 <input type="submit" value="注册"/>
	</form>
  </body>
</html>
