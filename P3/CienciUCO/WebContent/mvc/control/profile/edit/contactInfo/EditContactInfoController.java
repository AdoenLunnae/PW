package control.profile.edit.contactInfo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.dao.ContactInfoDAO;
import messages.Messages;

@WebServlet(name = "EditContactInfoSevlet", value = "/editContactInfo")
public class EditContactInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8"); //$NON-NLS-1$
		String name = request.getParameter("name"); //$NON-NLS-1$
		String value = request.getParameter("value"); //$NON-NLS-1$
		int id = Integer.valueOf(request.getParameter("id")); //$NON-NLS-1$

		ContactInfoDAO.updateContactInfo(id, name, value);

		response.sendRedirect(Messages.urlFromKey("General.profile") + request.getParameter("mail")); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
