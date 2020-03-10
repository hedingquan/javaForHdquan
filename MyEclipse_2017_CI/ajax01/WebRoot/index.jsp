<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function register()
	{
		var mobile=document.getElementById("mobile").value;
		//通过ajax异步请求服务端
		xmlHttpRequest=new XMLHttpRequest();//没加var表示为全局变量
		//设置xmlHttpRequest对象的回调函数
		xmlHttpRequest.onreadystatechange=callBack;//不需要写括号
		xmlHttpRequest.open("post","MobileServlet",true);//--post变为get
		//xmlHttpRequest.open("post","MobileServlet?mobile="+mobile,true);--get方式
		//设置post方式的头信息,get不需要
		xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlHttpRequest.send("mobile="+mobile);//k=v
		//xmlHttpRequest.send(null);--get方式
	}
	//定义回调函数，接受服务器端的返回值
	function callBack()
	{
		if(xmlHttpRequest.readyState==4&&xmlHttpRequest.status==200)
		{//接受服务器端的数据
		var data=xmlHttpRequest.responseText;//服务器端返回值为String格式
			if(data=="true")
			{
			alert("号码已存在，请更换");
			}else
			{
				alert("注册成功！");
			}
		}
	} 
</script>

<title>Insert title here</title>
</head>
<body>
		手机<input id="mobile"/>
		<br/>
		<input type="button" value="注册" onclick="register()"/>
</body>
</html>