import java.sql.SQLException;

import cl.keanzato.app.core.Cuenta;
import cl.keanzato.app.dao.CuentaDao;
import cl.keanzato.app.negocio.CuentaNegocio;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		CuentaNegocio cuenta = new CuentaNegocio();
		CuentaDao cuentas = new CuentaDao();
		for (Cuenta in : cuenta.cuentas()) {
			if (in.getIdusuario().equals("keanzato")) {
				System.out.println(in.getIdusuario());
				System.out.println(in.getFechaingreso());
				System.out.println(in.getMonto());
			}
		}
	}
}
