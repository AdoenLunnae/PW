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

import es.uco.pw.data.dao.UserDAO;
import es.uco.pw.display.beans.CustomerBean;
import messages.Messages;

@WebServlet(name = "LoginServlet", urlPatterns = "/loginAttempt")
public class LoginController extends HttpServlet {
	static final long serialVersionUID = 1L;

	private Boolean userIsLogged(CustomerBean customer) {
		return (customer != null && !customer.getIdRol().equals(Messages.getString("General.guestRoleName"))); //$NON-NLS-1$
	}

	/*
	 * private Boolean checkEmptyArgs(String nombre, String apellidos, String mail,
	 * String password, String telefono) throws ServletException, IOException {
	 * return !(mail.isEmpty() || password.isEmpty()); }
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		CustomerBean customer = (CustomerBean) session.getAttribute("customer"); //$NON-NLS-1$

		if (userIsLogged(customer)) {
			// loginErrorPage(request, response);
			return;
		}

		String mail = request.getParameter("correo"); //$NON-NLS-1$
		String password = request.getParameter("password"); //$NON-NLS-1$
		request.setAttribute("failedLogin", false); //$NON-NLS-1$
		try {
			if (!UserDAO.mailExists(mail) || !UserDAO.checkPass(mail, password)) {
				request.setAttribute("failedLogin", true); //$NON-NLS-1$
				RequestDispatcher rd = request.getRequestDispatcher(Messages.getString("Pages.loginPage")); //$NON-NLS-1$
				rd.include(request, response);
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		customer = new CustomerBean(mail, Messages.getString("General.userRoleName")); //$NON-NLS-1$
		session.setAttribute("customer", customer); //$NON-NLS-1$
		response.sendRedirect(Messages.buildURL("/home")); //$NON-NLS-1$
		return;
	}

}
