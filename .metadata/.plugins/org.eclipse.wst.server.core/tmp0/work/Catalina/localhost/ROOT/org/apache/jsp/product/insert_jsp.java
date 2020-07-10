/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-06-19 00:02:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>상품등록</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../home2.css\">\r\n");
      out.write("\t<script src=\"http://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"divPage\" style=background:#F2F2F2>\r\n");
      out.write("\t<div id=\"divTop\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../top.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t<div class=\"dropmenu\">\r\n");
      out.write("\t\t\t\t<ul id=\"dm_ul\" style=\"background:#F2F2F2\">\r\n");
      out.write("\t\t\t\t\t<li><a id=plist href=\"../product/list.jsp\">상품리스트</a></li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<li>현황관리\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"../stock/list.jsp\">재고현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"../sell_status/list.jsp\">판매현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"../order/list.jsp\">발주현황</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<li>등록관리\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"../order/insert.jsp\">발주등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"../product/insert.jsp\">상품등록</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<li>이건어때\r\n");
      out.write("\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"../bbs/insert.jsp\">칭찬해요</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"../bbs/binsert.jsp\">제안해요</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t<div id=\"divHeader\">\r\n");
      out.write("\t\t\t<h2>상 품 등 록</h2>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<form name=\"frm\" action=\"insert\" method=\"post\" enctype=\"multipart/form-data\"> <!-- enctype=\"multipart/form-data\" 이미지를 저장할수있게해주는거 -->\r\n");
      out.write("\t\t\t<table id=\"tbl\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"title\" width=130>상품코드</td>\r\n");
      out.write("\t\t\t\t\t<td width=100><input type=\"text\" name=\"product_code\" size=10></td>\r\n");
      out.write("\t\t\t\t\t<td class=\"title\" width=180>제조원/수입원</td>\r\n");
      out.write("\t\t\t\t\t<td width=200><input type=\"text\" name=\"company\" size=10></td>\r\n");
      out.write("\t\t\t\t\t<td class=\"title\" width=100>판매가격</td>\r\n");
      out.write("\t\t\t\t\t<td width=100><input type=\"text\" name=\"product_price\" size=10></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"title\">제조일</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"date\" name=\"product_date\" size=10></td>\r\n");
      out.write("\t\t\t\t\t<td class=\"title\">폐기일</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"date\" name=\"product_exp\" width=10></td>\r\n");
      out.write("\t\t\t\t\t<td class=\"title\">판매가능여부</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"prod_del\" size=10></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"title\">상품이름</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"product_name\" size=10></td>\r\n");
      out.write("\t\t\t\t\t<td class=\"title\">상품분류코드</td>\r\n");
      out.write("\t\t\t\t\t<td><input type=\"text\" name=\"category_code\" size=10></td>\r\n");
      out.write("\t\t\t\t\t<td class=\"title\" colspan=2></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td class=\"title\">상품이미지</td>\r\n");
      out.write("\t\t\t\t\t<td colspan=5 >\r\n");
      out.write("\t\t\t\t\t\t<img style=\"margin-left:170px;padding-top:20px;padding-bottom:5px;\" src=\"http://placehold.it/150x120\" id=\"image\" width=150 /> <input type=\"file\" name=\"image\" accept=\"image/*\" style=\"visibility: hidden;\">\r\n");
      out.write("\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t<h5 style = margin-right:88px;padding-bottom:15px;font-weight:100>이미지를 클릭하여 등록하세요!<h5>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<div id=\"pagination\">\r\n");
      out.write("\t\t\t\t<input type=\"submit\" value=\"저장\" id=\"save\"> <input type=\"reset\" value=\"취소\" id=\"cancel\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"divFoot\" style=\"text-align: center\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../footer.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("$(\".dropmenu ul li\").hover(function() {\r\n");
      out.write("\t$(this).find(\"ul\").stop().fadeToggle(300);\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("$(frm).submit(function(e){\r\n");
      out.write("\te.preventDefault();\r\n");
      out.write("\tif(!confirm(\"상품을 등록하시겠습니까?\")) return;\r\n");
      out.write("\talert(\"상품이 등록되었습니다.\");\r\n");
      out.write("\tfrm.submit();\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("\t//업로드일 이미지 불러오기\r\n");
      out.write("\t$(\"#image\").on(\"click\", function(){\r\n");
      out.write("\t\t$(frm.image).click();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//불러오기한 이미지가 변경되었을때\r\n");
      out.write("\t$(frm.image).on(\"change\", function(){\r\n");
      out.write("\t\tvar reader=new FileReader();\r\n");
      out.write("\t\treader.onload=function(e){\r\n");
      out.write("\t\t\t$(\"#image\").attr(\"src\", e.target.result);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treader.readAsDataURL(this.files[0]);\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//상품코드 불러오기\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype:\"get\",\r\n");
      out.write("\t\turl:\"id\",\r\n");
      out.write("\t\tdataType:\"json\",\r\n");
      out.write("\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t$(frm.product_code).val(data.id);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t \r\n");
      out.write("</script>\r\n");
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
