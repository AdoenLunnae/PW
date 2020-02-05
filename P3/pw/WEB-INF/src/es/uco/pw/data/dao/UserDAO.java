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

	private static String toBase64(Blob blob) {
		InputStream inputStream = null;
		try {
			inputStream = blob.getBinaryStream();
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

	public static int create(String email, String password, String fullName, String phoneNumber) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into Users(email,password,nombre_completo,telefono) values(?,?,?,?)");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, fullName);
			ps.setString(4, phoneNumber);
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
	public static Hashtable<String, String> queryByEmail(String email) {
		Statement stmt = null;
		Hashtable<String, String> resul = null;
		try {
			Connection con = getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select password, nombre_completo, telefono, info, imagen from Users where email = " + email);
			while (rs.next()) {
				String password = rs.getString("password");
				String nombreCompleto = rs.getString("nombre_completo");
				String telefono = rs.getString("telefono");
				String info = rs.getString("info");
				String imagenBase64 = toBase64(rs.getBlob("imagen"));

				resul = new Hashtable<String, String>();
				resul.put("email", email);
				resul.put("password", password);
				resul.put("nombre_completo", nombreCompleto);
				resul.put("info", info);
				resul.put("telefono", telefono);
				resul.put("imagen", imagenBase64);
			}
			// Se debe tener precaución con cerrar las conexiones, uso de auto-commit, etc.
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return resul;
	}

	public static Boolean checkMail(String email) throws SQLException {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT email FROM Users WHERE email = '" + email + "'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		// Comprobamos si la consulta está vacía (el mail introducido es válido)
		Boolean retval = !rs.next();
		return retval;

	}

	public static Boolean checkPass(String email, String pass) throws SQLException {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT password FROM Users WHERE email = '" + email + "'");
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return (pass == rs.getString("password"));

	}

	public static int delete(String email) {
		int status = 0;
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("delete from Users where email=?");
			ps.setString(1, email);
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}
}