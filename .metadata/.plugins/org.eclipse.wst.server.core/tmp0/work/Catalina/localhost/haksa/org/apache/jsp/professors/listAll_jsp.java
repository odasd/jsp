/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-06-02 01:02:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.professors;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class listAll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>교수목록</title>\r\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("\t<style>   \r\n");
      out.write("\t\t td{border:1px solid black; height:30px; font-size:12px;padding:0px 5px 0px 5px;}   \r\n");
      out.write("\t\t table .title{background:#EAEAEA; text-align:center;}\r\n");
      out.write("\t\t table .row:hover{background:gray; color:white;}    \r\n");
      out.write("\t\t table {border-collapse:collapse;}\r\n");
      out.write("\t\t .row:hover{background:gray; color:white; cursor:pointer;}   \r\n");
      out.write("\t\t #pagination, h2{text-align:center;padding-top:5px;} \r\n");
      out.write("\t </style> \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h2>[교수목록]</h2>\r\n");
      out.write("\t<table id=\"tbl\" border=1></table>\r\n");
      out.write("    <script id=\"temp\" type=\"text/x-handlebars-template\">\r\n");
      out.write("\t\t<tr class=\"title\">          \r\n");
      out.write("  \t\t\t\t<td width=100>교수번호</td>    \r\n");
      out.write("       \t\t\t<td width=100>교수이름</td>     \r\n");
      out.write("       \t\t\t<td width=100>교수학과</td>        \r\n");
      out.write(" \t\t\t</tr>       \r\n");
      out.write("\t\t\t{{#each array}}       \r\n");
      out.write(" \t\t\t\t<tr class=\"row\">       \r\n");
      out.write("    \t\t\t\t<td class=\"pcode\">{{pcode}}</td>   \r\n");
      out.write("        \t\t\t<td class=\"pname\">{{pname}}</td>    \r\n");
      out.write("        \t\t\t<td class=\"dept\">{{dept}}</td>            \r\n");
      out.write("  \t\t\t\t</tr>      \r\n");
      out.write("  \t\t\t{{/each}}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t <div id=\"pagination\">\r\n");
      out.write("\t \t<button id=\"btnPre\">◀</button>\r\n");
      out.write("\t \t<button id=\"btnNext\">▶</button>\r\n");
      out.write("\t </div> \r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\tvar url=\"/haksa/professors/list\";\r\n");
      out.write("\t$(\"#tbl\").on(\"click\", \".row\", function(){\r\n");
      out.write("\t\tvar pcode=$(this).find(\".pcode\").html();\r\n");
      out.write("\t\tvar pname=$(this).find(\".pname\").html();\r\n");
      out.write("\t\t$(opener.frm.pcode).val(pcode);\r\n");
      out.write("\t\t$(opener.frm.pname).val(pname);\r\n");
      out.write("\t\twindow.close();\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<script src=\"../home.js\"></script>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
