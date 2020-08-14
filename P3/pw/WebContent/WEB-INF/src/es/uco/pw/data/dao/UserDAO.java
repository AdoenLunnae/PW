package es.uco.pw.data.dao;

import messages.Messages;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.Hashtable;

import javax.sql.rowset.serial.SerialBlob;

public class UserDAO extends DAO {

		
	private static String defaultBase64Image = Messages.getString("UserDAO.defaultPicBase64"); //$NON-NLS-1$
	
	private static String toBase64(Blob binaryImage) {
		InputStream inputStream = null;
		try {
			inputStream = binaryImage.getBinaryStream();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		try {
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		byte[] imageBytes = outputStream.toByteArray();

		String base64Image = Base64.getEncoder().encodeToString(imageBytes);

		try {
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64Image;
	}
	
	private static Blob fillBlobFromStream(InputStream stream) throws SQLException, IOException {
		Blob blob = null;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int count;
		while ((count = stream.read(buffer)) != -1)
		    output.write(buffer, 0, count);
		
		blob = new SerialBlob(output.toByteArray());
		
		return blob;
	}
	
	public static int create(String mail, String password, String name, String phone) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement(Messages.getString("UserDAO.insertQuery")); //$NON-NLS-1$
			ps.setString(1, mail);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, phone);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static Hashtable<String, String> queryByMail(String mail) {
		Statement stmt = null;
		Hashtable<String, String> result = null;
		try {
			Connection con = getConnection();
			stmt = con.createStatement();
			String query = Messages.getString("UserDAO.queryByMail1") + mail + Messages.getString("UserDAO.queryByMail2"); //$NON-NLS-1$ //$NON-NLS-2$
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String password = rs.getString("password"); //$NON-NLS-1$
				String name = rs.getString("name"); //$NON-NLS-1$
				String phone = rs.getString("phone"); //$NON-NLS-1$
				String aboutme = rs.getString("aboutme"); //$NON-NLS-1$
				Blob binaryImage = rs.getBlob("image"); //$NON-NLS-1$
				String base64Image = ""; //$NON-NLS-1$
				
				if(aboutme == null)
					aboutme = ""; //$NON-NLS-1$
				
				if(binaryImage != null && binaryImage.length() >= 1) 
					base64Image = toBase64(binaryImage);
				else
					base64Image = defaultBase64Image;
				
				result = new Hashtable<String, String>();
				result.put("mail", mail); //$NON-NLS-1$
				result.put("password", password); //$NON-NLS-1$
				result.put("name", name); //$NON-NLS-1$
				result.put("aboutme", aboutme); //$NON-NLS-1$
				
				result.put("phone", phone); //$NON-NLS-1$
				
				result.put("image", base64Image); //$NON-NLS-1$
			}
			// Se debe tener precaución con cerrar las conexiones, uso de auto-commit, etc.
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public static Boolean mailExists(String mail) throws SQLException {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(Messages.getString("UserDAO.mailExistsQuery1") + mail + Messages.getString("UserDAO.mailExistsQuery2")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		// Comprobamos si la consulta no está vacía (el mail introducido existe)
		Boolean retval = rs.next();
		if (stmt != null)
			stmt.close();
		return retval;

	}
	
	public static Boolean checkPass(String mail, String pass) throws SQLException {
		Connection con = getConnection();
		Statement stmt = null;
		
		ResultSet rs;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(Messages.getString("UserDAO.passworQuery1") + mail + Messages.getString("UserDAO.passwordQuery2")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		rs.beforeFirst();
		rs.next();
		String userPass = rs.getString("password"); //$NON-NLS-1$
		return (pass.equals(userPass));

	}
	
	public static int updateAboutMe(String mail, String aboutMe) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(Messages.getString("UserDAO.updateAboutMeQuery")); //$NON-NLS-1$
			ps.setString(1, aboutMe);
			ps.setString(2, mail);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int updatePic(String mail, InputStream pic) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(Messages.getString("UserDAO.updatePicQuery")); //$NON-NLS-1$
			Blob imageBlob =  fillBlobFromStream(pic);
			ps.setBlob(1, imageBlob);
			ps.setString(2, mail);
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int delete(String mail) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement(Messages.getString("UserDAO.deleteUserQuery")); //$NON-NLS-1$
			ps.setString(1, mail);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
}