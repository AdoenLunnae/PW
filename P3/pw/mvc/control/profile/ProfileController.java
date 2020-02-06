package control.profile;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import es.uco.pw.display.beans.CustomerBean;
import es.uco.pw.display.beans.ProfileBean;
import es.uco.pw.data.dao.UserDAO;

@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mail = request.getParameter("mail");
		//CustomerBean customer = (CustomerBean) session.getAttribute("customer");
		Hashtable<String,String> userData = UserDAO.queryByMail(mail);
		
		ProfileBean profile = new ProfileBean();
		profile.setMail(mail);
		profile.setName(userData.get("name"));
		profile.setAboutMe(userData.get("aboutme"));
		profile.setPhone(userData.get("phone"));
		session.setAttribute("profile", profile);
		
		RequestDispatcher req = request.getRequestDispatcher("/mvc/view/ownProfileView.jsp");
		try {
			req.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
