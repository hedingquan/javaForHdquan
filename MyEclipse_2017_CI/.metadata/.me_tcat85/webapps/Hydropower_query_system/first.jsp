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
	   		function addTab(node)
		{
			var centerTabs=$('#cc').layout('panel','center');
			$(centerTabs).html('<iframe src="'+$(node).attr("url")+'" frameborder="0" style="border:0;width:100%;height:100%;"></ifrane>');
		}
	 </script>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/Hydropower_query_system/WebRoot/first.jsp">
    <div id="cc" class="easyui-layout" style="width:100%;height:100%;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-7" data-genuitec-path="/Hydropower_query_system/WebRoot/first.jsp">
        <div data-options="region:'west'" style="width:200px;" align="center">
        <div id="p" class="easyui-panel" style="width:100%;height:100%;background:#fafafa;"
			    data-options="collapsible:true,minimizable:true,maximizable:true">
        					<h3 align="center">水电费系统维护</h3>
        <a href="javascript:void(0)" url="HydropowerQueryMaintenance.jsp" title="教工水电维护" onclick="addTab(this);"><h3 style="text-align:center">教工水电维护</h3></a>
         <a href="javascript:void(0)" url="DataInitialization.jsp" title="教工水电维护" onclick="addTab(this);"><h3 style="text-align:center">数据初始化</h3></a>
        <a href="javascript:void(0)" url="OtherWaterAndElectricityMaintenance.jsp" title="其他水电维护" onclick="addTab(this);"><h3 style="text-align:center">其他水电维护</h3></a>
        <a href="javascript:void(0)" url="BuildingMaintenance.jsp" title="楼房维护" onclick="addTab(this);"><h3 style="text-align:center">楼房维护</h3></a>
       </div>
       </div>
        <div data-options="region:'center'">
				1513
        </div>
    </div>
  </body>
</html>
