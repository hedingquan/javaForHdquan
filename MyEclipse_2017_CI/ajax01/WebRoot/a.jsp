<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function register()
	{
	 	var $mobile=$("#mobile").val();
	 /* 		$.ajax({
	url:"MobileServlet",
	请求方式:"post",
	data:"mobile="+$mobile,
	success:function(result,testStatus)
	{
	if(result=="true")
		{alert("号码已存在，请更换");
		}else
		{alert("注册成功！");
		}
	},
	error:function(xhr,errorMessage,e)
	{
		alert("系统异常");
	}
	});
	$.post(
	"MobileServlet",
	"mobile="+$mobile,
	function(result){
	if(result=="true")
		{alert("号码已存在，请更换");
		}else
		{alert("注册成功！");
		}
	},
	"text"
	); 
	$("#tip").load(
		"MobileServlet",
		"mobile="+$mobile
		);
		
		//JSON
		var student={"name":"zs","age":23};
		//alert(student.name+"--"+student.age);
		//var name=["xxx","xx","xx"]
		var students=[
				{"name":"zs" , "age":23},
				{"name":"ls","age":24},
				{"name":"ww","age":25}
		];
		alert(students[1].name+"--"+students[1].age);
		
		$.getJSON(
			"MobileServlet",
		//	"mobile="+$mobile,
			{"mobile":$mobile},//"a":"b","c":"d",json的优势在于传参可以快速地写多个
			function(result){//msg:true|false
					if(result.msg=="true")
					{alert("号码已存在，请更换");
					}else
					{alert("注册成功！");
					}
				}
				);
		}
		*/
		function testJson()
		{
			$.getJSON(
			"JsonServlet",
			{"name":"zs","age":24},//要传进后台的值
			function(result){
					//js需要通过eval()函数，将返回值转为一个js能够识别的json对象
					var json=eval(result);//var jsonStudent=eval(result.stu1);
					$.each(json,function(i,element){//i表示下标，element表示当前元素
					alert(this.name+"---"+this.age);
					});//alert(jsonStudent.name+"--"+jsonStudent.age);
				}
				);
		}
	}
</script>

<title>Insert title here</title>
</head>
<body>
		手机<input id="mobile"/>
		<br/>
		<input type="button" value="注册" onclick="register()"/>
		<span id="tip"></span>
		<input type="button" value="测试json" onclick="testJson()"/>
</body>
</html>