/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.9
 * Generated at: 2019-10-30 11:19:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class first_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    ");

     request.setCharacterEncoding( "utf-8" );
    response.setHeader("Content-Type" , "text/html");
     
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write(" \t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "BaseJsp.jsp", out, false);
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar cc;\r\n");
      out.write("\t\t$.ajax(\r\n");
      out.write("\t\t\t{ \r\n");
      out.write("\t\t\turl:\"onLine.action\"\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t/* cc=$('#cc').layout();\r\n");
      out.write("\t\tcc.layout('collapse','east'); */\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction getCenterPanel()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\tvar CenterPanel=$('#cc').layout('panel','center');\r\n");
      out.write("\t\t//console.info(CenterPanel);\r\n");
      out.write("\t\tconsole.info(CenterPanel.panel('options').title);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write(" <script>\"undefined\"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:\"63900\",secure:\"63905\"},c={nonSecure:\"http://\",secure:\"https://\"},r={nonSecure:\"127.0.0.1\",secure:\"gapdebug.local.genuitec.com\"},n=\"https:\"===window.location.protocol?\"secure\":\"nonSecure\";script=e.createElement(\"script\"),script.type=\"text/javascript\",script.async=!0,script.src=c[n]+r[n]+\":\"+t[n]+\"/codelive-assets/bundle.js\",e.getElementsByTagName(\"head\")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>\r\n");
      out.write("  <body data-genuitec-lp-enabled=\"false\" data-genuitec-file-id=\"wc1-9\" data-genuitec-path=\"/hdquan3/WebRoot/first.jsp\">\r\n");
      out.write("      <div id=\"cc\" class=\"easyui-layout\" style=\"width:1350px;height:630px;\" data-genuitec-lp-enabled=\"false\" data-genuitec-file-id=\"wc1-9\" data-genuitec-path=\"/hdquan3/WebRoot/first.jsp\">\r\n");
      out.write("        <div data-options=\"region:'north',title:'通用权限管理系统',split:true\" style=\"height:65px;\" href=\"north.jsp\"></div>\r\n");
      out.write("        <div data-options=\"region:'east',split:true\" style=\"width:100px;\">\r\n");
      out.write("\t        <div id=\"hh\" class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("\t\t\t\t         <div data-options=\"region:'south',title:'在线用户',split:true\" fit=\"true\"  href=\"onLine.action\"></div>\r\n");
      out.write("\t\t\t        <div data-options=\"region:'center',title:'历史记录'\" fit=\"true\" href=\"log4j.html\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div data-options=\"region:'west',split:true\" style=\"width:100px;\" href=\"west.html\"></div>\r\n");
      out.write("        <div data-options=\"region:'center'\" style=\"padding:5px;background:#eee;overflow:hidden;\">\r\n");
      out.write("        <div id=\"centerTabs\" class=\"easyui-tabs\" fit=\"true\">\r\n");
      out.write("        \r\n");
      out.write("\t\t</div>\t\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  \r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
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