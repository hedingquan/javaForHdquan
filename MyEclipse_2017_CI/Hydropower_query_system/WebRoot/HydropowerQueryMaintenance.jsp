<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
 	<jsp:include page="BaseJsp.jsp" />
	 <script type="text/javascript">
	 var datagrid;
	var searchForm;
	var OtherhForm;
	var year;
	var data1;
	var deletedata;
	 $(function(){
	 searchForm=$('#form1').form();
	 OtherhForm=$('#qq').form();
	 datagrid=$('#datagrid').datagrid({
		url:'allWaterElectric.action',
		iconCls:'icon-save',
		pagination:true,
		pageSize:30,
		pageList:[ 10,20,30,40],
		fit:true,
		fitColums:false,
		nowarp:false,
		border:false,
		idField:'id',
		queryParams:{
									year:$('#year').val(),
									season:$('#season').val(),
									name1:$('#name1').val(),
									id1:$('#id1').val(),
									salaryNum:$('#salaryNum').val(),
									building:$('#building').val(),
									unit:$('#unit').val(),
					},
		frozenColumns : [ [
		  {field:'OtherController',
            title:'删除',
            width:50,
            align : 'center',
                formatter : function (value,row,index)
	             {
	              return '  <a href="javascript:void(0)" onclick="userDelete('+row.id+');">删除</a>';
	             }
            },
		  {field:'controller',
            title:'修改',
            width:50,
            align : 'center',
                formatter : function (value,row,index)
	             {
	              return '  <a href="javascript:void(0)" onclick="updateInformation('+index+');">修改</a>';
	             }
            },
		{
            field:'id',
            title:'序号',
            width:50,
            align : 'center'
            },
            {
            field:'name',
            title:'姓名',
            width:50,
            align : 'center'
            },
            {
            field:'salaryNum',
            title:'工资号',
            width:50,
            align : 'center'
            }
            ]],
             columns:[[
           {
            field:'buildingName',
            title:'楼名',
            width:100,
            align : 'center',
             formatter: function(value,row,index){  if(row.room!=undefined && row.room!=''&&row.room.building !=undefined &&  row.room.building!=''){return row.room.building.buildingName; }else{return '';} }
            },
            {
            field:'uName',
            title:'单元',
            width:50,
            align : 'center',
             formatter: function(value,row,index){if(row.unit!=undefined && row.unit!=''){return row.unit.uName;}else{return '';}}
            }, {
            field:'season',
            title:'季度',
            width:50,
            align : 'center'
            }, {
            field:'lastelectricNum',
            title:'电上次表低',
            width:100,
            align : 'center'
            }, {
            field:'electricNum',
            title:'电本季读数',
            width:100,
            align : 'center'
            },{
            field:'Bill',
            title:'电本季度数',
            width:100,
            align : 'center',
            formatter: function(value,row,index){return row.electricNum-row.lastelectricNum;}
            },{
            field:'electricBill',
            title:'电单价',
            width:100,
            align : 'center'
            },{
            field:'electricmoney',
            title:'电金额',
            width:100,
            align : 'center',
            formatter: function(value,row,index){return (row.electricNum-row.lastelectricNum)*row.electricBill;}
            },{
            field:'lastewaterNum',
            title:'水上次表低',
            width:100,
            align : 'center'
            }, {
            field:'waterNum',
            title:'水本季读数',
            width:100,
            align : 'center'
            },{
            field:'Bill1',
            title:'水本季方数',
            width:100,
            align : 'center',
            formatter: function(value,row,index){return row.waterNum-row.lastewaterNum;}
            },{
            field:'waterBill',
            title:'水单价',
            width:100,
            align : 'center'
            },{
            field:'watermoney',
            title:'水金额',
            width:100,
            align : 'center',
            formatter: function(value,row,index){return (row.waterNum-row.lastewaterNum)*row.waterBill;}
            },{
            field:'addition',
            title:'备注',
            width:200,
            align : 'center'
            }
            ]],
            onLoadSuccess:function(data)
            {
            	data1=data;
            }
	 	});
	 	    
	 	     year= $('#year').combobox({
			        url:'waterElectricYear.action',
			        prompt:'年份',
			        valueField : 'season',
			        textField : 'season',
			    });
			    
			     $('#building').combobox({
			        url:'buildingName.action',
			         prompt:'楼名',
			        valueField : 'buildingName',
			        textField : 'buildingName',
			    });
			    
			       $('#unit').combobox({
			        url:'Unit.action',
			         prompt:'单元',
			        valueField : 'uName',
			        textField : 'uName',
			    });
	 	    
	 	    	search_user=function ()
				{
							$('#datagrid').datagrid('load',{
							year:$('#year').val(),
							season:$('#season').val(),
							name1:$('#name1').val(),
							id1:$('#id1').val(),
							salaryNum:$('#salaryNum').val(),
							building:$('#building').val(),
							unit:$('#unit').val(),
							});
				}
	 	   
	 	    clear_data=function()
			{
			$('#datagrid').datagrid('load',{});
			searchForm.find('input').val('');
			}
			
	updateInformation =function(i)
	{
		var rows = datagrid.datagrid('getRows'); 
		deletedata=rows[i];
		 $('#win1').panel('open',true);
		 var f=$('#qq').form();
		 	f.form('load',{
		 	id1 : rows[i].id,
  			name1 : rows[i].name,
  			UnitName : rows[i].unit.uName,
  			Season2 : rows[i].season.split('第',2)[0],
  			Season5 : rows[i].season.replace(rows[i].season.split('第',2)[0]+'第','第'),
  			salaryNum : rows[i].salaryNum,
  			buildingName : rows[i].room.building.buildingName,
  			uName : rows[i].room.roomNum,
  			roomNum : rows[i].room.roomNum,
  			addition : rows[i].addition,
  			lastelectricNum : rows[i].lastelectricNum,
  			electricNum : rows[i].electricNum,
  			electricBill : rows[i].electricBill,
  			lastewaterNum : rows[i].lastewaterNum,
  			waterNum : rows[i].waterNum,
  			waterBill : rows[i].waterBill,
  			check_electric_time : rows[i].check_electric_time,
  			check_water_time : rows[i].check_water_time
  		});
  		 rows =undefined;
	}
	 
	 	    add_user=function ()
	 	    {
	 	     $('#win1').panel('open',true);
	 	      OtherhForm.form('clear'); 
	 	         $('#buildingName').combobox({
			        url:'BuildingNameForWaterElectri.action',
			         prompt:'楼名',
			        valueField : 'buildingName',
			        textField : 'buildingName',
			        onSelect : function(record)
			        {
			        console.info(record);
			          $('#roomNum').combobox({
					        url:'roomNumForWaterElectri.action',
					         prompt:'房号',
					          queryParams:{buildingName: record.buildingName},
					        valueField : 'roomNum',
					        textField : 'roomNum',
					    });
			        }
			    });
			    
			       $('#uName').combobox({
			        url:'UnitForWaterElectri.action',
			         prompt:'单元',
			        valueField : 'uName',
			        textField : 'uName',
			    });
			       
	 	       OtherhForm.form('submit', {
		        url:'AddWaterElectricInfo.action',
		        	success: function(){
									$('#win1').window('close');
										$('#datagrid').datagrid('load',{});
							}
	 	    });
	 	    }
	 	    userSave=function()
	 	    {
	 	     OtherhForm.form('submit', {
		        url:'AddWaterElectricInfo.action',
		        	success: function(data){
									$('#win1').window('close');
							}
	 	    });
	 	    }
	 	    
	 	    userDelete = function(a)
	 	    {
			 	   $.ajax({
		  					url : 'deleteAccount.action',
		  					data : {
		  						id : a
		  					},
		  					dataType : 'json',
		  					  success: function(msg){
				  						$.messager.show({
				  							title : '提示',
				  							msg : '删除成功！'
				  						}); 
							   }
		  				});
	 	    }
	 	    
	 	    printf_info =function(a)
	 	    {
	 	    	var href='';
	 	    if(a==0)
	 	    {
	 	    	href="print.action";
	 	    }else{
	 	   		 href="statistics.action";
	 	    }
	 	    	var centerTabs=$('#cc').layout('panel','center');
	 	    			var year=$('#year').val();
						var	season=$('#season').val();
						var	name1=$('#name1').val();
						var	id1=$('#id1').val();
						var	salaryNum=$('#salaryNum').val();
						var	building=$('#building').val();
						var	unit=$('#unit').val();
	 	    if(year!=undefined && year!=''|| season!=undefined && season!=''||name1!=undefined && name1!=''||id1!=undefined && id1!=''||salaryNum!=undefined && salaryNum!=''||building!=undefined && building!=''||unit!=undefined && unit!='')
	 	    {window.parent.location.href=href+'?year='+year+'&season='+season+'&name1='+name1+'&id1='+id1+'&salaryNum='+salaryNum+'&building='+building+'&unit='+unit;  }else{	window.parent.location.href=href;  }  
	 	    }
	 	    
	 	    closeWindow = function()
	 	    {
	 	    $('#win1').window('close');
	 	    }
	 });
	 </script>
  </head>
  
  <body>
	   <div id="cc" class="easyui-layout" style="width:100%;height:100%;">
	    <div id="form1" data-options="region:'north'" style="width:110%;height:130px;">
	   		<h3 align="center">教工水电资料维护</h3>
	       <input id="year" name="Year">
			    <input id="season" class="easyui-combobox" name="season" data-options="
			    prompt:'季度',
				valueField: 'label',
				textField: 'value',
				data: [{
					label: '第1季度',
					value: '第1季度'
				},{
					label: '第2季度',
					value: '第2季度'
				},{
					label: '第3季度',
					value: '第3季度'
				},{
					label: '第4季度',
					value: '第4季度'
				}]"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 <input id="name1" class="easyui-textbox" prompt='姓名' name="name1">
				  <input id="id1" class="easyui-textbox" prompt='序号' name="id1">
				   <input id="salaryNum" class="easyui-textbox" prompt='工资号' name="salaryNum">
				<br/>
				 <input id="building" name="building">
				  <input id="unit" name="unit">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  <a href="javascript:void(0);" class="easyui-linkbutton" onclick="clear_data();">清空</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" onclick="search_user();">查询</a>
				 <a href="javascript:void(0);" class="easyui-linkbutton" onclick="add_user();">新增</a>
				  <a href="javascript:void(0);" class="easyui-linkbutton" onclick="printf_info(0);">打印</a>
				     <a href="javascript:void(0);" class="easyui-linkbutton" onclick="printf_info(1);">统计</a>
				         <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">公告栏</a>
				  	    </div>
	   	 	<div data-options="region:'center'">
					 <table id="datagrid"></table>
	        </div>
        </div>
 		</div>
 		
 	<div id="win1" class="easyui-window" title="教工水电资料编辑" style="width:600px;height:650px" closed='true' closable="false"
	   data-options="iconCls:'icon-save',modal:true" align="center">
	   <form id="qq">
	   				<h3 align="center">教工水电资料编辑</h3>
	   				 <div style="margin-bottom:20px" align="center" style="display:none;">
	   				   <label for="name1" style="display:none;">序号</label>
					       <input name="id1" id="id1" style="display:none;" editable='false'/>
					       </div>
	 		  <div style="margin-bottom:20px" align="center">
		      <label for="name1">姓名</label>
		       <input class="easyui-textbox" type="text" name="name1" id="name1" style="width:150px" required='true'/>
		       &nbsp;&nbsp;&nbsp;
		        <label for="UnitName">单位</label>
		       <input class="easyui-textbox" type="text" name="UnitName" id="UnitName" style="width:150px" required='true'/>
		     </div>
		     <div style="margin-bottom:20px" align="center">
		      <label for="Season2">年份</label>
		       <input class="easyui-textbox" type="text" name="Season2" id="Season2" required='true'/> 
		       &nbsp;&nbsp;&nbsp;
		        <label for="Season5">季度</label>
		       <input class="easyui-textbox" type="text" name="Season5" id="Season5" required='true'/> 
		     </div>
		       <div style="margin-bottom:20px" align="center">
		        <label for="salaryNum">工资号</label>
		       <input class="easyui-textbox" type="text" name="salaryNum" id="salaryNum" required='true' style="width:250px"/>
		       </div>
		     <div style="margin-bottom:20px" align="center">
		      <label for="buildingName">楼名</label>
		       <input class="easyui-textbox" type="text" name="buildingName" id="buildingName" style="width:100px" required='true'/>
		        <label for="uName">单元</label>
		       <input class="easyui-textbox" type="text" name="uName" id="uName" style="width:100px" required='true'/>
		        <label for="roomNum">房号</label>
		       <input class="easyui-textbox" type="text" name="roomNum" id="roomNum" style="width:100px" required='true'/>
		     </div>
		     <div style="margin-bottom:20px" align="center">
		      <label for="addition">备注</label>
		       <input class="easyui-textbox" type="text" name="addition" id="addition" style="width:400px"/>
		     </div>
		     ---------------------------------电费----------------------------------------------<br>
		    <div style="margin-bottom:20px" align="center">
		      <label for="lastelectricNum"> 上季表底:</label>
		       <input class="easyui-textbox" type="text" name="lastelectricNum" id="lastelectricNum" required='true'/> 
		       &nbsp;&nbsp;&nbsp;
		       <label for="electricNum">本季读数</label>
		       <input class="easyui-textbox" type="text" name="electricNum" id="electricNum" required='true'/>
		     </div>  
		     <div style="margin-bottom:20px" align="center">
		      <label for="electricBill">单价</label>
		       <input class="easyui-textbox" type="text" name="electricBill" id="electricBill" required='true'/> 
		       &nbsp;&nbsp;&nbsp;
		       <label for="check_electric_time">抄表时间</label>
		       <input class="easyui-datetimebox" name="check_electric_time" id="check_electric_time" data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:150px">
		     </div>
		      ---------------------------------水费----------------------------------------------<br>
		    <div style="margin-bottom:20px" align="center">
		      <label for="lastewaterNum"> 上季表底:</label>
		       <input class="easyui-textbox" type="text" name="lastewaterNum" id="lastewaterNum" required='true'/> 
		       &nbsp;&nbsp;&nbsp;
		       <label for="waterNum">本季读数</label>
		       <input class="easyui-textbox" type="text" name="waterNum" id="waterNum" required='true'/>
		     </div>  
		     <div style="margin-bottom:20px" align="center">
		      <label for="waterBill">单价</label>
		       <input class="easyui-textbox" type="text" name="waterBill" id="waterBill" required='true'/> 
		       &nbsp;&nbsp;&nbsp;
		       <label for="check_water_time">抄表时间</label>
		       <input class="easyui-datetimebox" name="check_water_time" id="check_water_time" data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:150px">
		     </div>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="userSave();">保存</a>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-close'" onclick="closeWindow()">关闭</a>
		</form>
	</div>
  </body>
</html>