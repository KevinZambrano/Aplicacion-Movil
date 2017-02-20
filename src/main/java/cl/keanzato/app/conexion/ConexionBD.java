package cl.keanzato.app.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

import cl.keanzato.app.exceptions.ConexionException;

public class ConexionBD {

	private static ConexionBD _conexion;
	private Connection connection;

	/**
	 * 
	 */
	private ConexionBD() {
	}

	public static ConexionBD getInstancia() {
		if (_conexion == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = (Connection) DriverManager.getConnection(
						"jdbc:mysql://localhost/finanzasmobile", 
						"root",
						"");
				ConexionBD conexion = new ConexionBD();
				conexion.setConnection(conn);
				_conexion = conexion;
			} catch (Exception e) {
				throw new ConexionException("Ocurrio un error"
						+ " al conectar con la base de datos", e);
			}
		} 
		return _conexion;
		
	}
        
        /**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
