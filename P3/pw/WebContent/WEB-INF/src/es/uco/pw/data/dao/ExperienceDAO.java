package es.uco.pw.data.dao;

import java.util.Hashtable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

public class ExperienceDAO extends DAO {

	public static ArrayList<Hashtable<String, String>> queryByUserMail(String userMail){
		Statement stmt = null;
		ArrayList<Hashtable<String, String>> result = new ArrayList<Hashtable<String, String>>();
		Hashtable<String,String> current = new Hashtable<String,String>();
		ResultSet rs = null;
		try {
			Connection con = getConnection();
			stmt = con.createStatement();
			String query = "select start, end, nombre, descripcion, lugar from Experiences where user_email = '" + userMail + "'";
			rs = stmt.executeQuery(query);
			while (rs != null && rs.next()) {
				String start = rs.getString("start");
				String end = rs.getString("ens");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				String lugar =  rs.getString("lugar");

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
}
