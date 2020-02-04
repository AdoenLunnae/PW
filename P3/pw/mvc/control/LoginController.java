package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pw.CustomerBean;
import pw.UserDAO;

@WebServlet(
		  name = "LoginServlet", 
		  urlPatterns = "/loginAttempt")
public class LoginController extends HttpServlet {
	
	private Boolean checkNotLogged(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer");
		return (customer==null || customer.getIdRol() == "Guest");
	}
	
	private Boolean checkEmptyArgs(String nombre, String apellidos, String mail, String password, String telefono) throws ServletException, IOException {
		return !(mail.isEmpty() || password.isEmpty());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!checkNotLogged(request)){
			loginErrorPage(request, response);
			return;
		}
		
		String mail = request.getParameter("correo");
		String password = request.getParameter("password");
		
		if(!checkEmptyArgs(mail, password)) {
			backToLogin(request, response);
			return;
		}
		
		if(!UserDAO.checkMail(mail)) {
			return;
		}
		
		if(!UserDAO.checkPass(mail, pass)) {
			return;
		}
		
		
		
	}
}
