/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.99
 * Generated at: 2020-01-06 15:02:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mvc.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registerSuccessView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/include/footer.jsp", Long.valueOf(1578316565645L));
    _jspx_dependants.put("/include/header.jsp", Long.valueOf(1578147194546L));
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
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

      out.write('\r');
      out.write('\n');
      pw.CustomerBean customer = null;
      customer = (pw.CustomerBean) _jspx_page_context.getAttribute("customer", javax.servlet.jsp.PageContext.PAGE_SCOPE);
      if (customer == null){
        customer = new pw.CustomerBean();
        _jspx_page_context.setAttribute("customer", customer, javax.servlet.jsp.PageContext.PAGE_SCOPE);
      }
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("customer"), "mail", "testmail", null, null, false);
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/include/common-head.jsp" + "?" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("title", request.getCharacterEncoding())+ "=" + org.apache.jasper.runtime.JspRuntimeLibrary.URLEncode("Registration Completed", request.getCharacterEncoding()), out, false);
      out.write("\r\n");
      out.write("    \t<meta http-equiv = \"refresh\" content = '10; url = /perfil?mail=");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((pw.CustomerBean)_jspx_page_context.findAttribute("customer")).getMail())));
      out.write("' />\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t");
      out.write("<header>\n");
      out.write("\t<div class=\"row\">\n");
      out.write("\t    <div class=\"logo circle\" onclick=\"window.location.href='../pages/home.html'\"></div>\n");
      out.write("\t    <nav>\n");
      out.write("\t        <div class=\"col-3\">\n");
      out.write("\t            <a href=\"../pages/perfil-profesional.html\"\n");
      out.write("\t               class=\"button\">ASD</a>\n");
      out.write("\t        </div>\n");
      out.write("\t        <div class=\"double-col-3 search-container\">\n");
      out.write("\t            <form action=\"../pages/resultados.html\"\n");
      out.write("\t                  style=\"display: flex\">\n");
      out.write("\t                <input type=\"text\"\n");
      out.write("\t                       placeholder=\"Buscar...\"\n");
      out.write("\t                       name=\"search\">\n");
      out.write("\t                <button type=\"submit\">Enviar</button>\n");
      out.write("\t            </form>\n");
      out.write("\t        </div>\n");
      out.write("\t    </nav>\n");
      out.write("\t</div>\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"caja\">\r\n");
      out.write("\t\t\t<div class=\"titulo-caja\">Registro completado exitosamente</div>\r\n");
      out.write("\t\t\t<div class=\"elemento-caja\">\r\n");
      out.write("\t\t\t\t<p>\r\n");
      out.write("\t\t\t\tSu registro ha sido completado con éxito. Ahora será redirigido a su perfil, donde podrá\r\n");
      out.write("\t\t\t\teditar su información personal. Si la redirección no funciona automáticamente pulse \r\n");
      out.write("\t\t\t\t<a href='/perfil?mail=");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((pw.CustomerBean)_jspx_page_context.findAttribute("customer")).getMail())));
      out.write("'>aquí</a>.\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t            \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write("<footer>\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-3\">\n");
      out.write("            <a href=\"/pw/about.jsp\" class=\"button\">Sobre nosotros</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-3\">\n");
      out.write("            <a href=\"/pw/terminos.jsp\" class=\"button\">Términos y condiciones de uso</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-3\">\n");
      out.write("            <a href=\"/pw/privacidad.jsp\" class=\"button\">Política de privacidad</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>");
      out.write("\r\n");
      out.write("\t</body>\r\n");
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
