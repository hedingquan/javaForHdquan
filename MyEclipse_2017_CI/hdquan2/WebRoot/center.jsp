<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<jsp:include page="BaseJsp.jsp" />
  </head>
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
            field:'pincodes',
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
            field:'qq',
            title:'QQ',
            width:100,
            sortable:true,
            editor:{type:'validatebox'},
            align : 'center'
            },{
            field:'msn',
            title:'MSN',
            width:100,
            sortable:true,
            editor:{type:'validatebox'},
            align : 'center'
            },{
            field:'postalAddress',
            title:'通邮地址',
            width:100,
            sortable:true,
            editor:{type:'validatebox'},
            align : 'center'
            },{
            field:'postalCode',
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
		             var rolesids=[];
		            //roles= sy.fs('<span title="{0}">{1}</span>',row.roles[1].roleId,row.roles[1].roleId);
		         if(row.roles==undefined)
		         {
		         return '';
		         }else{
		            for(var i=0;i<row.roles.length;i++)
		            {
		               rolesids.push(row.roles[i].roleId);
		             }
		              return rolesids;
		                 /*   return sy.fs('<span title="{0}">{1}</span>',row.roles.roleNames,row.roleNames); */
	         		  }
	             },
	           /*   editor : {
	             	type : 'multiplecombobox',
	             	options : {
	             		url : 'role.action',
	             		queryParams : {page : 1 , rows : 10},
	             		valueField : 'row.number',
	             		textField : 'row.roleId'
	             		}
	          			   } */
            },{
            	field:'roleNames',
         	   title:'所属权限名称',
         	   width : 100,
         	     formatter : function (value,row,index)
	             {
		             var permissionids=[];
		          if(row.roles==undefined)
		         {
		         return '';
		         }else{
		            for(var i=0;i<row.roles.length;i++)
		            {
		            if(row.roles[i].permission!=undefined && row.roles[i].permission!='')
			             {
				             for(var j=0;j<row.roles[i].permission.length;j++)
			         		   {
				               permissionids.push(row.roles[i].permission[j].name);
				               }
			             }
		             }
		              return permissionids;
		              }
	             },
            },
            {field:'controller',
            title:'控制列',
            width:600,
            align : 'center',
                formatter : function (value,row,index)
	             {
	              return '<button onclick="SearchDepartmentAndUsergroup('+index+');">查看用户的用户组和部门</button><button  onclick="AddDepartmentAndUsergroup('+index+');">修改用户的用户组和部门</button></button><button  onclick="UserAddRoles('+index+');">为用户分配角色集合</button>';
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
			console.info(updated);
			}
				$.ajax({
					url : url,
					data : {user : JSON.stringify(row)},
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

	function UserAddRoles(i)
	{
	var rows= datagrid.datagrid('getSelections');
	console.info(rows[0]);
	$('#win1').panel('open',true);
		var f=$('#qq').form();
			var permission = f.find('input[name=role]');
												 permission.combobox({
										    	  prompt:'创建根部门，选择当前创建的部门的角色',
										      		url : 'comboboxRole.action',
										      		valueField :'number',
													 textField :'roleId',
										      		mode : 'remote',
										     		 width : 300,
										      		hasDownArrow : true,
										      		editable : true,
										      		multiple : true
													});
			f.form('load',{
  			userid : rows[0].userid,
  						});
	}
	
	function AddRoles()
	{
 if ($('#qq').form('validate')) {
	$('#qq').form('submit', {
							 url : 'updateUser.action',
								queryParams : $('#qq').serialize(),
								success : function(data) {
								$.messager.show({
											title:'更新用户提示',
											msg:'更新用户成功',
											timeout:5000,
											showType:'slide'
										});
						 $('#win1').panel('close',true);
						$('#qq').form('clear');
								},
								onLoadError : function()
								{
								$.messager.show({
											title:'用户添加角色提示',
											msg:'用户添加角色失败',
											timeout:5000,
											showType:'slide'
										});
								$.messager.confirm({
											title: '用户添加角色提示',
											msg: '是否重新申请用户添加角色',
											fn: function(r){
												if (r){
												 $('#win1').panel('close',false);
												}
											}
										});
								}
							});
						} else {
						$.messager.alert({
							title: '用户添加角色提示',
							msg: '填写相关信息格式不正确'
						});
						}
	}
	
	
	function SearchDepartmentAndUsergroup(i)
	{
		console.info(i);
		var rows = datagrid.datagrid('getRows'); 
		//console.info(rows);//当前页的所有行
		console.info(rows[i]);//选择的哪一行
		 $('#win').panel('open',true);
		 var f=$('#ff').form();
		 var name = '';
		 if(rows[i].department!=undefined)
		 {
		 name = rows[i].department.name;
		 }
		 var usGName = '';
		 if(rows[i].userGroup!=undefined)
		 {
		 usGName = rows[i].userGroup.usGName;
		 }
		 console.info(name+usGName);
		 	f.form('load',{
  			userid : rows[i].userid,
  			name1 : name,
  			usGName : usGName
  		});
  		 rows =undefined;
	}
	   function AddDepartmentAndUsergroup(i)
	{
	console.info(i);
	   							
		 $('#win').panel('open',true);
	   										 $('#name1').combobox({
								    	  prompt:'选择当前部门',
								      		url : 'getDepartment.action',
								      		valueField :'number1',
											 textField :'name',
								      		mode : 'remote',
								      		hasDownArrow : true,
								      		editable : true,
								      		onSelect : function(record)
								      		{
								      		console.info(record);
									  				var f=$('#ff').form();
									  				var usergroup = f.find('input[name=name1]');
									  				console.info(usergroup);
									  				var usergroup = $('#usGName').combobox({
									  					lines : true,
									  					url : 'getUserGroupByDepartment.action',
									  					queryParams : {deparementName : record.number1},
									  					checkbox : true,
									  					width : '600px',
									  					hasDownArrow : true,
								      					editable : true,
									  					valueField :'usGId',
									  					textField : 'usGName',
									  					multiple : true
									  				});
								      		}
           									});
	   }
	   
	   updateUser=function()
	   {
	   	 if ($('#ff').form('validate')) {
							$('#ff').form('submit', {
							 url : 'updateUser.action',
								queryParams : $('#ff').serialize(),
								success : function(data) {
								$.messager.show({
											title:'更新用户提示',
											msg:'更新用户成功',
											timeout:5000,
											showType:'slide'
										});
						 $('#win').panel('close',true);
					$('#pg').propertygrid('load',{});
				$('#pg').datagrid('load',{});
				$('#ff').form('clear');
								},
								onLoadError : function()
								{
								$.messager.show({
											title:'更新用户提示',
											msg:'更新用户失败',
											timeout:5000,
											showType:'slide'
										});
								$.messager.confirm({
											title: '更新用户提示',
											msg: '是否重新申请更新用户',
											fn: function(r){
												if (r){
												 $('#win').panel('close',false);
												}
											}
										});
								}
							});
						} else {
						$.messager.alert({
							title: '申报更新用户提示',
							msg: '填写相关信息格式不正确'
						});
						}
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
  <body>
  <div class="easyui-layout" fit="true" border="false"> 
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

<div id="win" class="easyui-window" title="AddDepartmentAndUsergroup" style="width:600px;height:400px" closed='true'
	   data-options="iconCls:'icon-save',modal:true">
	   <form id="ff">
	   			<div style="margin-bottom:20px">
			<input class="easyui-textbox" data-options="
					label: '用户id',
					labelPosition: 'top',
					prompt: 'Input something here!',
					iconWidth: 22,
					required : true" 
					style="width:300px;width:100%;" name="userid" id="userid"/>
				</div>
				<div style="margin-bottom:20px">
	   				<div style="margin-bottom:20px">
			<input class="easyui-textbox" data-options="
					label: '部门名称',
					labelPosition: 'top',
					prompt: 'Input something here!',
					iconWidth: 22,
					required : true,
					validType : ['String','length[0,20]'],
					missingMessage :'部门名称不能为空',
					icons: [{
						iconCls:'icon-clear',
						handler: function(e){
							$(e.data.target).textbox('clear');
						}
					}],
					iconAlign:'right'" 
					style="width:300px;width:100%;" name="name1" id="name1"/>
				</div>
				<div style="margin-bottom:20px">
			<input class="easyui-textbox" data-options="
					label: '用户组名称',
					labelPosition: 'top',
					prompt: 'Input something here!',
					iconWidth: 22,
					required : true,
					validType : ['String','length[0,20]'],
					missingMessage :'用户组名称不能为空',
					icons: [{
						iconCls:'icon-clear',
						handler: function(e){
							$(e.data.target).textbox('clear');
						}
					}],
					iconAlign:'right'" 
					style="width:300px;width:100%;" name="usGName" id="usGName"/>
				</div>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
        onclick="updateUser();">updateUser</a>
		</form>
	</div>
	
	<div id="win1" class="easyui-window" title="AddDepartmentAndUsergroup" style="width:600px;height:400px" closed='true'
	   data-options="iconCls:'icon-save',modal:true">
	   <form id="qq">
	 		  <div style="margin-bottom:20px" align="center">
		      <label for="userid">用户id</label>
		       <input class="easyui-textbox" type="text" name="userid" id="userid"/>
		     </div>
	   			<div style="margin-bottom:20px" align="center">
		      <label for="role">修改该部门拥有角色:</label>
		       <input class="easyui-validatebox" type="text" name="role" id="role"/>
		     </div>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
        onclick="AddRoles();">AddRoles</a>
		</form>
	</div>
  </body>
</html>
