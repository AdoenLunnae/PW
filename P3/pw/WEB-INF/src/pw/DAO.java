package pw;
import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	public static Connection getConnection(){
		// En primer lugar, obtenemos una instancia del driver de MySQL
		Connection con=null;
		try {
		  Class.forName("com.mysql.jdbc.Driver");
		  // Introducir correctamente el nombre y datos de conexión - Idealmente, estos datos se
		  // indican en un fichero de propiedades
		  con= DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/i72prbaa","i72prbaa","password");
		// Importante capturar 
		} catch(Exception e) {
		  System.out.println(e);
		}
		return con;
	  }
}
