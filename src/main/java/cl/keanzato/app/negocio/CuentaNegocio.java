package cl.keanzato.app.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cl.keanzato.app.core.Cuenta;
import cl.keanzato.app.core.Usuario;
import cl.keanzato.app.dao.CuentaDao;

public class CuentaNegocio {
	
	
	private HttpServletRequest request;
	
	public List<Cuenta> cuentas() throws ClassNotFoundException, SQLException{
		
		CuentaDao cuenta = new CuentaDao();
		List<Cuenta> lista = new ArrayList<Cuenta>();
		for(Cuenta in : cuenta.lista()){
		
				lista.add(in);
			
		}
		return lista;
	}
	
}
