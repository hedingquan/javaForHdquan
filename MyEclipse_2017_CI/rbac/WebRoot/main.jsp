<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<dl>
	<c:forEach items="${user.menus }" var="menu">
	<dt>${menu.name }</dt>
	<c:forEach items="${menu.children }" var="child">
			<dd>${child.name }</dd>
	</c:forEach>
	</c:forEach>
</dl>

<c:forEach items="${user.element }" var="ele">
	<c:if test="${ele.eleno eq 'grant' }">
	<button eleno="grant">授权</button>
		
	</c:if>
</c:forEach>

	<button>新增</button>
</body>
</html>