package control.profile.edit.experience;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.dao.ExperienceDAO;

@WebServlet(name = "AddExperienceServlet", value = "/addExperience")
public class AddExperienceController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String mail = request.getParameter("mail");
		String lugar = request.getParameter("lugar");
		String nombre = request.getParameter("nombre"); 
		String descripcion = request.getParameter("descripcion");
		Date start = Date.valueOf(request.getParameter("start")), end = Date.valueOf(request.getParameter("end"));
		
		ExperienceDAO.addExperience(mail, nombre, descripcion, lugar, start, end);
		
		response.sendRedirect("/pw/profile?mail=" + mail);
	}

}
