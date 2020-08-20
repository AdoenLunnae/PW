package control.profile.edit.contactInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.dao.ContactInfoDAO;
import messages.Messages;

@WebServlet(name = "DeleteContactInfoServlet", value = "/deleteContactInfo")
public class DeleteContactInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteContactInfoController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //$NON-NLS-1$

		String mail = request.getParameter("mail"); //$NON-NLS-1$
		int id = Integer.valueOf(request.getParameter("id")); //$NON-NLS-1$

		ContactInfoDAO.deleteContactInfo(id);

		response.sendRedirect(Messages.urlFromKey("General.profile") + mail); //$NON-NLS-1$
	}

}
