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
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-4" data-genuitec-path="/Hydropower_query_system/WebRoot/Notice.jsp">
  	<h3 align="center" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-4" data-genuitec-path="/Hydropower_query_system/WebRoot/Notice.jsp">教工水电资料</h3>
  		 <table border="1" align="center" border="0" cellpadding="0" cellspacing="0">
		  <tr>
		  <th colspan="1" rowspan="2">序号</th>
		   <th colspan="1" rowspan="2">楼名</th>
		   <th colspan="1" rowspan="2">房号</th>
		    <th colspan="1" rowspan="2">季度</th>
		    <th colspan="5" rowspan="1">电</th>
		     <th colspan="5" rowspan="1">水</th>
		    <th colspan="1" rowspan="2">总额</th>
		     <th colspan="1" rowspan="2">备注</th>
		  </tr>
		   <tr>
		     <th colspan="1" rowspan="1">上次表底</th>
		      <th colspan="1" rowspan="1">本季表底</th>
		       <th colspan="1" rowspan="1">本季度数</th>
		        <th colspan="1" rowspan="1">单价</th>
		         <th colspan="1" rowspan="1">金额</th>
		         
		         <th colspan="1" rowspan="1">上次表底</th>
		      <th colspan="1" rowspan="1">本季表底</th>
		       <th colspan="1" rowspan="1">本季方数</th>
		        <th colspan="1" rowspan="1">单价</th>
		         <th colspan="1" rowspan="1">金额</th>
		   </tr>
		  <c:forEach items="${print}" var="print">
		  <tr>
		  <td>${print.id}</td>
		  <td>${print.room.building.buildingName}</td>
		  <td>${print.room.roomNum}</td>
		   <td>${print.season}</td>
		   
		      <td>${print.lastelectricNum}</td>
		       <td>${print.electricNum}</td>
		       <td><c:out value="${print.electricNum-print.lastelectricNum}"></c:out></td>
		 		 <td>${print.electricBill}</td>
		 		 <td><c:out value="${(print.electricNum-print.lastelectricNum)*print.electricBill}"></c:out></td>
		 		
		 		  <td>${print.lastewaterNum}</td>
		       <td>${print.waterNum}</td>
		       <td><c:out value="${print.waterNum-print.lastewaterNum}"></c:out></td>
		 		 <td>${print.waterBill}</td>
		 		 <td><c:out value="${(print.waterNum-print.lastewaterNum)*print.waterBill}"></c:out></td>
		 		
		 			 <td><c:out value="${((print.electricNum-print.lastelectricNum)*print.electricBill)+((print.waterNum-print.lastewaterNum)*print.waterBill)}"></c:out></td>
		 		  <td>${print.addition}</td>
		  </tr>
		  </c:forEach>
		  </table>
  </body>
</html>