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

@WebServlet(name = "RegisterServlet", urlPatterns = "/registerAttempt")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Boolean checkNotLogged(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer");
		return (customer == null || customer.getIdRol() == "Guest");
	}

	private Boolean checkEmptyArgs(String nombre, String apellidos, String mail, String password, String telefono)
			throws ServletException, IOException {
		return !(nombre.isEmpty() || apellidos.isEmpty() || mail.isEmpty() || password.isEmpty() || telefono.isEmpty());
	}

	private Boolean mailIsUnique(String mail) {
		try {
			return (UserDAO.checkMail(mail));
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void backToRegister(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher req = request.getRequestDispatcher("/registro.jsp");
		try {
			req.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void registerErrorPage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher req = request.getRequestDispatcher("/mvc/view/registerErrorView.jsp");
		try {
			req.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void registerSuccessPage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher req = request.getRequestDispatcher("/mvc/view/registerSuccessView.jsp");
		try {
			req.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private int register(String nombre, String apellidos, String mail, String password, String telefono) {
		return UserDAO.create(mail, password, nombre + " " + apellidos, telefono);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!checkNotLogged(request)) {
			registerErrorPage(request, response);
			return;
		}

		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String mail = request.getParameter("correo");
		String password = request.getParameter("password");
		String telefono = request.getParameter("numero");

		if (!checkEmptyArgs(nombre, apellidos, mail, password, telefono)) {
			backToRegister(request, response);
			return;
		}

		if (!mailIsUnique(mail)) {
			registerErrorPage(request, response);
			return;
		}

		register(nombre, apellidos, mail, password, telefono);
		registerSuccessPage(request, response);

	}

}