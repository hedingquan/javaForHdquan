<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<form action="register.action" method="post" onsubmit="return checkip()">
		用户名&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text" name="user_name" id="user_name"/><br/>
		身份证&nbsp;&nbsp;&nbsp;&nbsp;：<input type="text" name="user_ID" id="user_ID"/><br/>
		密码&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;：<input type="password" name="user_password" id="user_password"/><br/>
		确认密码：<input type="password" name="accOutPassword" id="user_password1"/><br/>
		用户类型<input name="user_type" type="radio" value="0" />学生
				<input name="user_type" type="radio" value="1" />商家
		<br/>
		<input type="submit" value="注册">	<br/>
	</form>
	<script type="text/javascript" src="js/jquery.min.js" charset="uft-8"></script> 
	 <script type="text/javascript">
	 function checkip()
	 {
		 var str="";
		  if($.trim($('#user_name').val()).length == 0) { 
			  str += '用户名没有输入\n';
			  $('#user_name').focus();
			     alert(str);
			     return false;
			 }
		 if($.trim($('#user_ID').val()).length == 0) { 
			  str += '身份证号码没有输入\n';
			  $('#user_ID').focus();
			     alert(str);
			     return false;
			 } else {
				  if(isCardNo($.trim($('#user_ID').val())) == false) {
				   str += '身份证号不正确；\n';
				   $('#user_ID').focus();
				      alert(str);
				      return false;
				  }
			 }
			  if($.trim($('#user_password').val()).length == 0) { 
			  str += '密码没有输入\n';
			  $('#user_password').focus();
			     alert(str);
			     return false;
			 }else{
					if( $.trim($('#user_password').val()) != $.trim($('#user_password1').val()))
						 {
						 str += '两次输入的密码不一致\n';
						  $('#user_password').focus();
						     alert(str);
						     return false;
						 }
				 }
		}
	 
	 function isCardNo(card) { 
		 var pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
		 return pattern.test(card); 
		}
	 </script>
  </body>
</html>
