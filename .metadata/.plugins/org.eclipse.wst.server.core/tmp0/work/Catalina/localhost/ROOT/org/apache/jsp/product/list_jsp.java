/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-06-18 23:58:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>상품</title>\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../home3.css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"divPage\" >\r\n");
      out.write("\t\t<div id=\"divTop\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../top.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t<div class=\"dropmenu\">\r\n");
      out.write("\t\t\t<ul id=\"dm_ul\" style=\"background:white\">\r\n");
      out.write("\t\t\t\t<li><a id=plist href=\"../product/list.jsp\">상품리스트</a></li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<li>현황관리\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../stock/list.jsp\">재고현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../sell_status/list.jsp\">판매현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../order/list.jsp\">발주현황</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<li>등록관리\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../order/insert.jsp\">발주등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../product/insert.jsp\">상품등록</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t<li>이건어때\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../bbs/insert.jsp\">칭찬해요</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a class=alist href=\"../bbs/binsert.jsp\">제안해요</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"divMenu\"></div>\r\n");
      out.write("\t\t<div id=\"divHeader\">\r\n");
      out.write("\t\t\t<h2>상 품 목 록</h2>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"divCondition\">\r\n");
      out.write("\t\t\t<div id=\"divSearch\">\r\n");
      out.write("\t\t\t\t<select id=\"selKey\">\r\n");
      out.write("\t\t\t\t\t<option value=\"product_code\">상품코드</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"product_name\">상품명</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"company\">제조사</option>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</select> <input type=\"text\" id=\"txtWord\"> <select id=\"selPerpage\">\r\n");
      out.write("\t\t\t\t\t<option value=\"4\">4행</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"8\" selected>8행</option>\r\n");
      out.write("\t\t\t\t</select> <input type=\"button\" id=\"btnSearch\" value=\"검색\"> <span\r\n");
      out.write("\t\t\t\t\tstyle=\"font-size: 12px;\">검색수: <b id=\"count\"></b>건\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t<div id=\"divSort\">\r\n");
      out.write("\t\t\t\t\t<select id=\"selOrder\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"product_code\">상품코드</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"product_name\">상품명</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"company\">제조사</option>\r\n");
      out.write("\t\t\t\t\t</select> <select id=\"selDesc\">\r\n");
      out.write("\t\t\t\t\t\t<option value=\"\">오름차순</option>\r\n");
      out.write("\t\t\t\t\t\t<option value=\"desc\">내림차순</option>\r\n");
      out.write("\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"tbl\" style=\"width:1600px;margin:auto;margin-right:30px\"></div>\r\n");
      out.write("\t\t<script id=\"temp\" type=\"text/x-handlebars-template\">\r\n");
      out.write("         {{#each array}}\r\n");
      out.write("            <div class=\"box\">\r\n");
      out.write("               <div class=\"image\">\r\n");
      out.write("\t\t\t\t<a href=\"/product/read?product_code={{product_code}}\">\r\n");
      out.write("\t\t\t\t<img class=imgs src=\"{{printImage img}}\" width=300></a></div>\r\n");
      out.write("               <div class=\"product_name\">{{product_name}}</div>\r\n");
      out.write("               <div class=\"product_price\">{{product_price}}원</div>\r\n");
      out.write("            </div>\r\n");
      out.write("            {{/each}}\r\n");
      out.write("            </script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"pagination\" style=\"margin-bottom:40px;\">\r\n");
      out.write("\t\t\t<button id=\"btnPre\">◀</button>\r\n");
      out.write("\t\t\t<button id=\"btnNext\">▶</button>\r\n");
      out.write("\t\t\t[<span id=\"curPage\"></span>/<span id=\"totPage\"></span>]\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t<div id=\"divFoot\" style=\"text-align: center\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../footer.jsp", out, false);
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\t\r\n");
      out.write("\t$(\".dropmenu ul li\").hover(function() {\r\n");
      out.write("\t\t$(this).find(\"ul\").stop().fadeToggle(300);\r\n");
      out.write("\t})\r\n");
      out.write("\tvar url = \"/product/list\";\r\n");
      out.write("\r\n");
      out.write("\t//핸들바에서의 이미지 조건문\r\n");
      out.write("\tHandlebars.registerHelper(\"printImage\", function(img) {\r\n");
      out.write("\t\tvar src;\r\n");
      out.write("\t\tif (img == null)\r\n");
      out.write("\t\t\tsrc = \"http://placehold.it/300x200\";\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t\tsrc = \"/img/product/\" + img;\r\n");
      out.write("\t\treturn src;\r\n");
      out.write("\t});\r\n");
      out.write("\t/*\r\n");
      out.write("\t//핸들바에서의 prod_del 조건문\r\n");
      out.write("\tHandlebars.registerHelper(\"printDel\",function(del){\r\n");
      out.write("\t   var src;\r\n");
      out.write("\t   if(del==1) src=\"판매중지\";   \r\n");
      out.write("\t   else src=\"🛒\";   \r\n");
      out.write("\t   return src;\r\n");
      out.write("\t});\r\n");
      out.write("\t */\r\n");
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