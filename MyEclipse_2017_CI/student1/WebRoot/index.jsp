<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/student/js/jquery.js">
$(Function(){
var pageSize=${pageinfo.pageSize};
var pageNumber=${pageinfo.pageNumber};
var sname="${pageinfo.sname}";
var tname="${pageinfo.tname}";
	$.each($(":radio"),function(i,n)
	{if($(n).val==pageSize)
	{$(n).attr("checked","checked");
	}
	})
	$(":text[name='sname']").val(sname);
	$(":text[name='tname']").val(tname);
});
	$("button").clik(function()
	{location.href="show?pageSize="+pageSize+"&pageNumber=1&tname="+$(":text[name='tname']").val()+"&sname="+$(":text[name='sname']").val();
	});
</script>

</head>
<body>
<input type="radio" value="2" name="pageSize"/>2
<input type="radio" value="3" name="pageSize"/>3
<input type="radio" value="4" name="pageSize"/>4<br/>
学生姓名：<input type="text" name="sname"/>老师姓名<input type="text" name="tname"/><button>查询</button><br/>
<table border="1">
<tr>
	<td>学生编号</td>
	<td>学生姓名</td>
	<td>年龄</td>
	<td>任课老师</td>
<c:forEach items="${pageinfo.list}" var="stu">
<tr>
<td>${stu.id}</td>
<td>${stu.name}</td>
<td>${stu.age}</td>
<td>${stu.teacher.name}</td>
</tr>
</c:forEach>
</tr>
</table>
<a href="">上一页</a><a href="">下一页</a>
</body>
</html>