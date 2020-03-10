<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 	<jsp:include page="BaseJsp.jsp" />
	 <script type="text/javascript">
	 
	 </script>
  </head>
  
  <body>
 		<h3 align="center">所有水电资料统计</h3>
  		 <table border="1" align="center" border="0" cellpadding="0" cellspacing="0">
		  <tr>
		  <th colspan="1" rowspan="1">序号</th>
		  <th colspan="1" rowspan="1">工资号</th>
		   <th colspan="1" rowspan="1">姓名</th>
		    <th colspan="1" rowspan="1">单位</th>
		     <th colspan="1" rowspan="1">电费金额</th>
		     <th colspan="1" rowspan="1">水费金额</th>
		     <th colspan="1" rowspan="1">总额</th>
		  </tr>
		  
		  <c:forEach items="${statistics}" var="statistics">
		  <tr>
		  <td>${statistics.id}</td>
		  <td>${statistics.salaryNum}</td>
		  <td>${statistics.name}</td>
		    <td>${statistics.unit.uName}</td>
		    
		 	<td><c:out value="${(statistics.electricNum-statistics.lastelectricNum)*statistics.electricBill}"></c:out></td>
		 		
			 <td><c:out value="${(statistics.waterNum-statistics.lastewaterNum)*statistics.waterBill}"></c:out></td>
		 		
		 	<td><c:out value="${((statistics.electricNum-statistics.lastelectricNum)*statistics.electricBill)+((statistics.waterNum-statistics.lastewaterNum)*statistics.waterBill)}"></c:out></td>
		 		
		  </tr>
		  </c:forEach>
		  </table>
  </body>
</html>
