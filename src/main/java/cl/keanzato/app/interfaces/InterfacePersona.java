package cl.keanzato.app.interfaces;

import java.sql.SQLException;
import java.util.List;

import cl.keanzato.app.core.Persona;

public interface InterfacePersona {

	public List<Persona> lista() throws SQLException, ClassNotFoundException;
	
	public void agregar(Persona persona) throws SQLException, ClassNotFoundException;
	
	public Persona getPersona(int rut) throws SQLException, ClassNotFoundException;
}
