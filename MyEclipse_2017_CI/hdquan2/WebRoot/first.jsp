<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     request.setCharacterEncoding( "utf-8" );
    response.setHeader("Content-Type" , "text/html");
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 	<jsp:include page="BaseJsp.jsp" />
<script type="text/javascript" charset="utf-8">
		
		var cc;
		$.ajax(
			{ 
			url:"onLine.action"
			})
		$(function(){
		/* cc=$('#cc').layout();
		cc.layout('collapse','east'); */
		});
		function getCenterPanel()
		{
		var CenterPanel=$('#cc').layout('panel','center');
		//console.info(CenterPanel);
		console.info(CenterPanel.panel('options').title);
		}
	
	
</script>
 </head>
  <body>
      <div id="cc" class="easyui-layout" style="width:1350px;height:630px;">
        <div data-options="region:'north',title:'通用权限管理系统',split:true" style="height:65px;" href="north.jsp"></div>
        <div data-options="region:'east',split:true" style="width:100px;">
	        <div id="hh" class="easyui-layout" fit="true">
				         <div data-options="region:'south',title:'在线用户',split:true" fit="true"  href="onLine.action"></div>
			        <div data-options="region:'center',title:'历史记录'" fit="true" href="log4j.html"></div>
			</div>
        </div>
        <div data-options="region:'west',split:true" style="width:100px;" href="west.html"></div>
        <div data-options="region:'center'" style="padding:5px;background:#eee;overflow:hidden;">
        <div id="centerTabs" class="easyui-tabs" fit="true">
        
		</div>	
        </div>
    </div>
  
  </body>
</html>