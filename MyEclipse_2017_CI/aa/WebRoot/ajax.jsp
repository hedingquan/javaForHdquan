<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
$("#tip").load(
	"MobileServlet",
	"mobile="+$mobile,
	function(result){
			<!-- 	if(result=="true"){
				alert("已存在！注册失败！");
				}else
				{alert("注册成功！");
				} -->
			}
		);
</head>
<body>
	手机：<input id="mobile"/>
	<br/>
	<input type="button" value="注册" onclick="register()"/>
	<span id="tip"></span>
</body>
</html>