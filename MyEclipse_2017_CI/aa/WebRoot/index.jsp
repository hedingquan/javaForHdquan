<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
  </head>
  
  <body>
	<form method="post" action="test.html" name="form1">
		<input type="text" name="username" value="国庆六十周年_1" id="tid_1" onchange="change()"><br/>
		<input type="text" name="username" value="国庆六十周年_2" id="tid_2" onchange=""><br/>
		<input type="text" name="username" value="国庆六十周年_3" id="tid_3" onchange=""><br/>
		<input type="button" name="ok" value="保存">	
	</form>
		<select name="edu" id="edu">  
		<option value="博士">博士</option>
		<option value="硕士">硕士</option>
		<option value="本科" selected="selected">本科</option>
		<option value="幼儿园">幼儿园</option>
		</select>
		<p id="pid" name="888">
			明天上课
		</p>
	<h1 id="h1">
		明天休息
	</h1>
		<ul>
			<li id="bj" value="beijing">
				北京
				<p>海定</p>
				奥运
			</li>
			<li id="sh" value="shanghai">上海</li>
		</ul>
		<ul>
			<li id="fk" value="fankong">反恐</li>
			<li id="jy" value="jingying">精英</li>
		</ul>
	<script language="JavaScript">
	//	var inputElement=document.getElementById("tid");
	//	alert(inputElement.value);
		
	//	alert(inputElement.type);
		
		var inputElements=document.getElementsByName("username");
	//	alert(inputElements.length);//数组的长度
		//遍历数组，输出所有value属性的值
		for(var i=0;i<inputElements.length;i++)
		{
		var inputElement=inputElements[i];
	//	alert(inputElement.value);
		}
		//为每个文本框增加chanage事件，当值改变时，输出改变的值


		/* function change()
		{
			alert(document.getElementById("tid_1").value);
		} */
	
		/* for(var i=0;i<inputElements.length;i++)
		{
		var inputElement=inputElements[i];
			//为每一个文本框注册onchange事件
		inputElement.onchange=function()
		{
		//this表示当前的对象
			alert(this.value);
		}
		} */
		/* var inputElements=document.getElementsByTagName("input");
	//	alert(inputElements.length);
		for(var i=0;i<inputElements.length;i++)
		{
		var inputElement=inputElements[i];
		if(inputElement.type!='button')
		{
		alert(inputElement.value);
		}
		} */
		
		/* var eduSelectElement=document.getElementById("edu");
		var eduOptionsElements=eduSelectElement.getElementsByTagName("option");
		//alert(eduOptionsElements.length);
		for(var i=0;i<eduOptionsElements.length;i++)
		{
		alert(eduOptionsElements[i].value);
		} */
		
/* 		//输出所有下拉选选中的值
		var optionsElements=document.getElementsByTagName("option");
		for(var i=0;i<optionsElements.length;i++)
		{
		alert(optionsElements[i].value);
		} */
		
		//输出下拉选选中的值--取的是value的值，不是外边的值
	//	alert(document.getElementById("edu").value);
		
		//查看id=“edu”的节点是否有子节点
		//alert(document.getElementById("edu").hasChildNodes());
		
		/* var inputElement=document.getElementById("tid_1");
		alert("元素节点的名称"+inputElement.nodeName);
	 */	
		/*  var pidElement=document.getElementById("pid");
		var pidTextElement=pidElement.firstChild;
		 *///alert("文本节点名称"+pidTextElement.nodeName);

		//Attr(属性的意思)，属性节点 id="pid" 中name这个属性节点输出nodeName nodeType nodeValue
		//获取id=pid中name这个属性节点
		/* var attrElement=pidElement.getAttributeNode("name");
		alert("属性节点"+attrElement.nodeName);
		 */
		/* //利用firstChild
		var Element=document.getElementById("h1");
		alert(Element.firstChild.nodeValue);
		//利用chidNode表示父元素下的所有的子元素（数组)
		var element=document.getElementById("h1");
		alert(element.childNodes[0].nodeValue);
		 */
		 
	/* 	 var Element =document.getElementById("bj");
		 var beijing=Element.firstChild;
	//	 alert(beijing.nodeName);
		 alert(beijing.nodeValue);
		 var haiding=Element.childNodes[1];
		// alert(haiding.nodeValue);//nodeValue指的是value
	 */
	 
/* 	 var selectElement=document.getElementById("edu");
	 var optionElements=selectElement.getElementsByTagName("option");
	 for(var i=0;i<optionElements.length;i++)
	 {
	 	var optionElement=optionElements[i];
	 	alert(optionElement.firstChild.nodeValue);
	 } */
	 
/* 	//当文档加载完毕，才执行 onload事件所指定的函数
	 window.onload=function(){
		 //点击北京节点，将被反恐替换
		 document.getElementById("bj").onclick=function()
		 {
		 //替换节点--beijing换fk
		 var beijing=document.getElementById("bj");
		 var fk=document.getElementById("fk");
		 //获取父节点
		 var beijingParent=beijing.parentNode;
		 //替换
		var oldElement= beijingParent.replaceChild(fk,beijing);
		 } 
	 } */
	 
/* 	 //获取fk节点的value属性的值
	 var fk=document.getElementById("fk");
	 alert(fk.getAttribute("id"));//查看id的值 */
	 
/* 	 //给fk增加name属性
	 	 var fk=document.getElementById("fk");
	 	 alert(fk.getAttribute("name"));
	 	 //设置属性
	 	 fk.setAttribute("name", "fk");
	 	 alert(fk.getAttribute("name")); */
	 	 
	 	 //新增节点
	 	 var kf=document.createElement("li");
	 	 kf.setAttribute("id", "kf");
	 	 kf.setAttribute("v", "asd");
	 	 var textElement=document.createTextNode("kf");
	 	  kf.appendChild(textElement);
	 	  var fk=document.getElementById("fk");//获取需要加入的节点
	 	  fk.appendChild(kf);//在该节点追后添加kf
	 	  
	 	  
	 </script>
  </body>
  	
</html>
