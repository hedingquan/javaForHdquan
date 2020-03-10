<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html;" charset="UTF-8">
  	<script type="text/javascript" src="js/jquery-easyui-1.8.2/jquery.min.js" charset="uft-8"></script> 
  	<script type="text/javascript" src="js/jquery-easyui-1.8.2/jquery.easyui.min.js" charset="uft-8"></script>
     <script type="text/javascript" src="js/jquery-easyui-1.8.2/locale/easyui-lang-zh_CN.js" charset="uft-8"></script> 
   <link rel="stylesheet" href="js/jquery-easyui-1.8.2/themes/gray/easyui.css" type="text/css">
    <link rel="stylesheet" href="js/jquery-easyui-1.8.2/themes/icon.css" type="text/css"> 
    
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"63900",secure:"63905"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  <body class="easyui-layout" style="background-size: 100%;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-770" data-genuitec-path="/Hydropower_query_system/WebRoot/login.jsp">
		<div id="w" class="easyui-window" title="用户登录" collapsible="false"
			minimizable="false" maximizable="false" icon="icon-save"
			style="width: 450px; height: 330px; padding: 30px; background: #fafafa;"
			data-options="closable:false,draggable:false" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-770" data-genuitec-path="/Hydropower_query_system/WebRoot/login.jsp">
			
			<form id="formlogin" method="post" action="login.action">
			<!-- menulogin -->
				<div style="margin-bottom: 20px">
					<input class="easyui-textbox" id="username" name="username"
						prompt="username" iconWidth="28" 
						data-options="label:'用户名:',required:true"
						style="width: 300px; height: 34px; padding: 10px;">
				</div>
				<div style="margin-bottom: 20px">
					<input class="easyui-passwordbox" id="password" name="password"
						prompt="password" iconWidth="28"
						data-options="label:'密码:',required:true"
						style="width: 300px; height: 34px; padding: 10px">
				</div>
			</form>
			<div style="text-align: center; padding: 5px 0">
				<a href="javascript:void(0)" id="login-submit-btn"
					class="easyui-linkbutton" style="width: 80px">登录</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="clearForm()" style="width: 80px">清空</a>
			</div>
		</div>
<script charset="utf-8">
			$(function(){ 
				if("${msg }"!=""){ 
					var showmsg="${msg }";
					$.messager.show({
						title:'提示',
						msg:showmsg
					});
				}
				$('#username').textbox('textbox').focus(); 
				$("#login-submit-btn").on("click", function() {
					var username = $("#username").val();
					var password = $("#password").val();
						if($("#formlogin").form('validate')){
						var msg = ""; 
						if (!/^\w{1,20}$/.test(username)) {
							msg = "登录名长度必须是1~20之间";
						} else if (!/^\w{1,20}$/.test(password)) {
							msg = "密码长度必须是1~20之间";
						}
						if (msg != "") {
							$.messager.alert('用户名密码错误',msg,'info');
							return;
						} 
						}
						$("#formlogin").submit();
						});
				
				$(document).keydown(function(event) {
					if (event.keyCode == 13) {
						$("#login-submit-btn").trigger("click");
					}
				}); 
		});
			function clearForm() {
				$('#formlogin').form('clear');
			}
	
		</script>
	</body>
</html>