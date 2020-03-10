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
	$(function(){
	  	searchForm=$('#lsjs_search').form();
	  	
        $('#allRole').switchbutton({
            checked: true,
            onChange: function(checked){
                console.log(checked);
            }
        })
	  	
	datagridTojs=$('#datagrid').datagrid({
  		url:'PA_role.action',
		iconCls:'icon-save',
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
		fitColums:false,
		nowarp:false,
		border:false,
		idField:'usercode',
		queryParams : {
				allRole : 'true'
		},
		frozenColumns : [ [{
		      field:'usercode',
            formatter : function(value,row,rowIndex)
            {
          		return row.usercode;
            },
            title:'临时授权用户姓名',
            width:300,
            sortable:true,
            align : 'center'
		}]],
		 columns:[[
		  {
            field:'roleid',
             formatter : function(value,row,rowIndex)
            {
          		return row.roleid;
            },
            title:'临时授权角色ID',
            width:300,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            } , {
            field:'recoveryTime',
              formatter : function(value,row,rowIndex)
            {
          		return row.recoveryTime;
            },
            title:'临时授权收回时间',
            width:300,
            align : 'center',
             sortable:true,
               editor:{type:'datebox'}
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
     	 text:'我的临时角色',
     	 iconCls:'icon-edit',
     	 handler:function(){
     		 datagridTojs.datagrid({
     	url:'PA_role.action',
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
		idField:'usercode',
		frozenColumns : [ [{
		      field:'usercode',
            formatter : function(value,row,rowIndex)
            {
          		return row.usercode;
            },
            title:'临时授权用户姓名',
            width:300,
            sortable:true,
            align : 'center'
		}]],
		 columns:[[
		  {
            field:'roleid',
             formatter : function(value,row,rowIndex)
            {
          		return row.roleid;
            },
            title:'临时授权角色ID',
            width:300,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            } , {
            field:'recoveryTime',
              formatter : function(value,row,rowIndex)
            {
          		return row.recoveryTime;
            },
            title:'临时授权收回时间',
            width:300,
            align : 'center',
             sortable:true,
               editor:{type:'datebox'}
            }
		 ]],
     		 })
     	 			}
     	}
     	],
     	onLoadError :function(){
     	$.messager.show({
			title:'温馨提示',
			msg:'亲爱的客户，您没有查看临时角色的权限哦',
			timeout:5000,
			showType:'slide'
					});
								}
  			});
  	})
  	function edit()
  	{
  		var rows=datagridTojs.datagrid('getSelections');
  		var p=undefined;
  		console.info(rows);
  		if(rows.length == 1)
  		{
  			 p=$('#dd').dialog({
  				title: '编辑临时角色',
  				href :'',
  				width : 420,
  				height : 260,
  				buttons : [{
  					text : '提交数据',
  				handler : function()
  				{
  					var f=p.find('form');
  					f.form('submit',{
  					url:'PA_updateRole.action',
  					success : function(d)
  					{
  					d=eval('(' + d + ')');
  						console.info(d);
  						if(d.success)
  						{
  					$('#dd').dialog('close', 'true');
  						datagridTojs.datagrid('reload');
  						}
  						$.messager.show({
  							msg : d.msg,
  							title : '提示'
  						}); 
  					}
  					});
  				}
  				}],
  onOpen : function()
  	{		
  			var f=$('#dd').find('form');
  	 		f.form('load',{
  							usercode : rows[0].usercode,
  							roleid : rows[0].roleid,
  							RecoveryTime : rows[0].RecoveryTime,
  						});
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
  					url:'PA_insertRole.action',
  					success : function(d)
  					{
  						d=eval('(' + d + ')');
  						console.info(d);
  						if(d.success)
  						{
  						datagridTojs.datagrid('reload');
  						p.dialog('close');
  						}
  						$.messager.show({
  							msg : d.msg,
  							title : '提示'
  						}); 
  					}
  					});
  				}
  			}],
  			});
  	}
 remove= function ()
  {
  	var rows = datagridTojs.datagrid('getChecked');
  	if(rows.length > 0)
  	{
  		$.messager.confirm('请确认','您要删除当前所选项目？',function(r){
  			if(r)
  			{
  				$.ajax({
  					url : 'PA_deleteRole.action',
  					data : {
  						ids : rows[0].usercode
  					},
  					success :function(d)
  					{
  					d=eval('(' + d + ')');
  							datagridTojs.datagrid('load',{
											allRole : 'true'
									});
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

  	search_lsjs=function ()
	{
	console.info(serializeObject(searchForm));
				$('#datagrid').datagrid('load',serializeObject(searchForm)
					);
	}
		clear_data=function()
	{
	$('#datagrid').datagrid('load',{});
	searchForm.find('input').val('');
	}
	
  </script>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
 <body class="easyui-layout" data-options="fit:true" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-775" data-genuitec-path="/hdquan3/WebRoot/ls_js.jsp">
	<div region="north" border="false" title="查询条件" style="height:180px;overflow:hidden;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-775" data-genuitec-path="/hdquan3/WebRoot/ls_js.jsp">
	 	<form id="lsjs_search">
			<table class="tableForm datagrid-toolbar" style="width:100%;height:100%">
				<tr>
					<th>临时授权用户姓名</th>
					<td><input name="usercode" class="easyui-textbox"/></td>
					<th>临时授权角色ID</th>
					<td><input name="roleid" class="easyui-textbox"/></td>
				</tr>
				<tr>
					<th>临时授权收回时间</th>
					<td>
					<input name="RecoveryTime" class="easyui-datebox" style="width:155px"/>
						<a href="javascript:void(0);" class="easyui-linkbutton" onclick="search_lsjs();">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" onclick="clear_data();">清空</a>
					</td>
						<th>在全部用户下查询</th>
					<td>
					<input id="allRole" style="width:200px;height:30px" name="allRole" data-options="onText:'true',offText:'false'"/>
					</td>
				</tr>
			</table>
		</form>
	 </div>
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
		        <label for="usercode">临时授权用户姓名:</label>
		        <input class="easyui-textbox" name="usercode"/>
		    </div>
		    <div>
		        <label for="roleid">角色ID:</label>
		        <input class="easyui-textbox" name="roleid"/>
		    </div>
		    <div>
		        <label for="time">临时授权收回时间:</label>
		     	<input name="recoveryTime" class="easyui-datebox" style="width:155px"/>
		    </div>
			</form>
    </div>
   </body>
</html>
