package control.profile.edit.contactInfo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.dao.ContactInfoDAO;

@WebServlet(name = "DeleteContactInfoServlet", value = "/deleteContactInfo")
public class DeleteContactInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteContactInfoController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String mail = request.getParameter("mail");
		int id = Integer.valueOf(request.getParameter("id"));
		
		ContactInfoDAO.deleteContactInfo(id);
		
		response.sendRedirect("/pw/profile?mail=" + mail);
	}

}
