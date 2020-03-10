<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("a").click(function(){
		//parent（）父标签
		//prev()前一个兄弟标签
		//jquery中规范，对象名以$开头
		var $td=$(this).parent().prev();
		//html（）返回值是字符串
			$td.html(parseInt($td.html())+1);
			//点击“下载”以后并未实现跳转，但count+1了
		});
	});
	
</script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc8-1" data-genuitec-path="/register/WebRoot/main.jsp">
	<table border="1" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc8-1" data-genuitec-path="/register/WebRoot/main.jsp">
		<tr>
			<td>资料名称</td>
			<td>下载次数</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list }" var="file">
			<tr>
				<td>	${file.name }</td>
				<td>	${file.count }</td>
				<td><a href="download?id=${file.id }&name=${file.name}">下载</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>