package control.access;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.display.beans.CustomerBean;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutController extends HttpServlet {
	static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer");
		customer = new CustomerBean("", "Guest");
		session.setAttribute("customer", customer);
		
		response.sendRedirect("/pw/login.jsp");
		return;
	}
}
