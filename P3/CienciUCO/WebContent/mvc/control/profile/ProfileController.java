package control.profile;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
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

import es.uco.pw.data.dao.*;
import es.uco.pw.display.beans.*;
import es.uco.pw.util.HTMLConverter;
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
	
	private ArrayList<PostBean> getPosts(String userEmail) {
		ArrayList<PostBean> posts = new ArrayList<PostBean>();
		ArrayList<Hashtable<String, String>> databaseResult = PostDAO.getPostsByUser(userEmail);
		for (Hashtable<String, String> row : databaseResult) {
			String author = UserDAO.getName(row.get("user_email")); //$NON-NLS-1$
			posts.add(new PostBean(row.get("title"), row.get("user_email"), author, HTMLConverter.parseToHTML(row.get("content")), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					Timestamp.valueOf(row.get("created_at")))); //$NON-NLS-1$
		}
		return posts;
	}

	
	
	private ProfileBean beanFromData(String mail, ArrayList<ExperienceBean> experiences, ArrayList<ContactInfoBean> contactInfo, ArrayList<PostBean> posts, Hashtable<String, String> data) {
		ProfileBean profile = new ProfileBean();
		profile.setMail(mail);
		profile.setName(data.get("name")); //$NON-NLS-1$
		profile.setAboutMe(data.get("aboutme")); //$NON-NLS-1$
		profile.setPhone(data.get("phone")); //$NON-NLS-1$
		profile.setExperiences(experiences);
		profile.setPosts(posts);
		profile.setAllContactInfo(contactInfo);
		profile.setBase64Image(data.get("image")); //$NON-NLS-1$
		profile.setParsedAboutMe(HTMLConverter.parseToHTML(data.get("aboutme"))); //$NON-NLS-1$
		return profile;
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
			ProfileBean profile = beanFromData(mail, getExperiences(mail), getContactInfo(mail), getPosts(mail), UserDAO.queryByMail(mail));
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
