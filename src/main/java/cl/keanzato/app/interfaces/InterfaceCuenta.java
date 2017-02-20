package cl.keanzato.app.interfaces;

import java.util.List;
import cl.keanzato.app.core.Cuenta;
import java.sql.SQLException;

public interface InterfaceCuenta {

	public List<Cuenta> lista() throws SQLException, ClassNotFoundException;
	
	public boolean agregar(Cuenta cuenta) throws SQLException, ClassNotFoundException;
        
        public boolean eliminar(int idcuenta) throws SQLException, ClassNotFoundException;
        
        public int totalFinanzas();
}
