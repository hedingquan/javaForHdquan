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
  var datagridTojs;
var searchForm;

  		/* $('#cc').combotree({
		    url: '',
			checkbox:true,
			multiple : true,
			lines : true
			}); */
	$(function(){
	
	datagridTojs=$('#datagrid').datagrid({
  		url:'role.action',
		iconCls:'icon-save',
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
		fitColums:false,
		nowarp:false,
		border:false,
		idField:'userid',
		queryParams : {
				allRole : 'true'
		},
		frozenColumns : [ [{
		      field:'number',
            title:'编号',
            width:300,
            sortable:true,
            checkbox:true,
            align : 'center'
		}]],
		 columns:[[
		  {
            field:'roleId',
            title:'角色ID',
            width:300,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            }  ,
             {
            field:'requestRole',
            title:'请求角色',
            width:300,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            } ,
             {
            field:'hasUserLogin',
            title:'当前角色登录人数',
            width:300,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            },
             {
            field:'name',
            title:'权限',
            width:100,
            align : 'center',
            formatter : function(value,rowData,rowIndex)
            {
            if (!rowData.permission && typeof(rowData.permission)!="undefined" && rowData.permission!=0){
            	return '';
            	}else
            	{
            	var permissions=[];
            	for(i=0;i<rowData.permission.length;i++)
            	{
            	permissions.push(rowData.permission[i].name);
            	}
	 				  return permissions;
            			}
            }
            }
		 ]],
		 toolbar : [{
     	 text:'增加',
     	 iconCls:'icon-add',
     	 handler:function(){
     	 		append();
     	 			}
     	},'-',{
     	 text:'删除',
     	 iconCls:'icon-remove',
     	 handler:function(){
     	 		remove();
     	 			}
     	},'-',{
     	 text:'修改',
     	 iconCls:'icon-edit',
     	 handler:function(){
     	 		edit();
     	 			}
     	},'-',{
     	 text:'我的角色',
     	 iconCls:'icon-edit',
     	 handler:function(){
     		 datagridTojs.datagrid({
     		 url:'role.action',
		iconCls:'icon-save',
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
		fitColums:false,
		nowarp:false,
		border:false,
		queryParams : {
				allRole : 'false'
		},
		idField:'userid',
		frozenColumns : [ [{
		      field:'number',
            title:'编号',
            width:300,
            sortable:true,
            checkbox:true,
            align : 'center'
		}]],
		 columns:[[
		  {
            field:'roleId',
            title:'角色ID',
            width:300,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            } , {
            field:'usGId',
            title:'用户组',
            width:100,
            align : 'center',
            formatter : function(value,rowData,rowIndex)
            {
            if (!rowData.userGroup && typeof(rowData.userGroup)!="undefined" && rowData.userGroup!=0){
            	return '用户自身权限';
            	}else
            	{return rowData.userGroup.usGId;}
            }
            } , {
            field:'name',
            title:'权限',
            width:100,
            align : 'center',
            formatter : function(value,rowData,rowIndex)
            {
            if (!rowData.permission && typeof(rowData.permission)!="undefined" && rowData.permission!=0){
            	return '';
            	}else
            	{
	 				 	var permissions=[];
            	for(i=0;i<rowData.permission.length;i++)
            	{
            	permissions.push(rowData.permission[i].name);
            	}
	 				  return permissions;
            			}
            }
            }
		 ]],
     		 
     		 })
     	 		/* $('#datagrid').datagrid('load',{
							MyRoles: true
						}); */
     	 			}
     	}
     	],
     	onLoadError :function(){
     	$.messager.show({
			title:'温馨提示',
			msg:'亲爱的客户，您没有查看角色的权限哦',
			timeout:5000,
			showType:'slide'
					});
								}
  			});
  	})
  	function edit()
  	{
  		var rows=datagridTojs.datagrid('getSelections');
  		console.info(rows);
  		if(rows.length == 1)
  		{
  			var p=$('#dd').dialog({
  				title: '编辑角色',
  				href :'',
  				width : 420,
  				height : 260,
  				buttons : [{
  					text : '编辑',
  				handler : function()
  				{
  					var f=p.find('form');
  					f.form('submit',{
  					url:'updateRole.action',
  					dataType : 'json',
  					success : function(d)
  					{
  						datagridTojs.datagrid('load',{});
  						datagridTojs.datagrid('unselectAll');
  						$.messager.show({
  							title : '提示',
  							msg : d.msg
  						});
  					}
  					});
  				}
  				}],
  onOpen : function()
  	{
  					$('ff').form('clear');
  		var f=$('#dd').find('form');
  		var permission = f.find('input[name=permission]');
  		var permissionTree = permission.combotree({
				  	textField: 'text',
				    valueField: 'id',
				    cascadeCheck : false,
  					lines : true,
  					url : 'permission.action',
  					checkbox : true,
  					multiple : true,
  			onLoadSuccess : function()
  			{
  		permissionTree.combotree('setValue', rows[0].permission.name);//有问题
  		datagridTojs.datagrid('unselectAll');
  			}
  		}); 
  		console.info(rows[0].permission.name);
  		f.form('load',{
  			roleId : rows[0].roleId,
  			/* cdesc : rows[0].cdesc,
  			authIds : getList(rows[0].authIds) */
  		});
  			permissionTree.combotree('clear');
  	}
  	});
  	}else if(rows.length >1)
  	{
  	$.messager.alert('提示','同一时间只能编辑一条记录！','error');
  	}else{
  		$.messager.alert('提示','请勾选要编辑的记录！','error');
  	}
  
  			}
  	
  	function append()
  	{
  		var p=$('#dd').dialog({
  			title : '添加角色',
  			href : '',
  			width : 420,
  			height : 260 ,
  			buttons: [{
  				text : '添加',
  				handler : function()
  				{
  					var f=p.find('form');
  					f.form('submit',{
  					url:'insertRole.action',
  					dataType : 'json',
  					success : function(d)
  					{
  						datagridTojs.datagrid('load',{});
  						datagridTojs.datagrid('unselectAll');
  						$.messager.show({
  							title : '提示',
  							msg : d.msg
  						});
  					}
  					});
  				}
  			}],
  			onOpen : function()
  			{
  					$('ff').form('clear');
  				var f=$('#dd').find('form');
  				var permission = f.find('input[name=permission]');
  				var permissionTree = permission.combotree({
  					lines : true,
  					url : 'permission.action',
  					//queryParams : {currentUser: true},
  					checkbox : true,
  					textField : 'name',
  					multiple : true
  				});
  			}
  			});
  	}
 remove= function ()
  {
  	var rows = datagridTojs.datagrid('getChecked');
  	var ids = [];
  	if(rows.length > 0)
  	{
  		$.messager.confirm('请确认','您要删除当前所选项目？',function(r){
  			if(r)
  			{
  				for(var i=0;i<rows.length;i++)
  				{
  					ids.push(rows[i].number);
  				}
  				$.ajax({
  					url : 'deleteRole.action',
  					data : {
  						ids : ids.join(',')
  					},
  					dataType : 'json',
  					success :function(d)
  					{
  						datagridTojs.datagrid('load',{});
  						datagridTojs.datagrid('unselectAll');
  						$.messager.show({
  							title : '提示',
  							msg : d.msg
  						});
  					}
  				});
  			}
  		});
  	}else
  	{
  		$.messager.alert('提示','请勾选要删除的记录!','error');
  	}
  }
  </script>
  </head>
 <body class="easyui-layout" data-options="fit:true">
 	<div data-options="region:'center',border:false" style="overflow:hidden;">
 		<table id="datagrid"></table>
 	</div>
 	
 	 <div id="menu" class="easyui-menu" style="width:120px;display:none;">
 	<div onclick="append();" data-options="iconCls:'icon-add'">增加</div>
 	<div onclick="remove();" data-options="iconCls:'icon-remove'">删除</div>
 	<div onclick="edit();" data-options="iconCls:'icon-edit'">编辑</div>
 	</div>  
 		<div id="dd">
    		<form id="ff" method="post">
		    <div>
		        <label for="roleId">角色ID:</label>
		        <input class="easyui-validatebox" type="text" name="roleId"/>
		    </div>
		    <div>
		        <label for="permission">拥有权限:</label>
		        <input name="permission" />
		    </div>
			</form>
    </div>
   </body>
</html>
