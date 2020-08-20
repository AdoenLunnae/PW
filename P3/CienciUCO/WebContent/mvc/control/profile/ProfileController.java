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

import es.uco.pw.data.dao.ContactInfoDAO;
import es.uco.pw.data.dao.ExperienceDAO;
import es.uco.pw.data.dao.UserDAO;
import es.uco.pw.display.beans.ContactInfoBean;
import es.uco.pw.display.beans.CustomerBean;
import es.uco.pw.display.beans.ExperienceBean;
//import es.uco.pw.display.beans.CustomerBean;
import es.uco.pw.display.beans.ProfileBean;
import messages.Messages;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ArrayList<ExperienceBean> getExperiences(String userEmail) {
		List<Hashtable<String, String>> databaseResults = ExperienceDAO.queryByUserMail(userEmail);
		ArrayList<ExperienceBean> result = new ArrayList<ExperienceBean>();
		ExperienceBean currentExperience = null;
		for (Hashtable<String, String> databaseResult : databaseResults) {
			currentExperience = new ExperienceBean();
			currentExperience.setId(Integer.valueOf(databaseResult.get("id"))); //$NON-NLS-1$
			currentExperience.setStart(Date.valueOf(databaseResult.get("start"))); //$NON-NLS-1$
			currentExperience.setEnd(Date.valueOf(databaseResult.get("end"))); //$NON-NLS-1$
			currentExperience.setNombre(databaseResult.get("nombre")); //$NON-NLS-1$
			currentExperience.setDescripcion(databaseResult.get("descripcion")); //$NON-NLS-1$
			currentExperience.setLugar(databaseResult.get("lugar")); //$NON-NLS-1$
			result.add(currentExperience);
		}
		return result;
	}

	private ArrayList<ContactInfoBean> getContactInfo(String userEmail) {
		List<Hashtable<String, String>> databaseResults = ContactInfoDAO.queryByMail(userEmail);
		ArrayList<ContactInfoBean> result = new ArrayList<ContactInfoBean>();
		ContactInfoBean currentInfo = null;
		for (Hashtable<String, String> databaseResult : databaseResults) {
			currentInfo = new ContactInfoBean(Integer.valueOf(databaseResult.get("id")), //$NON-NLS-1$
					databaseResult.get("name"), //$NON-NLS-1$
					databaseResult.get("value") //$NON-NLS-1$
			);
			result.add(currentInfo);
		}
		return result;
	}

	private String parseToHTML(String original) {
		StringBuilder builder = new StringBuilder();
		boolean previousWasASpace = false;
		for (char c : original.toCharArray()) {
			if (c == ' ') {
				if (previousWasASpace) {
					builder.append("&nbsp;"); //$NON-NLS-1$
					previousWasASpace = false;
					continue;
				}
				previousWasASpace = true;
			} else {
				previousWasASpace = false;
			}
			switch (c) {
			case '<':
				builder.append("&lt;"); //$NON-NLS-1$
				break;
			case '>':
				builder.append("&gt;"); //$NON-NLS-1$
				break;
			case '&':
				builder.append("&amp;"); //$NON-NLS-1$
				break;
			case '"':
				builder.append("&quot;"); //$NON-NLS-1$
				break;
			case '\n':
				builder.append("<br>"); //$NON-NLS-1$
				break;
			// We need Tab support here, because we print StackTraces as HTML
			case '\t':
				builder.append("&nbsp; &nbsp; &nbsp;"); //$NON-NLS-1$
				break;
			default:
				if (c < 128) {
					builder.append(c);
				} else {
					builder.append("&#").append((int) c).append(";"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
		return builder.toString();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String mail = request.getParameter("mail"); //$NON-NLS-1$
		CustomerBean customer = (CustomerBean) session.getAttribute("customer"); //$NON-NLS-1$
		RequestDispatcher rd;

		if (customer == null || customer.getMail() == null || customer.getIdRol() == null) {
			customer = new CustomerBean("", Messages.getString("General.guestRoleName")); //$NON-NLS-1$ //$NON-NLS-2$
			session.setAttribute("customer", customer); //$NON-NLS-1$
		}

		if (!UserDAO.mailExists(mail)) {

			rd = request.getRequestDispatcher(Messages.getString("Pages.profileError")); //$NON-NLS-1$
			session.setAttribute("mail", mail); //$NON-NLS-1$
		} else {
			// TODO: Refactor to member function
			Hashtable<String, String> userData = UserDAO.queryByMail(mail);
			ArrayList<ExperienceBean> experiences = getExperiences(mail);
			ArrayList<ContactInfoBean> contactInfo = getContactInfo(mail);
			ProfileBean profile = new ProfileBean();
			profile.setMail(mail);
			profile.setName(userData.get("name")); //$NON-NLS-1$
			profile.setAboutMe(userData.get("aboutme")); //$NON-NLS-1$
			profile.setPhone(userData.get("phone")); //$NON-NLS-1$
			profile.setExperiences(experiences);
			profile.setAllContactInfo(contactInfo);
			profile.setBase64Image(userData.get("image")); //$NON-NLS-1$
			profile.setParsedAboutMe(parseToHTML(userData.get("aboutme"))); //$NON-NLS-1$
			session.setAttribute("profile", profile); //$NON-NLS-1$
			rd = (customer.getMail().equals(mail))
					? request.getRequestDispatcher(Messages.getString("Pages.ownProfile")) //$NON-NLS-1$
					: request.getRequestDispatcher(Messages.getString("Pages.otherProfile")); //$NON-NLS-1$
		}
		try {
			rd.include(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
