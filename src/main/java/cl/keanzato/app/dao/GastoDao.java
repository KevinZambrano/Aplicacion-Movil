package cl.keanzato.app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.keanzato.app.conexion.ConexionBD;
import cl.keanzato.app.core.Gasto;
import cl.keanzato.app.interfaces.InterfaceGasto;

public class GastoDao implements InterfaceGasto{

	public boolean agregar(Gasto gasto) throws SQLException, ClassNotFoundException {
		try{
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection().prepareStatement("insert into gastos values(null,?,?,?,?");
			consulta.setString(1, gasto.getIdusuario());
			consulta.setInt(2, gasto.getMonto());
			consulta.setString(3, gasto.getDescripcion());
			consulta.setString(4, gasto.getFechagasto());
			consulta.executeUpdate();
			return true;
		}catch(Exception ex){
			return false;
		}
		
	}

	public List<Gasto> lista() throws SQLException, ClassNotFoundException {
		try{
			ConexionBD conn = ConexionBD.getInstancia();
			PreparedStatement consulta = conn.getConnection().prepareStatement("select * from gastos");
			ResultSet rst = consulta.executeQuery();
			List<Gasto> gastos = new ArrayList<Gasto>();
			while(rst.next()){
				gastos.add(parser(rst));
			}
			return gastos;
		}catch(Exception ex){
			return null;
		}
	}

	public boolean eliminar(int idgasto) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	private Gasto parser(ResultSet rst) throws SQLException{
		Gasto gasto = new Gasto();
		
		gasto.setIdgasto(rst.getInt("idgasto"));
		gasto.setIdusuario(rst.getString("idusuario"));
		gasto.setMonto(rst.getInt("monto"));
		gasto.setDescripcion(rst.getString("descripcion"));
		gasto.setFechagasto(rst.getString("fechagasto"));
		
		return gasto;
	}
}
