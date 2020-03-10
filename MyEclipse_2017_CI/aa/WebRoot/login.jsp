<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String url = request.getRequestURL().toString();
	url = url.substring(0, url.indexOf('/', url.indexOf("//") + 2));
	String context = request.getContextPath();
	url += context;
	application.setAttribute("ctx", url);
	String loginName = request.getParameter("username");
	String password = request.getParameter("password");
	System.out.println(loginName+"xxx"+password);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html;" charset="UTF-8">
  	<script type="text/javascript" src="js/jquery-easyui-1.8.2/jquery.min.js" charset="uft-8"></script> 
  	<script type="text/javascript" src="js/jquery-easyui-1.8.2/jquery.easyui.min.js" charset="uft-8"></script>
     <script type="text/javascript" src="js/jquery-easyui-1.8.2/locale/easyui-lang-zh_CN.js" charset="uft-8"></script> 
   <link rel="stylesheet" href="js/jquery-easyui-1.8.2/themes/gray/easyui.css" type="text/css">
    <link rel="stylesheet" href="js/jquery-easyui-1.8.2/themes/icon.css" type="text/css"> 
    
  </head>
<!-- <script type="text/javascript" charset="utf-8">
      $(function () {
            $("#loginDialog").dialog({
                title: "登录",
                iconCls: "icon-remove",
                modal: true,
                width: 300,
                height: 150,
                buttons: [
                    {
                        iconCls: "icon-add",
                        text: "登录",
                        handler: function () {
                            console.log("登录");                      
                            //表单验证
                            ajaxfrmCheck();
                        }
                    },
                    {
                        iconCls: "icon-reload",
                        text: "重置",
                        handler: function () {
                            console.log("重置");
		  			 $("#frm").form("clear");
                        }
                    }
                ]
 
 
            });
		
	function ajaxfrmCheck() {
                $("#frm").form('submit', {
                    url: "login.action",
                    onSubmit: function () {
                        var username = $("#username").val();
                        var password = $("#password").val();
                        if (username == "" || password == "")
                        {
                            $.messager.alert("提示", "请输入用户名和密码！")
                            return false;//阻止表单提交
                        }
                    },
                    success: function (data) {
                     /*    var jsonData = $.parseJSON(data);//$.parseJSON()将json数据转化为对象
                        console.info(jsonData);
                        $.messager.alert("消息", jsonData.Message);//jsonData为一个对象,在这里相当于MessageInfo类
                     */}
                })
            }
        }); 
		     <div id="loginDialog" title="用户登录">
		         </div>
</script>


<body>

  <form action="login.action" method="post">
		username: <input type="text" name="username"><br>
		password: <input type="password" name="password"><br>
		<img src="kaptcha.jpg" /> <input type="text" name="captchaCode"/>
	<input type="submit" value="登录">
	</form>

  </body>
  
  -->
  		
  <body class="easyui-layout" style="background-size: 100%;">
		<div id="w" class="easyui-window" title="用户登录" collapsible="false"
			minimizable="false" maximizable="false" icon="icon-save"
			style="width: 450px; height: 330px; padding: 30px; background: #fafafa;"
			data-options="closable:false,draggable:false">
			
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
				<div style="margin-bottom: 20px">
					 <input class="easyui-textbox" id="captchaCode" name="captchaCode"
						prompt="验证码" iconWidth="28"
						data-options="label:'验证码:',required:true,missingMessage:''"
						style="width: 200px; height: 30px;">
					 <img src="kaptcha.jpg"/>
				</div>  
			</form>
			<div style="text-align: center; padding: 5px 0">
				<a href="javascript:void(0)" id="login-submit-btn"
					class="easyui-linkbutton" style="width: 80px">登录</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="clearForm()" style="width: 80px">取消</a>
			</div>
		</div>
<script charset="utf-8">
			$(function(){ 
				if("${msg }"!=""){ 
					//$.messager.alert('提示',"${msg }");
					var showmsg="${msg }";
					$.messager.show({
						title:'提示',
						msg:showmsg
					});
				}
				/*获取焦点*/
				$('#username').textbox('textbox').focus(); 
				/** 给登录按钮绑定点击事件  */
				$("#login-submit-btn").on("click", function() {
					/** 校验登录参数 ctrl+K */
					var username = $("#username").val();
					var password = $("#password").val();
					var captchaCode = $("#captchaCode").val();
						console.info(username);
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

				/* 	$.ajax({
						url:'login.action',
						type: "POST",
						data:{
						username:username,
						password:password,
						captchaCode:captchaCode
						},
						error:function(){
							$.messager.alert('提示','请求失败!')
						},
						success:function(res){
						 if(res.strresult=='OK'){
							}else{
								$.messager.alert('提示','用户名或者密码错误');
								window.location.href='userlogin.jsp';
							}
						}
					});
				}); */
				/* //相应输入框的回车键
				 $('#formlogin').find('input').on('keyup',function(event){
					if(event.keyCode=='13'){
						$('#formlogin').submit();
					}
				});  */
				
				 /** 按了回车键 */
				$(document).keydown(function(event) {
					if (event.keyCode == 13) {
						$("#login-submit-btn").trigger("click");
					}
				}); 
			function clearForm() {
				$('#formlogin').form('clear');
			}
			});
		</script>
	</body>
</html>