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
	$.post("getMenu",function(data){
		var result="";
		for(var i=0;i<data.length;i++)
		{
		result+="<dl>";
		result+="<dt>"+data[i].name+"</dt>";
			for(var j=0;j<data[i].children.length;j++)
			{
			result+="<dd>"+data[i].children[j].name+"</dd>"
			}
		result+="</dl>";
		}
		$("body").html(result);
	})
})
</script>
</head>
<body>
</body>
</html>