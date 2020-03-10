<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
				<tr>
					<td>真实姓名(不能为空，没有其他要求)</td>
					<td><input type="text" id="realname" name="realname"></td>
				</tr>
				<tr>
					<td>登录名</td>
					<td><input type="text" id="username" name="username"></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" id="psw" name="password"></td>
				</tr>
				<tr>
					<td>重复密码</td>
					<td><input type="password" id="psw2" name="password2"></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="radio" id="gender_male" value="m" name="gender"/>男
					<td><input type="radio" id="gender_female" value="f" name="gender"/>女
				</tr>
				<tr>
					<td>身份证</td>
					<td><input type="text" id="cart" size="20"></td>
				</tr>
	</table>
		<input type="button" id="ok" value="提交" onclick="a();"/>
 </body>
  
 <script language="JavaScript">
 	/* 	window.onload=function()
 		{ */
 			document.getElementById("ok").onclick=function()
 			{
 				alert("你的真实姓名不能为空");
 				var realname=document.getElementById("realname");
 				if(realname==""||realmname=='null'||realname=='undefined')
 				{
 			document.getElementById("realname").focus();//焦点
 				return false;
 				}
 						}
 		
 	
 </script>
</html>