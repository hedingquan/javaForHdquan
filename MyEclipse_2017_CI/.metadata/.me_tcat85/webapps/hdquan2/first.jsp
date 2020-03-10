<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
     request.setCharacterEncoding( "utf-8" );
    response.setHeader("Content-Type" , "text/html");
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
 <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/hdquan2/WebRoot/first.jsp">
      <div id="cc" class="easyui-layout" style="width:1350px;height:630px;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/hdquan2/WebRoot/first.jsp">
        <div data-options="region:'north',title:'North Title',split:true" style="height:100px;" href="north.jsp"></div>
        <div data-options="region:'east',title:'East',split:true" style="width:100px;">
	        <div id="hh" class="easyui-layout" fit="true">
				         <div data-options="region:'south',title:'South Title',split:true" fit="true"  href="onLine.action"></div>
			        <div data-options="region:'center',title:'center title'" fit="true" href="log4j.html"></div>
			</div>
        </div>
        <div data-options="region:'west',title:'West',split:true" style="width:100px;" href="west.html"></div>
        <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;overflow:hidden;">
        <div id="centerTabs" class="easyui-tabs" fit="true">
			
		</div>	
        </div>
    </div>
  
  </body>
</html>