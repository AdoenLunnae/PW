package control.profile.edit.contactInfo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.dao.ContactInfoDAO;

@WebServlet(name = "EditContactInfoSevlet", value="/editContactInfo")
public class EditContactInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String value = request.getParameter("value");
		int id = Integer.valueOf(request.getParameter("id"));
		
		ContactInfoDAO.update(id, name, value);
		
		response.sendRedirect("/pw/profile?mail=" + request.getParameter("mail"));
	}

}
