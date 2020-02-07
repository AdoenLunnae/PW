package control.profile.edit;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.dao.UserDAO;

@WebServlet(name = "AboutMeServlet", urlPatterns = "/editAboutMe")
public class EditAboutController extends HttpServlet {
	static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String aboutMe = request.getParameter("value");
		String mail = request.getParameter("mail");
		UserDAO.updateAboutMe(mail, aboutMe);
		
		response.sendRedirect("/pw/profile?mail=" + mail);
	}
}
