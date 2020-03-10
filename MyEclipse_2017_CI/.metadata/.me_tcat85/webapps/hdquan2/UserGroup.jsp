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
	$(function(){
	})
	lookUsers=function(){
		$('#pg').propertygrid({
	    url: 'getUserGroup.action',
	    showGroup: true,
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
	    groupField : 'group',
	    columns :[[
    		{field:'name',
    		formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].userid;
            	}
            	}
    		},
    		title:'用户编号',width:100,sortable:true},
   		    {field:'value',title:'真实姓名',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].realName;
            	}
            	}
    		},
   		    width:100,resizable:false},
   		    {field:'sex',title:'用户性别',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].sex;
            	}
            	}
    		},
   		    width:100,resizable:false},
   		    {field:'birthday',title:'出生日期',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].birthday;
            	}
            	}
    		},
   		    width:100,resizable:false},
   		    {field:'job',title:'职务',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].job;
            	}
            	}
    		},
   		    width:100,resizable:false},
   		    {field:'PINCodes',title:'身份证号',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].PINCodes;
            	}
            	}
    		},
   		    width:100,resizable:false},
   		    {field:'telephone',title:'联系电话',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].telephone;
            	}
            	}
    		},
   		    width:100,resizable:false},
   		    {field:'eMail',title:'e-mail',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].eMail;
            	}
            	}
    		},
   		    width:100,resizable:false},
   		    {field:'qq',title:'QQ',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].QQ;
            	}
            	}
    		},
   		    width:100,resizable:false},
   		    {field:'postalAddress',title:'通邮地址',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].PostalAddress;
            	}
            	}
    		},
   		    width:100,resizable:false},
   		    {field:'postalCode',title:'邮政编码',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].PostalCode;
            	}
            	}
    		},
   		    width:100,resizable:false},
   		    {field:'MSN',title:'MSN',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!="undefined" && row.attributes.Users.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Users.length;j++){
            	return row.attributes.Users[j].MSN;
            	}
            	}
    		},
   		    width:100,resizable:false}
        ]
        ],
	    scrollbarSize: 0 
		});
	}
	
	lookRoles=function()
	{
	$('#pg').propertygrid({
	    url: 'getUserGroup.action',
	    showGroup: true,
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
	    groupField : 'group',
	    columns :[[
   		    {field:'name',title:'角色ID',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Roles.length && typeof(row.attributes.Roles.length)!="undefined" && row.attributes.Roles.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Roles.length;j++){
            	return row.attributes.Roles[j].roleId;
            	}
            	}
    		},width:200,sortable:true},
   		    {field:'value',title:'权限',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.attributes.Roles.length && typeof(row.attributes.Roles.length)!="undefined" && row.attributes.Roles.length!=0){
            	return '';
            	}else
            	{
            	for(var j=0;j<row.attributes.Roles.length;j++){
            	return row.attributes.Roles[j].permission.name;
            	}
            	}
    		},width:200,sortable:true
    		}
	     ]
        ],
	    scrollbarSize: 0 
		});
	}
	
	insertUserGroup=function(){
		$('#win').window('open',true);
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
     	 }
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
			     			$('#pg').datagrid('unselectAll');
			     	 	 } 
     		}else{
     			$.messager.alert('提示','不能再同一时间编辑几条数据！','error');
     		}
     			 			}
     		},'-',{
     	 text:'保存',
     	 iconCls:'icon-save',
     	 handler:function(){
     	 	$('#pg').datagrid('endEdit',editRow);
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
     		},
     		
     		]
		});
	}
  </script>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
 <body  class="easyui-layout" data-options="fit:true"" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/hdquan2/WebRoot/UserGroup.jsp">
	 <div data-options="region:'north',title:'North Title',split:true" style="height:70px;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-2" data-genuitec-path="/hdquan2/WebRoot/UserGroup.jsp">
	 <a id="btn" onclick="lookUsers();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查看用户组的用户</a>
	  <a id="btn" onclick="lookRoles();" class="easyui-linkbutton" data-options="iconCls:'icon-man'">查看用户组的角色</a>
	   <a id="btn" onclick="insertUserGroup();" class="easyui-linkbutton" data-options="iconCls:'icon-man'">创建用户组</a>
	    <a id="btn" onclick="getUserGroup();" class="easyui-linkbutton" data-options="iconCls:'icon-man'">查看用户组信息</a>
	 </div>
       	<div data-options="region:'center',border:false" style="overflow:hidden;" data-options="fit:true">
		 <table id="pg" style="fit:true"></table>
		</div>
	<div id="win" class="easyui-window" title="addUserGroup" style="width:600px;height:400px" closed='true'
	   data-options="iconCls:'icon-save',modal:true">
	   <form id="ff">
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
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
        onclick="add_UserGroup();">addUserGroup</a>
        </form>
		</div>
   </body>
</html>
