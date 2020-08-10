package control.profile.edit.experience;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.uco.pw.data.dao.ExperienceDAO;

/**
 * Servlet implementation class DeleteExperienceController
 */
@WebServlet(name ="DeleteExperienceController", value = "/deleteExperience")
public class DeleteExperienceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExperienceController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	*/
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
    	int id = Integer.valueOf(request.getParameter("id"));
    	ExperienceDAO.deleteExperience(id);
    	
    	response.sendRedirect("/pw/profile?mail=" + request.getParameter("mail"));
	}

}
