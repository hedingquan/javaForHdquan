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
  var datagridToAdress;
var searchForm;
	$(function(){
	  	searchForm=$('#adress_search').form();
	  	
	datagridToAdress=$('#datagrid').datagrid({
  		url:'getadress.action',
		iconCls:'icon-save',
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
		fitColums:false,
		nowarp:false,
		border:false,
		idField:'Id',
		queryParams : {
				allAdress : 'true'
		},
		frozenColumns : [ [{
		      field:'Id',
            checkbox:true,
            formatter : function(value,row,rowIndex)
            {
          		return row.id;
            },
            title:'Id',
            width:300,
            sortable:true,
            align : 'center'
		}]],
		 columns:[[
		  {
            field:'IPStart',
             formatter : function(value,row,rowIndex)
            {
          		return row.ipstart;
            },
            title:'IPStart',
            width:300,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            } , {
            field:'IPEnd',
              formatter : function(value,row,rowIndex)
            {
          		return row.ipend;
            },
            title:'IPEnd',
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
     	},
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
  		var rows=datagridToAdress.datagrid('getSelections');
  		var p=undefined;
  		console.info(rows);
  		if(rows.length == 1)
  		{
  			 p=$('#dd').dialog({
  				buttons : [{
  					text : '提交数据',
  				handler : function()
  				{
  					var f=p.find('form');
  					f.form('submit',{
  					url:'updateAdress.action',
  					success : function(d)
  					{
  					d=eval('(' + d + ')');
  						console.info(d);
  						if(d.success)
  						{
  					$('#dd').dialog('close', 'true');
  						datagridToAdress.datagrid('reload');
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
  							Id : rows[0].id,
  							IPStart : rows[0].ipstart,
  							IPEnd : rows[0].ipend,
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
  					url:'insertAdress.action',
  					success : function(d)
  					{
  						d=eval('(' + d + ')');
  						console.info(d);
  						if(d.success)
  						{
  						datagridToAdress.datagrid('reload');
  							datagridToAdress.datagrid('unselectAll');
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
  	var rows = datagridToAdress.datagrid('getChecked');
  	console.info(rows);
  	if(rows.length > 0)
  	{
  		$.messager.confirm('请确认','您要删除当前所选项目？',function(r){
  			if(r)
  			{
  				$.ajax({
  					url : 'deleteAdress.action',
  					data : {
  						ids : rows[0].id
  					},
  					success :function(d)
  					{
  					d=eval('(' + d + ')');
  							datagridToAdress.datagrid('load',{
											allRole : 'true'
									});
  						datagridToAdress.datagrid('unselectAll');
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
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
 <body class="easyui-layout" data-options="fit:true" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-4" data-genuitec-path="/hdquan3/WebRoot/adress.jsp">
 	<div data-options="region:'center',border:false" style="overflow:hidden;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-4" data-genuitec-path="/hdquan3/WebRoot/adress.jsp">
 		<table id="datagrid"></table>
 	</div>
   </body>
   
   <div id="win" class="easyui-window" title="修改地址"
        data-options="iconCls:'icon-edit',modal:true" closed=true>
	   <div id="dd">
	    		<form id="ff" method="post">
	    			<div>
			        <label for="Id">Id:</label>
			        <input class="easyui-textbox" name="Id" readonly="false"/>
			  	 	 </div>
	    		<div>
			        <label for="RoleId">RoleId:</label>
			        <input class="easyui-textbox" name="RoleId"/>
			    </div>
	    		<div>
			        <label for="IPStart">IPStart:</label>
			        <input class="easyui-textbox" name="IPStart"/>
			    </div>
			    <div>
			        <label for="IPEnd">IPEnd:</label>
			        <input class="easyui-textbox" name="IPEnd"/>
			    </div>
				</form>
	    </div>
    </div>
</html>
