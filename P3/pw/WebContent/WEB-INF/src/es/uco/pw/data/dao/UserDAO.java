package es.uco.pw.data.dao;

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

public class UserDAO extends DAO {

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

	public static int create(String mail, String password, String name, String phone) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into Users(mail,password,name,phone) values(?,?,?,?)");
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

	// Método para actualizar un usuario
	public static int update(int id, String nombre, String descripcion) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update test set nombre=?,descripcion=? where id=?");
			ps.setString(1, nombre);
			ps.setString(2, descripcion);
			ps.setInt(3, id);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	// Para la consulta, se ha tomado una estructura Hash (columna-tabla, valor)
	public static Hashtable<String, String> queryByMail(String mail) {
		Statement stmt = null;
		Hashtable<String, String> resul = null;
		try {
			Connection con = getConnection();
			stmt = con.createStatement();
			String query = "select password, name, phone, aboutme, image from Users where mail = '" + mail + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String password = rs.getString("password");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String aboutme = rs.getString("aboutme");
				Blob binaryImage = rs.getBlob("image");
				String imageBase64 = "";
				if(binaryImage != null) {
					imageBase64 = toBase64(binaryImage);
				}

				resul = new Hashtable<String, String>();
				resul.put("mail", mail);
				resul.put("password", password);
				resul.put("name", name);
				if(aboutme == null) {
					resul.put("aboutme", "");
				}
				else {
				resul.put("aboutme", aboutme);
				}
				resul.put("phone", phone);
				
				resul.put("image", imageBase64);
			}
			// Se debe tener precaución con cerrar las conexiones, uso de auto-commit, etc.
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return resul;
	}

	public static Boolean mailExists(String mail) throws SQLException {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT mail FROM Users WHERE mail = '" + mail + "'");
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
			rs = stmt.executeQuery("SELECT password FROM Users WHERE mail = '" + mail + "'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		rs.beforeFirst();
		rs.next();
		String userPass = rs.getString("password");
		return (pass.equals(userPass));

	}
	public static int updateAboutMe(String mail, String aboutMe) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("update Users set aboutMe=? where mail=?");
			ps.setString(1, aboutMe);
			ps.setString(2, mail);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int delete(String mail) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from Users where mail=?");
			ps.setString(1, mail);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
}