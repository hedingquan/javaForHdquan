/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.9
 * Generated at: 2019-08-20 13:26:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class UserGroup_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "BaseJsp.jsp", out, false);
      out.write("\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("  \teditRow = undefined;\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t})\r\n");
      out.write("\tlookUsers=function(){\r\n");
      out.write("\t\t$('#pg').propertygrid({\r\n");
      out.write("\t    url: 'getUserGroup.action',\r\n");
      out.write("\t    showGroup: true,\r\n");
      out.write("\t\tpagination:true,\r\n");
      out.write("\t\tpageSize:10,\r\n");
      out.write("\t\tpageList:[ 10,20,30,40],\r\n");
      out.write("\t\tfit:true,\r\n");
      out.write("\t    groupField : 'group',\r\n");
      out.write("\t    columns :[[\r\n");
      out.write("    \t\t{field:'name',\r\n");
      out.write("    \t\tformatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].userid;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("    \t\ttitle:'用户编号',width:100,sortable:true},\r\n");
      out.write("   \t\t    {field:'value',title:'真实姓名',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].realName;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false},\r\n");
      out.write("   \t\t    {field:'sex',title:'用户性别',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].sex;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false},\r\n");
      out.write("   \t\t    {field:'birthday',title:'出生日期',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].birthday;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false},\r\n");
      out.write("   \t\t    {field:'job',title:'职务',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].job;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false},\r\n");
      out.write("   \t\t    {field:'PINCodes',title:'身份证号',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].PINCodes;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false},\r\n");
      out.write("   \t\t    {field:'telephone',title:'联系电话',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].telephone;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false},\r\n");
      out.write("   \t\t    {field:'eMail',title:'e-mail',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].eMail;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false},\r\n");
      out.write("   \t\t    {field:'qq',title:'QQ',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].QQ;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false},\r\n");
      out.write("   \t\t    {field:'postalAddress',title:'通邮地址',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].PostalAddress;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false},\r\n");
      out.write("   \t\t    {field:'postalCode',title:'邮政编码',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].PostalCode;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false},\r\n");
      out.write("   \t\t    {field:'MSN',title:'MSN',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Users.length && typeof(row.attributes.Users.length)!=\"undefined\" && row.attributes.Users.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Users.length;j++){\r\n");
      out.write("            \treturn row.attributes.Users[j].MSN;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},\r\n");
      out.write("   \t\t    width:100,resizable:false}\r\n");
      out.write("        ]\r\n");
      out.write("        ],\r\n");
      out.write("\t    scrollbarSize: 0 \r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tlookRoles=function()\r\n");
      out.write("\t{\r\n");
      out.write("\t$('#pg').propertygrid({\r\n");
      out.write("\t    url: 'getUserGroup.action',\r\n");
      out.write("\t    showGroup: true,\r\n");
      out.write("\t\tpagination:true,\r\n");
      out.write("\t\tpageSize:10,\r\n");
      out.write("\t\tpageList:[ 10,20,30,40],\r\n");
      out.write("\t\tfit:true,\r\n");
      out.write("\t    groupField : 'group',\r\n");
      out.write("\t    columns :[[\r\n");
      out.write("   \t\t    {field:'name',title:'角色ID',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Roles.length && typeof(row.attributes.Roles.length)!=\"undefined\" && row.attributes.Roles.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Roles.length;j++){\r\n");
      out.write("            \treturn row.attributes.Roles[j].roleId;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},width:200,sortable:true},\r\n");
      out.write("   \t\t    {field:'value',title:'权限',\r\n");
      out.write("   \t\t    formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t if (!row.attributes.Roles.length && typeof(row.attributes.Roles.length)!=\"undefined\" && row.attributes.Roles.length!=0){\r\n");
      out.write("            \treturn '';\r\n");
      out.write("            \t}else\r\n");
      out.write("            \t{\r\n");
      out.write("            \tfor(var j=0;j<row.attributes.Roles.length;j++){\r\n");
      out.write("            \treturn row.attributes.Roles[j].permission.name;\r\n");
      out.write("            \t}\r\n");
      out.write("            \t}\r\n");
      out.write("    \t\t},width:200,sortable:true\r\n");
      out.write("    \t\t}\r\n");
      out.write("\t     ]\r\n");
      out.write("        ],\r\n");
      out.write("\t    scrollbarSize: 0 \r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tinsertUserGroup=function(){\r\n");
      out.write("\t\t$('#win').window('open',true);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tadd_UserGroup=function()\r\n");
      out.write("\t{\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t if ($('#ff').form('validate')) {\r\n");
      out.write("\t\t\t\t\t\t\t$('#ff').form('submit', {\r\n");
      out.write("\t\t\t\t\t\t\t url : 'insertUserGroup.action',\r\n");
      out.write("\t\t\t\t\t\t\t\tqueryParams : $('#ff').serialize(),\r\n");
      out.write("\t\t\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle:'申请用户组提示',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmsg:'申请用户组成功',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttimeout:5000,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tshowType:'slide'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t $('#win').panel('close',true);\r\n");
      out.write("\t\t\t\t\t$('#pg').propertygrid('load',{});\r\n");
      out.write("\t\t\t\t$('#pg').datagrid('load',{});\r\n");
      out.write("\t\t\t\t$('#ff').form('clear');\r\n");
      out.write("\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\tonLoadError : function()\r\n");
      out.write("\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle:'申请用户组提示',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmsg:'申请用户组失败',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttimeout:5000,\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tshowType:'slide'\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t$.messager.confirm({\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\ttitle: '申请用户组提示',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmsg: '是否重新申请用户组',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tfn: function(r){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tif (r){\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t $('#win').panel('close',false);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t$.messager.alert({\r\n");
      out.write("\t\t\t\t\t\t\ttitle: '申报用户组提示',\r\n");
      out.write("\t\t\t\t\t\t\tmsg: '填写相关信息格式不正确'\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\tgetUserGroup =function()\r\n");
      out.write("\t{\r\n");
      out.write("\t\t\t$('#pg').datagrid({\r\n");
      out.write("\t\t    url:'getUserGroup.action',\r\n");
      out.write("\t\t    pagination:true,\r\n");
      out.write("\t\t\tpageSize:10,\r\n");
      out.write("\t\t\tpageList:[ 10,20,30,40],\r\n");
      out.write("\t\t\tfit:true,\r\n");
      out.write("\t\t\tfitColums:false,\r\n");
      out.write("\t\t\tnowarp:false,\r\n");
      out.write("\t\t\tborder:false,\r\n");
      out.write("\t\t\tidField:'id',\r\n");
      out.write("\t\t    columns:[[\r\n");
      out.write("\t\t    {field:'id',title:'用户组编号',width:200,sortable:true,editor:false},\r\n");
      out.write("\t\t        {field:'leaderName',title:'创建者',\r\n");
      out.write("\t\t        formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t\treturn row.attributes.leaderName;\r\n");
      out.write("    \t\t},width:200,sortable:true,editor:{type:'textbox'}},\r\n");
      out.write("\t\t        {field:'time',title:'创建时间',\r\n");
      out.write("\t\t        formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t\treturn row.attributes.time;\r\n");
      out.write("    \t\t},width:200,sortable:true,editor:false},\r\n");
      out.write("\t\t        {field:'descipt',title:'用户组描述',\r\n");
      out.write("\t\t        formatter :function(value,row,index)\r\n");
      out.write("    \t\t{\r\n");
      out.write("    \t\t\treturn row.attributes.descipt;\r\n");
      out.write("    \t\t},width:200,sortable:true,editor:{type:'textbox'}},\r\n");
      out.write("\t\t    ]],\r\n");
      out.write("\t\t toolbar:[{\r\n");
      out.write("     \t text:'增加',\r\n");
      out.write("     \t iconCls:'icon-add',\r\n");
      out.write("     \t handler:function(){\r\n");
      out.write("     \t insertUserGroup();\r\n");
      out.write("     \t }\r\n");
      out.write("     \t },'-',{\r\n");
      out.write("     \t text:'删除',\r\n");
      out.write("     \t iconCls:'icon-remove',\r\n");
      out.write("     \t handler:function(){\r\n");
      out.write("     \t\tvar rows= $('#pg').datagrid('getSelections');\r\n");
      out.write("     \t\tif(rows.length>0)\r\n");
      out.write("     \t\t{\r\n");
      out.write("     \t\t\t$.messager.confirm('请确认','您确定要删除当前所选择的项目吗？',function(b){\r\n");
      out.write("     \t\t\t\tif(b)\r\n");
      out.write("     \t\t\t\t{\r\n");
      out.write("     \t\t\t\tvar ids= [];\r\n");
      out.write("\t     \t\t\t\tfor(var i=0;i<rows.length;i++)\r\n");
      out.write("\t     \t\t\t\t{\r\n");
      out.write("\t     \t\t\t\t\tids.push(rows[i].id)\r\n");
      out.write("\t     \t\t\t\t}\r\n");
      out.write("\t     \t\t\t\t$.ajax({\r\n");
      out.write("\t     \t\t\t\t\turl : 'deleteUserGroup.action',\r\n");
      out.write("\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\tids : ids.join(',')\r\n");
      out.write("\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tdataType : 'json',\r\n");
      out.write("\t\t\t\t\tsuccess : function(r)\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t$('#pg').datagrid('load',{});\r\n");
      out.write("\t\t\t\t$('#pg').datagrid('unselectAll');\r\n");
      out.write("\t\t\t\t\t\t$.messager.show({\r\n");
      out.write("\t\t\t\t\t\ttitle:'提示',\r\n");
      out.write("\t\t\t\t\t\tmsg:'删除成功'\r\n");
      out.write("\t\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t     \t\t\t\t})\r\n");
      out.write("     \t\t\t\t}\t\r\n");
      out.write("     \t\t\t});\r\n");
      out.write("     \t\t}else{\r\n");
      out.write("     \t\t\t$.messager.alert('提示','请选择要删除的记录！','error');\r\n");
      out.write("     \t\t}\r\n");
      out.write("     \t\t\t\t }\r\n");
      out.write("     \t\t\t },'-',{\r\n");
      out.write("     \t text:'修改',\r\n");
      out.write("     \t iconCls:'icon-edit',\r\n");
      out.write("     \t handler:function(){\r\n");
      out.write("     \t\tvar rows= $('#pg').datagrid('getSelections');\r\n");
      out.write("     \t\tif(rows.length==1)\r\n");
      out.write("     \t\t{\r\n");
      out.write("\t\t     \t\tif(editRow != undefined)\r\n");
      out.write("\t\t     \t\t\t{\r\n");
      out.write("\t\t\t\t     $('#pg').datagrid('endEdit',editRow);\r\n");
      out.write("\t\t\t\t     \t}\r\n");
      out.write("\t\t\t\t     \tif(editRow == undefined)\r\n");
      out.write("\t\t\t\t     \t{\r\n");
      out.write("\t\t\t\t     \tvar index=$('#pg').datagrid('getRowIndex',rows[0]);\t\r\n");
      out.write("\t\t\t \t\t\t\t$('#pg').datagrid('beginEdit',index);\t\r\n");
      out.write("\t\t\t     \t\t\teditRow = index;\r\n");
      out.write("\t\t\t     \t\t\t$('#pg').datagrid('unselectAll');\r\n");
      out.write("\t\t\t     \t \t } \r\n");
      out.write("     \t\t}else{\r\n");
      out.write("     \t\t\t$.messager.alert('提示','不能再同一时间编辑几条数据！','error');\r\n");
      out.write("     \t\t}\r\n");
      out.write("     \t\t\t \t\t\t}\r\n");
      out.write("     \t\t},'-',{\r\n");
      out.write("     \t text:'保存',\r\n");
      out.write("     \t iconCls:'icon-save',\r\n");
      out.write("     \t handler:function(){\r\n");
      out.write("     \t \t$('#pg').datagrid('endEdit',editRow);\r\n");
      out.write("     \t\t\t }\r\n");
      out.write("     \t\t},'-',{\r\n");
      out.write("     \t text:'取消编辑',\r\n");
      out.write("     \t iconCls:'icon-redo',\r\n");
      out.write("     \t handler:function(){\r\n");
      out.write("     \t \t\teditRow = undefined;\r\n");
      out.write("     \t \t\t$('#pg').datagrid('rejectChanges');//回滚\r\n");
      out.write("     \t \t\t$('#pg').datagrid('unselectAll');//撤销所选\r\n");
      out.write("     \t\t\t }\r\n");
      out.write("     \t\t},'-',{\r\n");
      out.write("     \t text:'取消选中',\r\n");
      out.write("     \t iconCls:'icon-redo',\r\n");
      out.write("     \t handler:function(){\r\n");
      out.write("     \t \t\teditRow = undefined;\r\n");
      out.write("     \t \t\t$('#pg').datagrid('unselectAll');//撤销所选\r\n");
      out.write("     \t\t\t }\r\n");
      out.write("     \t\t},\r\n");
      out.write("     \t\t\r\n");
      out.write("     \t\t]\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("  </script>\r\n");
      out.write("  <script>\"undefined\"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:\"63900\",secure:\"63905\"},c={nonSecure:\"http://\",secure:\"https://\"},r={nonSecure:\"127.0.0.1\",secure:\"gapdebug.local.genuitec.com\"},n=\"https:\"===window.location.protocol?\"secure\":\"nonSecure\";script=e.createElement(\"script\"),script.type=\"text/javascript\",script.async=!0,script.src=c[n]+r[n]+\":\"+t[n]+\"/codelive-assets/bundle.js\",e.getElementsByTagName(\"head\")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>\r\n");
      out.write(" <body  class=\"easyui-layout\" data-options=\"fit:true\"\" data-genuitec-lp-enabled=\"false\" data-genuitec-file-id=\"wc1-3\" data-genuitec-path=\"/hdquan2/WebRoot/UserGroup.jsp\">\r\n");
      out.write("\t <div data-options=\"region:'north',title:'North Title',split:true\" style=\"height:70px;\" data-genuitec-lp-enabled=\"false\" data-genuitec-file-id=\"wc1-3\" data-genuitec-path=\"/hdquan2/WebRoot/UserGroup.jsp\">\r\n");
      out.write("\t <a id=\"btn\" onclick=\"lookUsers();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-search'\">查看用户组的用户</a>\r\n");
      out.write("\t  <a id=\"btn\" onclick=\"lookRoles();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-man'\">查看用户组的角色</a>\r\n");
      out.write("\t   <a id=\"btn\" onclick=\"insertUserGroup();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-man'\">创建用户组</a>\r\n");
      out.write("\t    <a id=\"btn\" onclick=\"getUserGroup();\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-man'\">查看用户组信息</a>\r\n");
      out.write("\t </div>\r\n");
      out.write("       \t<div data-options=\"region:'center',border:false\" style=\"overflow:hidden;\" data-options=\"fit:true\">\r\n");
      out.write("\t\t <table id=\"pg\" style=\"fit:true\"></table>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<div id=\"win\" class=\"easyui-window\" title=\"addUserGroup\" style=\"width:600px;height:400px\" closed='true'\r\n");
      out.write("\t   data-options=\"iconCls:'icon-save',modal:true\">\r\n");
      out.write("\t   <form id=\"ff\">\r\n");
      out.write("\t\t\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t\t<input class=\"easyui-textbox\" data-options=\"\r\n");
      out.write("\t\t\t\t\tlabel: '用户组名称',\r\n");
      out.write("\t\t\t\t\tlabelPosition: 'top',\r\n");
      out.write("\t\t\t\t\tprompt: 'Input something here!',\r\n");
      out.write("\t\t\t\t\ticonWidth: 22,\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\tvalidType : ['String','length[0,20]'],\r\n");
      out.write("\t\t\t\t\tmissingMessage :'用户组名称不能为空',\r\n");
      out.write("\t\t\t\t\ticons: [{\r\n");
      out.write("\t\t\t\t\t\ticonCls:'icon-clear',\r\n");
      out.write("\t\t\t\t\t\thandler: function(e){\r\n");
      out.write("\t\t\t\t\t\t\t$(e.data.target).textbox('clear');\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}],\r\n");
      out.write("\t\t\t\t\ticonAlign:'right'\" \r\n");
      out.write("\t\t\t\t\tstyle=\"width:300px;width:100%;\" name=\"usGName\" id=\"usGName\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t\t<input class=\"easyui-textbox\" data-options=\"\r\n");
      out.write("\t\t\t\t\tlabel: '创建者',\r\n");
      out.write("\t\t\t\t\tlabelPosition: 'top',\r\n");
      out.write("\t\t\t\t\trequired : true,\r\n");
      out.write("\t\t\t\t\tvalidType : ['String','length[0,20]'],\r\n");
      out.write("\t\t\t\t\tmissingMessage :'请问创建者是哪位',\r\n");
      out.write("\t\t\t\t\tprompt: '',\r\n");
      out.write("\t\t\t\t\ticonWidth: 22,\r\n");
      out.write("\t\t\t\t\ticons: [{\r\n");
      out.write("\t\t\t\t\t\ticonCls:'icon-clear',\r\n");
      out.write("\t\t\t\t\t\thandler: function(e){\r\n");
      out.write("\t\t\t\t\t\t\t$(e.data.target).textbox('clear');\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}],\r\n");
      out.write("\t\t\t\t\ticonAlign:'right'\" \r\n");
      out.write("\t\t\t\t\tstyle=\"width:300px;width:100%;\" name=\"leaderName\" id=\"leaderName\"/>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t<a href=\"#\" class=\"easyui-linkbutton\" data-options=\"iconCls:'icon-ok'\"\r\n");
      out.write("        onclick=\"add_UserGroup();\">addUserGroup</a>\r\n");
      out.write("        </form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("   </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}