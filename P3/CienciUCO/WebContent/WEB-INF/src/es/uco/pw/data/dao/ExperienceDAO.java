package es.uco.pw.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import messages.Messages;

public class ExperienceDAO extends DAO {

	private static Hashtable<String, String> hashtableFromResultSet(ResultSet data) throws SQLException {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();

		hashtable.put("id", data.getString("id")); //$NON-NLS-1$ //$NON-NLS-2$
		hashtable.put("start", data.getString("start")); //$NON-NLS-1$ //$NON-NLS-2$
		hashtable.put("end", data.getString("end")); //$NON-NLS-1$ //$NON-NLS-2$
		hashtable.put("nombre", data.getString("nombre")); //$NON-NLS-1$ //$NON-NLS-2$
		hashtable.put("descripcion", data.getString("descripcion")); //$NON-NLS-1$ //$NON-NLS-2$
		hashtable.put("lugar", data.getString("lugar")); //$NON-NLS-1$ //$NON-NLS-2$

		return hashtable;
	}

	public static ArrayList<Hashtable<String, String>> queryByUserMail(String userMail) {
		Statement stmt = null;
		ArrayList<Hashtable<String, String>> result = new ArrayList<Hashtable<String, String>>();
		Hashtable<String, String> current = null;
		ResultSet rs = null;
		try {
			Connection con = getConnection();
			stmt = con.createStatement();
			String query = Messages.getString("ExperienceDAO.queryByMail", userMail); //$NON-NLS-1$
			rs = stmt.executeQuery(query);
			while (rs != null && rs.next()) {
				current = hashtableFromResultSet(rs);

				result.add(current);
			}
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return result;
	}

	public static int updateExperience(int id, String nombre, String descripcion, String lugar, Date start, Date end) {
		int status = 0;
		PreparedStatement updateExp = null;
		try {
			Connection con = getConnection();
			String updateQuery = Messages.getString("ExperienceDAO.updateQuery"); //$NON-NLS-1$
			updateExp = con.prepareStatement(updateQuery);

			updateExp.setString(1, nombre);
			updateExp.setString(2, descripcion);
			updateExp.setString(3, lugar);
			updateExp.setDate(4, start);
			updateExp.setDate(5, end);
			updateExp.setInt(6, id);

			status = updateExp.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int addExperience(String mail, String nombre, String descripcion, String lugar, Date start,
			Date end) {
		int status = 0;

		PreparedStatement insertExp = null;
		try {
			Connection con = getConnection();
			String insertQuery = Messages.getString("ExperienceDAO.insertQuery"); //$NON-NLS-1$
			insertExp = con.prepareStatement(insertQuery);

			insertExp.setString(1, mail);
			insertExp.setString(2, nombre);
			insertExp.setString(3, descripcion);
			insertExp.setString(4, lugar);
			insertExp.setDate(5, start);
			insertExp.setDate(6, end);

			status = insertExp.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static int deleteExperience(int id) {
		int status = 0;

		PreparedStatement deleteExp = null;
		try {
			Connection con = getConnection();
			String deleteQuery = Messages.getString("ExperienceDAO.deleteQuery"); //$NON-NLS-1$
			deleteExp = con.prepareStatement(deleteQuery);

			deleteExp.setInt(1, id);

			status = deleteExp.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}
}
