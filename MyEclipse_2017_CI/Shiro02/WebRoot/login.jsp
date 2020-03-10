<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>通用权限管理</title>
<link rel="stylesheet" type="text/css" href="${baseurl }styles/style.css">

<style type="text/css">
.btnalink{
cursor: hand;
display: block;
width: 80px;
height: 29px;
float: left;
margin: 12px 28px 12px auto;
background: url('${baseurl}images/login/btnbg.jpg') no-repeat;
font-size: 14px;
color: #fff;
font-weight: bold;
text-decoration: none;
}
</style>

<%-- <%@ include file="/WEB-INF/jsp/common_js.jsp"%> --%>
<script type="text/javascript">
//登录提示方法
	Function loginsubmit()
	{
		$("#loginform").submit();
	}
</script>


</head>
<body style="background:#f6fdff url(${baseurl}images/login/bg1.jpg) repeat-x;">
	<form action="${baseurl }login.jsp" name="loginform" id="loginform">
		<div class="logincon">
			<div class="title"><img alt="" src="${baseurl }images/login/logo.png"></div>
			<div class="cen_con"><img alt="" src="${baseurl }images/login/bg2.png"></div>
		</div>
	</form>
	
	<center>
	<table>
		<tr>
			<td>用户名：</td>
			<td colspan="2"><input type="text" id="usercode" name="username" style="width: 130px"></td>
		</tr>
		<tr>
			<td>密码：</td>
			<td><input type="password" id="password" name="password" style="width: 130px"></td>
		</tr>
		<tr>
			<td>验证码：</td>
			<td><input id="randomcode" name="randomcode" size="8"/><img alt="" src="${baseurl }validatecode.jsp" width="56" height="20" align='absMiddle'/>
			<a href="javascript:randomcode_refresh()">刷新</a></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" class="btnalink" onclick="loginsubmit()" value="登&nbsp;&nbsp;陆">
			<input type="reset" class="btnalink" value="重&nbsp;&nbsp;登">
		</tr>
	</table>
	</center>
</body>
</html>