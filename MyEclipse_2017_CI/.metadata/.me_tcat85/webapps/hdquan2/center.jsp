<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<jsp:include page="BaseJsp.jsp" />
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  <script type="text/javascript" charset="utf-8">
var datagrid;
var searchForm;
$(function(){
	searchForm=$('#user_search').form();
	editRow = undefined;
	
	datagrid=$('#datagrid').datagrid({
		/* rowStyler: function(index,row){
		if(row.realName == '大哥大')
		{
			return '';
		}
		return 'background-color:#6293BB;color:#fff;';
								}, 
		*/
		url:'user.action',
		iconCls:'icon-save',
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
		fitColums:false,
		nowarp:false,
		border:false,
		idField:'userid',
		sortName:'realName',
		sortOrder:'asc',
		frozenColumns : [ [{
            field:'userid',
            title:'编号',
            width:100,
            sortable:true,
            checkbox:true,
            align : 'center'
            },
            {
            field:'realName',
            title:'姓名',
            width:100,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            }]],
		 columns:[[
           {
            field:'sex',
            title:'性别',
            width:100,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            },{
            field:'job',
            title:'工作',
            width:100,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            },{
            field:'PINCodes',
            title:'身份证号',
            width:100,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            },{
            field:'telephone',
            title:'联系电话',
            width:100,
            sortable:true,
            editor:{type:'validatebox'},
            align : 'center'
            },{
            field:'fixedPhone',
            title:'固定电话',
            width:100,
            sortable:true,
            editor:{type:'validatebox'},
            align : 'center'
            },{
            field:'eMail',
            title:'eMail',
            width:100,
            sortable:true,
            editor:{type:'validatebox'},
            align : 'center'
            },{
            field:'QQ',
            title:'QQ',
            width:100,
            sortable:true,
            editor:{type:'validatebox'},
            align : 'center'
            },{
            field:'MSN',
            title:'MSN',
            width:100,
            sortable:true,
            editor:{type:'validatebox'},
            align : 'center'
            },{
            field:'PostalAddress',
            title:'通邮地址',
            width:100,
            sortable:true,
            editor:{type:'validatebox'},
            align : 'center'
            },{
            field:'PostalCode',
            title:'邮政编码',
            width:100,
            sortable:true,
            editor:{type:'validatebox'},
            align : 'center'
            },{
            field:'usercode',
            title:'账号',
            width:100,
            sortable:true,
            editor:{type:'validatebox',options:{required:true}},
            align : 'center'
            },
            {field:'username',
            title:'密码',
            width:100,
            align:'center',
             editor:{type:'validatebox',options:{required:true}},
	             formatter : function (value,row,index)
	             {
	            /*  return '<button>编辑</button><button>编辑</button>'; */
	            	 return '******';
	             } 
            },
            {field:'birthday',
            title:'生日日期',
            width:100,
            align:'center',
             editor:{type:'datebox'}
              /*     时间格式化
              formatter : function (value,row,index)
	             {
	            	return new Date(value).format();//Date是javascript的
	              } 
	          */
            },
            {field:'rolesIds',
            title:'所属角色',
            width:100,
            align : 'center',
                formatter : function (value,row,index)
	             {
		             if(row.roleNames){
		              return sy.fs('<span title="{0}">{1}</span>',row.roleNames,row.roleNames);
		             }
	             },
	             editor : {
	             	type : 'multiplecombobox',
	             	options : {
	             		url : '',
	             		valueField : 'cid',
	             		textField : 'cname'
	             		}
	          			   }
            },{
            	field:'roleNames',
         	   title:'所属角色',
         	   width : 100,
         	   hidden : true
            },
            {field:'controller',
            title:'控制列',
            width:100,
            align : 'center',
                formatter : function (value,row,index)
	             {
	              return '<button onclick="show('+index+');">编辑</button><button>编辑</button>';
	             }
            }
     			   ]],
     	 toolbar:[{
     	 text:'增加',
     	 iconCls:'icon-add',
     	 handler:function(){
     	 
     	/*  //在最底部追加一行
     	 datagrid.datagrid('appendRow',{
     			userid:'',
     			realName:'',
     			sex:'',
     			birthday:'',
     			job:'',
     			PINCodes:'',
     			telephone:'',
     			fixedPhone:'',
     			eMail:'',
     			QQ:'',
     			MSN:'',
     			PostalAddress:'',
     			PostalCode:''
     				 });
     				 var rows=datagrid.datagrid('getRows');
     				 datagrid.datagrid('beginEdit',rows.length-1);	
     	*/ 
     	if(editRow != undefined)
     	{
     	datagrid.datagrid('endEdit',editRow);
     	}
     	if(editRow == undefined)
     	{
     	
     	datagrid.datagrid('addEditor',{
     		field:'username',
     		editor:{
     			   type:'validatebox',
     			   options:{required:true}
     		}
     	});
     	
   	  datagrid.datagrid('insertRow',{
				index: 0,	// index start with 0
				row: {
					userid:uuid(),
	     			realName:'请输入您的真实姓名',
	     			sex:'',
	     			birthday:'',
	     			job:'',
	     			PINCodes:'',
	     			telephone:'',
	     			fixedPhone:'',
	     			eMail:'',
	     			QQ:'',
	     			MSN:'',
	     			PostalAddress:'',
	     			PostalCode:'',
	     			usercode:'',
	     			username:''
					}
			});
     			datagrid.datagrid('beginEdit',0);	
     			editRow = 0;
     	 	 } 
     	 }
     			  },'-',{
     	 text:'删除',
     	 iconCls:'icon-remove',
     	 handler:function(){
     		var rows= datagrid.datagrid('getSelections');
     		if(rows.length>0)
     		{
     			$.messager.confirm('请确认','您确定要删除当前所选择的项目吗？',function(b){
     				if(b)
     				{
     				var userids= [];
	     				for(var i=0;i<rows.length;i++)
	     				{
	     					userids.push(rows[i].userid)
	     				}
	     				$.ajax({
	     					url : 'deleteUser.action',
					data : {
						userids : userids.join(',')
							},
					dataType : 'json',
					success : function(r)
					{
				datagrid.datagrid('load',{});
				datagrid.datagrid('unselectAll');
						$.messager.show({
						title:'提示',
						msg:'删除成功'
						});
					}
	     				})
     				}	
     				console.info(userids.join(','));
     			
     			});
     		}else{
     			$.messager.alert('提示','请选择要删除的记录！','error');
     		}
     				 }
     			 },'-',{
     	 text:'修改',
     	 iconCls:'icon-edit',
     	 handler:function(){
     		var rows= datagrid.datagrid('getSelections');
     		if(rows.length==1)
     		{
     		
     		datagrid.datagrid('removeEditor','username');
     		
		     		if(editRow != undefined)
		     			{
				     	datagrid.datagrid('endEdit',editRow);
				     	}
				     	if(editRow == undefined)
				     	{
				     	var index=datagrid.datagrid('getRowIndex',rows[0]);	
			 				datagrid.datagrid('beginEdit',index);	
			     			editRow = index;
			     			datagrid.datagrid('unselectAll');
			     	 	 } 
     		}
     			 			}
     		},'-',{
     	 text:'保存',
     	 iconCls:'icon-save',
     	 handler:function(){
     	 	datagrid.datagrid('endEdit',editRow);
     			 }
     		},'-',{
     	 text:'取消编辑',
     	 iconCls:'icon-redo',
     	 handler:function(){
     	 		editRow = undefined;
     	 		datagrid.datagrid('rejectChanges');//回滚
     	 		datagrid.datagrid('unselectAll');//撤销所选
     			 }
     		},'-',{
     	 text:'取消选中',
     	 iconCls:'icon-redo',
     	 handler:function(){
     	 		editRow = undefined;
     	 		datagrid.datagrid('unselectAll');//撤销所选
     			 }
     		},'-',],
    	 onAfterEdit : function(index,row,changes)//注意是  ':'
			{
			console.info(row);
			var inserted=datagrid.datagrid('getChanges','inserted');
			var updated=datagrid.datagrid('getChanges','updated');
			//如果什么都没做，就不发ajax
			if(inserted.length <1 && updated.length<1)
			{
				editRow = undefined;
     	 		datagrid.datagrid('unselectAll');
     	 		return;
			}
			
			var url = '';
			if(inserted.length>0)
			{
				url = 'insertUser.action';
			}
			if(updated.length>0)
			{
				url = 'updateUser.action';
			}
				$.ajax({
					url : url,
					data : row,
					dataType : 'json',
					success : function(r)
					{
						if(r && r.success)
						{
							datagrid.datagrid('acceptChanges');
							$.messager.show({
									msg : r.msg,
									title : '成功'
										})
						}else{
							datagrid.datagrid('rejectChanges');
							$.messager.alert('错误',r.msg,'error');
						}
				editRow = undefined;
				datagrid.datagrid('unselectAll');
					}
				});
			},
		onDblClickRow : function(index,row)
		{
			datagrid.datagrid('removeEditor','username');
			if(editRow != undefined)
	     	{
	     	datagrid.datagrid('endEdit',editRow);
	     	}
	     	if(editRow == undefined)
	     	{
 				datagrid.datagrid('beginEdit',index);	
     			editRow = index;
     	 	 } 
		},
		onRowContextMenu : function(e,index,row)
		{
			e.preventDefault();//阻止游览器默认的事件
				$(this).datagrid('unselectAll');//this代表当前的datagrid
				$(this).datagrid('selectRow',index);
			$('#menu').menu('show', {
							    left: e.pageX,
							    top: e.pageY
							});
		}
		});
		//将表单的头部内容居中
		$('.datagrid-header div').css('textAlign','center');
});

	function show(i)
	{
		console.info(i);
		var rows = datagrid.datagrid('getRows'); 
		//console.info(rows);//当前页的所有行
		console.info(rows[i]);//选择的哪一行
	}
	   
	search_user=function ()
	{
	console.info(serializeObject(searchForm));
				$('#datagrid').datagrid('load',
						/* realName: $('#user_search').find('[name=realName]').val(),
						birthday:$('#user_search').find('[name=birthday]').val() */
				serializeObject(searchForm)
					);
	}
	clear_data=function()
	{
	$('#datagrid').datagrid('load',{});
	searchForm.find('input').val('');
	}


	/* edit_user= function() 
	{
		var rows=$('#datagrid').datagrid('getSelections');
		if(rows.length !=1&& rows.length !=0)
		{
			var  names=[];
			for(var i=0;i<rows.length;i++)
			{
				names.push(rows[i].name);
			}
			$.messager.show({
				msg:'只能选择一个用户进行编辑!您已经选择了【'+names.join(',')+'】'+rows.length+'个用户',
				title:'提示'
			});
		}else if(rows.length==1)
		{
		//密码
			userForm.find('[name=username]').validatebox({
				required:false
			});
		}
		userForm.find('[name=name]').attr('readonly','readonly');
		userDialog.dialog('open');
		userForm.form('claer');
		userForm.form('load',{
			userid:rows[0].userid,
			realName:rows[0].realName,
			username:'',
		//	roleId:getList(rows[0].roleId)	选择角色id
		});
	}  */
</script>
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-3" data-genuitec-path="/hdquan2/WebRoot/center.jsp">
  <div class="easyui-layout" fit="true" border="false" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-3" data-genuitec-path="/hdquan2/WebRoot/center.jsp"> 
	<div region="north" border="false" title="查询条件" style="height:180px;overflow:hidden;">
		<form id="user_search">
			<table class="tableForm datagrid-toolbar" style="width:100%;height:100%">
				<tr>
					<th>编号</th>
					<td><input name="userid"/></td>
					<th>姓名</th>
					<td><input name="realName"/></td>
				</tr>
				<tr>
					<th>性别</th>
					<td><input name="sex"/></td>
						<th>身份证号</th>
					<td><input name="PINCodes"/></td>
				</tr>
				<tr>
					<th>联系电话</th>
					<td><input name="telephone"/></td>
					<th>固定电话</th>
					<td><input name="fixedPhone"/></td>
				</tr>
				<tr>
					<th>e-mail</th>
					<td><input name="eMail"/></td>
					<th>QQ</th>
					<td><input name="QQ"/></td>
				</tr>
				<tr>
					<th>生日</th>
					<td><input name="birthday" class="easyui-datebox" editable="false" style="width:155px"/>
					<a href="javascript:void(0);" class="easyui-linkbutton" onclick="search_user();">查询</a>
					<a href="javascript:void(0);" class="easyui-linkbutton" onclick="clear_data();">清空</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
		<div region="center" border="false">
			<table id="datagrid"></table>
		</div>
		<div id="menu" class="easyui-menu" style="width:120px;display:none">
			<div onclick="append();" iconCls="icon-add">增加</div>
			<div onclick="remove();" iconCls="icon-remove">删除</div>
			<div onclick="edit_user();" iconCls="icon-edit">编辑</div>
		</div>
</div> 
  </body>
</html>
