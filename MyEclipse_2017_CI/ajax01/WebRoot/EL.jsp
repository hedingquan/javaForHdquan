<%@page import="com.hdquan.entity.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	<% %>  
		Student student=(Student)request.getAttribute("student");
		out.print(student+"11<br/>");
		out.print(student.getName()+"22<br/>");
		out.print(student.getAge()+"33<br/>");
		 -->  
	 --------------request域中(requestScope)
	 ${requestScope.student }<br/>
	  ${requestScope.student.name }<br/>
	   ${requestScope.student.age }<br/>
	    ${requestScope["student"]["age"] }<br/>
	    
	    	 ${requestScope['my-name'] }<br/>
	    	 
	    	 ----------hobbies---<br/>
	    	 ${requestScope.hobbies[0] }
	    	  ${requestScope.hobbies[2] }<br/>
	    	  
	    	  -----map---<br/>
	    	  ${requestScope.map.cn }
	    	  ${requestScope.map["us"]}<br/>
	    	  ---运算-----<br/>
	    	  ${3>2 }、${3 gt 2 }、 <br/>
	    	   ${3>2 || 3<2 },${3>2 or 3<2 }<br/>
	    	   ---empty<br/>
	    	   ${empty requestScope["my-name"] }<br/>
	    	  不存在的值：  ${empty requestScope["hini"] }<br/>
	    	  ${empty requestScope.nullValue }<br/>
	    	  
	    	  ----session--<br/>
	    	  ${sessionScope.sessionKey }<br/>
	    	  ---默认找域---
	    	  ${sessionKey }<br/>
	  
	    	    ----获取参数--<br/>
	    	    ${param.uname },
	    	     ${paramValues.hobbies[0] },
	    	          ${paramValues.hobbies[1] },
</body>
</html>