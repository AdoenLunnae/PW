package control.access;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.display.beans.CustomerBean;
import es.uco.pw.data.dao.UserDAO;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginAttempt")
public class LoginController extends HttpServlet {
	static final long serialVersionUID = 1L;

	private Boolean checkNotLogged(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer");
		return (customer == null || customer.getIdRol() == "Guest");
	}

	/*
	 * private Boolean checkEmptyArgs(String nombre, String apellidos, String mail,
	 * String password, String telefono) throws ServletException, IOException {
	 * return !(mail.isEmpty() || password.isEmpty()); }
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!checkNotLogged(request)) {
			// loginErrorPage(request, response);
			return;
		}

		String mail = request.getParameter("correo"); 
		String password = request.getParameter("password"); 
		 
		/* if (!checkEmptyArgs(mail, password)) {
		 * backToLogin(request, response); return; } 
		 */
		try {
			if (!UserDAO.mailExists(mail)) {
				System.out.println("Email inexistente");
				return; 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		 try {
			 if (!UserDAO.checkPass(mail, password)) { 
				 System.out.println("Contraseña incorrecta");
				 return; }
		 }
		 catch (Exception e) {
			 e.printStackTrace();
		 }
		 
		 response.sendRedirect("/pw/profile?mail=" + mail);
		 return;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher req = request.getRequestDispatcher("/mvc/view/ownProfileView.jsp");
		try {
			req.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}
}
