package es.uco.pw.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

public class ContactInfoDAO extends DAO{
	
	private static Hashtable<String, String> hashtableFromResultSet(ResultSet data) throws SQLException {
		Hashtable<String, String> hashtable = new Hashtable<String, String>();
			
		hashtable.put("id", data.getString("id"));
		hashtable.put("name", data.getString("name"));
		hashtable.put("value", data.getString("value"));
		
		return hashtable;
	}
	
	public static ArrayList<Hashtable<String, String>> queryByMail(String userEmail){
		ArrayList<Hashtable<String, String>> result = new ArrayList<Hashtable<String, String>>();
		Hashtable<String, String> current = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			Connection con = getConnection();
			stmt = con.createStatement();
			String query = "SELECT id, name, value FROM ContactInfo WHERE user_email = '" + userEmail + "'  ORDER BY 'name' ASC";
			rs = stmt.executeQuery(query);
			while (rs != null && rs.next()) {
				current = hashtableFromResultSet(rs) ;
				result.add(current);
			}
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return result;
	}

	public static int updateContactInfo(int id, String name, String value) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			String updateQuery = "UPDATE ContactInfo SET name = ? , value = ? WHERE id = ?";
			PreparedStatement updateExp = con.prepareStatement(updateQuery);
			
			updateExp.setString(1, name);
			updateExp.setString(2, value);
			updateExp.setInt(3, id);
			
			status = updateExp.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public static int addContactInfo(String name, String value, String mail) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			String insertQuery = "INSERT INTO ContactInfo (name, value, user_email) VALUES ( ? , ? , ?)";
			PreparedStatement insertExp = con.prepareStatement(insertQuery);
			
			insertExp.setString(1, name);
			insertExp.setString(2, value);
			insertExp.setString(3, mail);
			
			status = insertExp.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public static int deleteContactInfo(int id) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			String deleteQuery = "DELETE FROM ContactInfo WHERE id = ?";
			PreparedStatement deleteExp = con.prepareStatement(deleteQuery);
			
			deleteExp.setInt(1, id);
			
			status = deleteExp.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
}
