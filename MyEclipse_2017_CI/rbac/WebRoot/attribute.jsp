<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//ServletContext:application
		application.setAttribute("name", "zs");//新增application属性
		application.setAttribute("name", "ls");//替换属性
		application.removeAttribute("name");//删除属性
		
			session.setAttribute("user", "user");
			session.setAttribute("name", "ls");
			session.removeAttribute("name");
	 %>
</body>
</html>