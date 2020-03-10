<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Permission.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<jsp:include page="BaseJsp.jsp" />
 	   <script type="text/javascript" charset="utf-8">
   var datagrid=undefined;
   $(function(){
   datagrid=$('#datagrid').datagrid({
		url:'permission.action',
		iconCls:'icon-save',
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
		fitColums:false,
		nowarp:false,
		border:false,
		idField:'id',
		frozenColumns : [ [{
            field:'id',
            title:'权限id',
            width:100,
            sortable:true,
            checkbox:true,
            align : 'center'
            },
            {
            field:'text',
            title:'权限名称',
            width:100,
            sortable:true,
            align : 'center'
            }]],
		 columns:[[
           {
            field:'parentid',
              formatter : function (value,row,index)
	             {
	             return row.attributes.parentid;
	             },
            title:'父权限id',
            width:100,
            sortable:true,
            align : 'center'
            },
            {
            field:'type',
             formatter : function (value,row,index)
	             {
	             return row.attributes.type;
	             },
            title:'权限类型',
            width:100,
            sortable:true,
            align : 'center'
            },
              {
            field:'Rejection_attribute',
              formatter : function (value,row,index)
	             {
	             return row.attributes.Rejection_attribute;
	             },
            title:'拒绝属性',
            width:100,
            sortable:true,
            align : 'center'
            },
              {
            field:'Mandatory_attribute',
                  formatter : function (value,row,index)
	             {
	             return row.attributes.Mandatory_attribute;
	             },
            title:'强制属性',
            width:100,
            sortable:true,
            align : 'center'
            },
                {
            field:'rank',
               formatter : function (value,row,index)
	             {
	             return row.attributes.rank;
	             },
            title:'权限优先级',
            width:100,
            sortable:true,
            align : 'center'
            },
                   {
            field:'permission',
               formatter : function (value,row,index)
	             {
	             return '<button onclick="searchThis();">查看该权限内容</button>';
	             },
            title:'权限优先级',
            width:200,
            sortable:true,
            align : 'center'
            },
              ]],
               toolbar:[{
			     	 text:'返回',
			     	 iconCls:'icon-undo',
			     	 handler:function(){
			     	   $('#datagrid').datagrid('load',{});
			     	 }
     	 }]
   });
   searchThis =function()
   {
    var rows= $('#datagrid').datagrid('getSelections');
    console.info(rows[0].id);
	    $('#datagrid').datagrid('load',{
		id: rows[0].id,
		});
   }
   });
   
	
   	search_permission=function ()
	{
	var searchForm=$('#permission_search').form();
	console.info(serializeObject(searchForm));
				$('#datagrid').datagrid('load',
				serializeObject(searchForm)
					);
	}
	clear_data=function()
	{
	var searchForm=$('#permission_search').form();
	$('#datagrid').datagrid('load',{});
	searchForm.find('input').val('');
	}
   
 </script>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/hdquan3/WebRoot/Permission.jsp">
    <div class="easyui-layout" fit="true" border="false" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/hdquan3/WebRoot/Permission.jsp"> 
	<div region="north" border="false" title="查询条件" style="height:180px;overflow:hidden;">
		<form id="permission_search">
			<table class="tableForm datagrid-toolbar" style="width:100%;height:100%">
				<tr>
					<th>权限id</th>
					<td><input name="id"/></td>
					<th>权限名称</th>
					<td><input name="name"/></td>
				</tr>
				<tr>
					<th>权限类型</th>
					<td><input name="type"/></td>
					<th>权限优先级</th>
					<td><input name="rank"/>
					
					<a href="javascript:void(0);" class="easyui-linkbutton" onclick="search_permission();">查询</a>
					<a href="javascript:void(0);" class="easyui-linkbutton" onclick="clear_data();">清空</a>
					</td>
				</tr>
				</table>
		</form>
	</div> 
		 <div region="center" border="false">
			<table id="datagrid"></table>
		</div>
</div>
  </body>
</html>
