package cl.keanzato.app.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.keanzato.app.core.Gasto;

public interface InterfaceGasto {

	public boolean agregar(Gasto gasto) throws SQLException, ClassNotFoundException;
	
	public List<Gasto> lista() throws SQLException, ClassNotFoundException;
	
	public boolean eliminar(int idgasto) throws SQLException, ClassNotFoundException;
	
}
