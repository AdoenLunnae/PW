/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.99
 * Generated at: 2020-01-04 14:14:12 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/./include/footer.jsp", Long.valueOf(1578147250850L));
    _jspx_dependants.put("/./include/header.jsp", Long.valueOf(1578147194546L));
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

      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Montserrat:300,400,600|Open+Sans\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <title>Sobre Nosotros</title>\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"./css/main.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
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
      out.write("\n");
      out.write("\n");
      out.write("<!-- Información del perfil -->\n");
      out.write("<div class=\"container mx-auto flex flex-row mt-3 text-sm leading-normal\">\n");
      out.write("    <div class=\"w-full lg:w-1/4 lg:pl-0 pr-6 mr-6 mt-8 mb-4\">\n");
      out.write("        <!-- información de contacto -->\n");
      out.write("        <div class=\"caja\">\n");
      out.write("            <div class=\"titulo-caja\">Información de contacto</div>\n");
      out.write("            <table border=\"0\" width=\"95%\" height=\"auto\">\n");
      out.write("                <tr>\n");
      out.write("                    <td><span class=\"nombre-elemento\">País</span></td>\n");
      out.write("                    <td><span class=\"descripcion-elemento\">España</span></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><span class=\"nombre-elemento\">Comunidad</span></td>\n");
      out.write("                    <td><span class=\"descripcion-elemento\">Andalucía</span></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><span class=\"nombre-elemento\">Ciudad</span></td>\n");
      out.write("                    <td><span class=\"descripcion-elemento\">Córdoba, Córdoba</span></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><span class=\"nombre-elemento\">Correo electrónico</span></td>\n");
      out.write("                    <td><span class=\"descripcion-elemento\">mail@mail.es</span></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><span class=\"nombre-elemento\">Teléfono</span></td>\n");
      out.write("                    <td><span class=\"descripcion-elemento\">(+34)987654321</span></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <div class=\"accion-caja\"></div>\n");
      out.write("        </div>\n");
      out.write("        <!-- Contactos -->\n");
      out.write("        <div class=\"caja\">\n");
      out.write("            <div class=\"titulo-caja\">Nuestra plantilla</div>\n");
      out.write("            <!-- Elemento contacto -->\n");
      out.write("            <div class=\"elemento-caja\">\n");
      out.write("                <div class=\"py-2\"><img src=\"./img/perfil.png\" alt=\"avatar\"\n");
      out.write("                                       class=\"imagen-contacto\"></div>\n");
      out.write("                <div class=\"informacion-contacto\">\n");
      out.write("                    <div class=\"nombre-elemento\">Álvaro Prieto</div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Elemento contacto -->\n");
      out.write("            <div class=\"elemento-caja\">\n");
      out.write("                <div class=\"py-2\"><img src=\"./img/perfil.png\" alt=\"avatar\"\n");
      out.write("                                       class=\"imagen-contacto\"></div>\n");
      out.write("                <div class=\"informacion-contacto\">\n");
      out.write("                    <div class=\"nombre-elemento\">Ángel Sevilla</div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Elemento contacto -->\n");
      out.write("            <div class=\"elemento-caja\">\n");
      out.write("                <div class=\"py-2\"><img src=\"./img/perfil.png\" alt=\"avatar\"\n");
      out.write("                                       class=\"imagen-contacto\"></div>\n");
      out.write("                <div class=\"informacion-contacto\">\n");
      out.write("                    <div class=\"nombre-elemento\">Juan Pedro Muñoz</div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Elemento contacto -->\n");
      out.write("            <div class=\"elemento-caja\">\n");
      out.write("                <div class=\"py-2\"><img src=\"./img/perfil.png\" alt=\"avatar\"\n");
      out.write("                                       class=\"imagen-contacto\"></div>\n");
      out.write("                <div class=\"informacion-contacto\">\n");
      out.write("                    <div class=\"nombre-elemento\">Carlos David Serrano</div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Columna central -->\n");
      out.write("    <div class=\"w-full lg:w-1/2 mb-4\">\n");
      out.write("        <!-- Sobre mí -->\n");
      out.write("        <div class=\"caja\">\n");
      out.write("            <div class=\"titulo-caja\">Quién somos</div>\n");
      out.write("            <div class=\"elemento-caja\">\n");
      out.write("                <div>\n");
      out.write("                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut\n");
      out.write("                        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco\n");
      out.write("                        laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in\n");
      out.write("                        voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat\n");
      out.write("                        non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>\n");
      out.write("                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium,\n");
      out.write("                        totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae\n");
      out.write("                        dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut\n");
      out.write("                        fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque\n");
      out.write("                        porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia\n");
      out.write("                        non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut\n");
      out.write("                        enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut\n");
      out.write("                        aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea </p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<footer>\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-3\">\n");
      out.write("            <a href=\"../static/about.html\" class=\"button\">Sobre nosotros</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-3\">\n");
      out.write("            <a href=\"../static/terminos.html\" class=\"button\">Términos y condiciones de uso</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-3\">\n");
      out.write("            <a href=\"../static/privacidad.html\" class=\"button\">Política de privacidad</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</footer>");
      out.write("\n");
      out.write("</body>\n");
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
