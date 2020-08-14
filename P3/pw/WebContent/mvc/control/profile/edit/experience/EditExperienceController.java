package control.profile.edit.experience;

import messages.Messages;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.dao.ExperienceDAO;


@WebServlet(name = "EditExperienceServlet", value = "/editExperience")
public class EditExperienceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8"); //$NON-NLS-1$
		int id = Integer.valueOf(request.getParameter("id")); //$NON-NLS-1$
		String lugar = request.getParameter("lugar"); //$NON-NLS-1$
		String nombre = request.getParameter("nombre");  //$NON-NLS-1$
		String descripcion = request.getParameter("descripcion"); //$NON-NLS-1$
		Date start = Date.valueOf(request.getParameter("start")), end = Date.valueOf(request.getParameter("end")); //$NON-NLS-1$ //$NON-NLS-2$
		
		ExperienceDAO.updateExperience(id, nombre, descripcion, lugar, start, end);
		
		response.sendRedirect(Messages.getString("General.profile") + request.getParameter("mail")); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
