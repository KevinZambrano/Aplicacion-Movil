package cl.keanzato.app.interfaces;

import java.sql.SQLException;

import cl.keanzato.app.core.Gasto;

public interface InterfaceGasto {

	public boolean agregar(Gasto gasto) throws SQLException, ClassNotFoundException;
	
	
}
