<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
$(function(){
	$("a").click(function(){
	/*	$.ajax({
			url:'demo',
			data:{"name":"张三"},
			dataType:'html',
			error:function(){
				alert("请求出错。")
			 },
			 success:function(abc){
			 alert("请求成功")
			 },
			 type:'POST'
		});*/
		$.post("demo",{"name":"张三"},function(data){
			var result="";
		for(var i=0;i<data.length;i++)
		{
		result+="<tr>";
		result+="<td>"+data[i].id+"</td>"
		result+="<td>"+data[i].name+"</td>"
		result+="<td>"+data[i].password+"</td>"
		result+="</tr>";
	/*	alert(data.id+""+data.username+""+data.password);*/
		}
		//相当于innerHTML先清空后添加
		$("#mytbody").html(result);
	/*	$("table").append(result);*/
		
	})
		return false;
	})

});

</script>
</head>
<body>
  <a href="demo">跳转</a>
  <table border="1">
  	<thead></thead>
		  <tr>
		  	<td>编号</td>
		  	<td>姓名</td>
		  	<td>密码</td>
		  </tr>
	<tbody id="mytbody"></tbody>
	<tfoot></tfoot>
  </table>
</body>
</html>