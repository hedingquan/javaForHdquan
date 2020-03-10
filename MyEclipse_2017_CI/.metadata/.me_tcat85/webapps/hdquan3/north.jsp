<%@page import="org.apache.shiro.web.subject.support.DefaultWebSubjectContext"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
				<%Object use = session.getAttribute(DefaultWebSubjectContext.PRINCIPALS_SESSION_KEY);
				request.setAttribute("usename", use);
					%>
 	<jsp:include page="BaseJsp.jsp" />					
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'north.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 	 <meta http-equiv="content-type" content="text/html;" charset="UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	var newdata=undefined;
	
			function User_logout(obj){
		console.info(obj);
		if(obj){
			$.ajax({
			url:"logout.action"
			})
		}else{
			$.ajax({
			url:"logout.action"
			})
			window.location.replace("login.jsp")
		}
		}
		
		var usename=${usename };
	
		Seacher_UserInfo=function()
	{
		$.messager.progress();	
	 var f=$('#dd').find('form');
		f.form('submit', {
			url: 'findUserByusercode.action',
			queryParams :{usename},
			onSubmit: function(data){
				var isValid = $(this).form('validate');
				if (!isValid){
					$.messager.progress('close');	
				}
				return isValid;	
			},
			success: function(data){
			console.info(usename);
			newdata=eval('(' + data + ')');
			//console.info(newdata.rows[0]);
			for(var j=0;j<newdata.rows.length;j++)
			{
			console.info(newdata.rows[j]);
				for(var i=0;i<newdata.rows[j].roles.length;i++){
			console.info(newdata.rows[j].roles[i].number);
				}
			}
				$.messager.progress('close');
			$('#dd').window('open');  
						f.form('load',{
  							userid : newdata.rows[0].attributes.user.userid,
  							usercode :newdata.rows[0].attributes.user.usercode,
  							realName :newdata.rows[0].attributes.user.realName,
  							job :newdata.rows[0].attributes.user.job,
  							PINCodes :newdata.rows[0].attributes.user.PINCodes,
  							telephone :newdata.rows[0].attributes.user.telephone,
  							fixedPhone :newdata.rows[0].attributes.user.fixedPhone,
  							PostalCode :newdata.rows[0].attributes.user.PostalCode,
  							eMail :newdata.rows[0].attributes.user.eMail,
  							QQ :newdata.rows[0].attributes.user.QQ,
  							MSN :newdata.rows[0].attributes.user.MSN,
  							PostalAddress :newdata.rows[0].attributes.user.PostalAddress
  						});
			}
		});
	}

	Seacher_UserGroup=function()
	{
		$('#pp').window('open');  
	$('#pg').datagrid({
		url: 'findUserByusercode.action',
		queryParams :{usename},
		    pagination:true,
			pageSize:10,
			pageList:[ 10,20,30,40],
			fit:true,
			fitColums:false,
			nowarp:false,
			border:false,
			idField:'usGId',
		    columns:[[
		    {field:'usGId',title:'用户组编号',
		      		 formatter: function(value,row,index)
    		{
    		 if (!row.length && typeof(row.length)!="undefined" && row.length!=0){
            	return '';
            	}else{
    			return row.id;
            	}
    		},width:200,sortable:true,editor:{type:'textbox'}},
		        {field:'leaderName',title:'创建者',
		       formatter: function(value,row,index)
    		{
    	 if (!row.length && typeof(row.length)!="undefined" && row.length!=0){
            	return '';
            	}else{
    			return row.attributes.leaderName;
            	}
    		},width:200,sortable:true,editor:{type:'textbox'}},
		        {field:'time',title:'创建时间',
		       		 formatter: function(value,row,index)
    		{
    		 if (!row.length && typeof(row.length)!="undefined" && row.length!=0){
            	return '';
            	}else{
    			return row.attributes.time;
            	}
    		},width:200,sortable:true,editor:false},
		        {field:'descipt',title:'用户组描述',
		     		 formatter: function(value,row,index)
    		{
    	 if (!row.length && typeof(row.length)!="undefined" && row.length!=0){
            	return '';
            	}else{
    			return row.attributes.descipt;
            	}
    		},width:200,sortable:true,editor:{type:'textbox'}},
		    ]]
		  	})
	}
	
	Seacher_js=function(){
		$('#qq').window('open');  
	datagridTojs=$('#datagrid').datagrid({
  		url: 'findUserByusercode.action',
		iconCls:'icon-save',
		pagination:true,
		pageSize:10,
		pageList:[ 10,20,30,40],
		fit:true,
		fitColums:false,
		nowarp:false,
		border:false,
		idField:'number',
		queryParams : {
				usename : usename,
				seacher_role :true
		},
		frozenColumns : [ [{
		      field:'number',
		     formatter : function(value,row,rowIndex)
            {
              if (!row.roles.length && typeof(row.roles.length)!="undefined" && row.roles.length!=0){
            	return '';
            	}else
            	{        
            		for(var j=0;j<row.roles.length;j++)
            			{    
            	return row.roles[j].number;
            			}
            }
            },
            title:'编号',
            width:300,
            sortable:true,
            checkbox:true,
            align : 'center'
		}]],
		 columns:[[
		  {
            field:'roleId',
            formatter : function(value,row,rowIndex)
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
            },
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
            formatter : function(value,row,rowIndex)
            {
	            if (!row.roles.length && typeof(row.roles.length)!="undefined" && row.roles.length!=0){
	            	return '';
	            	}else
		            	{    
		      	for(var j=0;j<row.roles.length;j++)
		                   {  
		                     if (!row.roles[j].userGroup && typeof(row.roles[j].userGroup)!="undefined" && row.roles[j].userGroup!=0){
	            	return '';
	            	}else
		            	{  
		            	return row.roles[j].userGroup.usGId;
		            	}
		            }
	            }
            }
            } , {
            field:'name',
            title:'权限',
            width:100,
            align : 'center',
            formatter : function(value,row,rowIndex)
            {
  		 if (!row.roles.length && typeof(row.roles.length)!="undefined" && row.roles.length!=0){
            	return '';
            	}else
            	{
       	for(var j=0;j<row.roles.length;j++)
            	{  
      	     if (!row.roles[j].permission && typeof(row.roles[j].permission)!="undefined" && row.roles[j].permission!=0){
            	return '';
            	}else
            	{
	 				  return row.roles[j].permission.name;
	 				  }
            	}
            }
            }
            }
		 ]]
		 })
}
var User_exclusive_attributes=undefined;
var UserGroup_exclusive_attributes=undefined;
User_Rejection_attribute=function(){
		User_exclusive_attributes=$('#Userexclusive').val();
		console.info(User_exclusive_attributes);
		$.ajax(
			{ 
			url:"User_Rejection_attribute.action",
			data: {User_Rejection_attribute:User_exclusive_attributes}
			})
}
UserGroup_Rejection_attribute=function(){
		UserGroup_exclusive_attributes=$('#UserGroupexclusive').val();
		console.info(UserGroup_exclusive_attributes);
		$.ajax(
			{ 
			url:"UserGroup_Rejection_attribute.action",
			data: {UserGroupExclusiveProperties:UserGroup_exclusive_attributes}
			})
}
</script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-776" data-genuitec-path="/hdquan3/WebRoot/north.jsp">
  <div style="position:absolute; left:0px; buttom:0px;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-776" data-genuitec-path="/hdquan3/WebRoot/north.jsp">
当前用户账号：${usename }
</div>
  <div style="position:absolute; right:0px; buttom:0px;">
  	<a href="javascript:void(0);" class="easyui-menubutton" menu="#layout_north_kzmbMenu" iconCls="icon-help">控制面板</a>
 	<a href="javascript:void(0);" class="easyui-menubutton" menu="#layout_north_zxMenu" iconCls="icon-help">系统面板</a>
 	<a href="javascript:void(0);" class="easyui-menubutton" menu="#layout_north_upMenu" iconCls="icon-danger">用户排他属性面板</a>
 	<a href="javascript:void(0);" class="easyui-menubutton" menu="#layout_north_downMenu" iconCls="icon-danger">用户组排他属性面板</a>
  </div>
  <div id="layout_north_kzmbMenu" style="width:100px; display:none;">
  	<div onclick="Seacher_UserInfo();">个人信息</div>
  </div>
   <div id="layout_north_upMenu" style="width:110px; display:none;">
  			<div> <label>排他角色roleID:</label></div>	
		     <input id="Userexclusive" class="easyui-textbox" name="User_exclusive_attributes" style="width:100px">
  			<div onclick="User_Rejection_attribute();"><button>提交</button></div>
   </div>
      <div id="layout_north_downMenu" style="width:110px; display:none;">
  			<div> <label>排他角色roleID:</label></div>	
		     <input id="UserGroupexclusive" class="easyui-textbox" name="UserGroup_exclusive_attributes" style="width:100px">
  			<div onclick="UserGroup_Rejection_attribute();"><button>提交</button></div>
   </div>
  <!-- onclick="loginAndRegDialog.dialog('open');" -->
  <div id="layout_north_zxMenu" style="width:100px; display:none;">
		 <div onclick="User_logout(false);">重新登录</div>
		 	 	<div onclick="User_logout(true);">退出系统</div>
  </div>
  
  <div id="dd" class="easyui-dialog" title="UserInfo" style="width:600px;height:400px" closed='true'
	   data-options="iconCls:'icon-search',modal:true">
     <form id="ff" method="post">
     <h1>个人信息</h1>
   			  <a id="btn" onclick="Seacher_UserGroup();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询用户组</a>
       <a id="btn" onclick="Seacher_js();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询角色</a>
    		 <div>
		    	<div style="margin-bottom:20px" align="center">
		        <label for="number1">用户编号:</label>
		        <input class="easyui-textbox" name="userid" style="width:100px" readonly='true'>
		     
		        <label>登陆名:&nbsp;</label>
		        <input class="easyui-textbox" name="usercode" style="width:100px" readonly='true'>
		        </div>
		    </div>
		     <div>
		    	<div style="margin-bottom:20px" align="center">
		        <label>真实姓名:</label>
		        <input class="easyui-textbox" name="realName" style="width:100px" readonly='true'>
	
		        <label>职务:&nbsp;&nbsp;&nbsp;&nbsp;</label>
		        <input class="easyui-textbox" name="job" style="width:100px" readonly='true'>
		        </div>
		    </div>
		     <div>
		    	<div style="margin-bottom:20px" align="center">
		        <label>身份证号:</label>
		        <input class="easyui-textbox" name="PINCodes" style="width:100px" readonly='true'>

		        <label>联系电话:</label>
		        <input class="easyui-textbox" name="telephone" style="width:100px" readonly='true'>
		        </div>
		    </div>
		     <div>
		    	<div style="margin-bottom:20px" align="center">
		        <label>固定电话:</label>
		        <input class="easyui-textbox" name="fixedPhone" style="width:100px" readonly='true'>
	
		        <label>邮政编码:</label>
		        <input class="easyui-textbox" name="PostalCode" style="width:100px" readonly='true'>
		        </div>
		    </div>
		     <div>
		    	<div style="margin-bottom:20px" align="center">
		        <label>e-mail:</label>
		        <input class="easyui-textbox" name="eMail" style="width:100px" readonly='true'>

		        <label>QQ:&nbsp;</label>
		        <input class="easyui-textbox" name="QQ" style="width:100px" readonly='true'>
		        </div>
		    </div>
		     <div>
		    	<div style="margin-bottom:20px" align="center">
		        <label>MSN:&nbsp;</label>
		        <input class="easyui-textbox" name="MSN" style="width:100px" readonly='true'>

		        <label>通邮地址:</label>
		        <input class="easyui-textbox" name="PostalAddress" style="width:100px" readonly='true'>
		        </div>
		    </div>
	</form>
</div>
			<div id="pp" class="easyui-dialog" title="UserInfo" style="width:600px;height:400px" closed='true'
				   data-options="iconCls:'icon-search',modal:true">
			 <table id="pg" style="fit:true"></table>
			 </div>
			 	<div id="qq" class="easyui-dialog" title="UserInfo" style="width:600px;height:400px" closed='true'
				   data-options="iconCls:'icon-search',modal:true">
			 <table id="datagrid"></table>
			 	 </div>
  </body>
</html>
