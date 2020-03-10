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
	var OtherhForm;
	 	 $(function(){
	 	 $('#year1').combobox({
	 	 prompt:'目的年份',
	 	 editable:false,
	 	 hasDownArrow : false
	 	 });
	   			year= $('#year').combobox({
			        url:'waterElectricYear.action',
			        prompt:'年份',
			        valueField : 'season',
			        textField : 'season',
	 	   			onSelect : function(record)
			        {
			       $('#season').textbox('clear');
			         $('#year1').textbox('clear');
			       $('#season1').textbox('clear');
			       }
			    });
			    	 $('#year4').combobox({
				 	 prompt:'目的年份',
				 	 editable:false,
	 	 			hasDownArrow : false
				 	 });
	   			year= $('#year3').combobox({
			        url:'waterElectricYear.action',
			        prompt:'年份',
			        valueField : 'season',
			        textField : 'season',
	 	 		  onSelect : function(record)
			        {
			       $('#season3').textbox('clear');
			         $('#year4').textbox('clear');
			       $('#season4').textbox('clear');
			       }
			    });
			    });
			   
	 	    TeacherElectricInitialization = function()
	 	    {
			 OtherhForm=$('#qq').form();
	 	        OtherhForm.form('submit', {
		        url:'TeacherElectricInitialization.action',
		        success: function(){
			        $.messager.show({
										title:'教工初始化',
										msg:'教工初始化成功！',
										timeout:5000,
										showType:'slide'
									});
		 	    }
		 	    	});
	 	    }
	 	    OtherElectricInitialization = function()
	 	    {
			 OtherhForm=$('#bb').form();
	 	        OtherhForm.form('submit', {
		        url:'OtherElectricInitialization.action',
		           success: function(){
			        $.messager.show({
										title:'其他水电初始化',
										msg:'其他水电初始化成功！',
										timeout:5000,
										showType:'slide'
									});
		 	    }
	 	    	});
	 	    }
	 	    formatterDate = function (date) {
				var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
				var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"
				+ (date.getMonth() + 1);
				var hor = date.getHours();
				var min = date.getMinutes();
				var sec = date.getSeconds();
				return date.getFullYear() + '-' + month + '-' + day+" "+hor+":"+min+":"+sec;
				};
	 </script>
  </head>
  
  <body>
  <div align="center">
    -----------------------------------------教工--------------------------------------<br>
     <form id="qq">
    				数据源年季: <input id="year" name="year">  
    				 <input id="season" class="easyui-combobox" name="season" data-options="
					    prompt:'季度',
						valueField: 'label',
						textField: 'value',
			        onSelect : function(record)
			        {
			       $('#year1').textbox('setValue','');
			       $('#season1').textbox('setValue','');
			        	if(record.label!='')
			        	{
			        		if(record.label==4)
			        		{
			        		 $('#year1').textbox('setValue',(parseInt($('#year').val().replace('年',''))+1)+'年');
			        		 $('#season1').textbox('setValue','第1季度');
			        		}else{
			        		$('#year1').textbox('setValue',$('#year').val());
			        		$('#season1').textbox('setValue','第'+(parseInt(record.label)+1)+'季度');
			        		}
			        	}
			        },
						data: [{
							label: '1',
							value: '第1季度'
						},{
							label: '2',
							value: '第2季度'
						},{
							label: '3',
							value: '第3季度'
						},{
							label: '4',
							value: '第4季度'
						}]"/><br>
    				目的年季：<input id="year1" name="year1">  
    				 <input id="season1" class="easyui-textbox" name="season1" data-options="prompt:'季度',editable:false"/><br>
    				电单价： <input class="easyui-textbox" id="electricBill" name="electricBill"><br>
    				 抄电表时间：  <input class="easyui-datetimebox" name="check_electric_time" id="check_electric_time" data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:150px"><br>
		    		水单价： <input class="easyui-textbox" id="waterBill" name="waterBill"><br>
    				 抄水表时间：<input class="easyui-datetimebox" name="check_water_time" id="check_water_time" data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:150px">
    	</form>
    	<a href="javascript:void(0);" class="easyui-linkbutton" onclick="TeacherElectricInitialization();">开始</a><br>
    				-----------------------------------------其他--------------------------------------<br>
    	  <form id="bb">			
    				数据源年季: <input id="year3" name="year3">  
    				 <input id="season3" class="easyui-combobox" name="season3" data-options="
					    prompt:'季度',
						valueField: 'label',
						textField: 'value',
			        onSelect : function(record)
			        {
			       $('#year4').textbox('setValue','');
			       $('#season4').textbox('setValue','');
			        	if(record.label!='')
			        	{
			        		if(record.label==4)
			        		{
			        		 $('#year4').textbox('setValue',(parseInt($('#year3').val().replace('年',''))+1)+'年');
			        		 $('#season4').textbox('setValue','第1季度');
			        		}else{
			        		$('#year4').textbox('setValue',$('#year3').val());
			        		$('#season4').textbox('setValue','第'+(parseInt(record.label)+1)+'季度');
			        		}
			        	}
			        },
						data: [{
							label: '1',
							value: '第1季度'
						},{
							label: '2',
							value: '第2季度'
						},{
							label: '3',
							value: '第3季度'
						},{
							label: '4',
							value: '第4季度'
						}]"/><br>
    				目的年季：<input id="year4" name="year4">  
    				 <input id="season4" class="easyui-textbox" name="season4" data-options="prompt:'季度',editable:false"/><br>
    		 </form>
    		 <a href="javascript:void(0);" class="easyui-linkbutton" onclick="OtherElectricInitialization();">开始</a><br>
    				</div>
    			
  </body>
</html>
