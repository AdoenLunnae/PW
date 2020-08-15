package control.profile.edit;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import es.uco.pw.data.dao.UserDAO;
import messages.Messages;


@WebServlet("/editProfilePic")
@MultipartConfig
public class EditProfilePicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditProfilePicController() {
        super();
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8"); //$NON-NLS-1$
		Part filePart = request.getPart("newPhoto"); // Retrieves <input type="file" name="file"> //$NON-NLS-1$
	    InputStream pic = filePart.getInputStream();
	    String mail = request.getParameter("mail"); //$NON-NLS-1$
	    
	    UserDAO.updatePic(mail, pic);
	    
	    response.sendRedirect(Messages.getString("General.profile") + mail); //$NON-NLS-1$
	}

}
