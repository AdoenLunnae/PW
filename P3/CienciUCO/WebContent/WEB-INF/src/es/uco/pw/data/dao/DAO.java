package es.uco.pw.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import messages.Messages;

public class DAO {
	public static Connection getConnection() {
		// En primer lugar, obtenemos una instancia del driver de MySQL
		Connection con = null;
		try {
			Class.forName(Messages.getString("DAO.className")); //$NON-NLS-1$
			// Introducir correctamente el nombre y datos de conexión - Idealmente, estos
			// datos se
			// indican en un fichero de propiedades
			con = DriverManager.getConnection(Messages.getString("DAO.databaseURL"), //$NON-NLS-1$
					Messages.getString("DAO.databaseUser"), Messages.getString("DAO.databasePassword")); //$NON-NLS-1$ //$NON-NLS-2$
			// Importante capturar
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	
}
