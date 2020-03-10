<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="WebRoot/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
//表单的非空验证
//页面加载完成后执行
//相当于：window.onload=function(){}    $(document).ready(function(){})//onload事件生效一个，$可以多个全部生效
$(function(){
	$("form").submit(function(){
	if($(":text:eq(0)").val()==" "||$(":text:eq(1)").val()==" "||$(":text:eq(2)").val()==" ") 
		alert("请填写完整信息");
		return false;//阻止默认行为	$():选择器    表单选择器，      ：input标签type属性值         等于(:eq(0))---取中第一个      .val():获取里面的内容
	})//监听表单或监听表单的提交按钮	
	
});
</script>
</head>
<body>
<!-- post:字节流，2GB	更安全，效率低
get:字符流 	2KB  不安全，效率高-->
<form action="insert" method="post">
<table border="1">
<tr>
	<td colspan="2" style="text-align:center;font-size:30px;font-weight:bold;">花卉信息</td>
</tr>
<tr>
	<td><b>花卉名称</b></td>
	<td><input type="text" name="name" /></td>
</tr>
<tr>
	<td><b>花卉价格</b></td>
	<td><input type="text" name="price" /></td>
</tr>
<tr>
	<td><b>原产地</b></td>
	<td><input type="text" name="production" /></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"><input type="reset" value="重置"></td>
</tr>
</table>
</form>
</body>
</html>