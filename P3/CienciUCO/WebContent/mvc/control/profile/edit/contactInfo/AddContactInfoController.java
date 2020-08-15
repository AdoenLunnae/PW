package control.profile.edit.contactInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.dao.ContactInfoDAO;
import messages.Messages;

@WebServlet(name = "AddContactInfoServlet", value = "/addContactInfo")
public class AddContactInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddContactInfoController() {
        super();
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //$NON-NLS-1$
		
		String mail = request.getParameter("mail"); //$NON-NLS-1$
		String name = request.getParameter("name"); //$NON-NLS-1$
		String value = request.getParameter("value"); //$NON-NLS-1$
		
		ContactInfoDAO.addContactInfo(name, value, mail);
		
		response.sendRedirect(Messages.getString("General.profile") + mail); //$NON-NLS-1$
	}

}
