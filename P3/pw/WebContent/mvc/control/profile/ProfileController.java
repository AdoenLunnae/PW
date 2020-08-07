package control.profile;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import es.uco.pw.display.beans.CustomerBean;
import es.uco.pw.display.beans.ProfileBean;
import es.uco.pw.display.beans.CustomerBean;
import es.uco.pw.display.beans.ExperienceBean;
import es.uco.pw.data.dao.UserDAO;
import es.uco.pw.data.dao.ExperienceDAO;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<ExperienceBean> getExperiences(String userEmail){
		List<Hashtable<String,String>> databaseResults = ExperienceDAO.queryByUserMail(userEmail);
		ArrayList<ExperienceBean> result = new ArrayList<ExperienceBean>();
		ExperienceBean currentExperience = new ExperienceBean();
		for (Hashtable<String,String> databaseResult : databaseResults) {
			currentExperience.setStart(Date.valueOf(databaseResult.get("start")));
			currentExperience.setEnd(Date.valueOf(databaseResult.get("end")));
			currentExperience.setNombre(databaseResult.get("nombre"));
			currentExperience.setDescripcion(databaseResult.get("descripcion"));
			currentExperience.setLugar(databaseResult.get("lugar"));
		}
		return result;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String mail = request.getParameter("mail");
		CustomerBean customer = (CustomerBean) session.getAttribute("customer");
		if(customer == null) {
			customer = new CustomerBean("", "Guest");
			session.setAttribute("customer", customer);
		}
		Hashtable<String,String> userData = UserDAO.queryByMail(mail);
		ArrayList<ExperienceBean> experiences = getExperiences(mail);
		
		ProfileBean profile = new ProfileBean();
		profile.setMail(mail);
		profile.setName(userData.get("name"));
		profile.setAboutMe(userData.get("aboutme"));
		profile.setPhone(userData.get("phone"));
		profile.setExperiences(experiences);
		profile.setBase64Image(userData.get("image"));
		session.setAttribute("profile", profile);
		
		RequestDispatcher rd = (customer.getMail().equals(mail)) 
				? request.getRequestDispatcher("/mvc/view/profile/ownProfileView.jsp")
				: request.getRequestDispatcher("/mvc/view/profile/otherProfileView.jsp");
		try {
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
