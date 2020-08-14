package control.profile.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.dao.UserDAO;
import messages.Messages;

@WebServlet(name = "AboutMeServlet", urlPatterns = "/editAboutMe")
public class EditAboutController extends HttpServlet {
	static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //$NON-NLS-1$
		String aboutMe = request.getParameter("value"); //$NON-NLS-1$
		String mail = request.getParameter("mail"); //$NON-NLS-1$
		UserDAO.updateAboutMe(mail, aboutMe);
		
		response.sendRedirect(Messages.getString("General.profile") + mail); //$NON-NLS-1$
	}
}
