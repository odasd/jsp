/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.5
 * Generated at: 2020-06-22 03:52:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1589249480000L));
    _jspx_dependants.put("jar:file:/C:/data/jsp/jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/semiProject/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>24/7 TFS</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"home.css\">\r\n");
      out.write("<script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"divPage\">\r\n");
      out.write("\t\t<div id=\"divCenter\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t<div id=\"main\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"divContent\" style=\"width: 100%; margin: auto\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!--여기에 내용출력 시작---------------------------- -->\r\n");
      out.write("\t\t\t\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"banners\">\r\n");
      out.write("\t\t\t\t\t\t\t<div id=\"slide\" style=\"float: left; margin-left: 71px;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"pos\" id=\"pos1\" checked> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"radio\" name=\"pos\" id=\"pos2\"> <input type=\"radio\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tname=\"pos\" id=\"pos3\"> <input type=\"radio\" name=\"pos\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"pos4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><img class=banners src=/semiProject/images/mainbanner.jpg></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><img class=banners src=/semiProject/images/night.jpg></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><img class=banners src=/semiProject/images/fresh.jpg></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><img class=banners src=/semiProject/images/yagan.jpg></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"pos\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label for=\"pos1\"></label> <label for=\"pos2\"></label> <label\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tfor=\"pos3\"></label> <label for=\"pos4\"></label>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<img id=\"sideBanner\" style=\"float: left; position: relative;\"\r\n");
      out.write("\t\t\t\t\t\t\t\tsrc=/semiProject/images/sideBanner.jpg>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"bannerDiv\">\r\n");
      out.write("\t\t\t\t\t\t<table id=\"midMenu\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><a class=aTag href=\"\">공지사항</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><a class=aTag href=\"\">사회공헌</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><a class=aTag href=\"\">보도자료</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td><a class=aTag href=\"\">이벤트</a></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td style=\"width: 55%\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"container\">\r\n");
      out.write("\t\t\t\t<img id=\"leftBro\" src=/semiProject/images/leftbro.jpg><img id=\"rightSis\"\r\n");
      out.write("\t\t\t\t\tsrc=/semiProject/images/rightsis.jpg>\r\n");
      out.write("\t\t\t\t<table id=\"menuContainer\">\r\n");
      out.write("\t\t\t\t\t<tr style=\"height: 70px\">\r\n");
      out.write("\t\t\t\t\t\t<td id=menu1><a href=\"/semiProject/user/company_login.jsp\"><img src=/semiProject/images/login1.jpg></a></td>\r\n");
      out.write("\t\t\t\t\t\t<td id=menu2><a href=\"/semiProject/user/cvs_login.jsp\"><img src=/semiProject/images/login2.jpg></a></td>\r\n");
      out.write("\t\t\t\t\t\t<td id=menu3><a href=\"\"><img src=/semiProject/images/ceosay.jpg></a></td>\r\n");
      out.write("\t\t\t\t\t\t<td id=menu4><a href=\"\"><img src=/semiProject/images/newdel.jpg></a></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr style=\"height: 180px\">\r\n");
      out.write("\t\t\t\t\t\t<td id=menu1-1><img src=/semiProject/images/log1.jpg></td>\r\n");
      out.write("\t\t\t\t\t\t<td id=menu1-2><img src=/semiProject/images/log2.jpg></td>\r\n");
      out.write("\t\t\t\t\t\t<td id=menu1-3><img style=\"margin-bottom: 130px;\"\r\n");
      out.write("\t\t\t\t\t\t\tsrc=/semiProject/images/ceo.jpg><img style=\"margin-left: 22px;\"\r\n");
      out.write("\t\t\t\t\t\t\tsrc=/semiProject/images/button.jpg></td>\r\n");
      out.write("\t\t\t\t\t\t<td id=menu1-4><img style=\"margin-bottom: 130px;\"\r\n");
      out.write("\t\t\t\t\t\t\tsrc=/semiProject/images/del.jpg><img style=\"margin-left: 22px;\"\r\n");
      out.write("\t\t\t\t\t\t\tsrc=/semiProject/images/button.jpg></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!--여기까지가 내용입니다.---------------------------- -->\r\n");
      out.write("\t\t\t<div id=\"divFoot\" style=\"text-align: center;\">");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\t$(\".dropmenu ul li\").hover(function(){\r\n");
      out.write("\t\t$(this).find(\"ul\").stop().fadeToggle(300);\r\n");
      out.write("\t})\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)_jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /index.jsp(16,3) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cvs_id==null and company_id==null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<div id=\"divTop\">");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top.jsp", out, false);
        out.write("</div>\r\n");
        out.write("\t\t\t<div class=\"dropmenu\">\r\n");
        out.write("\t\t\t\t<ul id=\"dm_ul\">\r\n");
        out.write("\t\t\t\t\t<li><a id=plist href=\"denied.jsp\">상품리스트</a></li>&nbsp;&nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t<li>현황관리\r\n");
        out.write("\t\t\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"denied.jsp\">재고현황</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"denied.jsp\">판매현황</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"denied.jsp\">발주현황</a></li>\r\n");
        out.write("\t\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t\t<li>등록관리\r\n");
        out.write("\t\t\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"denied.jsp\">발주등록</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"denied.jsp\">상품등록</a></li>\r\n");
        out.write("\t\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t\t<li>이건어때\r\n");
        out.write("\t\t\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"denied.jsp\">제안해요</a></li>\r\n");
        out.write("\t\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t<img id=\"logo\" src=/semiProject/images/tfs_logo.JPG>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)_jspx_page_context.getRequest();
    javax.servlet.http.HttpServletResponse response = (javax.servlet.http.HttpServletResponse)_jspx_page_context.getResponse();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent(null);
    // /index.jsp(44,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${cvs_id!=null or company_id!=null}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t<div id=\"divTop\">");
        org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "top2.jsp", out, false);
        out.write("</div>\r\n");
        out.write("\t\t\t<div class=\"dropmenu\">\r\n");
        out.write("\t\t\t\t<ul id=\"dm_ul\">\r\n");
        out.write("\t\t\t\t\t<li><a id=plist href=\"/semiProject/product/list.jsp\">상품리스트</a></li>&nbsp;&nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t\t\r\n");
        out.write("\t\t\t\t\t<li>현황관리\r\n");
        out.write("\t\t\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/stock/list.jsp\">재고현황</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/sell_status/list.jsp\">판매현황</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/order/list.jsp\">발주현황</a></li>\r\n");
        out.write("\t\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t\t<li>등록관리\r\n");
        out.write("\t\t\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/cart/cartList.jsp\">발주등록</a></li>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/product/insert.jsp\">상품등록</a></li>\r\n");
        out.write("\t\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t</li>&nbsp;&nbsp;&nbsp;\r\n");
        out.write("\t\t\t\t\t<li><a href=\"/semiProject/bbs/list.jsp\" style=text-decoration:none;color:#2569C9>이거어때?</a>\r\n");
        out.write("\t\t\t\t\t\t<ul>\r\n");
        out.write("\t\t\t\t\t\t\t<li><a class=alist href=\"/semiProject/bbs/insert.jsp\">제안해요</a></li>\r\n");
        out.write("\t\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t</li>\r\n");
        out.write("\t\t\t\t\t</ul>\r\n");
        out.write("\t\t\t\t\t</div>\r\n");
        out.write("\t\t\t\t\t<img id=\"logo\" src=/semiProject/images/tfs_logo.JPG>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }
}
