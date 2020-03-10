<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String work_id = request.getParameter("work_id");
 String work_title = request.getParameter("work_title");
  String work_time = request.getParameter("work_time");
   String work_money = request.getParameter("work_money");
    String work_place = request.getParameter("work_place");
     String work_content = request.getParameter("work_content");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'myinfo.jsp' starting page</title>
     <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.min.js" charset="uft-8"></script> 
	 <script type="text/javascript">
	function delete1(a)
	{
		var name=document.getElementById("name").value;
		var work_id=<%=work_id%>;
		  a.href = 'delete_work_stu.action?name='+name+'&work_id='+work_id;
	}
	</script>
  </head>
  
  <body>
		删除工作项目
		<div style="text-align: center">
			<table border="1" style="margin: auto">
			<tr>
				<td>工作标题</td>
				<td><%=work_title%></td>
			</tr>
			<tr>
				<td>工作时长</td>
				<td><%=work_time%></td>
			</tr>
			<tr>	
				<td>工作薪酬</td>
				<td><%=work_money%></td>
			</tr>
			<tr>		
				<td>工作地点</td>
				<td><%=work_place%></td>
			</tr>
			<tr>			
				<td>参与学生</td>
				<td><%=work_content%></td>
			</tr>
			</table>
				删除学生<input type="text" id="name"/><br/>
			 <a href="void(0)" onclick="delete1(this)">确认删除</a>
		</div>
  </body>
</html>
