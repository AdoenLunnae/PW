package control.access;

import messages.Messages;
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

@WebServlet(name = "RegisterServlet", value = "/registerAttempt")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Boolean checkNotLogged(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer"); //$NON-NLS-1$
		return (customer == null || customer.getIdRol() == Messages.getString("RegisterController.GuestRoleName")); //$NON-NLS-1$
	}

	private Boolean checkEmptyArgs(String nombre, String apellidos, String mail, String password, String telefono)
			throws ServletException, IOException {
		return !(nombre.isEmpty() || apellidos.isEmpty() || mail.isEmpty() || password.isEmpty() || telefono.isEmpty());
	}

	private Boolean mailIsUnique(String mail) {
		try {
			return (!UserDAO.mailExists(mail));
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void backToRegister(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher req = request.getRequestDispatcher(Messages.getString("RegisterController.registerPage")); //$NON-NLS-1$
		try {
			req.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void registerErrorPage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher req = request.getRequestDispatcher(Messages.getString("RegisterController.registerErrorPage")); //$NON-NLS-1$
		try {
			req.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void registerSuccessPage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher req = request.getRequestDispatcher(Messages.getString("RegisterController.registerSuccessPage")); //$NON-NLS-1$
		try {
			req.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private int register(String nombre, String apellidos, String mail, String password, String telefono) {
		return UserDAO.create(mail, password, nombre + " " + apellidos, telefono); //$NON-NLS-1$
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (!checkNotLogged(request)) {
			registerErrorPage(request, response);
			return;
		}
		request.setCharacterEncoding("UTF-8"); //$NON-NLS-1$
		String nombre = request.getParameter("nombre"); //$NON-NLS-1$
		String apellidos = request.getParameter("apellidos"); //$NON-NLS-1$
		String mail = request.getParameter("correo"); //$NON-NLS-1$
		String password = request.getParameter("password"); //$NON-NLS-1$
		String telefono = request.getParameter("numero"); //$NON-NLS-1$

		if (!checkEmptyArgs(nombre, apellidos, mail, password, telefono)) {
			backToRegister(request, response);
			return;
		}

		if (!mailIsUnique(mail)) {
			registerErrorPage(request, response);
			return;
		}

		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer"); //$NON-NLS-1$
		if(customer == null) {
			customer = new CustomerBean();
		}
		customer.setIdRol(Messages.getString("RegisterController.UserRoleName")); //$NON-NLS-1$
		customer.setMail(mail);
		session.setAttribute("customer", customer); //$NON-NLS-1$
		register(nombre, apellidos, mail, password, telefono);
		registerSuccessPage(request, response);

	}

}