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
  
  $(function()
  {
		
  })
  lookRoles=function()
	{
	$('#pg').propertygrid({
	    url: 'getAllDepartment.action',
	    showGroup: true,
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
	    groupField : 'text',
	    columns :[[
   		    {field:'name',title:'角色ID',
   		  formatter: function(value,row,index)
    		{
    		 if (!row.roles.length && typeof(row.roles.length)!="undefined" && row.roles.length!=0){
            	return '';
            	}else
            	{
            			for(var j=0;j<row.roles.length;j++)
            			{            			
	 					 return row.roles[j].roleId;
            			}
            	}
    		},width:200,sortable:true},
   		    {field:'value',title:'权限',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.roles.length && typeof(row.roles.length)!="undefined" && row.roles.length!=0){
            	return '';
            	}else
            	{
            			for(var j=0;j<row.roles.length;j++)
            			{            			
	 					 return row.roles[j].permission.name;
            			}
            	}
    		},width:200,sortable:true
    		}
	     ]
        ],
	    scrollbarSize: 0 
		});
	}	
  
   lookUsers=function()
	{
	$('#pg').propertygrid({
	    url: 'getAllDepartment.action',
	    showGroup: true,
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
	    groupField : 'text',
	    columns :[[
   		    {field:'userid',title:'用户编号',
   		  formatter: function(value,row,index)
    		{
    		 if (!row.users.length && typeof(row.users.length)!="undefined" && row.users.length!=0){
            	return '';
            	}else
            	{
            			for(var j=0;j<row.users.length;j++)
            			{            			
	 					 return row.users[j].userid;
            			}
            	}
    		},width:200,sortable:true},
   		    {field:'realName',title:'真实姓名',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.users.length && typeof(row.users.length)!="undefined" && row.users.length!=0){
            	return '';
            	}else
            	{
            			for(var j=0;j<row.users.length;j++)
            			{            			
	 					 return row.users[j].realName;
            			}
            	}
    		},width:200,sortable:true
    		},
   		    {field:'sex',title:'性别',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.users.length && typeof(row.users.length)!="undefined" && row.users.length!=0){
            	return '';
            	}else
            	{
            			for(var j=0;j<row.users.length;j++)
            			{            			
	 					 return row.users[j].sex;
            			}
            	}
    		},width:200,sortable:true
    		},
   		    {field:'birthday',title:'出生日期',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.users.length && typeof(row.users.length)!="undefined" && row.users.length!=0){
            	return '';
            	}else
            	{
            			for(var j=0;j<row.users.length;j++)
            			{            			
	 					 return row.users[j].birthday;
            			}
            	}
    		},width:200,sortable:true
    		},
   		    {field:'job',title:'职务',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.users.length && typeof(row.users.length)!="undefined" && row.users.length!=0){
            	return '';
            	}else
            	{
            			for(var j=0;j<row.users.length;j++)
            			{            			
	 					 return row.users[j].job;
            			}
            	}
    		},width:200,sortable:true
    		},
   		    {field:'PINCodes',title:'身份证号',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.users.length && typeof(row.users.length)!="undefined" && row.users.length!=0){
            	return '';
            	}else
            	{
            			for(var j=0;j<row.users.length;j++)
            			{            			
	 					 return row.users[j].PINCodes;
            			}
            	}
    		},width:200,sortable:true
    		},
   		    {field:'telephone',title:'联系电话',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.users.length && typeof(row.users.length)!="undefined" && row.users.length!=0){
            	return '';
            	}else
            	{
            			for(var j=0;j<row.users.length;j++)
            			{            			
	 					 return row.users[j].telephone;
            			}
            	}
    		},width:200,sortable:true
    		},
   		    {field:'fixedPhone',title:'固定电话',
   		    formatter :function(value,row,index)
    		{
    		 if (!row.users.length && typeof(row.users.length)!="undefined" && row.users.length!=0){
            	return '';
            	}else
            	{
            			for(var j=0;j<row.users.length;j++)
            			{            			
	 					 return row.users[j].fixedPhone;
            			}
            	}
    		},width:200,sortable:true
    		}
	     ]
        ],
	    scrollbarSize: 0 
		});
	}	
		function edit(){
				var rows=$('#tg').datagrid('getSelections');
				var p;
		if(rows.length == 1){
			p=$('#dd').dialog({
  			title : '修改部门',
  			href : '',
  			width : 420,
  			height : 380 ,
  			buttons: [{
  				text : '修改提交',
  				handler : function()
  				{
  					var f=$('#dd').find('form');
  					f.form('submit',{
  					url:'updateDepartment.action',
  					success : function(data)
  					{
  							console.info(data);
  						$('#dd').dialog('close',true);
  						 $('#tg').treegrid('load',{});
  						$('#tg').treegrid('unselectAll');
  				
  						$.messager.show({
							title:'部门提示',
							msg:'修改部门信息成功',
							timeout:5000,
							showType:'slide'
									});
  					},
  					onLoadError : function()
  					{
  						$('#dd').dialog('close',true);
  						$('#tg').treegrid('unselectAll');
  						$.messager.show({
							title:'部门提示',
							msg:'修改部门信息失败，请重新尝试',
							timeout:5000,
							showType:'slide'
									});
  					}
  					});
  				}
  			}],
  			onOpen : function()
  			{
				console.info(rows[0]);
			var f=$('#dd').find('form');
  			f.form('load',{
  			name : rows[0].text,
  			headerName : rows[0].attributes.headerName,
  			officeLocation : rows[0].attributes.officeLocation,
  			telephone : rows[0].attributes.telephone,
  			number1 : rows[0].id,
  			parentDepartment : rows[0]._parentId
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
		function save(){
			if (editingId != undefined){
				var t = $('#tg');
				t.treegrid('endEdit', editingId);
				editingId = undefined;
				var rows=$('#tg').datagrid('getSelections');
			
			}
		}
		
		//递归删除
		function panduan(rows,i,ids){
		if(rows[i].children)
  					{
			for(var j=0;j<rows[i].children.length;j++)
	  					{
	  					panduan(rows[i].children,j,ids);
	  					ids.push(rows[i].children[j].id);
	  					}
	  			}else{}
		}
		
	function cancel(){
	var rows = $('#tg').treegrid('getSelections');
	console.info(rows);
  	var ids = [];
  	if(rows.length > 0)
  	{
  		$.messager.confirm('请确认','您要删除当前所选部门？',function(r){
  			if(r)
  			{
  				for(var i=0;i<rows.length;i++)
  				{
  					ids.push(rows[i].id);
	  				panduan(rows,i,ids);
  				}
  				$.ajax({
  					url : 'deleteDepartment.action',
  					data : {
  						ids : ids.join(',')
  					},
  					dataType : 'json',
  					success: function(d)
  					{
  						$('#tg').treegrid('unselectAll');
  						$('#tg').treegrid('load',{});
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
  		$.messager.alert('提示','请勾选要删除的部门!','error');
  	}
		}
	
		 add_department=function(){ 
			addForm =$('#adddepartment').form();
		 if ($('#adddepartment').form('validate')) {
		 		$.ajax({
					  url : 'insertDepartment.action',
					  type : 'POST',
					  data : $('#adddepartment').serializeObject(),
					  dataType : "json",
					  traditional:true,
					  success : function(data) {
					   $('#tg').treegrid('load',{});
								$.messager.show({
											title:'申请部门提示',
											msg:'申请部门成功',
											timeout:5000,
											showType:'slide'
										});
						 $('#adddepartment').form('clear');
						 $('#win').panel('close',true);
					   },
					   error : function (XMLHttpRequest, textStatus, errorThrown) {
					  		$.messager.show({
											title:'申请部门提示',
											msg:'申请部门失败',
											timeout:5000,
											showType:'slide'
										}),
								$.messager.confirm({
											title: '申请部门提示',
											msg: '是否重新申请部门',
											fn: function(r){
												if (r){
												 $('#win').panel('close',false);
												}
											}
										})
					   }		  
												 });
						} else {
						$.messager.alert({
							title: '申报部门提示',
							msg: '填写相关信息格式不正确'
						});
						}
									}
						
	</script>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
 <body class="easyui-layout" data-options="fit:true" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-5" data-genuitec-path="/hdquan2/WebRoot/deparment.jsp">
 
 	<div data-options="region:'center',border:false" style="overflow:hidden;" data-options="fit:true" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-5" data-genuitec-path="/hdquan2/WebRoot/deparment.jsp">
 	<table id="tg" class="easyui-treegrid" title="部门管理" style="fit:true"
			data-options="
				iconCls: 'icon-ok',
				rownumbers: true,
				animate: true,
				collapsible: true,
				fitColumns: false,
				url: 'getAllDepartment.action',
				method: 'get',
				idField: 'id',
				treeField: 'text',
				pagination: true,
				pageSize: 8,
				pageList: [2,5,10],
				showFooter: true,
				toolbar: [{
							iconCls: 'icon-edit',
							handler: function(){
							edit();
							}
						},'-',{
							iconCls: 'icon-cancel',
							handler: function(){
						cancel();
							}
						},'-',{
							iconCls: 'icon-add',
							handler: function(){
								     $('#win').panel('open',true);
								      $('#parentDepartment').combobox({
								    	  prompt:'输入首关键字自动检索',
								      		url : 'getDepartment.action',
								      		valueField :'number1',
											 textField :'name',
								      		mode : 'remote',
								      		hasDownArrow : true,
								      		editable : true,
								      		filter : function(q, row){
                var opts = $(this).combobox('options');
                return row[opts.textField].indexOf(q) == 0;	//???
           													 }
											});
								 		}
						},'-',{
							iconCls: 'icon-man',
							handler: function(){
							lookRoles();
							}
						},'-',{
							iconCls: 'icon-search',
							handler: function(){
							lookUsers();
							}
						}]
			">
		<thead>
			<tr>
				<th data-options="field:'text',width:530,editor:'textbox'">部门名称</th>
				<th data-options="
				field:'headerName',width:200,align:'right',editor:'textbox',
				formatter: function(value,row,index){
				if (!row.attributes && typeof(row.attributes)!='undefined' && row.attributes!=0){
            	return '';
            	}else
            	{return row.attributes.headerName;
            	}
				}
				">负责人</th>
				<th data-options="
				field:'officeLocation',width:200,editor:'textbox',
				formatter: function(value,row,index){
				if (!row.attributes && typeof(row.attributes)!='undefined' && row.attributes!=0){
            	return '';
            	}else
            	{return row.attributes.officeLocation;
            	}
				}
				">办公地点</th>
				<th data-options="
				field:'telephone',width:200,editor:'textbox',
				formatter: function(value,row,index){
				if (!row.attributes && typeof(row.attributes)!='undefined' && row.attributes!=0){
            	return '';
            	}else
            	{return row.attributes.telephone;
            	}
				}
				">值班电话</th>
			</tr>
		</thead>
	</table>
	</div>
	
		 <table id="pg" style="fit:true"></table>
	
		 <table id="pg1" style="fit:true"></table>
	
	<div id="win" class="easyui-dialog" title="addDepartment" style="width:600px;height:400px" closed='true'
	   data-options="iconCls:'icon-save',modal:true">
	   <form id="adddepartment">
	   	<table class="tableForm datagrid-toolbar" style="width:100%;height:100%">
	   	
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
					style="width:300px;width:100%;" name="name"/>
			</div>
			<div style="margin-bottom:20px">
			<input class="easyui-textbox" data-options="
					label: '负责人',
					labelPosition: 'top',
					required : true,
					validType : ['String','length[0,20]'],
					missingMessage :'请问负责人是哪位',
					prompt: '',
					iconWidth: 22,
					icons: [{
						iconCls:'icon-clear',
						handler: function(e){
							$(e.data.target).textbox('clear');
						}
					}],
					iconAlign:'right'" 
					style="width:300px;width:100%;" name="headerName" id="headerName"/>
			</div>
			<div style="margin-bottom:20px">
			<input class="easyui-textbox" data-options="
					label: '办公地点',
					labelPosition: 'top',
					prompt: '',
					iconWidth: 22,
					required : true,
					validType : ['String','length[0,20]'],
					missingMessage :'部门办公不能为空',
					icons: [{
						iconCls:'icon-clear',
						handler: function(e){
							$(e.data.target).textbox('clear');
						}
					}],
					iconAlign:'right'" 
					style="width:300px;width:100%;" name="officeLocation" id="officeLocation"/>
			</div>
				<div style="margin-bottom:20px">
			<input class="easyui-textbox" data-options="
					label: '值班电话',
					labelPosition: 'top',
					prompt: '',
					iconWidth: 22,
					required : true,
					validType : ['String','length[0,20]'],
					missingMessage :'值班电话不能为空',
					icons: [{
						iconCls:'icon-clear',
						handler: function(e){
							$(e.data.target).textbox('clear');
						}
					}],
					iconAlign:'right'" 
					style="width:300px;width:100%;" name="telephone"/>
			</div>
					<div style="margin-bottom:20px">
				   <input class="easyui-radiobutton" value="true" label="Leaf of department" name="lastDepartment" id="lastDepartment"/>
				    </div>
					<div style="margin-bottom:20px">
			<input id="parentDepartment" style="width:300px;width:100%;" name="parentDepartment"/>
					</div>
		<div style="margin-bottom:20px">
			<input class="easyui-textbox" label="Description:" labelPosition="top" multiline="true" value="This TextBox will allow the user to enter multiple lines of text." style="width:100%;height:120px" name="Description" id="Description:"/>
		</div>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
        onclick="add_department();">add_department</a>
        			</table>
        </form>
		</div>
		
		 <div id="dd">
    <form id="ff" method="post">
    		<div id="p" class="easyui-panel">
    		 <div>
		    	<div style="margin-bottom:20px" align="center">
		        <label for="number1">部门编号:</label>
		        <input class="easyui-validatebox" type="text" editable="false" name="number1"/>
		        </div>
		    </div>
		   <div>
		    	<div style="margin-bottom:20px" align="center">
		   		  <label for="parentDepartment">上级编号:</label>
		        <input class="easyui-validatebox" type="text" editable="false" name="parentDepartment"/>
		   		 </div>
		  </div>
		 </div>
		    	<div style="margin-bottom:20px" align="center">
		        <label for="name">部门名称:</label>
		        <input class="easyui-validatebox" type="text" name="name"/>
		        </div>
		    <div>
		    	<div style="margin-bottom:20px" align="center">
		        <label for="headerName">&nbsp;负责人:&nbsp;&nbsp;</label>
		        <input class="easyui-validatebox" type="text" name="headerName"/>
		        </div>
		     </div>
		      <div>
		      	<div style="margin-bottom:20px" align="center">
		        <label for="officeLocation">办公地点:</label>
		        <input class="easyui-validatebox" type="text" name="officeLocation"/>
		        </div>
		    </div>
		    <div>
		    	<div style="margin-bottom:20px" align="center">
		        <label for="telephone">值班电话:</label>
		        <input class="easyui-validatebox" type="text" name="telephone"/>
		        </div>
		    </div>
		</form>
    </div>
   </body>
</html>
