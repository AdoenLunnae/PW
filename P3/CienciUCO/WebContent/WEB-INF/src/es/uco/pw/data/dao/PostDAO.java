package es.uco.pw.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import messages.Messages;

public class PostDAO extends DAO {

	private static Hashtable<String, String> hashtableFromResultSet(ResultSet data) throws SQLException {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();

		hashtable.put("id", data.getString("id")); //$NON-NLS-1$ //$NON-NLS-2$
		hashtable.put("title", data.getString("title")); //$NON-NLS-1$ //$NON-NLS-2$
		hashtable.put("content", data.getString("content")); //$NON-NLS-1$ //$NON-NLS-2$
		hashtable.put("user_email", data.getString("user_email")); //$NON-NLS-1$ //$NON-NLS-2$
		hashtable.put("created_at", data.getTimestamp("created_at").toString()); //$NON-NLS-1$ //$NON-NLS-2$

		return hashtable;
	}

	public static ArrayList<Hashtable<String, String>> getRecentPosts(int amount) {
		ArrayList<Hashtable<String, String>> result = new ArrayList<Hashtable<String, String>>();
		Hashtable<String, String> current = new Hashtable<String, String>();
		Statement stmt = null;
		Connection con = null;
		ResultSet rs;

		try {
			con = getConnection();
			stmt = con.createStatement();
			String query = Messages.getString("PostDAO.getRecentQuery", Integer.toString(amount)); //$NON-NLS-1$
			rs = stmt.executeQuery(query);
			while (rs != null && rs.next()) {
				current = hashtableFromResultSet(rs);
				result.add(current);
			}
			if (stmt != null)
				stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static int createPost(String mail, String title, String content) {
		int status = 0;
		try {
			Connection con = getConnection();
			String insertQuery = Messages.getString("PostDAO.insertQuery"); //$NON-NLS-1$
			PreparedStatement insertExp = con.prepareStatement(insertQuery);

			insertExp.setString(1, mail);
			insertExp.setString(2, title);
			insertExp.setString(3, content);

			status = insertExp.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	public static ArrayList<Hashtable<String, String>> getPostsByUser(String mail) {
		ArrayList<Hashtable<String, String>> result = new ArrayList<Hashtable<String, String>>();
		Hashtable<String, String> current = new Hashtable<String, String>();
		Statement stmt = null;
		Connection con = null;
		ResultSet rs;

		try {
			con = getConnection();
			stmt = con.createStatement();
			String query = Messages.getString("PostDAO.getByUserQuery", mail); //$NON-NLS-1$
			rs = stmt.executeQuery(query);
			while (rs != null && rs.next()) {
				current = hashtableFromResultSet(rs);
				result.add(current);
			}
			if (stmt != null)
				stmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
