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
  	editRow = undefined;
  	rows=undefined;
	$(function(){
	})
	lookUsers=function(){
		 $('#p_g').panel('close',true);
		  $('#p_g1').panel('open',true);
		$('#pg1').propertygrid({
	    url: 'getUserGroup.action',
	    showGroup: true,
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
		queryParams : {lookusers : true},
	    groupField : 'usGName',
	    groupFormatter : function(group,rows)
	    {
	    for(i=0;i<rows.length;i++)
	    {
	    return rows[i].userGroup.usGName;
	    }
	    },
	    columns :[[
    		{field:'userid',
    		title:'用户编号',width:100,sortable:true},
   		    {field:'value',title:'真实姓名',
   		    width:100,resizable:false},
   		    {field:'sex',title:'用户性别',
   		    width:100,resizable:false},
   		    {field:'birthday',title:'出生日期',
   		    width:100,resizable:false},
   		    {field:'job',title:'职务',
   		    width:100,resizable:false},
   		    {field:'PINCodes',title:'身份证号',
   		    width:100,resizable:false},
   		    {field:'telephone',title:'联系电话',
   		    width:100,resizable:false},
   		    {field:'eMail',title:'e-mail',
   		    width:100,resizable:false},
   		    {field:'qq',title:'QQ',
   		    width:100,resizable:false},
   		    {field:'postalAddress',title:'通邮地址',
   		    width:100,resizable:false},
   		    {field:'postalCode',title:'邮政编码',
   		    width:100,resizable:false},
   		    {field:'MSN',title:'MSN',
   		    width:100,resizable:false}
        ]
        ], 
	    scrollbarSize: 0 
		});
	}
	
	lookRoles=function()
	{
		 $('#p_g1').panel('close',true);
		  $('#p_g').panel('open',true);
	$('#pg').propertygrid({
	    url: 'getUserGroup.action',
	    showGroup: true,
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
	    groupField : 'group',
	    columns :[[
		    {field:'free',
			checkbox:true},
   		    {field:'name',title:'角色ID',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Roles.length && typeof(row.attributes.Roles.length)!="undefined" && row.attributes.Roles.length!=0){
            	return '';
            	}else
            	{
            	var roleids=[];
            	for(var j=0;j<row.attributes.Roles.length;j++){
            	roleids.push(row.attributes.Roles[j].roleId);
            	}
            	return roleids;
            	}
    		},width:200,sortable:true},
   		    {field:'value',title:'权限',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Roles.length && typeof(row.attributes.Roles.length)!="undefined" && row.attributes.Roles.length!=0){
            	return '';
            	}else
            	{
            	var permissions=[];
            	for(var j=0;j<row.attributes.Roles.length;j++){
            	 	for(var i=0;i<row.attributes.Roles[j].permission.length;i++){
		           permissions.push(row.attributes.Roles[j].permission[i].name);
		            	}
            												}
            	return permissions;
            	}
    		},width:200,sortable:true
    		},
            {field:'分配角色',
            title:'控制列',
            width:150,
            align : 'center',
                formatter : function (value,row,index)
	             {
	             rows=row;
	             /*  return '<button onclick="UserGroupAddRoles('+index+');">为用户组分配角色</button>'; */
	               return '<button onclick="UserGroupAddRoles();">为用户组分配角色</button>';
	             }
            }
	     ]
        ],
	    scrollbarSize: 0 
		});
	}
	
	insertUserGroup=function(){
		$('#win').window('open',true);
							 $('#parentDepartment').combobox({
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
									  				var permission = f.find('input[name=permission]');
									  				console.info(permission);
									  				var permissionTree = permission.combotree({
									  					lines : true,
									  					url : 'permission.action',
									  					queryParams : {deparementName : record.number1},
									  					checkbox : true,
									  					width : '600px',
									  					textField : 'name',
									  					multiple : true
									  				});
								      		}
           									});
	}
	
	add_UserGroup=function()
	{
		
		 if ($('#ff').form('validate')) {
							$('#ff').form('submit', {
							 url : 'insertUserGroup.action',
								queryParams : $('#ff').serialize(),
								success : function(data) {
								$.messager.show({
											title:'申请用户组提示',
											msg:'申请用户组成功',
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
											title:'申请用户组提示',
											msg:'申请用户组失败',
											timeout:5000,
											showType:'slide'
										});
								$.messager.confirm({
											title: '申请用户组提示',
											msg: '是否重新申请用户组',
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
							title: '申报用户组提示',
							msg: '填写相关信息格式不正确'
						});
						}
	};
	
	getUserGroup =function()
	{
		 $('#p_g1').panel('close',true);
		  $('#p_g').panel('open',true);
			$('#pg').datagrid({
		    url:'getUserGroup.action',
		    pagination:true,
			pageSize:10,
			pageList:[ 10,20,30,40],
			fit:true,
			fitColums:false,
			nowarp:false,
			border:false,
			idField:'id',
		    columns:[[
		    {field:'free',
			checkbox:true},
		    {field:'id',title:'用户组编号',width:200,sortable:true,editor:false},
		        {field:'leaderName',title:'创建者',
		        formatter :function(value,row,index)
    		{
    			return row.attributes.leaderName;
    		},width:200,sortable:true,editor:{type:'textbox'}},
		        {field:'time',title:'创建时间',
		        formatter :function(value,row,index)
    		{
    			return row.attributes.time;
    		},width:200,sortable:true,editor:false},
		        {field:'descipt',title:'用户组描述',
		        formatter :function(value,row,index)
    		{
    			return row.attributes.descipt;
    		},width:200,sortable:true,editor:{type:'textbox'}},
		    ]],
		 toolbar:[{
     	 text:'增加',
     	 iconCls:'icon-add',
     	 handler:function(){
     	 insertUserGroup();
     	 },
     	 },'-',{
     	 text:'删除',
     	 iconCls:'icon-remove',
     	 handler:function(){
     		var rows= $('#pg').datagrid('getSelections');
     		if(rows.length>0)
     		{
     			$.messager.confirm('请确认','您确定要删除当前所选择的项目吗？',function(b){
     				if(b)
     				{
     				var ids= [];
	     				for(var i=0;i<rows.length;i++)
	     				{
	     					ids.push(rows[i].id)
	     				}
	     				$.ajax({
	     					url : 'deleteUserGroup.action',
					data : {
						ids : ids.join(',')
							},
					dataType : 'json',
					success : function(r)
					{
				$('#pg').datagrid('load',{});
				$('#pg').datagrid('unselectAll');
						$.messager.show({
						title:'提示',
						msg:'删除成功'
						});
					}
	     				})
     				}	
     			});
     		}else{
     			$.messager.alert('提示','请选择要删除的记录！','error');
     		}
     				 }
     			 },'-',{
     	 text:'修改',
     	 iconCls:'icon-edit',
     	 handler:function(){
     		var rows= $('#pg').datagrid('getSelections');
     		if(rows.length==1)
     		{
		     		if(editRow != undefined)
		     			{
				     $('#pg').datagrid('endEdit',editRow);
				     	}
				     	if(editRow == undefined)
				     	{
				     	var index=$('#pg').datagrid('getRowIndex',rows[0]);	
			 				$('#pg').datagrid('beginEdit',index);	
			     			editRow = index;
			     	 	 } 
     		}else{
     			$.messager.alert('提示','不能再同一时间编辑几条数据！','error');
     		}
     			 			}
     		},'-',{
     	 text:'保存',
     	 iconCls:'icon-save',
     	 handler:function(){
     	 	var rows= $('#pg').datagrid('getSelections');
     	 	$('#pg').datagrid('endEdit',editRow);
     	 			$.ajax({
	     					url : 'updateUserGroup.action',
					data : rows[0],
					dataType : 'Json',
					success : function(r)
					{
				$('#pg').datagrid('load',{});
						$.messager.show({
						title:'提示',
						msg:'修改成功'
						});
					}
	     				})
		$('#pg').datagrid('unselectAll');
     	 editRow=undefined;
     	 console.info(editRow);
     			 }
     		},'-',{
     	 text:'取消编辑',
     	 iconCls:'icon-redo',
     	 handler:function(){
     	 		editRow = undefined;
     	 		$('#pg').datagrid('rejectChanges');//回滚
     	 		$('#pg').datagrid('unselectAll');//撤销所选
     			 }
     		},'-',{
     	 text:'取消选中',
     	 iconCls:'icon-redo',
     	 handler:function(){
     	 		editRow = undefined;
     	 		$('#pg').datagrid('unselectAll');//撤销所选
     			 }
     		},'-',{
     	 text:'修改用户组权限',
     	 iconCls:'icon-man',
     	 handler:function(){
     	 		var rows= $('#pg').datagrid('getSelections');
     	 		$('#p').panel('open',true);
     	 		var o=$('#oo').form();
     	 			o.form('load',{
     	 			usGId : rows[0].id
  						});
  						var role = o.find('input[name=role]');
  										 role.combobox({
										    	  prompt:'修改用户组角色',
										      		url : 'updateUserGroupRoles.action',
										      		valueField :'roleId',
													 textField :'roleId',
										      		mode : 'remote',
										      		hasDownArrow : true,
										      		editable : true,
										      		multiple : true,
										      		queryParams : {usGId : rows[0].id}
													});
     	 		console.info(rows);
     			 }
     		},
     		
     		]
		});
	}
	
	function updateUserGroupRoles()
	{
		var o=$('#oo').form();
  					o.form('submit',{
  					url:'updateUserGroupRoles.action',
  					success : function(data)
  					{
  						$('#p').panel('open',false);
  							o.form('clear');
  							console.info(data);
  						$('#p').panel('open',false);
  						$.messager.show({
							title:'部门提示',
							msg:'修改部门信息成功',
							timeout:5000,
							showType:'slide'
									});
  					},
  					});
	}
	
	function UserGroupAddRoles(){
		$('#win1').window('open',true);
  				var f=$('#qq').form();
  				var permission = f.find('input[name=permission]');
  				var permissionTree = permission.combotree({
  					lines : true,
  					url : 'permission.action',
  					checkbox : true,
  					width : '600px',
  					textField : 'name',
  					multiple : true
  				});
  		f.form('load',{
  			usGName : rows.group,
  			leaderName : rows.attributes.leaderName,
  			id : rows.id
  		});
	}
	
	function UserGroupAddRole(){
		 if ($('#qq').form('validate')) {
							$('#qq').form('submit', {
							 url : 'updateUserGroup.action',
								queryParams : $('#qq').serialize(),
								success : function(data) {
								$.messager.show({
											title:'申请用户组提示',
											msg:'申请用户组成功',
											timeout:5000,
											showType:'slide'
										});
						 $('#win1').panel('close',true);
					$('#pg').propertygrid('load',{});
				$('#pg').datagrid('load',{});
				$('#qq').form('clear');
								},
								onLoadError : function()
								{
								$.messager.show({
											title:'修改用户组角色提示',
											msg:'修改用户组角色失败',
											timeout:5000,
											showType:'slide'
										});
								$.messager.confirm({
											title: '申请修改用户组角色提示',
											msg: '是否重新申请修改用户组角色',
											fn: function(r){
												if (r){
												 $('#wi1n').panel('close',false);
												}
											}
										});
								}
							});
						} else {
						$.messager.alert({
							title: '申报修改用户组角色提示',
							msg: '填写相关信息格式不正确'
						});
						}
	}
  </script>
  </head>
 <body  class="easyui-layout" data-options="fit:true"">
	 <div data-options="region:'north',title:'North Title',split:true" style="height:70px;">
	 <a id="btn" onclick="lookUsers();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查看用户组的用户</a>
	  <a id="btn" onclick="lookRoles();" class="easyui-linkbutton" data-options="iconCls:'icon-man'">查看用户组的角色</a>
	   <a id="btn" onclick="insertUserGroup();" class="easyui-linkbutton" data-options="iconCls:'icon-man'">创建用户组</a>
	    <a id="btn" onclick="getUserGroup();" class="easyui-linkbutton" data-options="iconCls:'icon-man'">查看用户组信息</a>
	 </div>
       	<div data-options="region:'center',border:false" style="overflow:hidden;" data-options="width:100%;width:100%;">
       	<div id="p_g" class="easyui-panel" style="width:100%;height:100%">
		 <table id="pg" style="width:100%;width:100%;"></table>
		 </div>
		  	<div id="p_g1" class="easyui-panel" style="width:100%;height:100%">
		 <table id="pg1" style="width:100%;width:100%;"></table>
			 </div>
		</div>
	<div id="win" class="easyui-window" title="addUserGroup" style="width:600px;height:400px" closed='true'
	   data-options="iconCls:'icon-save',modal:true">
	   <form id="ff">
	   				<div style="margin-bottom:20px">
			<input id="parentDepartment" label="选择部门" style="width:300px;width:100%;" name="parentDepartment"/>
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
			<div style="margin-bottom:20px">
			<input class="easyui-textbox" data-options="
					label: '创建者',
					labelPosition: 'top',
					required : true,
					validType : ['String','length[0,20]'],
					missingMessage :'请问创建者是哪位',
					prompt: '',
					iconWidth: 22,
					icons: [{
						iconCls:'icon-clear',
						handler: function(e){
							$(e.data.target).textbox('clear');
						}
					}],
					iconAlign:'right'" 
					style="width:300px;width:100%;" name="leaderName" id="leaderName"/>
			</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" label="Description:" labelPosition="top" multiline="true" value="This TextBox will allow the user to enter multiple lines of text." style="width:100%;height:120px" name="descipt" id="descipt"/>
				</div>
			   <div style="margin-bottom:20px">
		        <label for="permission">添加该用户组拥有权限:</label>
		        <input name="permission" />
		   		 </div>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
        onclick="add_UserGroup();">addUserGroup</a>
        </form>
		</div>
		
			<div id="win1" class="easyui-window" title="UserGroupAddRoles" style="width:600px;height:400px" closed='true'
	   data-options="iconCls:'icon-save',modal:true">
	   <form id="qq">
	   <div style="margin-bottom:20px">
			<input class="easyui-textbox" data-options="
					label: '用户组Id',
					labelPosition: 'top',
					iconWidth: 22,
					required : true,
					icons: [{
						iconCls:'icon-clear',
						handler: function(e){
							$(e.data.target).textbox('clear');
						}
					}],
					iconAlign:'right'" 
					style="width:300px;width:100%;" name="id" id="id"/>
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
			<div style="margin-bottom:20px">
			<input class="easyui-textbox" data-options="
					label: '创建者',
					labelPosition: 'top',
					required : true,
					validType : ['String','length[0,20]'],
					missingMessage :'请问创建者是哪位',
					prompt: '',
					iconWidth: 22,
					icons: [{
						iconCls:'icon-clear',
						handler: function(e){
							$(e.data.target).textbox('clear');
						}
					}],
					iconAlign:'right'" 
					style="width:300px;width:100%;" name="leaderName" id="leaderName"/>
			</div>
				<div style="margin-bottom:20px">
					<input class="easyui-textbox" label="Description:" labelPosition="top" multiline="true" value="This TextBox will allow the user to enter multiple lines of text." style="width:100%;height:120px" name="descipt" id="descipt"/>
				</div>
			   <div style="margin-bottom:20px">
		        <label for="permission">添加该用户组拥有权限:</label>
		        <input name="permission" />
		   		 </div>
		   		
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
        onclick="UserGroupAddRole();">UserGroupAddRoles</a>
        </form>
		</div>
			<div id="p" class="easyui-window" title="UpdateGroupRoles" style="width:600px;height:400px" closed='true'
	   data-options="iconCls:'icon-save',modal:true">
		 <form id="oo" method="post">
    		 <div>
		    	<div style="margin-bottom:20px" align="center">
		        <label for="usGId">用户组编号:</label>
		        <input class="easyui-validatebox" type="text" editable="false" name="usGId" id="usGId"/>
		        </div>
		    </div>
		      <div>
		    	<div style="margin-bottom:20px" align="center">
		      <label for="role">修改该部门拥有角色:</label>
		       <input class="easyui-validatebox" type="text" name="role" id="role"/>
		     </div>
		   	 </div>
		   	 <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
        onclick="updateUserGroupRoles();">updateUserGroupRoles</a>
		 </form>
		 </div>
   </body>
</html>
