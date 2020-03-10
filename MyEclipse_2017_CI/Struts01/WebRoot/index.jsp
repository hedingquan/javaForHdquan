<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <!-- target="_parent"n 表示在父页面中打开，打开路径相同意思 -->
  <form action="login" target="_parent" method="post"></form>
  
  
   	<!-- 使用ognl+struts2标签实现计算字符串长度
   		value属性值:ognl表达式
   	 -->
   	<s:property value="'haha'.length()"/>
   	<!-- 获取值栈的值 -->
   	<s:property value="name"/>
	   	<s:property value="user.username"/>
	   	  	<s:property value="user.password"/>
	   	 <!-- list集合数据第一种方式 --> 	
	   	 <s:property value="list[0].username"/>
	   	  <s:property value="list[0].password"/>
	   	  <!-- 类似jstl的foreach标签 s:iterator 遍历值栈的list集合-->
	   	  	<s:iterator value="list">
	   	  		<s:property value="username"/>
	   	  		<s:property value="password"/>
	   	  	</s:iterator>
	   	  <!-- 第三种方式 -->
	   	  	<s:iterator value="list" var="user">
	   	  	<!-- 遍历值栈list集合，得到每个user对象
	   	  		机制：把每次遍历出来的user对象放到context里面--var 值 user	每次遍历user对象引用
	   	  		获取context里面的数据特点：写ognl表达式，
	   	  		使用特殊符号#
	   	  		 -->
	   	  		<s:property value="#user.username"/>
	   	  		<s:property value="#user.password"/>
	   	  	</s:iterator>
	   	  	
	   	  	
	   	  	<!-- 获取push方法设置的值 -->
	   	  		<s:property value="[0].top"/>
	   	  		
	   	  	<!-- 获取context里面数据，写ognl时候，首先添加符号#context的key名称.域对象名称 -->	
	   	  	<s:property value="#request.req"/>
   	<s:debug ></s:debug>
   	
   		<input type="text" name="name" value="123"/>
   		<s:textfield name="username" value="%{#request.req}"></s:textfield>
   	
   	<input type="radio" name="sex" value="女"/>女
   	  	<input type="radio" name="sex" value="男"/>男
   	<!-- form标签 -->
   	<s:form>
   		<!-- 普通输入项 -->
   		<s:textfield name="username" label="username"></s:textfield>
   		
   		<!-- 密码输入项 -->
   		<s:password name="password" label="password"></s:password>
   		<!-- 单选输入项 -->
   		<!-- type="radio"中的value属性值和显示值一样的 -->
   		<s:radio list="{'女','男'}" name="sex" label="性别"></s:radio>
   		<!-- type="radio"中的value属性值和显示值不一样的,使用map中的key，value形式 -->
   		<s:radio list="#{'nv':'女','nan':'男'}" name="sex" label="性别"></s:radio>
   		
		<!-- 复选输入框 -->
		<s:checkbox list="{'女','男'}" name="love" label="爱好"> </s:checkbox>   	
		
		<!-- 下拉复选框 -->
		<s:select list="{'博士后','教授','幼儿园'}" name="college" label="学历"></s:select>
  
  		<!-- 文件上传 -->
  		<s:file name="file" label="文件上传"></s:file>
  		
  		<!-- 隐藏项 -->
  		<s:hidden name="hid" value="">abcd</s:hidden>
  		
  		<!-- 文本域 -->
  		<s:textarea rows="10" cols="3" name="resume" label="简历"> </s:textarea>
  		
  		<!-- 提交按钮 -->
  		<s:submit value="提交"></s:submit>
  		
  		<!-- 重置 -->
  		<s:reset value="重置"></s:reset>
   	</s:form>
  </body>
</html>
