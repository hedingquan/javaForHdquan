<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<jsp:include page="BaseJsp.jsp" />
		
  <script type="text/javascript">
  
  $(function()
  {
		$.messager.show({
			title:'温馨提示',
			msg:${ex},
			timeout:5000,
			showType:'slide'
					});
  })
  </script>
  </head>
  <body>
 抱歉，没有权限
   </body>
</html>
