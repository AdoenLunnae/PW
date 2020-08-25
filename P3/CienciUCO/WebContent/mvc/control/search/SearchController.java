package control.search;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import messages.Messages;


@WebServlet(name="SearchController", value="/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String mail = request.getParameter("mail"); //$NON-NLS-1$
		
		response.sendRedirect(Messages.urlFromKey("General.profile") + mail); //$NON-NLS-1$
		
	}

}
