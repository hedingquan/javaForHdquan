<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tree.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;" charset="UTF-8">
  	<script type="text/javascript" src="js/jquery-easyui-1.8.2/jquery.min.js" charset="uft-8"></script> 
  	<script type="text/javascript" src="js/jquery.cookie.js" charset="UTF-8"></script>
    <link rel="stylesheet" href="js/jquery-easyui-1.8.2/themes/icon.css" type="text/css" charset="uft-8"> 
  	    <%
		//从cookies中读取主题名称
		String easyuiThemeName = "default";
		Cookie cookies[] = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for(int i=0; i<cookies.length; i++){
				if(cookies[i].getName().equals("easyuiThemeName")){
					easyuiThemeName = cookies[i].getValue();
					break;
				}
			}
		}
     %>
  <link id="easyuiTheme" rel="stylesheet" type="text/css" href="js/jquery-easyui-1.8.2/themes/<%=easyuiThemeName%>/easyui.css">   <%--   即索引的样式--%>
  	<script type="text/javascript" src="js/jquery-easyui-1.8.2/jquery.easyui.min.js" charset="uft-8"></script>
     <script type="text/javascript" src="js/jquery-easyui-1.8.2/locale/easyui-lang-zh_CN.js" charset="uft-8"></script> 
   <link rel="stylesheet" href="js/jquery-easyui-1.8.2/themes/gray/easyui.css" type="text/css" charset="uft-8">
     <script type="text/javascript" src="js/syUtils.js" charset="uft-8"></script> 
<script type="text/javascript" charset="utf-8">
	$(function(){
		$('#tt').tree({
			 url:'tree_data.json',
			 lines:true
		});
	});
	

</script>
 </head>
  
  <body>
  		<ul id="tt" class="easyui-tree">
    <li>
        <span>Folder</span>
        <ul>
            <li>
                <span>Sub Folder 1</span>
                <ul>
                    <li><span><a href="#">File 11</a></span></li>
                    <li><span>File 12</span></li>
                    <li><span>File 13</span></li>
                </ul>
            </li>
            <li><span>File 2</span></li>
            <li><span>File 3</span></li>
        </ul>
    </li>
    <li><span>File21</span></li>
</ul>
  </body>
</html>
