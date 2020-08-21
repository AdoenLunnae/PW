package control.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.uco.pw.data.dao.PostDAO;
import messages.Messages;

@WebServlet("/createPost")
public class CreatePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreatePostController() {
		super();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); //$NON-NLS-1$

		String mail = request.getParameter("mail"); //$NON-NLS-1$
		String title = request.getParameter("title"); //$NON-NLS-1$
		String content = request.getParameter("content"); //$NON-NLS-1$

		PostDAO.createPost(mail, title, content);

		response.sendRedirect(Messages.buildURL("/home")); //$NON-NLS-1$
	}

}
