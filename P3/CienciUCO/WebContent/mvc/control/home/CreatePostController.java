package control.home;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uco.pw.data.dao.ContactInfoDAO;
import es.uco.pw.data.dao.PostDAO;
import es.uco.pw.data.dao.UserDAO;
import es.uco.pw.display.beans.CustomerBean;
import es.uco.pw.display.beans.PostBean;
import messages.Messages;

@WebServlet("/createPost")
public class CreatePostController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreatePostController() {
		super();
	}

	private static ArrayList<PostBean> postsFromDatabaseResult(ArrayList<Hashtable<String, String>> databaseResult) {
		ArrayList<PostBean> posts = new ArrayList<PostBean>();
		for (Hashtable<String, String> row : databaseResult) {
			String author = UserDAO.getName(row.get("user_email"));
			posts.add(new PostBean(row.get("title"), row.get("user_email"), author, row.get("content"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					Timestamp.valueOf(row.get("created_at")))); //$NON-NLS-1$
		}
		return posts;
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
