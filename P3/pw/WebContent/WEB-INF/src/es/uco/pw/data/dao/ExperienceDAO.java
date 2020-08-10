package es.uco.pw.data.dao;

import java.util.Hashtable;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ExperienceDAO extends DAO {

	public static ArrayList<Hashtable<String, String>> queryByUserMail(String userMail){
		Statement stmt = null;
		ArrayList<Hashtable<String, String>> result = new ArrayList<Hashtable<String, String>>();
		Hashtable<String,String> current = null;
		ResultSet rs = null;
		try {
			Connection con = getConnection();
			stmt = con.createStatement();
			String query = "SELECT id, start, end, nombre, descripcion, lugar FROM Experiences WHERE user_email = '" + userMail + "'  ORDER BY 'start', 'end' ASC";
			rs = stmt.executeQuery(query);
			while (rs != null && rs.next()) {
				String id = rs.getString("id");
				String start = rs.getString("start");
				String end = rs.getString("end");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				String lugar =  rs.getString("lugar");
				
				current = new Hashtable<String,String>();
				
				current.put("id", id);
				current.put("start", start);
				current.put("end", end);
				current.put("nombre", nombre);
				current.put("descripcion", descripcion);
				current.put("lugar", lugar);
				
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
			String updateQuery = "UPDATE Experiences SET nombre = ?, descripcion = ?, lugar = ?, start = ?, end = ? WHERE id = ?";
			updateExp = con.prepareStatement(updateQuery);
			
			updateExp.setString(1, nombre);
			updateExp.setString(2, descripcion);
			updateExp.setString(3, lugar);
			updateExp.setDate(4, start);
			updateExp.setDate(5, end);
			updateExp.setInt(6, id);
			
			status = updateExp.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int addExperience(String mail, String nombre, String descripcion, String lugar, Date start, Date end) {
		int status = 0;
		
		PreparedStatement insertExp = null;
		try {
			Connection con = getConnection();
			String insertQuery = "INSERT INTO Experiences (user_email, nombre, descripcion, lugar, start, end)  VALUES ( ? , ? , ? , ? , ? , ? )";
			insertExp = con.prepareStatement(insertQuery);
			
			insertExp.setString(1, mail);
			insertExp.setString(2, nombre);
			insertExp.setString(3, descripcion);
			insertExp.setString(4, lugar);
			insertExp.setDate(5, start);
			insertExp.setDate(6, end);
			
			status = insertExp.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;		
	}

	public static int deleteExperience(int id) {
		int status = 0;
		
		PreparedStatement deleteExp = null;
		try {
			Connection con = getConnection();
			String deleteQuery = "DELETE FROM Experiences WHERE id = ?";
			deleteExp = con.prepareStatement(deleteQuery);
			
			deleteExp.setInt(1, id);
			
			status = deleteExp.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
}
