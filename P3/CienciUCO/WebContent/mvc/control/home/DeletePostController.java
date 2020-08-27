package control.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.uco.pw.data.dao.PostDAO;
import messages.Messages;

@WebServlet("/deletePost")
public class DeletePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletePostController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); //$NON-NLS-1$

		int id = Integer.valueOf(request.getParameter("id")); //$NON-NLS-1$

		PostDAO.deletePost(id);

		response.sendRedirect(Messages.buildURL("/home")); //$NON-NLS-1$
	}

}
