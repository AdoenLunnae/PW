package control.access;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.data.dao.UserDAO;
import es.uco.pw.display.beans.CustomerBean;
import messages.Messages;

@WebServlet(name = "RegisterServlet", value = "/registerAttempt")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Boolean isLogged(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer"); //$NON-NLS-1$
		return !(customer == null || customer.getIdRol() == Messages.getString("General.guestRoleName")); //$NON-NLS-1$
	}

	private Boolean checkEmptyArgs(String nombre, String apellidos, String mail, String password, String telefono)
			throws ServletException, IOException {
		return !(nombre.isEmpty() || apellidos.isEmpty() || mail.isEmpty() || password.isEmpty() || telefono.isEmpty());
	}

	private Boolean mailIsUnique(String mail) {
		return (!UserDAO.mailExists(mail));
	}

	private int register(String nombre, String apellidos, String mail, String password, String telefono) {
		return UserDAO.create(mail, password, nombre + " " + apellidos, telefono); //$NON-NLS-1$
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd;
		if (isLogged(request)) {
			rd = request.getRequestDispatcher(Messages.urlFromKey("Pages.registerErrorPage")); //$NON-NLS-1$
			rd.include(request, response);
			return;
		}

		request.setCharacterEncoding("UTF-8"); //$NON-NLS-1$
		String nombre = request.getParameter("nombre"); //$NON-NLS-1$
		String apellidos = request.getParameter("apellidos"); //$NON-NLS-1$
		String mail = request.getParameter("correo"); //$NON-NLS-1$
		String password = request.getParameter("password"); //$NON-NLS-1$
		String telefono = request.getParameter("numero"); //$NON-NLS-1$

		if (!checkEmptyArgs(nombre, apellidos, mail, password, telefono)) {
			rd = request.getRequestDispatcher(Messages.urlFromKey("Pages.registerPage")); //$NON-NLS-1$
			rd.include(request, response);
			return;
		}

		if (!mailIsUnique(mail)) {
			rd = request.getRequestDispatcher(Messages.urlFromKey("Pages.registerErrorPage")); //$NON-NLS-1$
			rd.include(request, response);
			return;
		}

		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer"); //$NON-NLS-1$
		if (customer == null)
			customer = new CustomerBean();

		customer.setIdRol(Messages.getString("General.userRoleName")); //$NON-NLS-1$
		customer.setMail(mail);
		session.setAttribute("customer", customer); //$NON-NLS-1$
		register(nombre, apellidos, mail, password, telefono);

		rd = request.getRequestDispatcher(Messages.getString("Pages.registerSuccessPage")); //$NON-NLS-1$
		rd.include(request, response);

		return;
	}

}